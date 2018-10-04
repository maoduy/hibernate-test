package net.improve.hibernate;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.NClob;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Generated;
import org.hibernate.annotations.GenerationTime;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "User")
public class User {
	@GenericGenerator(name = "uuid-generator", strategy = "uuid")
	@GeneratedValue(generator = "uuid-generator", strategy = GenerationType.AUTO)
	@Id
	@Column(columnDefinition = "VARCHAR(32)")
	private String userId;

	@GenericGenerator(name = "hibernate-generator", strategy = "uuid2")
	@GeneratedValue(generator = "hibernate-generator", strategy = GenerationType.AUTO)
	private UUID uuid; // Not auto generated now

	private String username;
	private String createdBy;

	@Generated(value = GenerationTime.ALWAYS)
	//@Column(columnDefinition = "AS CONCAT(username, createdBy)")
	private String fullName;
	private Date createdDate;

	@Temporal(TemporalType.DATE)
	private Date date1;

	@Temporal(TemporalType.TIME)
	private Date date2;

	@Temporal(TemporalType.TIMESTAMP)
	private Date date3;

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

	@Convert(converter = JobConverter.class)
	private Job job;

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private int number;

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

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

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}

	public Date getDate2() {
		return date2;
	}

	public void setDate2(Date date2) {
		this.date2 = date2;
	}

	public Date getDate3() {
		return date3;
	}

	public void setDate3(Date date3) {
		this.date3 = date3;
	}

}
