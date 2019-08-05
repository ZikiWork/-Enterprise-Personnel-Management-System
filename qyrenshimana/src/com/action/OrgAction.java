package com.action;

import java.util.List;
import java.util.Map;


import com.model.TOrganization;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrganizationService;

public class OrgAction extends ActionSupport
{
	private OrganizationService organizationService;
	
	private Integer depId;
	private String orgName;
	private String orgDescription;
	
	private int userId;
	

	public String orgMana() throws Exception
	{
		List orgList=organizationService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orgList", orgList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String orgMana1() throws Exception
	{
		List orgList=organizationService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orgList", orgList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String addOrg()
	{
		TOrganization organization=new TOrganization();
		organization.setOrgName(orgName);
		organization.setOrgDescription(orgDescription);
		System.out.println(depId+"%%%%%%%%%%%%%%%%");
		if(depId!=0)
		{
			organization.setParenOrganization(organizationService.findById(depId));
		}
		organizationService.save(organization);
		return "successAdd";
	}
	
	
	public String orgAll() throws Exception
	{
		List orgList=organizationService.findAll();
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orgList", orgList);
		return ActionSupport.SUCCESS;
	}
	
	
	public String delOrg()
	{
		return organizationService.delete(depId);
	}



	public String getOrgDescription()
	{
		return orgDescription;
	}

	public OrganizationService getOrganizationService()
	{
		return organizationService;
	}



	public void setOrganizationService(OrganizationService organizationService)
	{
		this.organizationService = organizationService;
	}


	public void setOrgDescription(String orgDescription)
	{
		this.orgDescription = orgDescription;
	}



	public String getOrgName()
	{
		return orgName;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}



	public Integer getDepId()
	{
		return depId;
	}



	public void setDepId(Integer depId)
	{
		this.depId = depId;
	}


    
	
}
