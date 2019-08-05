package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TGongziDAO;
import com.dao.TJiangchengDAO;
import com.dao.TYuangongDAO;
import com.model.TGongzi;
import com.model.TJiangcheng;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionSupport;

public class gongziAction extends ActionSupport {
	private int id;
	private int yuangongId;
	private String yuefen;
	private int jibengongzi;
	private int jiabanfei;
	private int gonglingfei;
	private int kaoqinfei;
	private int baoxianfei;
	private int jiangjin;
	private int wugongfei;

	private String message;
	private String path;

	private TGongziDAO gongziDAO;
	private TYuangongDAO yuangongDAO;
	private TJiangchengDAO jiangchengDAO;

	public String gongziAdd() {
		TGongzi gongzi = new TGongzi();
		gongzi.setYuangongId(yuangongId);
		gongzi.setYuefen(yuefen);
		gongzi.setJibengongzi(jibengongzi);
		gongzi.setJiabanfei(jiabanfei);
		gongzi.setGonglingfei(gonglingfei);
		gongzi.setJiangjin(jiangjin);
		gongzi.setBaoxianfei(baoxianfei);
		gongzi.setKaoqinfei(kaoqinfei);
		
		String	sql1 = "from TYuangong where yuangongId = " + yuangongId ;
		List yuangongList = yuangongDAO.getHibernateTemplate().find(sql1);
		TYuangong yuangong = null ;
		for (int i = 0; i < yuangongList.size(); i++) {
			yuangong = (TYuangong) yuangongList.get(i);
		}
//		String sql = "";
//		if(yuangong == null){
//			//计算奖惩扣除费用
//			sql = "from TJiangcheng where jiangchengDate ='" + yuefen + "'";
//		}else{
//			//计算奖惩扣除费用
//			sql = "from TJiangcheng where jiangchengYuangongName='" + yuangong.getYuangongName() + "' and jiangchengDate like '%" + yuefen + "%'";
//		}
//		List jiangchengList = jiangchengDAO.getHibernateTemplate().find(sql);
//		for (int i = 0; i < jiangchengList.size(); i++) {
//			TJiangcheng jiangcheng = (TJiangcheng) jiangchengList.get(i);
//			if(jiangcheng.getJiangchengXiangmu().equals("迟到")){
//				kaoqinfei += 50 ;
//			}
//			if(jiangcheng.getJiangchengXiangmu().equals("早退")){
//				kaoqinfei += 100 ;
//			}
//		}
		
		gongzi.setWugongfei(wugongfei);

		int all = jibengongzi + jiabanfei + gonglingfei + jiangjin
				+ baoxianfei + kaoqinfei ;
		int gerenshui = 0;
		if (all > 1800) {
			gerenshui = (int) (all * 0.2);
		}

		gongzi.setGerenshui(gerenshui);
		gongzi.setShifagongzi(all - gerenshui);
		gongzi.setDel("no");
		gongziDAO.save(gongzi);
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
	}

