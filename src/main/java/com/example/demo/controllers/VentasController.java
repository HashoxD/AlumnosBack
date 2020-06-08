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
import com.example.demo.beans.Venta;
import com.google.gson.Gson;

@RestController
public class VentasController {
	
	ArrayList<Venta> listaVentas = new ArrayList();

	public VentasController() {
		listaVentas.add(new Venta("Tomas", 900, "Mouse Inalámbrico"));
		listaVentas.add(new Venta("Fernando", 350, "Memoria USB 32 GB"));
		listaVentas.add(new Venta("Mariano", 500, "Silla de plástico"));
	}

	@CrossOrigin
	@RequestMapping(value = "/obtenerVentas", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response obtenerVentas() {
		try {
			return new Response("200", "OK", new Gson().toJson(listaVentas));
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/agregarVenta", method = RequestMethod.POST,
    produces = MediaType.APPLICATION_JSON_VALUE)
	public Response agregarVenta(@RequestBody String json) {
		try {
			Venta venta = new Gson().fromJson(json, Venta.class);
			listaVentas.add(venta);
			return new Response("200", "OK", "Venta registrada");
		}catch(Exception e) {
			return new Response("500", "ERROR", e.getMessage());
		}
	}
}
