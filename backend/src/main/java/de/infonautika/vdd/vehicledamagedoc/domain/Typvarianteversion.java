package de.infonautika.vdd.vehicledamagedoc.domain;

import java.util.StringJoiner;

public class Typvarianteversion {

    private String typ;
    private String variante;
    private String version;

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setVariante(String variante) {
        this.variante = variante;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Typvarianteversion.class.getSimpleName() + "[", "]")
                .add("typ='" + typ + "'")
                .add("variante='" + variante + "'")
                .add("version='" + version + "'")
                .toString();
    }
}
