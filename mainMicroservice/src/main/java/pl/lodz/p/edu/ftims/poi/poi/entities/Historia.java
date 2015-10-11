/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

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
public class Historia {

    @Id
    private Long ID;

    @DBRef
    private Oddzial oddzial;
    
    @DBRef
    private Paczka pack;

    public Historia() {
    }    

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Oddzial getOddzial() {
        return oddzial;
    }

    public void setOddzial(Oddzial oddzial) {
        this.oddzial = oddzial;
    }

    public Paczka getPack() {
        return pack;
    }

    public void setPack(Paczka pack) {
        this.pack = pack;
    }
    
    
}
