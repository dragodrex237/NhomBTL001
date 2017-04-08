package com.example.asus.giaodien;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ThongTinXe extends AppCompatActivity {

    TextView txtTTNhaxe, txtTTDi, txtTTDen, txtTTGia;
    ListView LVXe;
    ArrayList<Xe> listXe;
    XeAdapter XeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_tin_xe);
        txtTTNhaxe=(TextView)findViewById(R.id.txtTTNhaXe);
        txtTTDi=(TextView)findViewById(R.id.txtTTDiemDi);
        txtTTDen=(TextView)findViewById(R.id.txtTTDiemDen);
        txtTTGia=(TextView)findViewById(R.id.txtTTGiaTien);



        Intent myintent=getIntent();
        Bundle myBundle=myintent.getExtras();

        String nhaxe=myBundle.getString("Nhaxe");
        String di=myBundle.getString("Di");
        String den=myBundle.getString("Den");
        String gia=myBundle.getString("Gia");

        txtTTNhaxe.setText(nhaxe);
        txtTTDi.setText(di);
        txtTTDen.setText(den);
        txtTTGia.setText(gia);

        LVXe=(ListView)findViewById(R.id.list002);
        ListInit();
        XeAdapter=new XeAdapter(this, R.layout.row_thongtin, listXe);
        LVXe.setAdapter(XeAdapter);
    }

    private void ListInit() {
        listXe=new ArrayList<Xe>();
        listXe.add(new Xe("Bến Xe A","001","06:00 AM"));
        listXe.add(new Xe("Bến Xe B","002","05:00 PM"));
        listXe.add(new Xe("Bến Xe C","003","12:00 PM"));
        listXe.add(new Xe("Bến Xe A","003","04:00 PM"));
        listXe.add(new Xe("Bến Xe B","022","11:00 AM"));
        listXe.add(new Xe("Bến Xe C","012","05:30 AM"));

    }
}
