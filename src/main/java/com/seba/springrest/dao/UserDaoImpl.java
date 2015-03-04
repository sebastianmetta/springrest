package com.seba.springrest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import com.seba.springrest.model.User;


public class UserDaoImpl implements UserDao {

	private SessionFactory sessionFactory;
		
	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory; 
	}
	
	@Override
	@Transactional
	public User getById(int id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}
	
	@Override
	@Transactional
	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}
	
	@Override
	@Transactional
	public User getByName(String username) {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.add(Restrictions.eq("username", username)).list();
		return listUser!=null ? listUser.get(0) : null;
	}

	@Override
	@Transactional
	public List<User> getAll() {
		@SuppressWarnings("unchecked")
		List<User> listUser = (List<User>) sessionFactory.getCurrentSession()
				.createCriteria(User.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listUser;
	}
}
