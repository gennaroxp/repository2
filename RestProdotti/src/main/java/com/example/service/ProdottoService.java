package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Prodotto;
import com.example.repository.ProdottoRepository;

@Service
public class ProdottoService {
	
	@Autowired
	private ProdottoRepository repo;
	
	public List<Prodotto> listAll()   {
			
		return repo.findAll();
	}
	
	public void save(Prodotto prodotto) {
		
		repo.save(prodotto);
	}
	
	public Prodotto get(int id) {
		
		return repo.findById(id).get();
	}
	
	public void delete(int id)  {
		repo.deleteById(id);
	}

	public List<Prodotto> getNome(String nome) {
		// TODO Auto-generated method stub
		return repo.findByNome(nome);
	}

}
