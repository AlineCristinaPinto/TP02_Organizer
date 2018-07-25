/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetmg.inf.organizer.model.domain;

/**
 *
 * @author aline
 */
public class Theme {
    private int idTheme;
    private int radiusLevel;
    private String letterColor;
    private String backgroundColor;
    private String secondColor;

    public int getIdTheme() {
        return idTheme;
    }

    public void setIdTheme(int idTheme) {
        this.idTheme = idTheme;
    }

    public int getRadiusLevel() {
        return radiusLevel;
    }

    public void setRadiusLevel(int radiusLevel) {
        this.radiusLevel = radiusLevel;
    }

    public String getLetterColor() {
        return letterColor;
    }

    public void setLetterColor(String letterColor) {
        this.letterColor = letterColor;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getSecondColor() {
        return secondColor;
    }

    public void setSecondColor(String secondColor) {
        this.secondColor = secondColor;
    }
    
    
}
