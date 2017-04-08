package com.example.asus.giaodien;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ASUS on 04/04/2017.
 */

public class ChuyenXeAdapter extends BaseAdapter {

    Activity myContext;
    int Layout;
    ArrayList<ChuyenXe> listCX;

    public ChuyenXeAdapter(Activity myContext, int layout, ArrayList<ChuyenXe> listCX) {
        this.myContext = myContext;
        Layout = layout;
        this.listCX = listCX;
    }

    @Override
    public int getCount() {
        return listCX.size();
    }

    @Override
    public Object getItem(int i) {
        return listCX.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        XeHolder riderholder;
        if(view==null)
        {
            riderholder=new XeHolder();
            view= LayoutInflater.from(myContext).inflate(R.layout.row_chuyenxe, viewGroup, false);
            riderholder.TNX=(TextView)view.findViewById(R.id.txtNhaXe);
            riderholder.Di=(TextView)view.findViewById(R.id.txtDiemDi);
            riderholder.Den=(TextView)view.findViewById(R.id.txtDiemDen);
            riderholder.Gia=(TextView)view.findViewById(R.id.txtGiaTien);
            view.setTag(riderholder);
        }
        else
        {
            riderholder=(XeHolder)view.getTag();
        }
        riderholder.TNX.setText(listCX.get(i).getTenNhaXe());
        riderholder.Di.setText(listCX.get(i).getDiemDi());
        riderholder.Den.setText(listCX.get(i).getDiemDen());
        riderholder.Gia.setText(listCX.get(i).getGiaTien());

        Button btXem=(Button)view.findViewById(R.id.button);
        btXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(myContext, ThongTinXe.class);
                Bundle myBundle=new Bundle();
                myBundle.putString("Nhaxe", listCX.get(i).getTenNhaXe());
                myBundle.putString("Di", listCX.get(i).getDiemDi());
                myBundle.putString("Den", listCX.get(i).getDiemDen());
                myBundle.putString("Gia", listCX.get(i).getGiaTien());
                intent.putExtras(myBundle);
                myContext.startActivity(intent);
            }
        });

        return view;
    }

    public class XeHolder
    {
        TextView TNX;
        TextView Di;
        TextView Den;
        TextView Gia;
    }
}
