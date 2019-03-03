package de.infonautika.vdd.vehicledamagedoc.domain;

import java.util.StringJoiner;

public class Doku {

    private String erstzulassung;
    private String fahrzeugklasse;
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

    @Override
    public String toString() {
        return new StringJoiner(", ", Doku.class.getSimpleName() + "[", "]")
                .add("erstzulassung='" + erstzulassung + "'")
                .add("fahrzeugklasse='" + fahrzeugklasse + "'")
                .add("identifizierungsnummer='" + identifizierungsnummer + "'")
                .add("marke='" + marke + "'")
                .add("typvarianteversion=" + typvarianteversion)
                .add("handelsbezeichnungen='" + handelsbezeichnungen + "'")
                .add("herstellerkurzbezeichnung='" + herstellerkurzbezeichnung + "'")
                .add("bezeichnungfahrzeugklasse='" + bezeichnungfahrzeugklasse + "'")
                .add("schadstoffklasse='" + schadstoffklasse + "'")
                .add("emissionsklasse='" + emissionsklasse + "'")
                .add("kraftstoff='" + kraftstoff + "'")
                .toString();
    }
}
