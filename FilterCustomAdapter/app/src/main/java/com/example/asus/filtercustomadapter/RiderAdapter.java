package com.example.asus.filtercustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.crypto.KeyAgreement;

/**
 * Created by ASUS on 01/04/2017.
 */

public class RiderAdapter extends BaseAdapter implements Filterable{
    ArrayList<KamenRider> Riderlist;
    ArrayList<KamenRider>OriginList;
    int RiderLayout;
    Context RiderContext;

    public RiderAdapter(Context riderContext, int riderLayout, ArrayList<KamenRider> riderlist) {
        Riderlist = riderlist;
        RiderLayout = riderLayout;
        RiderContext = riderContext;
    }

    @Override
    public int getCount() {
        return Riderlist.size();
    }

    @Override
    public Object getItem(int i) {
        return Riderlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        RiderHolder riderholder;
        if(view==null)
        {
            riderholder=new RiderHolder();
            view= LayoutInflater.from(RiderContext).inflate(R.layout.rider_row, viewGroup, false);
            riderholder.Name=(TextView)view.findViewById(R.id.txtName);
            riderholder.Number=(TextView)view.findViewById(R.id.txtNumber);
            riderholder.FinalForm=(TextView)view.findViewById(R.id.txtFinalForm);
            view.setTag(riderholder);
        }
        else
        {
            riderholder=(RiderHolder)view.getTag();
        }
        riderholder.Name.setText(Riderlist.get(i).getName());
        riderholder.Number.setText(Riderlist.get(i).getNumber());
        riderholder.FinalForm.setText(Riderlist.get(i).getFinalForm());
        return view;
    }

    public class RiderHolder
    {
        TextView Number;
        TextView Name;
        TextView FinalForm;
    }

    @Override
    public Filter getFilter() {
        Filter filter=new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults=new FilterResults();
                ArrayList<KamenRider> FilterArray=new ArrayList<KamenRider>();
                if(OriginList==null || OriginList.size()==0)
                {
                    OriginList=new ArrayList<KamenRider>(Riderlist);
                }
                if(charSequence==null || charSequence.length()==0)
                {
                    filterResults.count=OriginList.size();
                    filterResults.values=OriginList;
                }
                else
                {
                    Locale locale=Locale.getDefault();
                    charSequence=charSequence.toString().toLowerCase(locale);
                    for(int j=0; j<OriginList.size(); j++)
                    {
                        KamenRider KR=OriginList.get(j);
                        String data1=KR.getNumber();
                        String data2=KR.getName();
                        String data3=KR.getFinalForm();
                        if(data1.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(KR);
                        }
                        else if(data2.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(KR);
                        }
                        else if(data3.toLowerCase(locale).contains(charSequence))
                        {
                            FilterArray.add(KR);
                        }
                    }
                    filterResults.count=FilterArray.size();
                    filterResults.values=FilterArray;
                }
                return filterResults;
            }

            @SuppressWarnings("unchecked")
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                Riderlist=(ArrayList<KamenRider>)filterResults.values;
                notifyDataSetChanged();
            }
        };
        return filter;
    }


}
