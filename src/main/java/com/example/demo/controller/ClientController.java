package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@GetMapping("/findall")
	public Flux<Client>  findAll(){
		return clientService.findAll();
		
	}
	
	@GetMapping("/findbyid/{id}")
	public Mono<Client>  findById(@PathVariable Long id){
		return clientService.findById(id);
		
	}
	
	@PostMapping("/create")
	public Mono<Client>  createClient(@RequestBody Client client){
		return clientService.createClient(client);
		
	}
	
}
