/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.math.BigInteger;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Version;

/**
 *
 * @author lwieczor
 */
@Document
public class Oddzial {

    @Id
    private BigInteger ID;

    private String name;

    private String address;

    @Version
    private Integer Version;

    public Oddzial() {
    }
    
    public Oddzial(BigInteger ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }
    
    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getVersion() {
        return Version;
    }

}
