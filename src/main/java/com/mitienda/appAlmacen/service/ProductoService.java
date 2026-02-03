package com.mitienda.appAlmacen.service;

import org.springframework.stereotype.Service;

import com.mitienda.appAlmacen.model.Producto;

@Service
public class ProductoService {
	
	public Producto procesarCalculos(Producto objPro) {
		
		double subtotal =  objPro.getPrecio()*objPro.getCantidad();
		double descuento = 0;
		
		if(subtotal > 100) {
			descuento = subtotal*0.10;
		}
		
		objPro.setDescuento(descuento);
		objPro.setTotal(subtotal - descuento);
		
		return objPro;
	}
	
}
