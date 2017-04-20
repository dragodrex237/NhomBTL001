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
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ASUS on 04/04/2017.
 */

public class ChuyenXeAdapter extends BaseAdapter implements Filterable{

    Activity myContext;
    int Layout;
    ArrayList<ChuyenXe> listCX;
    ArrayList<ChuyenXe> listRoot;
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
            riderholder.img=(ImageView)view.findViewById(R.id.imageView);
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

        riderholder.img.setImageResource(R.drawable.xe);

        Button btXem=(Button)view.findViewById(R.id.button);
        btXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(MainActivity.KiemTraDN==true) {
                    Intent intent = new Intent(myContext, ThongTinXe.class);
                    Bundle myBundle = new Bundle();
                    myBundle.putString("Nhaxe", listCX.get(i).getTenNhaXe());
                    myBundle.putString("Di", listCX.get(i).getDiemDi());
                    myBundle.putString("Den", listCX.get(i).getDiemDen());
                    myBundle.putString("Gia", listCX.get(i).getGiaTien());
                    intent.putExtras(myBundle);
                    myContext.startActivity(intent);
                }
                else
                    Toast.makeText(myContext, "Hãy đăng nhập để có thể tiếp tục", Toast.LENGTH_SHORT).show();
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
        ImageView img;
    }

    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults=new FilterResults();
                ArrayList<ChuyenXe> FilterArray=new ArrayList<ChuyenXe>();
                if(listRoot==null || listRoot.size()==0)
                {
                    listRoot=new ArrayList<ChuyenXe>(listCX);
                }
                if(charSequence==null || charSequence.length()==0)
                {
                    filterResults.count=listRoot.size();
                    filterResults.values=listRoot;
                }
                else
                {
                    Locale locale=Locale.getDefault();
                    charSequence=charSequence.toString().toLowerCase(locale);
                    for(int i=0; i<listRoot.size(); i++)
                    {
                        ChuyenXe cx=listRoot.get(i);
                        String tennhaxe=cx.getTenNhaXe();
                        String tendiemdi=cx.getDiemDi();
                        String tendiemden=cx.getDiemDen();
                        String giatien=cx.getGiaTien();
                        if(tennhaxe.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(cx);
                        }
                        else if(tendiemdi.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(cx);
                        }
                        else if(tendiemden.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(cx);
                        }
                        else if(giatien.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(cx);
                        }
                        filterResults.count=FilterArray.size();
                        filterResults.values=FilterArray;
                    }
                }
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {

                listCX= (ArrayList<ChuyenXe>) filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }

}
