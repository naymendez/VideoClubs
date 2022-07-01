package uabc.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uabc.demo.entities.Staff;
import uabc.demo.repository.StaffRepository;

@Service
public class StaffService {

	@Autowired
	private StaffRepository repo;
	
	public Staff obtenerPorId(Integer staffId) {
		
		Optional<Staff> staff = repo.findById(null);
		
		return staff.get();
	}
}