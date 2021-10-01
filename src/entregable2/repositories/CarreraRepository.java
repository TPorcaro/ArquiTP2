package entregable2.repositories;

import java.util.List;

import entregable2.entities.Carrera;

/**
 * 
 * @author Juan Cruz
 * @author Nicolas
 * @author Tomas
 */
public interface CarreraRepository {

	void create(Carrera carrera);

	/**
	 * Retorna una lista de carreras con estudiantes, ordenada por la cantidad de
	 * inscriptos.
	 * 
	 * @return lista de carreras
	 */
	List<Carrera> getCarrerasWithEstudiantesByCantidadInscriptos();

	Carrera getCarreraById(int id);
}
