package com.example.demo;

//import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity

public class ExchangeRequest {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String monedaOrigen;
	    private String monedaDestino;
	    private double tipoCambio;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getMonedaOrigen() {
			return monedaOrigen;
		}
		public void setMonedaOrigen(String monedaOrigen) {
			this.monedaOrigen = monedaOrigen;
		}
		public String getMonedaDestino() {
			return monedaDestino;
		}
		public void setMonedaDestino(String monedaDestino) {
			this.monedaDestino = monedaDestino;
		}
		public double getTipoCambio() {
			return tipoCambio;
		}
		public void setTipoCambio(double tipoCambio) {
			this.tipoCambio = tipoCambio;
		}

	    // Getters y Setters
	


}
