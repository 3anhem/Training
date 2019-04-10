package vn.edu.vtn.baithuchanhtuan5.model;

public class Country {
    private int image;
    private String name;
    private String population;

    public Country() {
    }

    public Country(int image, String name, String population) {
        this.image = image;
        this.name = name;
        this.population = population;
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

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }
}
