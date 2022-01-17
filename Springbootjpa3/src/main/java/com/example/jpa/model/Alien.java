package com.example.jpa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
//by giving entity and id table will be automatically created in the h2 database
//we can directly do 
//select * from alien;
//insert into ALIEN VALUES(101,'Navin','java');
//insert into ALIEN VALUES(102,'Kiran','android');
//insert into ALIEN VALUES(103,'Pravin','python');
//insert into ALIEN VALUES(104,'Komal','java');
//insert into ALIEN VALUES(105,'Rafiq','android');
//101	Navin	java
//102	kiran	andriod
//103	pravin	python
//104	komal	java
//105	rafiq	       android

@Entity
public class Alien {
	@Id
  private int aid;
  private String aname;
  private String tech;
public int getAid() {
	return aid;
}
public void setAid(int aid) {
	this.aid = aid;
}
public String getAname() {
	return aname;
}
public void setAname(String aname) {
	this.aname = aname;
}
public String getTech() {
	return tech;
}
public void setTech(String tech) {
	this.tech = tech;
}
@Override
public String toString() {
	return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + "]";
}
  

  
  
}

//localhost:8080/aliens will give all the aliens present in database

//localhost:8080/h2-console