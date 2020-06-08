package com.example.demo.beans;

public class Alumno {
	private int id;
	private String nombre;
	private int edad;
	
	public Alumno(int id, String nombre, int edad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Alumno(Alumno alumno) {
		this.id = alumno.getId();
		this.nombre = alumno.getNombre();
		this.edad = alumno.getEdad();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void setAlumno(Alumno alumno) {
		this.id = alumno.getId();
		this.nombre = alumno.getNombre();
		this.edad = alumno.getEdad();
	}
}
