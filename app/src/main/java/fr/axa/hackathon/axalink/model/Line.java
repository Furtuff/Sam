package fr.axa.hackathon.axalink.model;

/**
 * Created by tuffery on 15/10/16.
 */

public class Line {
    private String grosTitres;
    private String sousTitres;
    private String type;

    public Line(String grosTitres, String sousTitres, String type) {
        this.grosTitres = grosTitres;
        this.sousTitres = sousTitres;
        this.type = type;
    }

    public String getGrosTitres() {
        return grosTitres;
    }

    public void setGrosTitres(String grosTitres) {
        this.grosTitres = grosTitres;
    }

    public String getSousTitres() {
        return sousTitres;
    }

    public void setSousTitres(String sousTitres) {
        this.sousTitres = sousTitres;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
