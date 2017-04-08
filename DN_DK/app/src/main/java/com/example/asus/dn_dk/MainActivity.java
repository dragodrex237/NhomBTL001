package com.example.asus.dn_dk;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btDN, btDK;
    String ten, mk;
    ArrayList<Taikhoan> taikhoan = new ArrayList<Taikhoan>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btDN=(Button)findViewById(R.id.btDN);
        btDK=(Button)findViewById(R.id.btDK);

        taikhoan.add(new Taikhoan("hung", "123456"));
        btDN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, DangNhap.class);
                Bundle extra=new Bundle();
                extra.putSerializable("taikhoan", taikhoan);
                intent.putExtras(extra);
                startActivity(intent);
            }
        });
        btDK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog dialog =new Dialog(MainActivity.this);
                dialog.setTitle("Đăng Ký Tài Khoản");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.dang_ky);
                final EditText ed01=(EditText)dialog.findViewById(R.id.editText);
                final EditText ed02=(EditText)dialog.findViewById(R.id.editText2);
                Button bt01=(Button)dialog.findViewById(R.id.button3);
                Button bt02=(Button)dialog.findViewById(R.id.button4);

                bt01.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ten=ed01.getText().toString();
                        mk=ed02.getText().toString();
                        taikhoan.add(new Taikhoan(ten, mk));
                        Toast.makeText(MainActivity.this, "Đăng Ký tài khoàn thành công", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                bt02.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.cancel();
                    }
                });

                dialog.show();


            }
        });
    }
}
