package com.example.asus.giaodien;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView LVXe;
    ArrayList<ChuyenXe> listXe;
    ChuyenXeAdapter XeAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LVXe=(ListView)findViewById(R.id.list001);
        ListInit();
        XeAdapter=new ChuyenXeAdapter(MainActivity.this, R.layout.row_chuyenxe, listXe);
        LVXe.setAdapter(XeAdapter);
    }

    private void ListInit() {
        listXe = new ArrayList<ChuyenXe>();
        listXe.add(new ChuyenXe("Nhà Xe 1", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 2", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 3", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 4", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 5", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 6", "TP HCM", "Hà Nội", "100,000 Đ"));
        listXe.add(new ChuyenXe("Nhà Xe 7", "TP HCM", "Hà Nội", "100,000 Đ"));
    }
}
