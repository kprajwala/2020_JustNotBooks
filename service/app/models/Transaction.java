package models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;

    public String itemName;
    public String owner;
    //public String name;

    public String customer;
    public String takenAt;
    public String returnedAt;


}