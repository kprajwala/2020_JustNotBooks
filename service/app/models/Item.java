package models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    public String owner;
    //public String name;
    public String itemName;
    public Integer price;
    public String image;
    public String description;
    public String category;
    public String from2;
    public String to2;
    public String address;
    public String customer;
    //public enum status{Available,Unavailable};
    public String status="Available";

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFrom2() {
        return from2;
    }

    public void setFrom2(String from2) {
        this.from2 = from2;
    }

    public void setTo2(String to2) {
        this.to2 = to2;
    }

    public String getTo2() {
        return to2;
    }
    //Date from=new Date();

    /*public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }*/

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }






    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

   /*public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}