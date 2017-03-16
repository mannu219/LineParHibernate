package com.test.bean;

 
import org.hibernate.validator.constraints.NotEmpty;

public class Subject {
	@NotEmpty
	private int subjectId;
	@NotEmpty
	private String subject;
	@NotEmpty
	private String start;
	@NotEmpty
	private String end; 
	
	
	public Subject(int subjectId, String subject, String start, String end) {
		super();
		this.subjectId = subjectId;
		this.subject = subject;
		this.start = start;
		this.end = end;
	}

	public Subject() {
		// TODO Auto-generated constructor stub
	}

	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "SubjectId=" + subjectId + ", subject=" + subject + "\nTest can be given between "+ start + " and " + end + "\n" ;
	}
	
	
	
}
