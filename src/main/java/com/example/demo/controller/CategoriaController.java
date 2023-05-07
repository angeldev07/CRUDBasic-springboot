package com.example.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Categoria;

//funciona para armar un controllador de manera rest 
@RestController 
//Con RequestMapping se le indica al navegador como acceder al recurso
@RequestMapping("/categorias_") 
public class CategoriaController {

	// el método no hace nada hasta que se exponga, para esto se usa las anotaciones.
	@GetMapping("/status") //De esta manera se mapea por el método get 
	public String status() {
		return "pong";
	}
	
	@GetMapping//De esta manera se mapea por el método get 
	public String allCategories() {
		return "Lista de categorias";
	}
	
	@GetMapping("/{id}")//De esta manera se mapea por el método get 
	public String categorieById(@PathVariable String id) {
		return "Buscando por el id "+id;
	}
	
	@PostMapping
	public String addCategorie(@RequestBody Categoria categoria ) {
		return "añadiendo una nueva categoria"+categoria.toString();
	}
	
	@PutMapping("/{id}")
	public String updateCategorie(@PathVariable String id) {
		return "actualizando la categoria con id "+id;
	}
	
	@DeleteMapping("/{id}")
	public String deleteCategorie(@PathVariable String id) {
		return "eliminando la categoria con id "+id;
	}
	
	
	
	
}
