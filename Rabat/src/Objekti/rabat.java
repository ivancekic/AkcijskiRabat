/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objekti;

/**
 *
 * @author ceka
 */
public class rabat {
    
    private String poslovniPartnerSifra;
    private String nazivPP;
    private String proizvodSifra;
    private String nazivProizvoda;
    private String vaziOD;
    private String vaziDO;
    private String rabat;
    
 public rabat()
 {
     poslovniPartnerSifra = null;
     nazivPP = null;
     proizvodSifra = null;
     nazivProizvoda = null;
     vaziOD = null;
     vaziDO = null;
     rabat = null;
 }
    
  public rabat(String pps, String pp, String proizvodS, String nazivPr, String vaziOD, String vaziDO, String rabat)
 {
     poslovniPartnerSifra = pps;
     nazivPP = pp;
     proizvodSifra = proizvodS;
     nazivProizvoda = nazivPr;
     this.vaziOD = vaziOD;
     this.vaziDO = vaziDO;
     this.rabat = rabat;
 }

    /**
     * @return the poslovniPartnerSifra
     */
    public String getPoslovniPartnerSifra() {
        return poslovniPartnerSifra;
    }

    /**
     * @param poslovniPartnerSifra the poslovniPartnerSifra to set
     */
    public void setPoslovniPartnerSifra(String poslovniPartnerSifra) {
        this.poslovniPartnerSifra = poslovniPartnerSifra;
    }

    /**
     * @return the nazivPP
     */
    public String getNazivPP() {
        return nazivPP;
    }

    /**
     * @param nazivPP the nazivPP to set
     */
    public void setNazivPP(String nazivPP) {
        this.nazivPP = nazivPP;
    }

    /**
     * @return the proizvodSifra
     */
    public String getProizvodSifra() {
        return proizvodSifra;
    }

    /**
     * @param proizvodSifra the proizvodSifra to set
     */
    public void setProizvodSifra(String proizvodSifra) {
        this.proizvodSifra = proizvodSifra;
    }

    /**
     * @return the nazivProizvoda
     */
    public String getNazivProizvoda() {
        return nazivProizvoda;
    }

    /**
     * @param nazivProizvoda the nazivProizvoda to set
     */
    public void setNazivProizvoda(String nazivProizvoda) {
        this.nazivProizvoda = nazivProizvoda;
    }

    /**
     * @return the vaziOD
     */
    public String getVaziOD() {
        return vaziOD;
    }

    /**
     * @param vaziOD the vaziOD to set
     */
    public void setVaziOD(String vaziOD) {
        this.vaziOD = vaziOD;
    }

    /**
     * @return the vaziDO
     */
    public String getVaziDO() {
        return vaziDO;
    }

    /**
     * @param vaziDO the vaziDO to set
     */
    public void setVaziDO(String vaziDO) {
        this.vaziDO = vaziDO;
    }

    /**
     * @return the rabat
     */
    public String getRabat() {
        return rabat;
    }

    /**
     * @param rabat the rabat to set
     */
    public void setRabat(String rabat) {
        this.rabat = rabat;
    }
    
  
}
