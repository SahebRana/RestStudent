package com.rana.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Student{
	@Id
	private int studentId;
	private int studentRoll;
	private String studentName;
	private String studentEmail;
	
	public Student(){
		
	}
	public Student(int studentId, int studentRoll, String studentName, String studentEmail) {
		super();
		this.studentId = studentId;
		this.studentRoll = studentRoll;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public int getStudentRoll() {
		return studentRoll;
	}
	public void setStudentRoll(int studentRoll) {
		this.studentRoll = studentRoll;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	
	
}
