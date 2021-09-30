package entregable2.repositories;


import java.util.List;

import entregable2.DTO.ReporteCarrera;
import entregable2.entities.Matricula;

public interface MatriculaRepository {

	void create(Matricula matricula);
	List<ReporteCarrera> generarReporte();
}
