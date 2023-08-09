package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Component;

import spring_mvc_basics.controller.DoctorDto;

@Component
public class DoctorDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("dev");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public void insert(DoctorDto d1) {
		entityTransaction.begin();
		entityManager.persist(d1);
		entityTransaction.commit();
	}

	public boolean delete(int id) {
		DoctorDto d1 = entityManager.find(DoctorDto.class, id);
		if (d1 != null) {
			entityTransaction.begin();
			entityManager.remove(d1);
			entityTransaction.commit();
			return true;
		}
		return false;
	}

	public String deleteAll() {
		Query query = entityManager.createQuery("select data from DoctorDto data");
		List<DoctorDto> dtos = query.getResultList();
		if (dtos.isEmpty()) {
			return "data not found";
		} else {
			for (DoctorDto uv : dtos) {
				entityTransaction.begin();
				entityManager.remove(uv);
				entityTransaction.commit();
			}
		}
		return "data deleted succesfully";
	}

	public DoctorDto findById(int id) {
		DoctorDto d1 = entityManager.find(DoctorDto.class, id);
		return d1;
	}

	public List<DoctorDto> fetchAll() {
		Query query = entityManager.createQuery("select data from DoctorDto data");
		List<DoctorDto> dtos = query.getResultList();
		if (dtos.isEmpty()) {
			return null;
		} else
			return dtos;
	}

	public void updateAll(DoctorDto d2) {
		// TODO Auto-generated method stub
		entityTransaction.begin();
		entityManager.merge(d2);
		entityTransaction.commit();
	}

}
