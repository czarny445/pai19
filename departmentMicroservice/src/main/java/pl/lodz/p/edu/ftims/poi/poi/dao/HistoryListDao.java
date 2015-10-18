/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lwieczor
 */
public class HistoryListDao {

    List<HistoryDao> history = new ArrayList<>();
    
    BigInteger departement = new BigInteger("2"); //TODO

    public List<HistoryDao> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryDao> history) {
        this.history = history;
    }

    public BigInteger getDepartement() {
        return departement;
    }

    public void setDepartement(BigInteger departement) {
        this.departement = departement;
    }
    
    

}
