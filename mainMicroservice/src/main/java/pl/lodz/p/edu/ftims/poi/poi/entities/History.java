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
public class History {

    @Id
    private Long ID;

    @DBRef
    private List<Department> departments;
    
    @Version
    private Integer Version;

    public History() {
    }    
    
    public History(Long ID, List<Department> departments) {
        this.ID = ID;
        this.departments = departments;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(List<Department> departments) {
        this.departments = departments;
    }

    public Integer getVersion() {
        return Version;
    }
    
}
