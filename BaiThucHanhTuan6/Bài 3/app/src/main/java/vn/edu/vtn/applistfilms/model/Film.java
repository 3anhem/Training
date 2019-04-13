package vn.edu.vtn.applistfilms.model;

import java.io.Serializable;

public class Film implements Serializable {
    private String name;
    private String content;
    private int image;

    public Film() {
    }

    public Film(String name, String content, int image) {
        this.name = name;
        this.content = content;
        this.image = image;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
