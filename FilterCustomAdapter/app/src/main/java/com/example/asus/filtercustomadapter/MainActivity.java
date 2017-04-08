package com.example.asus.filtercustomadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText txtTK;
    ListView ListRider;
    RiderAdapter riderAdapter;
    ArrayList<KamenRider> RiderList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTK=(EditText) findViewById(R.id.edtk);
        ListRider=(ListView)findViewById(R.id.listKR);



        ListInit();
        riderAdapter=new RiderAdapter(MainActivity.this, R.layout.rider_row, RiderList);

        ListRider.setAdapter(riderAdapter);

        txtTK.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                riderAdapter.getFilter().filter(editable);

            }
        });
    }

    private void ListInit() {
        RiderList=new ArrayList<KamenRider>();
        RiderList.add(new KamenRider("2000","Kamen Rider Kuuga", "Ultimate"));

        RiderList.add(new KamenRider("2001","Kamen Rider Agito", "Shining"));
        RiderList.add(new KamenRider("2001","Kamen Rider G3", "G3-X"));
        RiderList.add(new KamenRider("2001","Kamen Rider Gill", "Exceed"));

        RiderList.add(new KamenRider("2002","Kamen Rider Ryuki", "Survive"));
        RiderList.add(new KamenRider("2002","Kamen Rider Knight", "Survive"));

        RiderList.add(new KamenRider("2003","Kamen Rider Faiz", "Blaster"));

        RiderList.add(new KamenRider("2004","Kamen Rider Blade", "King"));
        RiderList.add(new KamenRider("2004","Kamen Rider Chalice", "Wild"));

        RiderList.add(new KamenRider("2005","Kamen Rider Hibiki", "Armor"));

        RiderList.add(new KamenRider("2006","Kamen Rider Kabuto", "Hyper"));
        RiderList.add(new KamenRider("2006","Kamen Rider Gattack", "Hyper"));

        RiderList.add(new KamenRider("2007","Kamen Rider Den-o", "Climax"));
        RiderList.add(new KamenRider("2007","Kamen Rider Zeronos", "Zero"));

        RiderList.add(new KamenRider("2008","Kamen Rider Kiva", "Emperor"));
        RiderList.add(new KamenRider("2008","Kamen Rider Ixa", "Rising"));

        RiderList.add(new KamenRider("2009","Kamen Rider Decade", "Complete"));
        RiderList.add(new KamenRider("2009","Kamen Rider Diend", "Complete"));

        RiderList.add(new KamenRider("2010", "Kamen Rider Double", "Xtreme"));
        RiderList.add(new KamenRider("2010", "Kamen Rider Accel", "Trial/Booster"));

        RiderList.add(new KamenRider("2011", "Kamen Rider OOO", "Putotyra"));
        RiderList.add(new KamenRider("2011", "Kamen Rider Birth", "Birthday"));

        RiderList.add(new KamenRider("2012", "Kamen Rider Fourze", "Cosmic"));
        RiderList.add(new KamenRider("2012", "Kamen Rider Meteor", "Storm"));

        RiderList.add(new KamenRider("2013", "Kamen Rider Wizard", "Infinity"));
        RiderList.add(new KamenRider("2013", "Kamen Rider Beast", "Hyper"));

        RiderList.add(new KamenRider("2014", "Kamen Rider Gaim", "Kiwami"));
        RiderList.add(new KamenRider("2014", "Kamen Rider Baron", "Golden"));

        RiderList.add(new KamenRider("2015", "Kamen Rider Drive", "Tridoron"));
        RiderList.add(new KamenRider("2015", "Kamen Rider Mach", "Ridecrosser"));

        RiderList.add(new KamenRider("2016", "Kamen Rider Ghost", "Mugen"));
        RiderList.add(new KamenRider("2016", "Kamen Rider Specter", "Deep/Sins"));

        RiderList.add(new KamenRider("2017", "Kamen Rider Ex-Aid", "Muteki"));
        RiderList.add(new KamenRider("2017", "Kamen Rider Brave", "Fantasy"));
        RiderList.add(new KamenRider("2017", "Kamen Rider Snipe", "Simulation"));

    }

}
