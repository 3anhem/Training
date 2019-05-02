package vn.edu.vtn.bai2;

public class SanPham {
    private String masp;
    private String tensp;
    private String hinhAnh;

    @Override
    public String toString() {
        return "masp" + masp + "/n tensp" + tensp;
    }

    public String getMasp() {
        return masp;
    }

    public void setMasp(String masp) {
        this.masp = masp;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }


    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

}
