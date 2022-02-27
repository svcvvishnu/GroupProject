package com.csci5308.w22.wiseshopping.models;

import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Time;

/**
 * @author Nilesh
*/
@EqualsAndHashCode
@Entity
@Table
public class ProductInventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private int inventoryId;

    @Column(name = "store_id")
    private int storeId;

    @Column(name = "product_id")
    private int startTime;

    @Column(name = "price")
    private int endTime;

    @Column(name = "stock")
    private int type;

    private String contact;

    @ManyToOne
    @JoinColumn(name="location_id", referencedColumnName = "location_id")
    private Location location;

    @ManyToOne
    @JoinColumn(name="merchant_id", referencedColumnName = "merchant_id")
    private Merchant merchant;

    public ProductInventory(){}

    public ProductInventory(String storeName, Time startTime, Time endTime, String type, String contact, Location location, Merchant merchant) {
        this.storeName = storeName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.type = type;
        this.contact = contact;
        this.location = location;
        this.merchant = merchant;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }
}
