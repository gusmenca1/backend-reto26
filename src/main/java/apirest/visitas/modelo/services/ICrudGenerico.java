package apirest.visitas.modelo.services;

import java.util.List;

public interface ICrudGenerico<T, ID> {

	List<T> findAll();
	T findById(ID id);
	T save(T entity);
	void deleteById(ID id);
}
