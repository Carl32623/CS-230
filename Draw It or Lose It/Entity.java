package com.gamingroom;

public class Entity {

//Private attributes
	private long id;
	private String name;
	
//Default constructor
	private Entity() {
	}
	
//Constructor with long id and String name as parameters.
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}
	
//This method will return the id.
	public long getId() {
		return id;
	}
	
//This method will return the name.
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}
