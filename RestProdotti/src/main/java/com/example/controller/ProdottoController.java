package com.example.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Prodotto;
import com.example.service.ProdottoService;

@RestController
public class ProdottoController {
	
	@Autowired
	private ProdottoService prodottoService;
	
	@GetMapping("/prodotti")
	public List<Prodotto> list()  {
		return prodottoService.listAll();
	}
	
	@GetMapping("/prodotto/{id}")
	public ResponseEntity<Prodotto> getById(@PathVariable int id) {
		try {
			Prodotto prodotto = prodottoService.get(id);
			return new ResponseEntity<Prodotto>(prodotto, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/prodottoNome/{nome}")
	public List<Prodotto> getByNome(@PathVariable String nome) {
		return prodottoService.getNome(nome);
	}
	
	@PostMapping("/prodotto")
	public void add(@RequestBody Prodotto prodotto)  {
		
		prodottoService.save(prodotto);
	}
	
	@PutMapping("/prodotto/{id}")
	public ResponseEntity<HttpStatus> update(@PathVariable int id, @RequestBody Prodotto prodotto) {
		
		try {
			Prodotto prodottoEsistente = prodottoService.get(id);
			prodottoService.save(prodotto);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/prodotto/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable int id) {
		
		try {
			Prodotto prodottoEsistente = prodottoService.get(id);
			prodottoService.delete(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

}
