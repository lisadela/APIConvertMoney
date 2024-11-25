package com.example.demo.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.ExchangeRequest;

import java.util.Optional;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.example.demo.ExchangeRequest;
import reactor.core.publisher.Mono;
@Document
@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRequest, Long> {
    Optional<ExchangeRequest> findByMonedaOrigenAndMonedaDestino(String monedaOrigen, String monedaDestino);
}



