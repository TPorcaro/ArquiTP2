package entregable2.repositories;

import java.util.List;

import entregable2.entities.Carrera;

public interface CarreraRepository {

	void create(Carrera carrera);
	List<Carrera> getCarrerasWithEstudiantesByCantidadInscriptos();
	Carrera getCarreraById(int id);
}
