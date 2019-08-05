package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TYuangong;

/**
 * Data access object (DAO) for domain model class TYuangong.
 * 
 * @see com.model.TYuangong
 * @author MyEclipse Persistence Tools
 */

public class TYuangongDAO extends HibernateDaoSupport
{
	private static final Log log = LogFactory.getLog(TYuangongDAO.class);

	// property constants
	public static final String YUANGONG_NAME = "yuangongName";

	public static final String YUANGONG_SEX = "yuangongSex";

	public static final String YUANGONG_AGE = "yuangongAge";

	public static final String YUANGONG_XUELI = "yuangongXueli";

	public static final String YUANGONG_ZHIWEI = "yuangongZhiwei";

	public static final String YUANGONG_ADDRESS = "yuangongAddress";

	public static final String YUANGONG_TEL = "yuangongTel";

	public static final String YUANGONG_EMAIL = "yuangongEmail";

	public static final String YUANGONG_QQ = "yuangongQq";

	public static final String YUANGONG_LOGIN_NAME = "yuangongLoginName";

	public static final String YUANGONG_LOGIN_PW = "yuangongLoginPw";

	public static final String YUANGONG_ORG_ID = "yuangongOrgId";

	public static final String DEL = "del";

	protected void initDao()
	{
		// do nothing
	}

	public void save(TYuangong transientInstance)
	{
		log.debug("saving TYuangong instance");
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

	public void delete(TYuangong persistentInstance)
	{
		log.debug("deleting TYuangong instance");
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

	public TYuangong findById(java.lang.Integer id)
	{
		log.debug("getting TYuangong instance with id: " + id);
		try
		{
			TYuangong instance = (TYuangong) getHibernateTemplate().get(
					"com.model.TYuangong", id);
			return instance;
		} catch (RuntimeException re)
		{
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TYuangong instance)
	{
		log.debug("finding TYuangong instance by example");
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
		log.debug("finding TYuangong instance with property: " + propertyName
				+ ", value: " + value);
		try
		{
			String queryString = "from TYuangong as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re)
		{
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByYuangongName(Object yuangongName)
	{
		return findByProperty(YUANGONG_NAME, yuangongName);
	}

	public List findByYuangongSex(Object yuangongSex)
	{
		return findByProperty(YUANGONG_SEX, yuangongSex);
	}

	public List findByYuangongAge(Object yuangongAge)
	{
		return findByProperty(YUANGONG_AGE, yuangongAge);
	}

	public List findByYuangongXueli(Object yuangongXueli)
	{
		return findByProperty(YUANGONG_XUELI, yuangongXueli);
	}

	public List findByYuangongZhiwei(Object yuangongZhiwei)
	{
		return findByProperty(YUANGONG_ZHIWEI, yuangongZhiwei);
	}

	public List findByYuangongAddress(Object yuangongAddress)
	{
		return findByProperty(YUANGONG_ADDRESS, yuangongAddress);
	}

	public List findByYuangongTel(Object yuangongTel)
	{
		return findByProperty(YUANGONG_TEL, yuangongTel);
	}

	public List findByYuangongEmail(Object yuangongEmail)
	{
		return findByProperty(YUANGONG_EMAIL, yuangongEmail);
	}

	public List findByYuangongQq(Object yuangongQq)
	{
		return findByProperty(YUANGONG_QQ, yuangongQq);
	}

	public List findByYuangongLoginName(Object yuangongLoginName)
	{
		return findByProperty(YUANGONG_LOGIN_NAME, yuangongLoginName);
	}

	public List findByYuangongLoginPw(Object yuangongLoginPw)
	{
		return findByProperty(YUANGONG_LOGIN_PW, yuangongLoginPw);
	}

	public List findByYuangongOrgId(Object yuangongOrgId)
	{
		return findByProperty(YUANGONG_ORG_ID, yuangongOrgId);
	}

	public List findByDel(Object del)
	{
		return findByProperty(DEL, del);
	}

	public List findAll()
	{
		log.debug("finding all TYuangong instances");
		try
		{
			String queryString = "from TYuangong";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re)
		{
			log.error("find all failed", re);
			throw re;
		}
	}

	public TYuangong merge(TYuangong detachedInstance)
	{
		log.debug("merging TYuangong instance");
		try
		{
			TYuangong result = (TYuangong) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re)
		{
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TYuangong instance)
	{
		log.debug("attaching dirty TYuangong instance");
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

	public void attachClean(TYuangong instance)
	{
		log.debug("attaching clean TYuangong instance");
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

	public static TYuangongDAO getFromApplicationContext(ApplicationContext ctx)
	{
		return (TYuangongDAO) ctx.getBean("TYuangongDAO");
	}
}