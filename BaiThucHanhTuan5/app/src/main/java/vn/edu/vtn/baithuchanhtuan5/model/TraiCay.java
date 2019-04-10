package vn.edu.vtn.baithuchanhtuan5.model;

public class TraiCay {
    int hinh;
    String ten;
    String mota;

    public TraiCay() {
    }

    public TraiCay(int hinh, String ten, String mota) {
        this.hinh = hinh;
        this.ten = ten;
        this.mota = mota;
    }

    public int getHinh() {
        return hinh;
    }

    public void setHinh(int hinh) {
        this.hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }
}
