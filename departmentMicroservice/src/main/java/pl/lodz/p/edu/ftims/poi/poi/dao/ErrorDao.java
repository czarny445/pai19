/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.dao;

/**
 *
 * @author lwieczor
 */
public class ErrorDao {

    private int insertedRecords;

    private Boolean error;

    public ErrorDao(Boolean error) {
        this.error = error;
    }

    public ErrorDao(int insertedRecords, Boolean error) {
        this.insertedRecords = insertedRecords;
        this.error = error;
    }

    public ErrorDao(int insertedRecords) {
        this.insertedRecords = insertedRecords;
    }

    public int getInsertedRecords() {
        return insertedRecords;
    }

    public void setInsertedRecords(int insertedRecords) {
        this.insertedRecords = insertedRecords;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

}
