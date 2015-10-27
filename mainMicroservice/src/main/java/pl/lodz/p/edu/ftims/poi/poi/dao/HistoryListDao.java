/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lwieczor
 */
public class HistoryListDao {

    List<HistoryDao> history = new ArrayList<>();
    
    Long departement;

    public List<HistoryDao> getHistory() {
        return history;
    }

    public void setHistory(List<HistoryDao> history) {
        this.history = history;
    }

    public Long getDepartement() {
        return departement;
    }

    public void setDepartement(Long departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return "HistoryListDao{" + "history=" + history + ", departement=" + departement + '}';
    }
    
    

}
