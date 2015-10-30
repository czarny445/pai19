/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

import java.util.Date;
import pl.lodz.p.edu.ftims.poi.poi.entities.History;

/**
 *
 * @author lwieczor
 */
public class HistoryDao {

    private String pack;

    private Date date;

    public HistoryDao() {
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public HistoryDao(History h) {
        this.pack = h.getPack();
        this.date = h.getDate();
    }

    @Override
    public String toString() {
        return "HistoryDao{" + "pack=" + pack + ", date=" + date + '}';
    }

}
