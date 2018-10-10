package com.hcl.api.base.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BaseDAOImpl<T> extends HibernateDaoSupport implements BaseDAO<T> {
	@Override
	public void delete(T paramT) throws HibernateException {
		final Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.delete(paramT);
		currentSession.flush();
	}

	@Override
	public boolean deleteById(Class<T> clazz, Long id) throws HibernateException {
		T obj = findById(clazz, id);
		if (obj != null) {
			final Session currentSession = getSessionFactory().getCurrentSession();
			currentSession.delete(obj);
			currentSession.flush();
			return true;
		}
		return false;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findAll(Class<T> clazz) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findAllWithOrder(final Class<T> clazz, final String property, final boolean isAscending)
			throws HibernateException {
		if (isAscending) {
			return getSessionFactory().getCurrentSession().createCriteria(clazz).addOrder(Order.asc(property)).list();
		} else {
			return getSessionFactory().getCurrentSession().createCriteria(clazz).addOrder(Order.desc(property)).list();
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> X findUnique(Class<T> clazz) throws HibernateException {
		final List<X> result = getSessionFactory().getCurrentSession().createCriteria(clazz).list();
		if (result != null && !result.isEmpty()) {
			return (X) result.get(0);
		}
		return null;
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findByColumn(Class<T> clazz, String column, Object value) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(column, value)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findByColumn(Class<T> clazz, String column, String... values) throws HibernateException {
		return (List<X>) getSessionFactory().getCurrentSession().createCriteria(clazz)
				.add(Restrictions.in(column, values)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findById(Class<T> clazz, final List<Long> ids) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.in("id", ids)).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> X findById(Class<T> clazz, Long id) throws HibernateException {
		return (X) getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq("id", id))
				.uniqueResult();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> List<X> findById(Class<T> clazz, final Long... id) throws HibernateException {
		return getSessionFactory().getCurrentSession().createCriteria(clazz)
				.add(Restrictions.in("id", new ArrayList<>(Arrays.asList(id)))).list();
	}

	@Override
	@SuppressWarnings("unchecked")
	public <X> X findUniqueByColumn(Class<T> clazz, String column, Object value) throws HibernateException {
		return (X) getSessionFactory().getCurrentSession().createCriteria(clazz).add(Restrictions.eq(column, value))
				.uniqueResult();
	}

	public void flush() throws HibernateException {
		final Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.flush();
	}

	public Session getCurrentSession() {
		return getSessionFactory().getCurrentSession();
	}

	@Override
	@SuppressWarnings({ "unchecked" })
	public T merge(T paramT) throws HibernateException {
		final Session currentSession = getSessionFactory().getCurrentSession();
		return (T) currentSession.merge(paramT);
	}

	@Override
	public Serializable save(T paramT) throws HibernateException {
		final Session currentSession = getSessionFactory().getCurrentSession();
		final Serializable serializable = currentSession.save(paramT);
		currentSession.flush();
		return serializable;
	}

	@Override
	public void saveOrUpdate(T paramT) throws HibernateException {
		final Session currentSession = getSessionFactory().getCurrentSession();
		currentSession.saveOrUpdate(paramT);
		currentSession.flush();
	}

	@Resource(name = "sessionFactory")
	public void setBaseDaoSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}
}
