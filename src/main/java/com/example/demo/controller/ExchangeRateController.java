package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.ExchangeRequest;
import com.example.demo.service.ExchangeRateService;
import com.example.demo.Client;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/exchange-rate")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService service;

    @GetMapping("/convert")
    public Mono<Map<String, Object>> convertirMonto(
        @RequestParam(required = false, defaultValue = "0") double monto,
        @RequestParam(required = false, defaultValue = "USD") String monedaOrigen,
        @RequestParam(required = false, defaultValue = "PEN") String monedaDestino) {

        return service.convertirMonto(monto, monedaOrigen, monedaDestino)
            .map(montoConvertido -> {
                // Convertir a Double (objeto) si no lo es
                Double montoConvertidoObj = Double.valueOf(montoConvertido);  // Convertimos a Double (objeto)
                Map<String, Object> response = new HashMap<>();
                response.put("monto", monto);
                response.put("montoConTipoDeCambio", montoConvertidoObj);
                response.put("monedaOrigen", monedaOrigen);
                response.put("monedaDestino", monedaDestino);
                response.put("tipoDeCambio", montoConvertidoObj / monto);  // Usamos el objeto Double aquí
                return response;
            });
    }

    @PostMapping("/update")
    public ResponseEntity<String> actualizarTipoCambio(@RequestBody ExchangeRequest rate) {
        service.actualizarTipoCambio(rate.getMonedaOrigen(), rate.getMonedaDestino(), rate.getTipoCambio());
        return ResponseEntity.ok("Tipo de cambio actualizado exitosamente");
    }
}
