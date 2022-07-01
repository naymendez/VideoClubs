package uabc.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import uabc.demo.entities.Language;


public interface LanguageRepository extends JpaRepository<Language, Integer>{
	
	

}