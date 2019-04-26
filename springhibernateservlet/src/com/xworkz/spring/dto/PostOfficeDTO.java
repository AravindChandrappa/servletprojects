
package com.xworkz.spring.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "Post_office")
public class PostOfficeDTO implements Serializable {

	
	@Id
	@GenericGenerator(name="auto",strategy="increment")
	@GeneratedValue(generator="auto")
	@Column(name="P_ID")
	private int pId;
	@Column(name="PIN_CODE")
	private int pincode;
	@Column(name="BRANCH_NAME")
	private String branchName;
	@Column(name="WORKING")
	private boolean working;
	@Column(name="LOCATION")
	private String location;

	public PostOfficeDTO() {
		System.out.println("Created\t" + this.getClass().getSimpleName());
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public boolean isWorking() {
		return working;
	}

	public void setWorking(boolean working) {
		this.working = working;
	}
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}


	@Override
	public String toString() {
		return "PostOfficeDTO [pId=" + pId + ", pincode=" + pincode + ", branchName=" + branchName + ", working="
				+ working + "]";
	}
	
	

}