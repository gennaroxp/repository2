package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Prodotto;

public interface ProdottoRepository extends JpaRepository<Prodotto, Integer> {

	List<Prodotto> findByNome(String nome);

	
	
}
