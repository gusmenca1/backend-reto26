package apirest.visitas.modelo.services;

import java.util.List;
import apirest.visitas.security.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apirest.visitas.modelo.entities.Perfil;
import apirest.visitas.modelo.repository.PerfilRepository;

@Service
public class PerfilServiceImplMySql8 implements PerfilService{

    private final SecurityConfig securityConfig;

	@Autowired
	private PerfilRepository perfilRepository;

    PerfilServiceImplMySql8(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }
	
	@Override
	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return perfilRepository.findAll();
	}

	@Override
	public Perfil findById(Integer idPerfil) {
		// TODO Auto-generated method stub
		return perfilRepository.findById(idPerfil).orElse(null);
	}

	@Override
	public Perfil save(Perfil perfil) {
		// TODO Auto-generated method stub
		return perfilRepository.save(perfil);
	}

	@Override
	public void deleteById(Integer idPerfil) {
		// TODO Auto-generated method stub
		perfilRepository.deleteById(idPerfil);
	}

}
