/*
 * $Id: DefaultTableColumnModelExt.java,v 1.9 2005/10/13 08:59:55 kleopatra Exp $
 *
 * Copyright 2004 Sun Microsystems, Inc., 4150 Network Circle,
 * Santa Clara, California 95054, U.S.A. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */

package org.jdesktop.swingx.table;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.TableColumn;


/**
 * A default implementation supporting invisible columns.
 *
 * Note (JW): hot fixed issues #156, #157. To really do it
 * need enhanced TableColumnModelEvent and -Listeners that are
 * aware of the event.
 * 
 *  
 * @author Richard Bair
 */
public class DefaultTableColumnModelExt extends DefaultTableColumnModel implements TableColumnModelExt {
    private static final String IGNORE_EVENT = "TableColumnModelExt.ignoreEvent";
    /**
     * contains a list of all of the columns, in the order in which they would
     * appear if all of the columns were visible.
     */
    private List allColumns = new ArrayList();
    
    /**
     * Set of invisible columns. These must be of type TableColumnExt.
     */
    private Set invisibleColumns = new HashSet();
    
    private Map oldIndexes = new HashMap();
    
    /**
     * Listener attached to TableColumnExt instances to listen for changes
     * to their visibility status, and to hide/show the column as oppropriate
     */
    private VisibilityListener visibilityListener = new VisibilityListener();
    
    /** 
     * Creates a new instance of DefaultTableColumnModelExt 
     */
    public DefaultTableColumnModelExt() {
        super();
    }

    /**
     * 
     */
    public List getAllColumns() {
        //defensive copy
        return getColumns(true);
    }

    /**
     * 
     */
    public List getColumns(boolean includeHidden) {
        if (includeHidden) {
            return new ArrayList(allColumns);
        } 
        return Collections.list(getColumns());
    }

    public int getColumnCount(boolean includeHidden) {
        if (includeHidden) {
            return allColumns.size();
        }
        return getColumnCount();
    }
    /**
     * {@inheritDoc}
     */
    public TableColumnExt getColumnExt(Object identifier) {
        for (Iterator iter = allColumns.iterator(); iter.hasNext();) {
            TableColumn column = (TableColumn) iter.next();
            if ((column instanceof TableColumnExt) && (identifier.equals(column.getIdentifier()))) {
                return (TableColumnExt) column;
            }
        }
        return null;
    }
    public Set getInvisibleColumns() {
        return new HashSet(invisibleColumns);
    }

    /**
     * hot fix for #157: listeners that are aware of
     * the possible existence of invisible columns
     * should check if the received columnRemoved originated
     * from moving a column from visible to invisible.
     * 
     * @param oldIndex the fromIndex of the columnEvent
     * @return true if the column was moved to invisible
     */
    public boolean isRemovedToInvisibleEvent(int oldIndex) {
        Integer index = new Integer(oldIndex);
        return oldIndexes.containsValue(index);
    }

    /**
     * hot fix for #157: listeners that are aware of
     * the possible existence of invisible columns
     * should check if the received columnAdded originated
     * from moving a column from invisible to visible.
     * 
     * @param newIndex the toIndex of the columnEvent
     * @return true if the column was moved to visible
     */
    public boolean isAddedFromInvisibleEvent(int newIndex) {
        if (!(getColumn(newIndex) instanceof TableColumnExt)) return false;
        return Boolean.TRUE.equals(((TableColumnExt) getColumn(newIndex)).getClientProperty(IGNORE_EVENT));
    }

    
    public void removeColumn(TableColumn column) {
        //remove the visibility listener if appropriate
        if (column instanceof TableColumnExt) {
            ((TableColumnExt)column).removePropertyChangeListener(visibilityListener);
        }
        //remove from the invisible columns set and the allColumns list first
        invisibleColumns.remove(column);
        allColumns.remove(column);
        //let the superclass handle notification etc
        super.removeColumn(column);
    }

    public void addColumn(TableColumn aColumn) {
        // hacking to guarantee correct events
        // two step: add as visible, setVisible
        boolean oldVisible = true;
        //add the visibility listener if appropriate
        if (aColumn instanceof TableColumnExt) {
            TableColumnExt xColumn = (TableColumnExt) aColumn;
            oldVisible = xColumn.isVisible();
            xColumn.setVisible(true);
            xColumn.addPropertyChangeListener(visibilityListener);
        }
        //append the column to the end of "allColumns". If the column is
        //visible, let super add it to the list of columns. If not, then
        //add it to the set of invisible columns and return.
        //In the case of an invisible column being added to the model,
        //I still do event notification for the model having
        //been changed so that the ColumnControlButton or other similar
        //code interacting with invisible columns knows that a new invisible
        //column has been added
        allColumns.add(aColumn);
        super.addColumn(aColumn);
        if (aColumn instanceof TableColumnExt) {
            ((TableColumnExt) aColumn).setVisible(oldVisible);
        }
        
    }

        
    protected void moveToInvisible(TableColumnExt col) {
        //make invisible
        int oldIndex = tableColumns.indexOf(col);
        invisibleColumns.add(col);
        oldIndexes.put(col, new Integer(oldIndex));
        super.removeColumn(col);
    }

    protected void moveToVisible(TableColumnExt col) {
        //make visible
        invisibleColumns.remove(col);
        Integer oldIndexInteger = (Integer)oldIndexes.get(col);
        int oldIndex = oldIndexInteger == null ? getColumnCount() : oldIndexInteger.intValue();
        oldIndexes.remove(col);
        col.putClientProperty(IGNORE_EVENT, Boolean.TRUE);
        super.addColumn(col);
        moveColumn(getColumnCount() - 1, Math.min(getColumnCount() - 1, oldIndex));
        col.putClientProperty(IGNORE_EVENT, null);
    }

    private final class VisibilityListener implements PropertyChangeListener {        
        public void propertyChange(PropertyChangeEvent evt) {
            if (evt.getPropertyName().equals("visible")) {
                boolean oldValue = ((Boolean)evt.getOldValue()).booleanValue();
                boolean newValue = ((Boolean)evt.getNewValue()).booleanValue();
                TableColumnExt col = (TableColumnExt)evt.getSource();

                if (oldValue && !newValue) {
                    moveToInvisible(col);
                } else if (!oldValue && newValue) {
                    moveToVisible(col);
                }
            }
        }
    }
    
}
