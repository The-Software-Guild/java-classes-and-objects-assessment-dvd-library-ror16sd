/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sal.dvdlibrary.dto;


import java.util.Date;

public class DvD {
    private String title;
    private String ReleaseDate;
    private String MPAA;
    private String DirectorsName;
    private String Studio;
    private String UserRating;

    public DvD(String title) {
        this.title = title;
    }

    //getters for DvD
    public String getTitle(){return title;}
    public String getReleaseDate(){return ReleaseDate;}
    public String getMPAA(){return MPAA;}
    public String getDirectorsName(){return DirectorsName;}
    public String getStudio(){return Studio;}
    public String getUserRating(){return UserRating;}

    //setters for DvD
    public void  setTitle(String title){
        this.title = title;
    }
    public void setReleaseDate(String ReleaseDate){
        this.ReleaseDate = ReleaseDate;
    }
    public void setMPAA(String MPAA){
        this.MPAA = MPAA;
    }
    public void setDirectorsName(String DirectorsName){
        this.DirectorsName = DirectorsName;
    }
    public void setStudio(String Studio){
        this.Studio = Studio;
    }
    public void setUserRating(String UserRating){
        this.UserRating = UserRating;
    }


}