	public String gongziMana() {
		String sql = "from TGongzi where del='no'";
		List gongziList = gongziDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < gongziList.size(); i++) {
			TGongzi gongzi = (TGongzi) gongziList.get(i);
			gongzi.setYuangongName(yuangongDAO.findById(gongzi.getYuangongId())
					.getYuangongName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}

	public String gongziSearch() {
		String sql = "from TGongzi where del='no' and yuangongId=" + yuangongId;
		List gongziList = gongziDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < gongziList.size(); i++) {
			TGongzi gongzi = (TGongzi) gongziList.get(i);
			gongzi.setYuangongName(yuangongDAO.findById(gongzi.getYuangongId())
					.getYuangongName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}

	public String gongziSearch1() {
		StringBuffer sql = new StringBuffer("from TGongzi where del='no'");
		if (yuangongId != 0) {
			sql.append(" and yuangongId=" + yuangongId);
		}
		if (yuefen != null && !yuefen.equals("")) {
			sql.append(" and yuefen='" + yuefen + "'");
		}

		List gongziList = gongziDAO.getHibernateTemplate().find(sql.toString());
		for (int i = 0; i < gongziList.size(); i++) {
			TGongzi gongzi = (TGongzi) gongziList.get(i);
			gongzi.setYuangongName(yuangongDAO.findById(gongzi.getYuangongId())
					.getYuangongName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}

	public String gongziDel() {
		TGongzi gongzi = gongziDAO.findById(id);
		gongzi.setDel("yes");
		gongziDAO.getHibernateTemplate().update(gongzi);
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
	}

	public String gongziEditPre() {
		TGongzi gongzi = gongziDAO.findById(id);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("gongzi", gongzi);
		return ActionSupport.SUCCESS;
	}

	public String gongziEdit() {
		TGongzi gongzi = gongziDAO.findById(id);
		gongzi.setYuangongId(yuangongId);
		gongzi.setYuefen(yuefen);
		gongzi.setJibengongzi(jibengongzi);
		gongzi.setJiabanfei(jiabanfei);
		gongzi.setGonglingfei(gonglingfei);
		gongzi.setKaoqinfei(kaoqinfei);
		gongzi.setJiangjin(jiangjin);
		gongzi.setBaoxianfei(baoxianfei);
		gongzi.setWugongfei(wugongfei);

		int all = jibengongzi + jiabanfei + gonglingfei + kaoqinfei + jiangjin
				+ baoxianfei - wugongfei;
		int gerenshui = 0;
		if (all > 1800) {
			gerenshui = (int) (all * 0.2);
		}

		gongzi.setGerenshui(gerenshui);
		gongzi.setShifagongzi(all - gerenshui);
		gongziDAO.attachDirty(gongzi);
		this.setMessage("操作成功");
		this.setPath("gongziMana.action");
		return "succeed";
	}

	public String gongziMy() {
		String sql = "from TGongzi where del='no' and yuangongId=" + yuangongId;
		List gongziList = gongziDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < gongziList.size(); i++) {
			TGongzi gongzi = (TGongzi) gongziList.get(i);
			gongzi.setYuangongName(yuangongDAO.findById(gongzi.getYuangongId())
					.getYuangongName());
		}
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("gongziList", gongziList);
		return ActionSupport.SUCCESS;
	}

	public int getBaoxianfei() {
		return baoxianfei;
	}

	public void setBaoxianfei(int baoxianfei) {
		this.baoxianfei = baoxianfei;
	}

	public int getGonglingfei() {
		return gonglingfei;
	}

	public void setGonglingfei(int gonglingfei) {
		this.gonglingfei = gonglingfei;
	}

	public TGongziDAO getGongziDAO() {
		return gongziDAO;
	}

	public void setGongziDAO(TGongziDAO gongziDAO) {
		this.gongziDAO = gongziDAO;
	}

	public int getJiabanfei() {
		return jiabanfei;
	}

	public void setJiabanfei(int jiabanfei) {
		this.jiabanfei = jiabanfei;
	}

	public int getJiangjin() {
		return jiangjin;
	}

	public void setJiangjin(int jiangjin) {
		this.jiangjin = jiangjin;
	}

	public int getJibengongzi() {
		return jibengongzi;
	}

	public void setJibengongzi(int jibengongzi) {
		this.jibengongzi = jibengongzi;
	}

	public int getKaoqinfei() {
		return kaoqinfei;
	}

	public void setKaoqinfei(int kaoqinfei) {
		this.kaoqinfei = kaoqinfei;
	}

	public int getWugongfei() {
		return wugongfei;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setWugongfei(int wugongfei) {
		this.wugongfei = wugongfei;
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

	public int getYuangongId() {
		return yuangongId;
	}

	public void setYuangongId(int yuangongId) {
		this.yuangongId = yuangongId;
	}

	public String getYuefen() {
		return yuefen;
	}

	public void setYuefen(String yuefen) {
		this.yuefen = yuefen;
	}

	public TJiangchengDAO getJiangchengDAO() {
		return jiangchengDAO;
	}

	public void setJiangchengDAO(TJiangchengDAO jiangchengDAO) {
		this.jiangchengDAO = jiangchengDAO;
	}

}
