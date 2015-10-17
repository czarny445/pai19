/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.math.BigInteger;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Version;

/**
 *
 * @author lwieczor
 */
@Document
public class Paczka {

    @Id
    private BigInteger ID;

    @DBRef
    private List<Historia> history;

    public Paczka() {
    }

    public Paczka(BigInteger ID, List<Historia> history) {
        this.ID = ID;
        this.history = history;
    }

    public BigInteger getID() {
        return ID;
    }

    public void setID(BigInteger ID) {
        this.ID = ID;
    }

    public List<Historia> getHistory() {
        return history;
    }

    public void setHistory(List<Historia> history) {
        this.history = history;
    }

}
