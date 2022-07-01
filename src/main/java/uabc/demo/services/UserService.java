package uabc.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uabc.demo.entities.Staff;
import uabc.demo.repository.StaffRepository;


@Service
public class UserService implements UserDetailsService{

	@Autowired
	private StaffRepository repo;
	
	private Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Staff usuario = repo.findByUsername(username);
		
		if(usuario == null) {
			logger.error("Error en el login: No existe el usuario: '" + username + "' en el sistema");
			throw new UsernameNotFoundException("usuario: '" + username + "' no existe en el sistema");
		}
		
		List <GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		roles.add(new SimpleGrantedAuthority("EMPLEADO"));
		
		return new User(usuario.getEmail(), usuario.getPassword(), roles) ;
	}
	
	
}
