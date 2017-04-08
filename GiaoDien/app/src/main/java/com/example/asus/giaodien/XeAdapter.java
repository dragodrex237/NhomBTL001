package com.example.asus.giaodien;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by ASUS on 04/04/2017.
 */

public class XeAdapter extends BaseAdapter {

    Activity myContext;
    int Layout;
    ArrayList<Xe> listXe;

    public XeAdapter(Activity myContext, int layout, ArrayList<Xe> listXe) {
        this.myContext = myContext;
        Layout = layout;
        this.listXe = listXe;
    }

    @Override
    public int getCount() {
        return listXe.size();
    }

    @Override
    public Object getItem(int i) {
        return listXe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Xe1Holder riderholder;
        if(view==null)
        {
            riderholder=new Xe1Holder();
            view= LayoutInflater.from(myContext).inflate(R.layout.row_thongtin, viewGroup, false);
            riderholder.SoXe=(TextView)view.findViewById(R.id.txtSoXe);
            riderholder.BenXe=(TextView)view.findViewById(R.id.txtBenXe);
            riderholder.TGKH=(TextView)view.findViewById(R.id.txtTGKH);
            view.setTag(riderholder);
        }
        else
        {
            riderholder=(Xe1Holder) view.getTag();
        }
        riderholder.SoXe.setText(listXe.get(i).getSoXe());
        riderholder.BenXe.setText(listXe.get(i).getBenXe());
        riderholder.TGKH.setText(listXe.get(i).getTGKH());

        return view;
    }

    public class Xe1Holder
    {
        TextView SoXe;
        TextView BenXe;
        TextView TGKH;
    }
}
