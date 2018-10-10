package com.hcl.api.base.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public interface BaseDAO<T> {
	public void delete(T paramT) throws HibernateException;

	public boolean deleteById(Class<T> clazz, Long id) throws HibernateException;

	public <X> List<X> findAll(final Class<T> clazz) throws HibernateException;

	public <X> List<X> findAllWithOrder(final Class<T> clazz, String property, boolean isAscending)
			throws HibernateException;

	public <X> List<X> findByColumn(final Class<T> clazz, String column, Object value) throws HibernateException;

	public <X> X findUnique(final Class<T> clazz) throws HibernateException;

	public <X> List<X> findByColumn(Class<T> clazz, String column, String... values) throws HibernateException;

	public <X> List<X> findById(final Class<T> clazz, final List<Long> ids) throws HibernateException;

	public <X> X findById(final Class<T> clazz, final Long id) throws HibernateException;

	public <X> List<X> findById(final Class<T> clazz, final Long... id) throws HibernateException;

	public <X> X findUniqueByColumn(final Class<T> clazz, String column, Object value) throws HibernateException;

	public Session getCurrentSession();

	public T merge(T paramT) throws HibernateException;

	public Serializable save(T paramT) throws HibernateException;

	public void saveOrUpdate(T paramT) throws HibernateException;

	public void flush() throws HibernateException;

}
