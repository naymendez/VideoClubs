package uabc.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.CatalogoIndex;
import uabc.demo.entities.Film;
import uabc.demo.repository.FilmRepository;

@Service

public class FilmService implements IFilmService{

	@Autowired
	private FilmRepository filmRepository;
	
	public List<CatalogoIndex> obtenerPeliculas(){
		return filmRepository.obtenerPeliculas();
	}
	
	public List<CatalogoIndex> filtrarPeliculasTitulo(String titulo){
		return filmRepository.filtrarPeliculasTitulo(titulo);
	}
	
	public List<CatalogoIndex> filtrarPeliculasCategoria(String categoria){
		return filmRepository.filtrarPeliculasCategoria(categoria);
	}
	
	public List<CatalogoIndex> filtrarPeliculasActor(String actor){
		return filmRepository.filtrarPeliculasActor(actor);
	}

	@Override
	public Optional<Film> findById(Integer id) {
		return filmRepository.findById(id);
	}

	@Override
	public List<String> obtenerCategorias(Integer filmId) {
		return filmRepository.obtenerCategorias(filmId);
	}

	@Override
	public List<String> obtenerActores(Integer filmId) {
		return filmRepository.obtenerActores(filmId);
	}
	
	
}
