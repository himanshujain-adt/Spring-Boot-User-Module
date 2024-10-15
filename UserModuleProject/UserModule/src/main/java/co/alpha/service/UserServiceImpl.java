package co.alpha.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.alpha.common.BaseServiceImpl;
import co.alpha.dao.UserDAOInt;
import co.alpha.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

}
