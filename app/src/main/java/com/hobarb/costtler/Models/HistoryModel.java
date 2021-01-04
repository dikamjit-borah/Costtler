package com.hobarb.costtler.Models;

public class HistoryModel {

   // private String time;
    private String TOTAL_AMOUNT;
    private String DATE;

    public String getTOTAL_AMOUNT() {
        return TOTAL_AMOUNT;
    }

    public void setTOTAL_AMOUNT(String TOTAL_AMOUNT) {
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

    public String getDATE() {
        return DATE;
    }

    public void setDATE(String DATE) {
        this.DATE = DATE;
    }

    public HistoryModel(String TOTAL_AMOUNT, String DATE) {
        this.DATE = DATE;
        this.TOTAL_AMOUNT = TOTAL_AMOUNT;
    }

}
