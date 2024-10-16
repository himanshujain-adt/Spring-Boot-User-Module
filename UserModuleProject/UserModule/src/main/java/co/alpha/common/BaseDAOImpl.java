package co.alpha.common;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import co.alpha.dto.UserDTO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public abstract class BaseDAOImpl<T extends BaseDTO> implements BaseDAOInt<T> {
	@PersistenceContext
	public EntityManager entityManager;

	public abstract Class<T> getDTOClass();

	@Override
	public long add(T dto) {

		entityManager.persist(dto);
		return dto.getId();
	}

	@Override
	public void update(T dto) {

		entityManager.merge(dto);

	}

	@Override
	public void delete(T dto) {
		System.out.println("base dao delete id" + dto.getId());

		entityManager.remove(dto);

	}

	@Override
	public T findByPk(Long pk) {

		T dto = entityManager.find(getDTOClass(), pk);
		return dto;
	}

	@Override
	public List search(T dto, int pageNo, int pageSize) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> cq = builder.createQuery(getDTOClass());
		Root<T> qRoot = cq.from(getDTOClass());
		TypedQuery<T> tq = entityManager.createQuery(cq);

		if (pageNo > 0) {
			System.out.println("Pagination work BaseDAOImpl class...");
			tq.setFirstResult(pageNo * pageSize);
			tq.setMaxResults(pageSize);

		}
		List<T> list = tq.getResultList();
		return list;
	}

	@Override
	public T findByRollNo(Long rollNo) {
		try {
			String jpql = "SELECT u FROM UserDTO u WHERE u.rollNo = :rollNo"; // Using UserDTO here
			return (T) entityManager.createQuery(jpql, UserDTO.class) // Specify UserDTO.class for type safety
					.setParameter("rollNo", rollNo).getSingleResult();
		} catch (NoResultException e) {
			// Handle the case where no result is found
			return null; // or throw your custom exception
		}

	}

}
