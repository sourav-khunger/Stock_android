
package com.doozycod.stock.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("itemCode")
    @Expose
    private String itemCode;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("stoney")
    @Expose
    private Stoney stoney;
    @SerializedName("london")
    @Expose
    private London london;
    @SerializedName("nugget")
    @Expose
    private Nugget nugget;
    @SerializedName("caledonia")
    @Expose
    private Caledonia caledonia;
    @SerializedName("101west")
    @Expose
    private _101west _101west;
    @SerializedName("75west")
    @Expose
    private _75west _75west;
    @SerializedName("bramalea")
    @Expose
    private Bramalea bramalea;

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Stoney getStoney() {
        return stoney;
    }

    public void setStoney(Stoney stoney) {
        this.stoney = stoney;
    }

    public London getLondon() {
        return london;
    }

    public void setLondon(London london) {
        this.london = london;
    }

    public Nugget getNugget() {
        return nugget;
    }

    public void setNugget(Nugget nugget) {
        this.nugget = nugget;
    }

    public Caledonia getCaledonia() {
        return caledonia;
    }

    public void setCaledonia(Caledonia caledonia) {
        this.caledonia = caledonia;
    }

    public _101west get101west() {
        return _101west;
    }

    public void set101west(_101west _101west) {
        this._101west = _101west;
    }

    public _75west get75west() {
        return _75west;
    }

    public void set75west(_75west _75west) {
        this._75west = _75west;
    }

    public Bramalea getBramalea() {
        return bramalea;
    }

    public void setBramalea(Bramalea bramalea) {
        this.bramalea = bramalea;
    }

}
