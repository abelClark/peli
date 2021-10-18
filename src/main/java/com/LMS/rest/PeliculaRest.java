package com.LMS.rest;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.LMS.model.Pelicula;
import com.LMS.service.PeliculaService;

@RestController
@RequestMapping("/api/pelicula/")
public class PeliculaRest {
	
	@Autowired
	private PeliculaService peliculaService;
	
	@PostMapping
	private ResponseEntity<Pelicula> guardar (@RequestBody Pelicula pelicula){
		Pelicula temporal = peliculaService.create(pelicula);
		
		try {
			return ResponseEntity.created(new URI("/api/pelicula"+temporal.getId())).body(temporal);
			
		}catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping
	private ResponseEntity<List<Pelicula>> listarTodasLasPeliculas (){
		return ResponseEntity.ok(peliculaService.getAllPersonas());
	}
	
	@DeleteMapping
	private ResponseEntity<Void> eliminarPelicula (@RequestBody Pelicula pelicula){
		peliculaService.delete(pelicula);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping (value = "{id}")
	private ResponseEntity<Optional<Pelicula>> listarPeliculasPorID (@PathVariable ("id") Long id){
		return ResponseEntity.ok(peliculaService.findById(id));
	}

}
