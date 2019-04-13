package com.example.bt2_b6;

import java.io.Serializable;

public class FootballLegend implements Serializable {
    public int image;
    private String name;
    private String soBanThang;
    private String cauLacBo;

    public FootballLegend() {
    }

    public FootballLegend(int image, String name, String soBanThang,String cauLacBo) {
        this.image = image;
        this.name = name;
        this.soBanThang = soBanThang;
        this.cauLacBo = cauLacBo;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSoBanThang() {
        return soBanThang;
    }

    public void setSoBanThang(String soBanThang) {
        this.soBanThang = soBanThang;
    }

    public String getCauLacBo() {
        return cauLacBo;
    }

    public void setCauLacBo(String cauLacBo) {
        this.cauLacBo = cauLacBo;
    }
}
