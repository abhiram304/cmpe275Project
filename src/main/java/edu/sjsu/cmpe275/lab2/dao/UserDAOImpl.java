package edu.sjsu.cmpe275.lab2.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.lab2.model.User;

@Repository
public class UserDAOImpl extends AbstractDao<String, User> implements UserDAO {
	
	@Autowired
    SessionFactory sessionFactory;
	
	public User findUserById(String id) {
		return findById(id);
	}

	public void saveUser(User user) {
		save(user);		
	}

	public void updateUser(User user) {
		update(user);		
	}

	public void deleteUserById(String id) {
		deleteById(id);
	}

	public List<User> findAllUsers() {
		List<User> list = findAll();
		return list;
	}

}
