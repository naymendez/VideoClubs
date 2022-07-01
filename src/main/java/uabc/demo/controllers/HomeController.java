package uabc.demo.controllers;


import java.io.IOException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import uabc.demo.entities.CatalogoIndex;
import uabc.demo.entities.Category;
import uabc.demo.entities.Film;
import uabc.demo.services.CategoryService;
import uabc.demo.services.FilmService;
import uabc.demo.services.InventoryService;
import uabc.demo.services.LanguageService;
import uabc.demo.services.RentalService;


@Controller
public class HomeController {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private LanguageService languageService;
	
	@Autowired
	private InventoryService inventoryService;

	@Autowired
	private RentalService rentalService;
	
	@RequestMapping(value = {"/","index"})
	public String index(Model model, HttpServletRequest request, HttpServletResponse response, Principal principal) {
		
		List<CatalogoIndex> catalogo;
		//System.out.println(model.getAttribute("catalogo"));
		
		if(model.getAttribute("catalogo")==null) {
			catalogo = filmService.obtenerPeliculas();
		}
		else {
			catalogo = (List<CatalogoIndex>) model.getAttribute("catalogo");
		}
		
		
		List <Category> categorias = categoryService.findAll();
		
		model.addAttribute("catalogo",catalogo);
		model.addAttribute("categorias",categorias);
		
		return "views/index";
	}
	
	@RequestMapping(value = "filtroTitulo" , method = RequestMethod.POST)
	public String filtroTitulo(Model model, @RequestParam(name = "inputCambiar") String titulo, RedirectAttributes redirectAtt) {
		List<CatalogoIndex> filtroTitulo = filmService.filtrarPeliculasTitulo("%"+titulo.toUpperCase()+"%");
		redirectAtt.addFlashAttribute("catalogo",filtroTitulo);
		return "redirect:/";
	}
	
	@RequestMapping(value = "filtroCategoria" , method = RequestMethod.POST)
	public String filtroCategoria(Model model, @RequestParam(name = "selectCategoria") Integer categoria, RedirectAttributes redirectAtt) {
		Category category = categoryService.findById(categoria).get();
		
		List<CatalogoIndex> filtroCategoria = filmService.filtrarPeliculasCategoria(category.getName());
		redirectAtt.addFlashAttribute("catalogo",filtroCategoria);
		return "redirect:/";
	}
	
	@RequestMapping(value = "filtroActor" , method = RequestMethod.POST)
	public String filtroActor(Model model, @RequestParam(name = "inputCambiar") String actor, RedirectAttributes redirectAtt) {
		if(!actor.isBlank()) {
			List<CatalogoIndex> filtroActor = filmService.filtrarPeliculasActor("%"+actor.toUpperCase()+"%");
			redirectAtt.addFlashAttribute("catalogo",filtroActor);
		}
		return "redirect:/";
	}
	
	@GetMapping(value="detallesFilm/{filmId}")
	@ResponseBody  //
	public Map<String, Object> cargarDetalles(@PathVariable Integer filmId){
		Map<String, Object> response = new HashMap<>();
		
		Film film = filmService.findById(filmId).get();
		List<String> categorias = filmService.obtenerCategorias(filmId);
		List<String> actores = filmService.obtenerActores(filmId);
		
		response.put("detalles", film);
		response.put("categorias", categorias);
		response.put("actores", actores);
		
		return response;
	}
	
/*	@GetMapping("detallesFilm/exportarpdf/{filmId}")
	public void exportToPDF(HttpServletResponse response, HttpServletRequest request, @PathVariable Integer filmId)
			throws DocumentException, IOException {
		
		Film film = filmService.findById(filmId).get();
		List<String> categorias = filmService.obtenerCategorias(filmId);
		List<String> actores = filmService.obtenerActores(filmId);
		
		response.setContentType("application/pdf");
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String currentDateTime = dateFormatter.format(new Date());
		
		String headerKey = "Content-Disposition";
		StringBuilder sbHeaderValue = new StringBuilder("attachment; filename=film_");
		sbHeaderValue.append(film.getFilmId() + "_");
		sbHeaderValue.append(currentDateTime + ".pdf");
		response.setHeader(headerKey, sbHeaderValue.toString());

		FilmPDFExporter exporter = new FilmPDFExporter(film, categorias, actores);
		exporter.export(response);
	}
*/

	@GetMapping(value="detallesInventory/{inventoryId}")
	@ResponseBody
	public Map<String, Object> cargarDetallesInventario(@PathVariable Integer inventoryId){
		Map<String, Object> response = new HashMap<>();		
		response.put("result", inventoryService.findByInventoryId(inventoryId));		
		return response;
	}
	

	@GetMapping(value="rental")
	public String rental(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "views/renta/rental";
	}
	@GetMapping(value="RegistroPeliculas")
	public String RegistroPeliculas(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "views/RegistroPeliculas";
	}

	@GetMapping(value="customer")
	public String customer(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "views/customer/customer";
	}
	
	
	@GetMapping(value="RegistroDePeliculas")
	public String RegistroDePeliculas(Model model, HttpServletRequest request, HttpServletResponse response) {
		
		return "views/registroPeliculas/RegistroDePeliculas";
	}


	
}
