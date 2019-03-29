/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reiseportal.jpa;

/**
 *
 * @author jonas
 * @content enum-class of Ausstattungen
 */
public enum Ausstattung {
    POOL, SAUNA, GYM, WLAN, WELLNESS;

    public String getLabel() {
        switch (this) {
            case POOL:
                return "Schwimmbad";
            case SAUNA:
                return "Sauna";
            case GYM:
                return "Fitnesscenter";
            case WLAN:
                return "WLAN";
            case WELLNESS:
                return "Wellnesscenter";
            default:
                return this.toString();
        }
    }
}
