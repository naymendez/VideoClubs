package uabc.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import uabc.demo.entities.Rental;

public interface RentalRepository extends JpaRepository<Rental, Integer> {

}
