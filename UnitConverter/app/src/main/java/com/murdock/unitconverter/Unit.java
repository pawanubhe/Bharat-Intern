package com.murdock.unitconverter;

import java.io.Serializable;

public class Unit implements Serializable {
    String unit1;
    String unit2;

    public Unit(String unit1, String unit2) {
        this.unit1 = unit1;
        this.unit2 = unit2;
    }

    public String getUnit1() {
        return unit1;
    }

    public void setUnit1(String unit1) {
        this.unit1 = unit1;
    }

    public String getUnit2() {
        return unit2;
    }

    public void setUnit2(String unit2) {
        this.unit2 = unit2;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unit1='" + unit1 + '\'' +
                ", unit2='" + unit2 + '\'' +
                '}';
    }
}
