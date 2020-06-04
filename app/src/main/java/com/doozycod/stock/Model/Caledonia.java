
package com.doozycod.stock.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Caledonia {

    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("area")
    @Expose
    private String area;
    @SerializedName("retPrice")
    @Expose
    private String retPrice;
    @SerializedName("contPrice")
    @Expose
    private String contPrice;

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRetPrice() {
        return retPrice;
    }

    public void setRetPrice(String retPrice) {
        this.retPrice = retPrice;
    }

    public String getContPrice() {
        return contPrice;
    }

    public void setContPrice(String contPrice) {
        this.contPrice = contPrice;
    }

}
