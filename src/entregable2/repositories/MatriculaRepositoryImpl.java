package entregable2.repositories;

import java.util.List;

import javax.persistence.EntityManager;

import entregable2.DTO.ReporteCarrera;
import entregable2.entities.Matricula;

public class MatriculaRepositoryImpl implements MatriculaRepository {

	private EntityManager em;
	
	
	public MatriculaRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}
	public void closeConnection() {
		this.em.close();
	}
	@Override
	public void create(Matricula matricula) {
		this.em.getTransaction().begin();
		this.em.persist(matricula);
		this.em.getTransaction().commit();
	}
	@Override
	public List<ReporteCarrera> generarReporte() {
		@SuppressWarnings("unchecked")
		List<ReporteCarrera> retornoDTOCarreras = em.createQuery(
				"SELECT new entregable2.DTO.ReporteCarrera(c.idCarrera, c.nombre, YEAR(m.fecha_inicio),sum(m.egresado+0), COUNT(m.estudiante))"
				+ "FROM Matricula m JOIN m.carrera c JOIN m.estudiante e GROUP BY (c.idCarrera) ORDER BY YEAR(m.fecha_inicio) ASC, c.nombre ASC") 
				.getResultList();

		if (!retornoDTOCarreras.isEmpty()) {
			return retornoDTOCarreras;
		}
		return null;
	}

}
