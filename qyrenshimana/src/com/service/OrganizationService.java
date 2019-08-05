package com.service;

import java.util.List;

import com.dao.TOrganizationDAO;
import com.model.TOrganization;



public class OrganizationService
{
	private TOrganizationDAO organizationDAO;

	public TOrganizationDAO getOrganizationDAO()
	{
		return organizationDAO;
	}

	public void setOrganizationDAO(TOrganizationDAO organizationDAO)
	{
		this.organizationDAO = organizationDAO;
	}
	
	
	public void save(TOrganization transientInstance)
	{
		organizationDAO.save(transientInstance);
	}

	public String delete(Integer depId)
	{
		//organizationDAO.delete(transientInstance);
		TOrganization organization=organizationDAO.findById(depId);
		System.out.println(organization.getOrgName());
		System.out.println(organization.getChildOrganization());
		if(organization.getChildOrganization().size()>0)
		{
			return "haveChildOrganization";
		}
		
		String hql="delete from TOrganization o where o.orgId=?";
		organizationDAO.getHibernateTemplate().bulkUpdate(hql,depId);
		return "successDel";
	}
	
	public List findAll()
	{
		return organizationDAO.findAll();
	}
	
	public TOrganization findById(java.lang.Integer id)
	{
		return organizationDAO.findById(id);
	}

}
