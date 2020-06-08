package com.example.demo.beans;

import java.util.ArrayList;

public class Venta {
	String cliente;
	int totalVenta;
	String listaArticulos;
	public Venta(String cliente, int totalVenta, String listaArticulos) {
		super();
		this.cliente = cliente;
		this.totalVenta = totalVenta;
		this.listaArticulos = listaArticulos;
	}
	public String getCliente() {
		return cliente;
	}
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	public int getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(int totalVenta) {
		this.totalVenta = totalVenta;
	}
	public String getListaArticulos() {
		return listaArticulos;
	}
	public void setListaArticulos(String listaArticulos) {
		this.listaArticulos = listaArticulos;
	}
}
