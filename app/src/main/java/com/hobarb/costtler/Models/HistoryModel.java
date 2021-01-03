package com.hobarb.costtler.Models;

public class HistoryModel {

   // private String time;
    private String AMOUNT;
    private String DESCRIPTION;
    private String TIME;

    public HistoryModel(String amount, String description, String time) {

        this.AMOUNT =amount;
        this.DESCRIPTION = description;
        this.TIME = time;

    }

    /*public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
*/
    public String getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(String AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public String getTIME() {
        return TIME;
    }

    public void setTIME(String TIME) {
        this.TIME = TIME;
    }
}
