package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TAdminDAO;
import com.dao.TPeixunDAO;
import com.model.TAdmin;
import com.model.TPeixun;
import com.opensymphony.xwork2.ActionSupport;
import com.util.Pagination;

public class peixunAction extends ActionSupport
{
	private int id;
	private String peixunren;
	private String peixunzhuti;
	private String peixunzongzhi;
	private String peixunneirong;
	private String peixunshijian;
	private String peixundidian;
	private String canjiarenyuan;
	 
	private String message;
	private String path;
	
	private TPeixunDAO peixunDAO;
	
	
	
	public String peixunAdd()
	{
		TPeixun peixun=new TPeixun();
		peixun.setPeixunren(peixunren);
		peixun.setPeixunzhuti(peixunzhuti);
		peixun.setPeixunzongzhi(peixunzongzhi);
		peixun.setPeixunneirong(peixunneirong);
		peixun.setPeixunshijian(peixunshijian);
		peixun.setPeixundidian(peixundidian);
		peixun.setCanjiarenyuan(canjiarenyuan);
		peixun.setDel("no");
		peixunDAO.save(peixun);
		
		this.setMessage("操作成功");
		this.setPath("peixunMana.action");
		return "succeed";
	}
	
	public String peixunDel()
	{
		TPeixun peixun=peixunDAO.findById(id);
		peixun.setDel("yes");
		peixunDAO.attachDirty(peixun);
		this.setMessage("操作成功");
		this.setPath("peixunMana.action");
		return "succeed";
	}
	
	
	public String peixunMana()
	{
		String sql="from TPeixun where del='no'";
		List peixunList=peixunDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunList", peixunList);
		return ActionSupport.SUCCESS;
	}
	
	public String peixunMana1()
	{
		String sql="from TPeixun where del='no'";
		List peixunList=peixunDAO.getHibernateTemplate().find(sql);
		Map request=(Map)ServletActionContext.getContext().get("request");
		request.put("peixunList", peixunList);
		return ActionSupport.SUCCESS;
	}


	public String getCanjiarenyuan()
	{
		return canjiarenyuan;
	}



	public void setCanjiarenyuan(String canjiarenyuan)
	{
		this.canjiarenyuan = canjiarenyuan;
	}



	public int getId()
	{
		return id;
	}



	public void setId(int id)
	{
		this.id = id;
	}



	public String getMessage()
	{
		return message;
	}



	public TPeixunDAO getPeixunDAO()
	{
		return peixunDAO;
	}



	public void setPeixunDAO(TPeixunDAO peixunDAO)
	{
		this.peixunDAO = peixunDAO;
	}



	public void setMessage(String message)
	{
		this.message = message;
	}



	public String getPath()
	{
		return path;
	}



	public void setPath(String path)
	{
		this.path = path;
	}



	public String getPeixundidian()
	{
		return peixundidian;
	}



	public void setPeixundidian(String peixundidian)
	{
		this.peixundidian = peixundidian;
	}



	public String getPeixunneirong()
	{
		return peixunneirong;
	}



	public void setPeixunneirong(String peixunneirong)
	{
		this.peixunneirong = peixunneirong;
	}



	public String getPeixunren()
	{
		return peixunren;
	}



	public void setPeixunren(String peixunren)
	{
		this.peixunren = peixunren;
	}



	public String getPeixunshijian()
	{
		return peixunshijian;
	}



	public void setPeixunshijian(String peixunshijian)
	{
		this.peixunshijian = peixunshijian;
	}



	public String getPeixunzhuti()
	{
		return peixunzhuti;
	}



	public void setPeixunzhuti(String peixunzhuti)
	{
		this.peixunzhuti = peixunzhuti;
	}



	public String getPeixunzongzhi()
	{
		return peixunzongzhi;
	}



	public void setPeixunzongzhi(String peixunzongzhi)
	{
		this.peixunzongzhi = peixunzongzhi;
	}
	
}
