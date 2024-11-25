package com.example.demo.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Client;
//import com.example.demo.Client;
import jakarta.persistence.Entity;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
//public interface ClientRepository extends ReactiveMongoRepository<Client, Long>{
//public interface ClientRepository extends JpaRepository<Client, Long>{ 
public interface ClientRepository extends ReactiveCrudRepository<Client, Long> {

}
