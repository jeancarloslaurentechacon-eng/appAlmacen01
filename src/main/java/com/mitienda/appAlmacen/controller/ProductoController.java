package com.mitienda.appAlmacen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.mitienda.appAlmacen.model.Producto;


@Controller
public class ProductoController {

	@GetMapping("/")
	public String mostrarFormulario(Model model) {
		
		model.addAttribute("producto",new Producto());
		
		return "formulario.html";
	}
	
	@PostMapping("/calcular")
	public String calcularProducto(@ModelAttribute Producto producto,Model model) {
		
		// Logica de negocio
		double subtotal = producto.getPrecio()*producto.getCantidad();
		double descuento = 0;
		
		if(subtotal > 100) {
			descuento = subtotal * 0.10; // 10% de descuento
		}
		
		producto.setDescuento(descuento);
		producto.setTotal(subtotal -descuento );
		
		model.addAttribute("resultado",producto);
		
		return "resultado.html";
	}
	
	
}






