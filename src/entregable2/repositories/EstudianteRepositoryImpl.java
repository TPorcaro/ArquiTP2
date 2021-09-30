package entregable2.repositories;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;

import entregable2.entities.Carrera;
import entregable2.entities.Estudiante;
import entregable2.entities.Matricula;

public class EstudianteRepositoryImpl implements EstudianteRepository {

	private EntityManager em;
	
	public EstudianteRepositoryImpl(EntityManager em) {
		super();
		this.em = em;
	}
	public void closeConnection() {
		this.em.close();
	}

	@Override
	//Probar
	public void create(Estudiante estudiante) {
		this.em.getTransaction().begin();
		this.em.persist(estudiante);
		this.em.getTransaction().commit();

	}

	@Override
	//Probar
	public void matricularse(Estudiante estudiante, Carrera carrera) {
		this.em.getTransaction().begin();
		Matricula matricula = new Matricula(estudiante, carrera, new Timestamp(System.currentTimeMillis()), false);
		Estudiante estudiantePersisted = this.em.find(Estudiante.class, estudiante.getNmro_libreta());
		this.em.persist(matricula);
		estudiantePersisted.addMatricula(matricula);
		this.em.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	//Probar
	public List<Estudiante> getEstudiantesByDni() {
		this.em.getTransaction().begin();
		List<Estudiante> estudiantesByDni = this.em.createNamedQuery("SELECT e FROM estudiante e ORDER BY e.dni").getResultList();
		return estudiantesByDni;
	}

	@Override
	public Estudiante getEstudianteByLibreta(int libreta) {
		this.em.getTransaction().begin();
		Estudiante estudiante = this.em.find(Estudiante.class, libreta);
		this.em.getTransaction().commit();
		return estudiante;
	}

	@SuppressWarnings("unchecked")
	@Override
	//Probar
	public List<Estudiante> getEstudiantesByGenero(String genero) {
		this.em.getTransaction().begin();
		List<Estudiante> estudiantesByGenero = this.em.createNamedQuery("SELECT e FROM estudiante e WHERE e.genero = :genero")
												.setParameter(genero, genero).getResultList();
		return estudiantesByGenero;
	}

	@SuppressWarnings("unchecked")
	@Override
	//Probar
	public List<Estudiante> getEstudiantesByCarreraAndCiudad(int carrera, String ciudad) {
		this.em.getTransaction().begin();
		List<Estudiante> estudiantes = em.createQuery("SELECT e FROM Estudiante e JOIN e.carreras_inscriptas s WHERE s.carrera.id =: carrera AND  e.ciudad_residencia =: ciudad")
				.setParameter("carrera", carrera)
				.setParameter("ciudad", ciudad).getResultList();;
		return estudiantes;
	}

}
