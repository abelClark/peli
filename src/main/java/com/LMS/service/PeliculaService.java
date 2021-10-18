package com.LMS.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.LMS.model.Pelicula;
import com.LMS.repository.PeliculaRepository;


@Service
public class PeliculaService {
	
	@Autowired
	private PeliculaRepository pelicularepository;
	
	
	public Pelicula create (Pelicula pelicula) {
		return pelicularepository.save(pelicula);
	}
	
	public List<Pelicula> getAllPersonas (){
		return pelicularepository.findAll();
	}
	
	public void delete (Pelicula pelicula) {
		 pelicularepository.delete(pelicula);
	}
	
	public Optional<Pelicula> findById (Long id) {
		return pelicularepository.findById(id);
	}

}
