/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.time.LocalDateTime;
import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lwieczor
 */
@Document
public class History {

    @Id
    private Long pack;

    private Date date;

    private Boolean reportStatus;

    public History() {
        this.reportStatus = false;
    }

    public Long getPack() {
        return pack;
    }

    public void setPack(Long pack) {
        this.pack = pack;
    }

    public Boolean getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Boolean reportStatus) {
        this.reportStatus = reportStatus;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
