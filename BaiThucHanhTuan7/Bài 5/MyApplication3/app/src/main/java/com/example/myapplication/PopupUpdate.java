package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class PopupUpdate extends Activity {
    public SinhVienHolder holder;
    MyDatabase db;
    static Boolean updated = false;
    static Boolean dismiss = false;
    static SinhVien sv;
    public static String EXTRA_ID = "ID";
    public static String EXTRA_NAME = "NAME";
    public static String EXTRA_ADRESS = "ADDRESS";
    public static String EXTRA_SEX = "SEX";
    public static String EXTRA_IMG = "IMG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhap);
        db = new MyDatabase(this);
        updated = false;
        dismiss = false;
        init();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null) {

            Uri uri = data.getData();

            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                // Log.d(TAG, String.valueOf(bitmap));

                ImageView imageView = (ImageView) findViewById(R.id.Avatar);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void init(){
        holder = new SinhVienHolder();
        holder.Img = findViewById(R.id.Img);
        holder.Address = findViewById(R.id.Address);
        holder.Name = findViewById(R.id.Name);
        holder.Sex = findViewById(R.id.Radio_Sex);
        Button cancel = findViewById(R.id.cancel);
        Button save = findViewById(R.id.save);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                dismiss = true;
            }
        });

        ImageView img = findViewById(R.id.Avatar);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPickerImage();
            }
        });

        int id =  getIntent().getIntExtra(EXTRA_ID, -1);

        if (id == -1){
            save.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    hitSaveToInsert();
                    PopupUpdate.this.finish();
                }
            });
        }else {
            save.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    hitSaveToUpdate();
                    PopupUpdate.this.finish();
                }
            });
        }


        // setup value
        if (id == -1){
            holder.Address.setText("");
            holder.Name.setText("");
            holder.Sex.check(R.id.Sex_Male);
            holder.Img.setImageResource(R.mipmap.sample_avatar);
        }else {
            holder.Address.setText(getIntent().getStringExtra(EXTRA_ADRESS));
            holder.Name.setText(getIntent().getStringExtra(EXTRA_NAME));
            switch (getIntent().getStringExtra(EXTRA_SEX)){
                case SinhVien.SEX_MALE: holder.Sex.check(R.id.Sex_Male); break;
                case SinhVien.SEX_FEMALE: holder.Sex.check(R.id.Sex_Female); break;
                default: holder.Sex.check(R.id.Sex_Male); break;
            }
            holder.openAvatar(getIntent().getStringExtra(EXTRA_IMG));
        }



    }

    void hitSaveToInsert(){
        sv = new MyAction().insert(holder, db);
        updated = true;
    }
    void hitSaveToUpdate(){
        sv = new SinhVien();
        sv.ID = getIntent().getIntExtra(EXTRA_ID, -1);
        new MyAction().update(sv, holder, db);
        updated = true;
    }
    void showPickerImage(){
        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent, 1);
    }
    public static Boolean isUpdated(){
        return updated;
    }
    public static Boolean dismiss(){
        return dismiss;
    }
    public static SinhVien getSinhVien(){
        if (isUpdated()) {
            updated = false;
            return sv;
        }
        dismiss = false;
        return null;
    }
}
