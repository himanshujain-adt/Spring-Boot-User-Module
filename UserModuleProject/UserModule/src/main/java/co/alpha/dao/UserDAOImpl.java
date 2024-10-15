package co.alpha.dao;

import org.springframework.stereotype.Repository;

import co.alpha.common.BaseDAOImpl;
import co.alpha.dto.UserDTO;

@Repository
public class UserDAOImpl extends BaseDAOImpl<UserDTO> implements UserDAOInt {

	@Override
	public Class<UserDTO> getDTOClass() {
		// TODO Auto-generated method stub
		return UserDTO.class;
	}

}
