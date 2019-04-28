package com.example.ferovybonuspartner.ui.model;

public class Voucher {

    private String guid;
    private boolean hasBeenUsed;
    private String name;
    private String price;

    public Voucher(String guid, boolean hasBeenUsed, String name, String price) {
        this.guid = guid;
        this.hasBeenUsed = hasBeenUsed;
        this.name = name;
        this.price = price;
    }

    public String getGuid() {
        return guid;
    }

    public String getBoolToString(){
        return String.valueOf(hasBeenUsed);
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public boolean getHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
