package vn.edu.vtn.baithuchanhtuan5.model;

public class FootballLegend {
    public int id_football;
    public String name;
    public String birthday;
    public int id_flag;
    public FootballLegend(int id, String name, String birthday, int id_flag){
        this.id_football=id;
        this.name=name;
        this.birthday=birthday;
        this.id_flag=id_flag;
    }
}
