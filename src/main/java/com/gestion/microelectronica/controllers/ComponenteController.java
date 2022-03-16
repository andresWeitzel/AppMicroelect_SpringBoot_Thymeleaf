package com.gestion.microelectronica.controllers;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.gestion.microelectronica.entities.ComponenteEntity;
import com.gestion.microelectronica.services.ComponenteService;

@RestController
@RequestMapping("/componentes")
public class ComponenteController {

	@Autowired
	private ComponenteService componenteService;

	// ============= MÉTODOS HTTP CRUD ==============

	// ----POST----
	@PostMapping("/")
	public boolean addComponente(@RequestBody ComponenteEntity componente) {

		return componenteService.addComponente(componente);
	}

	// ----PUT-----
	@PutMapping("/")
	public boolean updateComponente(@RequestBody ComponenteEntity componente) {

		return componenteService.updateComponente(componente);
	}

	// ---DELETE---
	@DeleteMapping("/{id}")
	public boolean deleteComponente(@PathVariable("id") int id) {

		return componenteService.deleteComponente(id);
	}

	// ---GET---
	// ---LISTADO PAGINADO Y COMPLETO---
	@GetMapping("/listado")
	public List<ComponenteEntity> getAll(Pageable pageable) {

		return componenteService.getAllComponente(pageable);
	}

	// ---GET---
	// ---VISTA COMPONENTES-LISTAR.HTML---
	@GetMapping("/listar")
	public ModelAndView listarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("listaComponentes", componenteService.getAllComponente());
		mav.setViewName("componentes/comp-listar");
		return mav;
	}

	// ---GET---
	// ---VISTA COMPONENTES-AGREGAR.HTML---
	@GetMapping("/agregar")
	public ModelAndView agregarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentes/comp-agregar");
		return mav;
	}

	// ---GET---
	// ---VISTA COMPONENTES-EDITAR.HTML---
	@GetMapping("/editar")
	public ModelAndView editarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentes/comp-editar");
		return mav;
	}

	// ---GET---
	// ---VISTA COMPONENTES-ELIMINAR.HTML---
	@GetMapping("/eliminar")
	public ModelAndView eliminarModelAndView() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("componentes/comp-eliminar");
		return mav;
	}
	// ============= MÉTODOS HTTP BÚSQUEDA ==============

	// ---GET---
	@GetMapping("/id/{id}")
	public ComponenteEntity getById(@PathVariable("id") int id) {

		return componenteService.findById(id);
	}

	// ---GET---
	@GetMapping("/codigo/{codigo}")
	public List<ComponenteEntity> getByCodigo(@PathVariable("codigo") String codigo) {

		return componenteService.findByCodigo(codigo);
	}

	// ---GET---
	@GetMapping("/imagen/{imagen}")
	public List<ComponenteEntity> getByImagen(@PathVariable("imagen") String imagen) {

		return componenteService.findByImagen(imagen);
	}

	// ---GET---
	@GetMapping("/nro-de-pieza/{nroPieza}")
	public List<ComponenteEntity> getByNroPieza(@PathVariable("nroPieza") String nroPieza) {

		return componenteService.findByNroPieza(nroPieza);
	}

	// ---GET---
	@GetMapping("/categoria/{categoria}")
	public List<ComponenteEntity> getByCategoria(@PathVariable("nroPieza") String nroPieza) {

		return componenteService.findByNroPieza(nroPieza);
	}

	// ---GET---
	@GetMapping("/descripcion/{descripcion}")
	public List<ComponenteEntity> getByDescripcion(@PathVariable("descripcion") String descripcion) {

		return componenteService.findByDescripcion(descripcion);
	}

	// ---GET---
	@GetMapping("/fabricante/{fabricante}")
	public List<ComponenteEntity> getByFabricante(@PathVariable("fabricante") String fabricante) {

		return componenteService.findByFabricante(fabricante);
	}

	// ---GET---
	@GetMapping("/stock/{stock}")
	public List<ComponenteEntity> getByStock(@PathVariable("stock") int stock) {

		return componenteService.findByStock(stock);
	}

	// ---GET---
	@GetMapping("/precio/{precio}")
	public List<ComponenteEntity> getByPrecio(@PathVariable("precio") double precio) {

		return componenteService.findByPrecio(precio);
	}

}
