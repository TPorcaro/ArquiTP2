package entregable2.repositories;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import entregable2.entities.Carrera;

/**
 * 
 * @author Juan Cruz
 * @author Nicolas
 * @author Tomas
 *
 */
public class CarreraRepositoryImpl implements CarreraRepository {

	private EntityManager em;

	public CarreraRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}

	public void closeConnection() {
		this.em.close();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Carrera> getCarrerasWithEstudiantesByCantidadInscriptos() {
		List<Carrera> retornedList = em.createQuery(
				"SELECT c FROM Matricula m JOIN m.carrera c GROUP BY c.idCarrera ORDER BY COUNT(m.estudiante) DESC")
				.getResultList();

		if (!retornedList.isEmpty()) {
			return retornedList;
		}
		return null;
	}

	@Override
	public void create(Carrera carrera) {
		this.em.getTransaction().begin();
		this.em.persist(carrera);
		this.em.getTransaction().commit();
	}

	@Override
	public Carrera getCarreraById(int id) {
		this.em.getTransaction().begin();
		Carrera carrera = this.em.find(Carrera.class, id);
		this.em.getTransaction().commit();
		return carrera;
	}

}
