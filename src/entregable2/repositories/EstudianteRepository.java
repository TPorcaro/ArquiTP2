package entregable2.repositories;

import java.util.List;

import entregable2.entities.Carrera;
import entregable2.entities.Estudiante;

public interface EstudianteRepository {

	void create(Estudiante estudiante);
	
	void matricularse(Estudiante estudiante,Carrera carrera);
	
	List<Estudiante> getEstudiantesByDni();
	
	Estudiante getEstudianteByLibreta(int libreta);
	
	List<Estudiante> getEstudiantesByGenero(String genero);
	
	List<Estudiante> getEstudiantesByCarreraAndCiudad(int carrera, String ciudad);
}
