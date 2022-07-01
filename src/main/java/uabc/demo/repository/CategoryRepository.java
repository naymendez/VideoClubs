package uabc.demo.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.demo.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	public Optional<Category> findById(Integer id);

}
