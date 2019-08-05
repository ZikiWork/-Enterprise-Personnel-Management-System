package com.action;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TQiyexinxiDAO;
import com.model.TQiyexinxi;
import com.opensymphony.xwork2.ActionSupport;

public class qiyexinxiAction extends ActionSupport
{
	private int id;
	private String name;
	private String fenlei;
	private String dizhi;
	private String lianxiren;
	
	private TQiyexinxiDAO qiyexinxiDAO;
	private String message;
	private String path;
	
	//管理员企业信息维护
	public String qiyexinxi()
	{
		TQiyexinxi qiyexinxi=qiyexinxiDAO.findById(1);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("qiyexinxi", qiyexinxi);
		return ActionSupport.SUCCESS;
	}
	
	
	//普通员工企业信息查看
	public String qiyexinxi_yuangong()
	{
		TQiyexinxi qiyexinxi=qiyexinxiDAO.findById(1);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("qiyexinxi", qiyexinxi);
		return ActionSupport.SUCCESS;
	}
	
	public String qiyexinxiUp()
	{
		TQiyexinxi qiyexinxi=qiyexinxiDAO.findById(1);
		qiyexinxi.setDizhi(dizhi);
		qiyexinxi.setFenlei(fenlei);
		qiyexinxi.setLianxiren(lianxiren);
		qiyexinxi.setName(name);
		qiyexinxiDAO.attachDirty(qiyexinxi);
		this.setMessage("操作成功");
		this.setPath("qiyexinxi.action");
		return "succeed";
		
	}
	
	
	public String getDizhi()
	{
		return dizhi;
	}
	public void setDizhi(String dizhi)
	{
		this.dizhi = dizhi;
	}
	public String getFenlei()
	{
		return fenlei;
	}
	public void setFenlei(String fenlei)
	{
		this.fenlei = fenlei;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getLianxiren()
	{
		return lianxiren;
	}
	public void setLianxiren(String lianxiren)
	{
		this.lianxiren = lianxiren;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPath()
	{
		return path;
	}
	public void setPath(String path)
	{
		this.path = path;
	}
	public TQiyexinxiDAO getQiyexinxiDAO()
	{
		return qiyexinxiDAO;
	}
	public void setQiyexinxiDAO(TQiyexinxiDAO qiyexinxiDAO)
	{
		this.qiyexinxiDAO = qiyexinxiDAO;
	}
	
}
