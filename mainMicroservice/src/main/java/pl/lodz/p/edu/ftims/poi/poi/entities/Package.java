/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lwieczor
 */
@Document
public class Package {

    @Id
    private String ID;

	private String name;

	private String receiverName;

	private String receiverSubname;

    public Package(String ID, List<History> history, String name) {
        this.ID = ID;
        this.history = history;
        this.name = name;
    }
	private String receiverStreet;

    public String getID() {
        return ID;
    }
	private String receiverFlatNumber;

    public void setID(String ID) {
        this.ID = ID;
    }
	private String receiverCity;

	private String receiverPostCode;

	@DBRef
	private List<History> history = new ArrayList<>();

	public Package() {
	}

	public Package(Long iD, String name, String receiverName,
			String receiverSubname, String receiverStreet,
			String receiverFlatNumber, String receiverCity,
			String receiverPostCode, List<History> history) {

		ID = iD;
		this.name = name;
		this.receiverName = receiverName;
		this.receiverSubname = receiverSubname;
		this.receiverStreet = receiverStreet;
		this.receiverFlatNumber = receiverFlatNumber;
		this.receiverCity = receiverCity;
		this.receiverPostCode = receiverPostCode;
		this.history = history;
	}

	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public List<History> getHistory() {
		return history;
	}

	public void setHistory(List<History> history) {
		this.history = history;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public String getReceiverSubname() {
		return receiverSubname;
	}

	public void setReceiverSubname(String receiverSubname) {
		this.receiverSubname = receiverSubname;
	}

	public String getReceiverStreet() {
		return receiverStreet;
	}

	public void setReceiverStreet(String receiverStreet) {
		this.receiverStreet = receiverStreet;
	}

	public String getReceiverFlatNumber() {
		return receiverFlatNumber;
	}

	public void setReceiverFlatNumber(String receiverFlatNumber) {
		this.receiverFlatNumber = receiverFlatNumber;
	}

	public String getReceiverCity() {
		return receiverCity;
	}

	public void setReceiverCity(String receiverCity) {
		this.receiverCity = receiverCity;
	}

	public String getReceiverPostCode() {
		return receiverPostCode;
	}

	public void setReceiverPostCode(String postCode) {
		this.receiverPostCode = postCode;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 37 * hash + Objects.hashCode(this.ID);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Package other = (Package) obj;
		return Objects.equals(this.ID, other.ID);
	}

}
