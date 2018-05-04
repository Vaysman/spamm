package com.oboz.spam.model;

import javax.persistence.*;

@Entity
@Table(name = "mailing", schema = "dwh")
public class SpamVariables {
    @Id
    @Column(name = "num")
    private String Num;

    @Column(name = "origin_name")
    private String OriginName;

    @Column(name = "destination_name")
    private String DestinationName;

    @Column(name = "price")
    private String Price;

    @Column(name = "carrier")
    private String Carrier;

    @Column(name = "driver")
    private String Driver;

    @Column(name = "driver_phone")
    private String DriverPhone;

    @Column(name = "repr_face")
    private String ReprFace;

    @Column(name = "repr_phone")
    private String ReprPhone;

    @Column(name = "link")
    private String Link;

    @Column(name = "email")
    private String Email;

    public String getNum() {
        return Num;
    }

    public void setNum(String num) {
        Num = num;
    }

    public String getOriginName() {
        return OriginName;
    }

    public void setOriginName(String originName) {
        OriginName = originName;
    }

    public String getDestinationName() {
        return DestinationName;
    }

    public void setDestinationName(String destinationName) {
        DestinationName = destinationName;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getCarrier() {
        return Carrier;
    }

    public void setCarrier(String carrier) {
        Carrier = carrier;
    }

    public String getDriver() {
        return Driver;
    }

    public void setDriver(String driver) {
        Driver = driver;
    }

    public String getDriverPhone() {
        return DriverPhone;
    }

    public void setDriverPhone(String driverPhone) {
        DriverPhone = driverPhone;
    }

    public String getReprFace() {
        return ReprFace;
    }

    public void setReprFace(String reprFace) {
        ReprFace = reprFace;
    }

    public String getReprPhone() {
        return ReprPhone;
    }

    public void setReprPhone(String reprPhone) {
        ReprPhone = reprPhone;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
