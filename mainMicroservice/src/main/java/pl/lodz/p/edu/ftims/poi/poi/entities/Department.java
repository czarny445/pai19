/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.lodz.p.edu.ftims.poi.poi.entities;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author lwieczor
 */
@Document
public class Department {

    @Id
    private String ID;

	private String name;

	private String street;

	private String flatNumber;

	private String city;

    public Department(String ID, String name, String address) {
        this.ID = ID;
        this.name = name;
        this.address = address;
    }
	private String postCode;

    public String getID() {
        return ID;
    }
	@Version
	private Integer Version;

    public void setID(String ID) {
        this.ID = ID;
    }
	public Department() {
	}

	

	public Department(Long iD, String name, String street, String flatNumber,
			String city, String postCode) {
		ID = iD;
		this.name = name;
		this.street = street;
		this.flatNumber = flatNumber;
		this.city = city;
		this.postCode = postCode;
	}



	public Long getID() {
		return ID;
	}

	public void setID(Long ID) {
		this.ID = ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getFlatNumber() {
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber) {
		this.flatNumber = flatNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public Integer getVersion() {
		return Version;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 23 * hash + Objects.hashCode(this.ID);
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
		final Department other = (Department) obj;
		return Objects.equals(this.ID, other.ID);
	}

}
