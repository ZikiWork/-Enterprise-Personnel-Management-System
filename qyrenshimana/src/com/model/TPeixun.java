package com.model;

/**
 * TPeixun generated by MyEclipse Persistence Tools
 */

public class TPeixun implements java.io.Serializable
{

	// Fields

	private Integer id;

	private String peixunren;

	private String peixunzhuti;

	private String peixunzongzhi;

	private String peixunneirong;

	private String peixunshijian;

	private String peixundidian;

	private String canjiarenyuan;
	
	private String del;

	// Constructors

	/** default constructor */
	public TPeixun()
	{
	}

	/** full constructor */
	public TPeixun(String peixunren, String peixunzhuti, String peixunzongzhi,
			String peixunneirong, String peixunshijian, String peixundidian,
			String canjiarenyuan)
	{
		this.peixunren = peixunren;
		this.peixunzhuti = peixunzhuti;
		this.peixunzongzhi = peixunzongzhi;
		this.peixunneirong = peixunneirong;
		this.peixunshijian = peixunshijian;
		this.peixundidian = peixundidian;
		this.canjiarenyuan = canjiarenyuan;
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

	public String getDel()
	{
		return del;
	}

	public void setDel(String del)
	{
		this.del = del;
	}

	public String getPeixunren()
	{
		return this.peixunren;
	}

	public void setPeixunren(String peixunren)
	{
		this.peixunren = peixunren;
	}

	public String getPeixunzhuti()
	{
		return this.peixunzhuti;
	}

	public void setPeixunzhuti(String peixunzhuti)
	{
		this.peixunzhuti = peixunzhuti;
	}

	public String getPeixunzongzhi()
	{
		return this.peixunzongzhi;
	}

	public void setPeixunzongzhi(String peixunzongzhi)
	{
		this.peixunzongzhi = peixunzongzhi;
	}

	public String getPeixunneirong()
	{
		return this.peixunneirong;
	}

	public void setPeixunneirong(String peixunneirong)
	{
		this.peixunneirong = peixunneirong;
	}

	public String getPeixunshijian()
	{
		return this.peixunshijian;
	}

	public void setPeixunshijian(String peixunshijian)
	{
		this.peixunshijian = peixunshijian;
	}

	public String getPeixundidian()
	{
		return this.peixundidian;
	}

	public void setPeixundidian(String peixundidian)
	{
		this.peixundidian = peixundidian;
	}

	public String getCanjiarenyuan()
	{
		return this.canjiarenyuan;
	}

	public void setCanjiarenyuan(String canjiarenyuan)
	{
		this.canjiarenyuan = canjiarenyuan;
	}

}