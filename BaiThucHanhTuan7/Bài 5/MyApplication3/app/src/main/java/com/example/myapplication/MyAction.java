package com.example.myapplication;


public class MyAction {

    public MyAction(){}
    public SinhVien insert(SinhVienHolder holder, MyDatabase db) {
        SinhVien sv = new SinhVien();
        sv.Name = holder.Name.getText().toString();
        sv.Address = holder.Address.getText().toString();

        int id_checked = holder.Sex.getCheckedRadioButtonId();
        switch(id_checked){
            case R.id.Sex_Male: sv.Sex = SinhVien.SEX_MALE; break;
            case R.id.Sex_Female: sv.Sex = SinhVien.SEX_FEMALE; break;
            default: sv.Sex = SinhVien.SEX_MALE; break;
        }

        if (holder.File_Img!=null && holder.File_Img.exists()){
            sv.Img = holder.File_Img.getAbsolutePath();
        } else sv.Img = null;

        return db.insertSinhVien(sv)?sv:null;
    }
    public Boolean update(SinhVien sv, SinhVienHolder holder, MyDatabase db){
        String name = holder.Name.getText().toString();
        String address = holder.Address.getText().toString();
        int id_checked = holder.Sex.getCheckedRadioButtonId();
        String sex;
        switch (id_checked){
            case R.id.Sex_Male: sex = SinhVien.SEX_MALE; break;
            case R.id.Sex_Female: sex = SinhVien.SEX_FEMALE; break;
            default: sex = SinhVien.SEX_MALE; break;
        }

        sv.Name = name;
        sv.Address = address;
        sv.Sex = sex;

        return db.updateSinhVien(sv);
    }
}
