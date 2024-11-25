/*package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping("/findall")
	public Flux<Client> findAll(){
		return clientRepository.findAll();
	}

	@GetMapping("/findbyid/{id}")
	public Mono<Client> findById(@PathVariable Long id) {
		return clientRepository.findById(id);
	}
	
	@PostMapping("/create")
	public Mono<Client> createClient(@RequestBody Client client){
		return clientRepository.insert(client);
	}
}*/


package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/findall")
    public Flux<Client> findAll() {
        return clientRepository.findAll(); // Asegúrate que devuelve Flux<Client>
    }

    @GetMapping("/findbyid/{id}")
    public Mono<Client> findById(@PathVariable Long id) {
        return clientRepository.findById(id); // Asegúrate que retorna Mono<Client>
    }

    @PostMapping("/create")
    public Mono<Client> createClient(@RequestBody Client client) {
        return clientRepository.save(client); // Usa save() si insert() no está disponible
    }
}

