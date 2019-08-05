package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TJiangchengDAO;
import com.dao.TYuangongDAO;
import com.model.TGongzi;
import com.model.TJiangcheng;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class jiangchengAction extends ActionSupport {
	private int jiangchengId;
	private int jiangchengYuangongId;
	private String jiangchengDate;
	private String jiangchengXiangmu;

	private String jiangchengShuxing;
	private Integer jiangchengJine;
	private String jiangchengBeizhu;

	private int yuangongId;

	private TJiangchengDAO jiangchengDAO;
	private TYuangongDAO yuangongDAO;
	private String message;
	private String path;

	public String jiangchengAdd() {
		TJiangcheng jiangcheng = new TJiangcheng();
		jiangcheng.setJiangchengYuangongId(jiangchengYuangongId);
		jiangcheng.setJiangchengYuangongName(yuangongDAO.findById(
				jiangchengYuangongId).getYuangongName());

		jiangcheng.setJiangchengDate(jiangchengDate);
		jiangcheng.setJiangchengXiangmu(jiangchengXiangmu);
		jiangcheng.setJiangchengJine(jiangchengJine);
		jiangcheng.setJiangchengBeizhu(jiangchengBeizhu);

		jiangchengDAO.save(jiangcheng);
		this.setMessage("操作成功");
		this.setPath("jiangchengMana.action");
		return "succeed";

	}

	public String jiangchengMana() {
		List jiangchengList = jiangchengDAO.findAll();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("jiangchengList", jiangchengList);
		return ActionSupport.SUCCESS;
	}

	public String jiangchengManaMy() {
		String sql = "from TJiangcheng where jiangchengYuangongId="
				+ yuangongId;
		List jiangchengList = jiangchengDAO.getHibernateTemplate().find(sql);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("jiangchengList", jiangchengList);
		return ActionSupport.SUCCESS;
	}

	public String jiangchengDel() {
		jiangchengDAO.delete(jiangchengDAO.findById(jiangchengId));
		this.setMessage("操作成功");
		this.setPath("jiangchengMana.action");
		return "succeed";
	}

	public String jiangchengEditPre() {
		TJiangcheng jiangcheng = jiangchengDAO.findById(jiangchengId);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("jiangcheng", jiangcheng);
		return ActionSupport.SUCCESS;
	}

	public String jiangchengEdit() {
		TJiangcheng jiangcheng = jiangchengDAO.findById(jiangchengId);
		jiangcheng.setJiangchengYuangongId(jiangchengYuangongId);
		jiangcheng.setJiangchengYuangongName(yuangongDAO.findById(
				jiangchengYuangongId).getYuangongName());

		jiangcheng.setJiangchengDate(jiangchengDate);
		jiangcheng.setJiangchengXiangmu(jiangchengXiangmu);

		jiangchengDAO.attachDirty(jiangcheng);
		this.setMessage("操作成功");
		this.setPath("jiangchengMana.action");
		return "succeed";
	}

	public TJiangchengDAO getJiangchengDAO() {
		return jiangchengDAO;
	}

	public void setJiangchengDAO(TJiangchengDAO jiangchengDAO) {
		this.jiangchengDAO = jiangchengDAO;
	}

	public String getJiangchengDate() {
		return jiangchengDate;
	}

	public void setJiangchengDate(String jiangchengDate) {
		this.jiangchengDate = jiangchengDate;
	}

	public int getJiangchengId() {
		return jiangchengId;
	}

	public void setJiangchengId(int jiangchengId) {
		this.jiangchengId = jiangchengId;
	}

	public String getJiangchengXiangmu() {
		return jiangchengXiangmu;
	}

	public void setJiangchengXiangmu(String jiangchengXiangmu) {
		this.jiangchengXiangmu = jiangchengXiangmu;
	}

	public int getJiangchengYuangongId() {
		return jiangchengYuangongId;
	}

	public void setJiangchengYuangongId(int jiangchengYuangongId) {
		this.jiangchengYuangongId = jiangchengYuangongId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TYuangongDAO getYuangongDAO() {
		return yuangongDAO;
	}

	public void setYuangongDAO(TYuangongDAO yuangongDAO) {
		this.yuangongDAO = yuangongDAO;
	}

	public String getJiangchengShuxing() {
		return jiangchengShuxing;
	}

	public void setJiangchengShuxing(String jiangchengShuxing) {
		this.jiangchengShuxing = jiangchengShuxing;
	}

	public Integer getJiangchengJine() {
		return jiangchengJine;
	}

	public void setJiangchengJine(Integer jiangchengJine) {
		this.jiangchengJine = jiangchengJine;
	}

	public String getJiangchengBeizhu() {
		return jiangchengBeizhu;
	}

	public void setJiangchengBeizhu(String jiangchengBeizhu) {
		this.jiangchengBeizhu = jiangchengBeizhu;
	}

	public int getYuangongId() {
		return yuangongId;
	}

	public void setYuangongId(int yuangongId) {
		this.yuangongId = yuangongId;
	}

}
