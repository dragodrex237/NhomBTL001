package com.example.asus.dn_dk;

/**
 * Created by ASUS on 3/25/2017.
 */
import java.io.Serializable;

public class Taikhoan implements Serializable{
    public String id;
    public String mk;

    public Taikhoan(String id, String mk) {
        this.id = id;
        this.mk = mk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMk() {
        return mk;
    }

    public void setMk(String mk) {
        this.mk = mk;
    }
}
