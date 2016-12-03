package edu.sjsu.cmpe275.lab2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import edu.sjsu.cmpe275.lab2.dao.UserDAO;
import edu.sjsu.cmpe275.lab2.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;
	
	public User findUserById(String id) {
		return userDAO.findUserById(id);
	}

	public void saveUser(User User) {
		userDAO.saveUser(User);
	}

	public void updateUser(User User) {
		userDAO.updateUser(User);
	}

	public void deleteUserById(String id) {
		userDAO.deleteUserById(id);
	}

	public List<User> findAllUsers() {
		return userDAO.findAllUsers();
	}

}
