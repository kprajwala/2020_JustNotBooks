package models;

import javax.persistence.*;


@Entity
public class Notification {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long id;


    public String owner;
    public String customer;

    public String customerNote;
    public  String ownerNote;
    public  String customerStatus="Not Processed";
    public String ownerStatus="Not Processed";


}