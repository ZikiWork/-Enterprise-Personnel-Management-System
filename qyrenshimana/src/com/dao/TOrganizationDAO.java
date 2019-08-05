package com.dao;

import java.util.List;
import java.util.Set;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TOrganization;


/**
 * Data access object (DAO) for domain model class TOrganization.
 * 
 * @see com.model.TOrganization
 * @author MyEclipse Persistence Tools
 */

public class TOrganizationDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TOrganizationDAO.class);

	

	public void save(TOrganization transientInstance)
	{
		log.debug("saving TOrganization instance");
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

	public void delete(TOrganization persistentInstance)
	{
		log.debug("deleting TOrganization instance");
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

	public TOrganization findById(java.lang.Integer id)
	{
		log.debug("getting TOrganization instance with id: " + id);
		try
		{
			TOrganization instance = (TOrganization) getHibernateTemplate()
					.get("com.model.TOrganization", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	

	public List findAll()
	{
		log.debug("finding all TOrganization instances");
		try
		{
			String queryString = "from TOrganization";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	
}