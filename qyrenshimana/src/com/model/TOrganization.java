package com.model;

import java.util.HashSet;
import java.util.Set;



public class TOrganization implements java.io.Serializable
{

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer orgId;

	private String orgName;

	private String orgSn;

	private String orgDescription;

	private TOrganization parenOrganization;
	
	private Set childOrganization = new HashSet(0);


	

	/** default constructor */
	public TOrganization()
	{
	}

	/** full constructor */
	public TOrganization(String orgName, String orgSn, String orgDescription)
	{
		this.orgName = orgName;
		this.orgSn = orgSn;
		this.orgDescription = orgDescription;
	}

	// Property accessors

	public Integer getOrgId()
	{
		return this.orgId;
	}

	public void setOrgId(Integer orgId)
	{
		this.orgId = orgId;
	}

	public String getOrgName()
	{
		return this.orgName;
	}

	public void setOrgName(String orgName)
	{
		this.orgName = orgName;
	}

	public String getOrgSn()
	{
		return this.orgSn;
	}

	public void setOrgSn(String orgSn)
	{
		this.orgSn = orgSn;
	}

	public String getOrgDescription()
	{
		return this.orgDescription;
	}

	public void setOrgDescription(String orgDescription)
	{
		this.orgDescription = orgDescription;
	}

	public Set getChildOrganization()
	{
		return childOrganization;
	}

	public void setChildOrganization(Set childOrganization)
	{
		this.childOrganization = childOrganization;
	}

	public TOrganization getParenOrganization()
	{
		return parenOrganization;
	}

	public void setParenOrganization(TOrganization parenOrganization)
	{
		this.parenOrganization = parenOrganization;
	}

}