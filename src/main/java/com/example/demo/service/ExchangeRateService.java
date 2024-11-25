
package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.ExchangeRequest;
import com.example.demo.repository.ExchangeRateRepository;
import reactor.core.publisher.Mono;



@Service
public class ExchangeRateService {
    @Autowired
    private ExchangeRateRepository repository;

    public double convertirMonto(Double monto, String monedaOrigen, String monedaDestino) {
        ExchangeRequest rate = repository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino)
                .orElseThrow(() -> new RuntimeException("Tipo de cambio no encontrado"));
        return monto * rate.getTipoCambio();
    }

    public ExchangeRequest actualizarTipoCambio(String monedaOrigen, String monedaDestino, double nuevoTipoCambio) {
        ExchangeRequest rate = repository.findByMonedaOrigenAndMonedaDestino(monedaOrigen, monedaDestino)
                .orElse(new ExchangeRequest());  // Si no existe, crea uno nuevo
        rate.setMonedaOrigen(monedaOrigen);
        rate.setMonedaDestino(monedaDestino);
        rate.setTipoCambio(nuevoTipoCambio);
        return repository.save(rate);  // Guarda el cambio y retorna el objeto actualizado
    }
}


