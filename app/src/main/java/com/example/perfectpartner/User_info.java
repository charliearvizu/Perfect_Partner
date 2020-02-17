package com.example.perfectpartner;

import java.sql.Time;
import java.util.Date;

public class User_info {
    private String f_name, l_name;
    private int year, month, day;
    private String dob;

    public User_info() {

    }

    public void setdob(int month,int day, int year) {
        dob = month + "/" + day + "/" + year;
    }

    public String getdob() {
        return dob;
    }

    public String getf_name() {
    return f_name;
    }

    public void setf_name(String F_name) {
        f_name = F_name;
    }

    public String getl_name() {
        return l_name;
    }

    public void setl_name(String L_name) {
        l_name = L_name;
    }

    public int getyear() {
        return year;
    }

    public void setyear(int Year) {
        year = Year;
    }

    public int getmonth() {
        return month;
    }

    public void setmonth(int Month) {
        month = Month + 1;
    }

    public int getday() {
        return day;
    }

    public void setday(int Day) {
        day = Day;
    }
}
