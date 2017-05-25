package com.example.alierdemakin.yazlab;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Picture {

    @SerializedName("resimID")
    @Expose
    private String resimID;
    @SerializedName("resimYol")
    @Expose
    private String resimYol;
    @SerializedName("resimEvID")
    @Expose
    private String resimEvID;

    public String getResimID() {
        return resimID;
    }

    public void setResimID(String resimID) {
        this.resimID = resimID;
    }

    public String getResimYol() {
        return resimYol;
    }

    public void setResimYol(String resimYol) {
        this.resimYol = resimYol;
    }

    public String getResimEvID() {
        return resimEvID;
    }

    public void setResimEvID(String resimEvID) {
        this.resimEvID = resimEvID;
    }

}