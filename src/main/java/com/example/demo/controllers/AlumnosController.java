package com.example.demo.controllers;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Alumno;
import com.example.demo.beans.Response;
import com.google.gson.Gson;

@RestController
public class AlumnosController{
	
	ArrayList<Alumno> listaAlumnos = new ArrayList();

	public AlumnosController() {
		listaAlumnos.add(new Alumno(1, "Camilo", 24));
		listaAlumnos.add(new Alumno(2, "Amanda", 24));
		listaAlumnos.add(new Alumno(3, "Tomás", 25));
		listaAlumnos.add(new Alumno(4, "Sandra", 22));
	}
	
	@CrossOrigin
	@RequestMapping(value = "/obtenerAlumnos", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response obtenerAlumnos() {
		try {
			return new Response("200", "OK", new Gson().toJson(listaAlumnos));
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/agregarAlumno", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response agregarAlumno(@RequestBody String json) {
		try {
			Alumno alumno = new Gson().fromJson(json, Alumno.class);
			if(existeAlumno(alumno))
				return new Response("201", "ERROR", "El alumno con ID "+alumno.getId()+" ya está registrado.");
			listaAlumnos.add(alumno);
			return new Response("200", "OK", "Alumno registrado");
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/modificarAlumno", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response modificarAlumno(@RequestBody String json) {
		try {
			Alumno alumno = new Gson().fromJson(json, Alumno.class);
			for(int i = 0; i<listaAlumnos.size(); i++) {
				if(listaAlumnos.get(i).getId() == alumno.getId()) {
					listaAlumnos.get(i).setAlumno(alumno);
					return new Response("200", "OK", "Alumno modificado");
				}
			}
			return new Response("404", "NOT FOUND", "Alumno no encontrado");
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/eliminarAlumno", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response eliminarAlumno(@RequestParam("id") int id) {
		try {
			for(int i = 0; i<listaAlumnos.size(); i++) {
				if(listaAlumnos.get(i).getId() == id) {
					listaAlumnos.remove(i);
					return new Response("200", "OK", "Alumno eliminado");
				}
			}
			return new Response("404", "NOT FOUND", "No se encontró el alumno con id "+id);
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
	
	
	public boolean existeAlumno(Alumno alumno) {
		for(int i = 0; i<listaAlumnos.size(); i++) {
			if(listaAlumnos.get(i).getId() == alumno.getId()) 
				return true;
		}
		return false;
	}
}
