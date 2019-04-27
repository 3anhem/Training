package com.example.myapplication;


import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.io.File;

public class SinhVienHolder {
    public ImageView Img;
    public TextView Name;
    public TextView Address;
    public RadioGroup Sex;

    public File File_Img;

    public Boolean openAvatar(String Img){
        if (Img==null || Img.isEmpty()) return false;
        if (File_Img==null){
            File_Img = new File(Img);
        }
        if (File_Img.exists()) {

            return true;
        }
        return false;
    }
}
