package net.improve.hibernate;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.util.Date;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity(name = "User")
public class User {
	@Id
	private int userId;
	private String username;
	private String createdBy;
	private Date createdDate;
	
	@Lob
	private Blob blob;
	
	@Lob
	private String stringLob;
	
	@Lob
	private byte[] byteArrLob;
	
	@Lob
	private Clob clob;
	
	@Lob
	private char[] charArr;
	
	@Lob // No need for nationalized
	private NClob nclob; 
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	@Convert (converter = JobConverter.class)
	private Job job;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public Blob getBlob() {
		return blob;
	}

	public void setBlob(Blob blob) {
		this.blob = blob;
	}

	public String getStringLob() {
		return stringLob;
	}

	public void setStringLob(String stringLob) {
		this.stringLob = stringLob;
	}

	public byte[] getByteArrLob() {
		return byteArrLob;
	}

	public void setByteArrLob(byte[] byteArrLob) {
		this.byteArrLob = byteArrLob;
	}

	public Clob getClob() {
		return clob;
	}

	public void setClob(Clob clob) {
		this.clob = clob;
	}

	public char[] getCharArr() {
		return charArr;
	}

	public void setCharArr(char[] charArr) {
		this.charArr = charArr;
	}

	public NClob getNclob() {
		return nclob;
	}

	public void setNclob(NClob nclob) {
		this.nclob = nclob;
	}

}
