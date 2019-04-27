package com.example.bt4_t7;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText edtten, edtgia;
    Button btnthem,btndanhsach;
    ImageView imganh;
    int REQUEST_CODE = 100 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add();

    }

    private void add() {
        db=new SQL(this,"BanHang.sqlite",null,1);
        db.TruyVan("Create Table If not Exists SanPham(ID Integer Primary Key Autoincrement, TenSP Varchar, Gia Integer, HinhMh Blob)");
        edtten= (EditText) findViewById(R.id.edtTen);
        edtgia= (EditText) findViewById(R.id.edtGiatien);
        btnthem= (Button) findViewById(R.id.btnThemSP);
        btndanhsach= (Button) findViewById(R.id.btnXemDS);
        imganh= (ImageView) findViewById(R.id.imageView);

        imganh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
                startActivityForResult(intent,REQUEST_CODE);
            }
        });
        btnthem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.Insertsanpham(edtten.getText().toString(), Integer.parseInt(edtgia.getText().toString()),ConverttoArrayByte(imganh));
                Toast.makeText(MainActivity.this,"Thêm thành công",Toast.LENGTH_SHORT).show();
                edtgia.setText("");
                edtten.setText("");
                edtten.requestFocus();
            }
        });
        btndanhsach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,DanhsachSP.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode== REQUEST_CODE&&resultCode==RESULT_OK)
        {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            imganh.setImageBitmap(imageBitmap);
        }
    }

    public byte[] ConverttoArrayByte(ImageView img)
    {
        BitmapDrawable bitmapDrawable = (BitmapDrawable) img.getDrawable();
        Bitmap bitmap=bitmapDrawable.getBitmap();

        ByteArrayOutputStream stream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
        return stream.toByteArray();
    }

    public static SQL db;


}
