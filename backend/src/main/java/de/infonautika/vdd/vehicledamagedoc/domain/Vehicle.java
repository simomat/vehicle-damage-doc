package de.infonautika.vdd.vehicledamagedoc.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Vehicle {

    private String erstzulassung;
    private String fahrzeugklasse;
    @Id
    private String identifizierungsnummer;
    private String marke;
    private Typvarianteversion typvarianteversion;
    private String handelsbezeichnungen;
    private String herstellerkurzbezeichnung;
    private String bezeichnungfahrzeugklasse;
    private String schadstoffklasse;
    private String emissionsklasse;
    private String kraftstoff;

    public void setErstzulassung(String erstzulassung) {
        this.erstzulassung = erstzulassung;
    }

    public void setFahrzeugklasse(String fahrzeugklasse) {
        this.fahrzeugklasse = fahrzeugklasse;
    }

    public void setIdentifizierungsnummer(String identifizierungsnummer) {
        this.identifizierungsnummer = identifizierungsnummer;
    }

    public void setMarke(String marke) {
        this.marke = marke;
    }

    public void setTypvarianteversion(Typvarianteversion typvarianteversion) {
        this.typvarianteversion = typvarianteversion;
    }

    public void setHandelsbezeichnungen(String handelsbezeichnungen) {
        this.handelsbezeichnungen = handelsbezeichnungen;
    }

    public void setHerstellerkurzbezeichnung(String herstellerkurzbezeichnung) {
        this.herstellerkurzbezeichnung = herstellerkurzbezeichnung;
    }

    public void setBezeichnungfahrzeugklasse(String bezeichnungfahrzeugklasse) {
        this.bezeichnungfahrzeugklasse = bezeichnungfahrzeugklasse;
    }

    public void setSchadstoffklasse(String schadstoffklasse) {
        this.schadstoffklasse = schadstoffklasse;
    }

    public void setEmissionsklasse(String emissionsklasse) {
        this.emissionsklasse = emissionsklasse;
    }

    public void setKraftstoff(String kraftstoff) {
        this.kraftstoff = kraftstoff;
    }

    public String getErstzulassung() {
        return erstzulassung;
    }

    public String getFahrzeugklasse() {
        return fahrzeugklasse;
    }

    public String getIdentifizierungsnummer() {
        return identifizierungsnummer;
    }

    public String getMarke() {
        return marke;
    }

    public Typvarianteversion getTypvarianteversion() {
        return typvarianteversion;
    }

    public String getHandelsbezeichnungen() {
        return handelsbezeichnungen;
    }

    public String getHerstellerkurzbezeichnung() {
        return herstellerkurzbezeichnung;
    }

    public String getBezeichnungfahrzeugklasse() {
        return bezeichnungfahrzeugklasse;
    }

    public String getSchadstoffklasse() {
        return schadstoffklasse;
    }

    public String getEmissionsklasse() {
        return emissionsklasse;
    }

    public String getKraftstoff() {
        return kraftstoff;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "erstzulassung='" + erstzulassung + '\'' +
                ", fahrzeugklasse='" + fahrzeugklasse + '\'' +
                ", identifizierungsnummer='" + identifizierungsnummer + '\'' +
                ", marke='" + marke + '\'' +
                ", typvarianteversion=" + typvarianteversion +
                ", handelsbezeichnungen='" + handelsbezeichnungen + '\'' +
                ", herstellerkurzbezeichnung='" + herstellerkurzbezeichnung + '\'' +
                ", bezeichnungfahrzeugklasse='" + bezeichnungfahrzeugklasse + '\'' +
                ", schadstoffklasse='" + schadstoffklasse + '\'' +
                ", emissionsklasse='" + emissionsklasse + '\'' +
                ", kraftstoff='" + kraftstoff + '\'' +
                '}';
    }
}
