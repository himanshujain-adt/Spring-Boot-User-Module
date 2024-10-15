package co.alpha.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class BaseServiceImpl<T extends BaseDTO, D extends BaseDAOInt<T>> implements BaseSeviceInt<T> {
	@Autowired
	public D baseDao;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long add(T dto) {

		return baseDao.add(dto);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void update(T dto) {

		baseDao.update(dto);

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public long save(T dto) {

		Long id = dto.getId();
		if (id != null && id > 0) {
			update(dto);
		} else {
			id = add(dto);
		}
		return id;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public T delete(Long id) {

		T dto = findById(id);
		try {
			System.out.println("service delete==>>>>>" + id);
			baseDao.delete(dto);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return dto;
	}

	@Transactional(readOnly = true)
	@Override
	public T findById(Long pk) {

		return baseDao.findByPk(pk);
	}

	@Override
	public List search(T dto, int pageNo, int pageSize) {

		return baseDao.search(dto, pageNo, pageSize);
	}

}
