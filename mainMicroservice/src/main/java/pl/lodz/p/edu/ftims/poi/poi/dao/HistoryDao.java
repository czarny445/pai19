/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

import java.math.BigInteger;
import java.time.LocalDateTime;

/**
 *
 * @author lwieczor
 */
public class HistoryDao {

    private BigInteger pack;

    private LocalDateTime date;

    public HistoryDao() {
    }

    public BigInteger getPack() {
        return pack;
    }

    public void setPack(BigInteger pack) {
        this.pack = pack;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}