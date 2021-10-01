package entregable2.repositories;

import java.util.List;

import entregable2.DTO.ReporteCarrera;
import entregable2.entities.Matricula;

public interface MatriculaRepository {

	void create(Matricula matricula);

	/**
	 * Genera un reporte de las carreras, que para cada carrera incluya información
	 * de los inscriptos y egresados por año. Ordenado alfabetica y
	 * cronologicamente.
	 * 
	 * @return reportes
	 */
	List<ReporteCarrera> generarReporte();
}
