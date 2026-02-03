package com.mitienda.appAlmacen.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mitienda.appAlmacen.model.Producto;
import com.mitienda.appAlmacen.service.ProductoService;


@Controller
public class ProductoController {

	@Autowired
	private ProductoService productoService;
	
	@GetMapping("/")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("producto",new Producto());
		
		return "formulario.html";
	}
	
	@PostMapping("/calcular")
	public String calcularProducto(@ModelAttribute Producto producto,Model model) {
		
		// El controlador solo delega la tarea
		Producto resultado = productoService.procesarCalculos(producto);
		
		model.addAttribute("resultado",resultado);
		
		return "resultado.html";
	}
	
	
}






