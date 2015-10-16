package au.edu.parentPortal.dao.hibernate;

import au.edu.parentPortal.exceptions.DaoException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by blim on 24/11/2014.
 */
public abstract class DaoImpl<T> {

	@Autowired
	protected SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public T getById(long id) throws DaoException
	{
		Session s = sessionFactory.getCurrentSession();
		try
		{
			Object o = s.get(getModelClass(), id);

			if(o != null)
			{
				return (T) o;
			}
			else
			{
				return null;
			}
		}
		catch(RuntimeException e)
		{
			throw e;
		}
	}

	public void create(T o) throws DaoException
	{
		Session s = sessionFactory.getCurrentSession();
		try
		{
			s.save(o);
			s.flush();
		}
		catch(RuntimeException e)
		{
			throw e;
		}
	}

	public void update(T o) throws DaoException
	{
		Session s = sessionFactory.getCurrentSession();
		try
		{
			s.update(o);
			s.flush();
		}
		catch(RuntimeException e)
		{
			throw e;
		}

	}

	public void delete(T o) throws DaoException
	{

		Session s = sessionFactory.getCurrentSession();

		try
		{
			s.delete(o);
			s.flush();
		}
		catch(RuntimeException e)
		{
			throw e;
		}
	}


	public abstract Class<T> getModelClass();

}
