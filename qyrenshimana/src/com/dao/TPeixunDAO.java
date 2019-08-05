package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TPeixun;

/**
 * Data access object (DAO) for domain model class TPeixun.
 * 
 * @see com.model.TPeixun
 * @author MyEclipse Persistence Tools
 */

public class TPeixunDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TPeixunDAO.class);

	// property constants
	public static final String PEIXUNREN = "peixunren";

	public static final String PEIXUNZHUTI = "peixunzhuti";

	public static final String PEIXUNZONGZHI = "peixunzongzhi";

	public static final String PEIXUNNEIRONG = "peixunneirong";

	public static final String PEIXUNSHIJIAN = "peixunshijian";

	public static final String PEIXUNDIDIAN = "peixundidian";

	public static final String CANJIARENYUAN = "canjiarenyuan";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TPeixun transientInstance)
	{
		log.debug("saving TPeixun instance");
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

	public void delete(TPeixun persistentInstance)
	{
		log.debug("deleting TPeixun instance");
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

	public TPeixun findById(java.lang.Integer id)
	{
		log.debug("getting TPeixun instance with id: " + id);
		try
		{
			TPeixun instance = (TPeixun) getHibernateTemplate().get(
					"com.model.TPeixun", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TPeixun instance)
	{
		log.debug("finding TPeixun instance by example");
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
		log.debug("finding TPeixun instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TPeixun as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByPeixunren(Object peixunren)
	{
		return findByProperty(PEIXUNREN, peixunren);
	}

	public List findByPeixunzhuti(Object peixunzhuti)
	{
		return findByProperty(PEIXUNZHUTI, peixunzhuti);
	}

	public List findByPeixunzongzhi(Object peixunzongzhi)
	{
		return findByProperty(PEIXUNZONGZHI, peixunzongzhi);
	}

	public List findByPeixunneirong(Object peixunneirong)
	{
		return findByProperty(PEIXUNNEIRONG, peixunneirong);
	}

	public List findByPeixunshijian(Object peixunshijian)
	{
		return findByProperty(PEIXUNSHIJIAN, peixunshijian);
	}

	public List findByPeixundidian(Object peixundidian)
	{
		return findByProperty(PEIXUNDIDIAN, peixundidian);
	}

	public List findByCanjiarenyuan(Object canjiarenyuan)
	{
		return findByProperty(CANJIARENYUAN, canjiarenyuan);
	}

	public List findAll()
	{
		log.debug("finding all TPeixun instances");
		try
		{
			String queryString = "from TPeixun";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TPeixun merge(TPeixun detachedInstance)
	{
		log.debug("merging TPeixun instance");
		try
		{
			TPeixun result = (TPeixun) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TPeixun instance)
	{
		log.debug("attaching dirty TPeixun instance");
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

	public void attachClean(TPeixun instance)
	{
		log.debug("attaching clean TPeixun instance");
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

	public static TPeixunDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TPeixunDAO) ctx.getBean("TPeixunDAO");
	}
}