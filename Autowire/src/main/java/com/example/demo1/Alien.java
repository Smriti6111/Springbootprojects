package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//component specifies we want to make an object of the class
@Scope(value="prototype")
//after giving prototype  it will then understand to create an object
//if we don't give any scope then by default it will follow singleton scope 
//where it will automatically create the object even when 
//Alien a=context.getBean(Alien.class); is not written in Alien class
public class Alien {
	
private int aid;
private String aname;
private String tech;

@Autowired   
//it will search for laptop (object) in spring container
//@Qualifier("lap1")
//it will search by the name of object
private Laptop laptop;

public Alien() {
	super();
	System.out.println("object created");
}

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
public Laptop getLaptop() {
	return laptop;
}

public void setLaptop(Laptop laptop) {
	this.laptop = laptop;
}

public void show()
{
	System.out.println("in show");
	laptop.compile();
}

}
