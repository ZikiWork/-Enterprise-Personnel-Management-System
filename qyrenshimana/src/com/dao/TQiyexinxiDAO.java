package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TQiyexinxi;

/**
 * Data access object (DAO) for domain model class TQiyexinxi.
 * 
 * @see com.model.TQiyexinxi
 * @author MyEclipse Persistence Tools
 */

public class TQiyexinxiDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TQiyexinxiDAO.class);

	// property constants
	public static final String NAME = "name";

	public static final String FENLEI = "fenlei";

	public static final String DIZHI = "dizhi";

	public static final String LIANXIREN = "lianxiren";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TQiyexinxi transientInstance)
	{
		log.debug("saving TQiyexinxi instance");
		try
		{
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re)
		{
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TQiyexinxi persistentInstance)
	{
		log.debug("deleting TQiyexinxi instance");
		try
		{
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re)
		{
			log.error("delete failed", re);
			throw re;
		}
	}

	public TQiyexinxi findById(java.lang.Integer id)
	{
		log.debug("getting TQiyexinxi instance with id: " + id);
		try
		{
			TQiyexinxi instance = (TQiyexinxi) getHibernateTemplate().get(
					"com.model.TQiyexinxi", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TQiyexinxi instance)
	{
		log.debug("finding TQiyexinxi instance by example");
		try
		{
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re)
		{
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value)
	{
		log.debug("finding TQiyexinxi instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TQiyexinxi as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name)
	{
		return findByProperty(NAME, name);
	}

	public List findByFenlei(Object fenlei)
	{
		return findByProperty(FENLEI, fenlei);
	}

	public List findByDizhi(Object dizhi)
	{
		return findByProperty(DIZHI, dizhi);
	}

	public List findByLianxiren(Object lianxiren)
	{
		return findByProperty(LIANXIREN, lianxiren);
	}

	public List findAll()
	{
		log.debug("finding all TQiyexinxi instances");
		try
		{
			String queryString = "from TQiyexinxi";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TQiyexinxi merge(TQiyexinxi detachedInstance)
	{
		log.debug("merging TQiyexinxi instance");
		try
		{
			TQiyexinxi result = (TQiyexinxi) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TQiyexinxi instance)
	{
		log.debug("attaching dirty TQiyexinxi instance");
		try
		{
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TQiyexinxi instance)
	{
		log.debug("attaching clean TQiyexinxi instance");
		try
		{
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re)
		{
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TQiyexinxiDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TQiyexinxiDAO) ctx.getBean("TQiyexinxiDAO");
	}
}