/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.math.BigInteger;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lwieczor
 */
@Document
public class Historia {

    @Id
    private BigInteger pack;

    private LocalDateTime date;

    /**
     * Doręczony do centrali - true Nie doręczony - false
     */
    private Boolean reportStatus;

    public Historia() {
    }

    public BigInteger getPack() {
        return pack;
    }

    public void setPack(BigInteger pack) {
        this.pack = pack;
    }

    public Boolean getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}