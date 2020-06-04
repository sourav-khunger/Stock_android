
package com.doozycod.stock.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class StockResponseModel {

    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("item")
    @Expose
    private Item item;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
