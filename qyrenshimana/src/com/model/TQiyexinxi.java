package com.model;

/**
 * TQiyexinxi generated by MyEclipse Persistence Tools
 */

public class TQiyexinxi implements java.io.Serializable
{

	// Fields

	private Integer id;

	private String name;

	private String fenlei;

	private String dizhi;

	private String lianxiren;

	// Constructors

	/** default constructor */
	public TQiyexinxi()
	{
	}

	/** full constructor */
	public TQiyexinxi(String name, String fenlei, String dizhi, String lianxiren)
	{
		this.name = name;
		this.fenlei = fenlei;
		this.dizhi = dizhi;
		this.lianxiren = lianxiren;
	}

	// Property accessors

	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getFenlei()
	{
		return this.fenlei;
	}

	public void setFenlei(String fenlei)
	{
		this.fenlei = fenlei;
	}

	public String getDizhi()
	{
		return this.dizhi;
	}

	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}

	public String getLianxiren()
	{
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}

}