package com.example.asus.giaodien;

import android.widget.BaseAdapter;

/**
 * Created by ASUS on 04/04/2017.
 */

public class Xe {
    String BenXe;
    String SoXe;
    String TGKH;

    public Xe(String benXe, String soXe, String TGKH) {
        BenXe = benXe;
        SoXe = soXe;
        this.TGKH = TGKH;
    }

    public String getBenXe() {
        return BenXe;
    }

    public void setBenXe(String benXe) {
        BenXe = benXe;
    }

    public String getSoXe() {
        return SoXe;
    }

    public void setSoXe(String soXe) {
        SoXe = soXe;
    }

    public String getTGKH() {
        return TGKH;
    }

    public void setTGKH(String TGKH) {
        this.TGKH = TGKH;
    }
}
