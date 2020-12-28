package com.hobarb.costtler.Models;

public class TransactionsTodayModel {

   // private String time;
    private String AMOUNT;
    private String DESCRIPTION;

    public TransactionsTodayModel(String amount, String description) {

        this.AMOUNT =amount;
        this.DESCRIPTION = description;
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
}
