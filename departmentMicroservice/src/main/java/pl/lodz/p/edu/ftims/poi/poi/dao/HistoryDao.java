/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

import java.util.Date;

/**
 *
 * @author lwieczor
 */
public class HistoryDao {

    private Long pack;

    private Date date;

    public HistoryDao() {
    }

    public Long getPack() {
        return pack;
    }

    public void setPack(Long pack) {
        this.pack = pack;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
