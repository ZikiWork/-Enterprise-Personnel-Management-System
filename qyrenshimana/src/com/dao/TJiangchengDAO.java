package com.dao;

import java.util.Date;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJiangcheng;

/**
 * Data access object (DAO) for domain model class TJiangcheng.
 * 
 * @see com.model.TJiangcheng
 * @author MyEclipse Persistence Tools
 */

public class TJiangchengDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TJiangchengDAO.class);

	// property constants
	public static final String JIANGCHENG_XIANGMU = "jiangchengXiangmu";

	public static final String JIANGCHENG_JINE = "jiangchengJine";

	public static final String JIANGCHENG_BEIZHU = "jiangchengBeizhu";

	public static final String JIANGCHENG_USER_ID = "jiangchengUserId";

	public static final String JIANGCHENG_USER_NAME = "jiangchengUserName";

	public static final String JIANGCHENG_USER_ORG = "jiangchengUserOrg";

	public static final String JIANGCHENG_USER_SEX = "jiangchengUserSex";

	public static final String JIANGCHENG_ONE1 = "jiangchengOne1";

	public static final String JIANGCHENG_ONE2 = "jiangchengOne2";

	public static final String JIANGCHENG_ONE3 = "jiangchengOne3";

	public static final String JIANGCHENG_ONE4 = "jiangchengOne4";

	public static final String JIANGCHENG_ONE5 = "jiangchengOne5";

	public static final String JIANGCHENG_ONE6 = "jiangchengOne6";

	public static final String JIANGCHENG_ONE7 = "jiangchengOne7";

	public static final String JIANGCHENG_ONE10 = "jiangchengOne10";

	protected void initDao() {
		// do nothing
	}

	public void save(TJiangcheng transientInstance) {
		log.debug("saving TJiangcheng instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJiangcheng persistentInstance) {
		log.debug("deleting TJiangcheng instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJiangcheng findById(java.lang.Integer id) {
		log.debug("getting TJiangcheng instance with id: " + id);
		try {
			TJiangcheng instance = (TJiangcheng) getHibernateTemplate().get(
					"com.model.TJiangcheng", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJiangcheng instance) {
		log.debug("finding TJiangcheng instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TJiangcheng instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJiangcheng as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByJiangchengXiangmu(Object jiangchengXiangmu) {
		return findByProperty(JIANGCHENG_XIANGMU, jiangchengXiangmu);
	}

	public List findByJiangchengJine(Object jiangchengJine) {
		return findByProperty(JIANGCHENG_JINE, jiangchengJine);
	}

	public List findByJiangchengBeizhu(Object jiangchengBeizhu) {
		return findByProperty(JIANGCHENG_BEIZHU, jiangchengBeizhu);
	}

	public List findByJiangchengUserId(Object jiangchengUserId) {
		return findByProperty(JIANGCHENG_USER_ID, jiangchengUserId);
	}

	public List findByJiangchengUserName(Object jiangchengUserName) {
		return findByProperty(JIANGCHENG_USER_NAME, jiangchengUserName);
	}

	public List findByJiangchengUserOrg(Object jiangchengUserOrg) {
		return findByProperty(JIANGCHENG_USER_ORG, jiangchengUserOrg);
	}

	public List findByJiangchengUserSex(Object jiangchengUserSex) {
		return findByProperty(JIANGCHENG_USER_SEX, jiangchengUserSex);
	}

	public List findByJiangchengOne1(Object jiangchengOne1) {
		return findByProperty(JIANGCHENG_ONE1, jiangchengOne1);
	}

	public List findByJiangchengOne2(Object jiangchengOne2) {
		return findByProperty(JIANGCHENG_ONE2, jiangchengOne2);
	}

	public List findByJiangchengOne3(Object jiangchengOne3) {
		return findByProperty(JIANGCHENG_ONE3, jiangchengOne3);
	}

	public List findByJiangchengOne4(Object jiangchengOne4) {
		return findByProperty(JIANGCHENG_ONE4, jiangchengOne4);
	}

	public List findByJiangchengOne5(Object jiangchengOne5) {
		return findByProperty(JIANGCHENG_ONE5, jiangchengOne5);
	}

	public List findByJiangchengOne6(Object jiangchengOne6) {
		return findByProperty(JIANGCHENG_ONE6, jiangchengOne6);
	}

	public List findByJiangchengOne7(Object jiangchengOne7) {
		return findByProperty(JIANGCHENG_ONE7, jiangchengOne7);
	}

	public List findByJiangchengOne10(Object jiangchengOne10) {
		return findByProperty(JIANGCHENG_ONE10, jiangchengOne10);
	}

	public List findAll() {
		log.debug("finding all TJiangcheng instances");
		try {
			String queryString = "from TJiangcheng";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJiangcheng merge(TJiangcheng detachedInstance) {
		log.debug("merging TJiangcheng instance");
		try {
			TJiangcheng result = (TJiangcheng) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJiangcheng instance) {
		log.debug("attaching dirty TJiangcheng instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJiangcheng instance) {
		log.debug("attaching clean TJiangcheng instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJiangchengDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (TJiangchengDAO) ctx.getBean("TJiangchengDAO");
	}
}