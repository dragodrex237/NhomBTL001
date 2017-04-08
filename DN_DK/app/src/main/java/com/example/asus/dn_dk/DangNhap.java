package com.example.asus.dn_dk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class DangNhap extends AppCompatActivity {

    Button btThoat, btLogin;
    EditText edID, edPW;
    ArrayList<Taikhoan> taikhoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        btThoat=(Button)findViewById(R.id.button);
        btLogin=(Button)findViewById(R.id.button2);
        edID=(EditText)findViewById(R.id.edID);
        edPW=(EditText)findViewById(R.id.edPW);



        btThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id, pw;
                id=edID.getText().toString();
                pw=edPW.getText().toString();
                Intent intent = getIntent();
                Bundle bundle=intent.getExtras();
                boolean dung=false;
                taikhoan=(ArrayList<Taikhoan>)bundle.getSerializable("taikhoan");
                for (Taikhoan tk: taikhoan) {
                    if(id.equals(tk.getId())&& pw.equals(tk.getMk())) {
                        dung=true;
                        break;
                    }
                }
                if(dung==false)
                {
                    Toast.makeText(DangNhap.this, "Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(DangNhap.this, "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
