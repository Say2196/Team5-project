package donors.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Donors {
	private Integer id;
	private String firstname;
	private String lastname;
	private Integer age;
	private String gender;
	private Date dob;
	private Integer height;
	private Integer weight;
	private String mailid;
	private Integer phone;
	private String address;
	private String bloodgrp;
	private String flag;
	private Date lastblooddonation;
	
	public Donors()
	{
		
	}

	public Donors(Integer id, String firstname, String lastname, Integer age, String gender, Date dob, Integer height,
			Integer weight, String mailid, Integer phone, String address, String bloodgrp, String flag,
			Date lastblooddonation) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
		this.gender = gender;
		this.dob = dob;
		this.height = height;
		this.weight = weight;
		this.mailid = mailid;
		this.phone = phone;
		this.address = address;
		this.bloodgrp = bloodgrp;
		this.flag = flag;
		this.lastblooddonation = lastblooddonation;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDob() {
		return dob;
	}
	
	public String getDob1()
	{
		SimpleDateFormat sdf=new SimpleDateFormat("dd-MMM-yyyy");
		String DateOfBirth=sdf.format(this.getDob());
		return DateOfBirth;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

	public String getMailid() {
		return mailid;
	}

	public void setMailid(String mailid) {
		this.mailid = mailid;
	}

	public Integer getPhone() {
		return phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBloodgrp() {
		return bloodgrp;
	}

	public void setBloodgrp(String bloodgrp) {
		this.bloodgrp = bloodgrp;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Date getLastblooddonation() {
		return lastblooddonation;
	}

	public void setLastblooddonation(Date lastblooddonation) {
		this.lastblooddonation = lastblooddonation;
	}

	@Override
	public String toString() {
		return "Donors [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age + ", gender="
				+ gender + ", dob=" + dob + ", height=" + height + ", weight=" + weight + ", mailid=" + mailid
				+ ", phone=" + phone + ", address=" + address + ", bloodgrp=" + bloodgrp + ", flag=" + flag
				+ ", lastblooddonation=" + lastblooddonation + "]";
	}
	
	
}
