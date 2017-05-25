package com.example.alierdemakin.yazlab;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Home {

    @SerializedName("evID")
    @Expose
    private String evID;
    @SerializedName("evIL")
    @Expose
    private String evIL;
    @SerializedName("evEmlakTip")
    @Expose
    private String evEmlakTip;
    @SerializedName("evAlan")
    @Expose
    private String evAlan;
    @SerializedName("evOdaSayisi")
    @Expose
    private String evOdaSayisi;
    @SerializedName("evBinaYasi")
    @Expose
    private String evBinaYasi;
    @SerializedName("evBulKat")
    @Expose
    private String evBulKat;
    @SerializedName("evFiyat")
    @Expose
    private String evFiyat;
    @SerializedName("evAciklama")
    @Expose
    private String evAciklama;
    @SerializedName("Pictures")
    @Expose
    private List<Picture> pictures = null;

    public String getEvID() {
        return evID;
    }

    public void setEvID(String evID) {
        this.evID = evID;
    }

    public String getEvIL() {
        return evIL;
    }

    public void setEvIL(String evIL) {
        this.evIL = evIL;
    }

    public String getEvEmlakTip() {
        return evEmlakTip;
    }

    public void setEvEmlakTip(String evEmlakTip) {
        this.evEmlakTip = evEmlakTip;
    }

    public String getEvAlan() {
        return evAlan;
    }

    public void setEvAlan(String evAlan) {
        this.evAlan = evAlan;
    }

    public String getEvOdaSayisi() {
        return evOdaSayisi;
    }

    public void setEvOdaSayisi(String evOdaSayisi) {
        this.evOdaSayisi = evOdaSayisi;
    }

    public String getEvBinaYasi() {
        return evBinaYasi;
    }

    public void setEvBinaYasi(String evBinaYasi) {
        this.evBinaYasi = evBinaYasi;
    }

    public String getEvBulKat() {
        return evBulKat;
    }

    public void setEvBulKat(String evBulKat) {
        this.evBulKat = evBulKat;
    }

    public String getEvFiyat() {
        return evFiyat;
    }

    public void setEvFiyat(String evFiyat) {
        this.evFiyat = evFiyat;
    }

    public String getEvAciklama() {
        return evAciklama;
    }

    public void setEvAciklama(String evAciklama) {
        this.evAciklama = evAciklama;
    }

    public List<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(List<Picture> pictures) {
        this.pictures = pictures;
    }

}