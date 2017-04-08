package com.example.asus.filtercustomadapter;

/**
 * Created by ASUS on 01/04/2017.
 */

public class KamenRider {
    String Number;
    String Name;
    String FinalForm;

    public KamenRider(String number, String name, String finalForm) {
        Number = number;
        Name = name;
        FinalForm = finalForm;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getFinalForm() {
        return FinalForm;
    }

    public void setFinalForm(String finalForm) {
        FinalForm = finalForm;
    }
}
