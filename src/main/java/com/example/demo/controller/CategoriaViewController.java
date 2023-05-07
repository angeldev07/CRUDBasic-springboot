package com.example.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entities.Categoria;
import com.example.demo.repository.CategoriaRepository;


@Controller 
@RequestMapping("/categorias_view")
public class CategoriaViewController {

	@Autowired
	CategoriaRepository cr;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Categoria> categorias = cr.findAll();
		model.addAttribute("categorias", categorias);
		return "index";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id, Model model) {
		//obtengo la categoria de la BD usando el repository
		Categoria c =  cr.findById(id).get();
		// subo el objeto a la vista para que se pueda usar
		model.addAttribute("categoria", c);
		return "edit_categoria";
	}

	@PostMapping("/update")
	public String update(@ModelAttribute Categoria categoria, RedirectAttributes attributes) {
		//actualizamos la categoria
		System.out.println(categoria.toString());
		cr.save(categoria);
		return "redirect:/categorias_view/listar";
	}
}
