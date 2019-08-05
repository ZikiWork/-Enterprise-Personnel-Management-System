package com.action;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.dao.TYuangongDAO;
import com.model.TYuangong;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrganizationService;

public class yuangongAction extends ActionSupport {
	private int yuangongId;
	private String yuangongName;
	private String yuangongSex;
	private int yuangongAge;
	private String yuangongXueli;
	private String yuangongZhiwei;
	private String yuangongAddress;
	private String yuangongTel;
	private String yuangongEmail;
	private String yuangongQq;
	private String yuangongLoginName;
	private String yuangongLoginPw;
	private int yuangongOrgId;

	// 用于查询类型
	private String searchType;

	private TYuangongDAO yuangongDAO;
	private OrganizationService organizationService;
	private String message;
	private String path;

	private String filename;
	private InputStream inputStream;

	private String yuangongAgeSta;
	private String yuangongAgeEnd;

	public String yuangongAdd() {
		TYuangong yuangong = new TYuangong();
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongQq(yuangongQq);
		yuangong.setYuangongLoginName(yuangongLoginName);
		yuangong.setYuangongLoginPw(yuangongLoginPw);
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setType("yuangong");
		yuangong.setDel("no");
		yuangongDAO.save(yuangong);// zhaopin：招聘
		this.setMessage("操作成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}

	public String yuangongDel() {
		TYuangong yuangong = yuangongDAO.findById(yuangongId);
		yuangong.setDel("yes");
		yuangongDAO.attachDirty(yuangong);
		this.setMessage("操作成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}

	public String yuangongMana() {
		String sql = "from TYuangong where type='yuangong' and del='no'";
		List yuangongList = yuangongDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < yuangongList.size(); i++) {
			TYuangong yuangong = (TYuangong) yuangongList.get(i);
			yuangong.setYuangongOrgName(organizationService.findById(
					yuangong.getYuangongOrgId()).getOrgName());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}

	public String yuangongEditPre() {
		TYuangong yuangong = yuangongDAO.findById(yuangongId);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("yuangong", yuangong);
		return ActionSupport.SUCCESS;
	}

	public String yuangongEdit() {
		TYuangong yuangong = yuangongDAO.findById(yuangongId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongQq(yuangongQq);
		yuangong.setYuangongLoginName(yuangongLoginName);
		yuangong.setYuangongLoginPw(yuangongLoginPw);
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setType("yuangong");

		yuangongDAO.attachDirty(yuangong);
		this.setMessage("操作成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}
	
	
	public String yuangongEdit1() {
		TYuangong yuangong = yuangongDAO.findById(yuangongId);
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel(yuangongTel);
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongQq(yuangongQq);
		yuangong.setYuangongLoginName(yuangongLoginName);
		yuangong.setYuangongLoginPw(yuangongLoginPw);
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setType("yuangong");

		yuangongDAO.attachDirty(yuangong);
		this.setMessage("操作成功");
		return "succeed";
	}

	public String yuangongSearch() {
		// <select id="searchType" name="searchType">
		// <option value ="0">姓名</option>
		// <option value ="1">学历</option>
		// <option value="2">简历</option>
		// <option value="3">年龄</option>
		// </select>

		String sql = "";
		if (searchType != null && !"".equals(searchType)) {
			if (searchType.equals("0")) {
				sql = "from TYuangong where type='yuangong' and del='no' and yuangongName like '%"
						+ yuangongName + "%'";
			}
			if (searchType.equals("1")) {
				sql = "from TYuangong where type='yuangong' and del='no' and yuangongXueli like '%"
						+ yuangongName + "%'";
			}
			if (searchType.equals("2")) {
				sql = "from TYuangong where type='yuangong' and del='no' and yuangongZhiwei like '%"
						+ yuangongName + "%'";
			}
			if (searchType.equals("3")) {
				sql = "from TYuangong where type='yuangong' and del='no' and yuangongAge = "
						+ Integer.parseInt(yuangongName);
			}
		} else {
			sql = "from TYuangong where type='yuangong' and del='no' and yuangongName like '%"
					+ yuangongName + "%'";
		}
		
		//根据部门查询 
		if(yuangongOrgId > 0){
			
			sql = "from TYuangong where type='yuangong' and del='no' and yuangongOrgId = " + yuangongOrgId ;
			
		}
		
		List yuangongList = yuangongDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < yuangongList.size(); i++) {
			TYuangong yuangong = (TYuangong) yuangongList.get(i);
			yuangong.setYuangongOrgName(organizationService.findById(
					yuangong.getYuangongOrgId()).getOrgName());
		}
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("yuangongList", yuangongList);
		return ActionSupport.SUCCESS;
	}

	public String yuangongExcel() {
		try {
			this.filename = new String("人事信息.xls".getBytes(), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return ActionSupport.SUCCESS;
	}

	public String zhaopinAdd() {
		TYuangong yuangong = new TYuangong();
		yuangong.setYuangongName(yuangongName);
		yuangong.setYuangongSex(yuangongSex);
		yuangong.setYuangongAge(yuangongAge);
		yuangong.setYuangongXueli(yuangongXueli);
		yuangong.setYuangongZhiwei(yuangongZhiwei);
		yuangong.setYuangongAddress(yuangongAddress);
		yuangong.setYuangongTel("请假申请中");
		yuangong.setYuangongEmail(yuangongEmail);
		yuangong.setYuangongQq(yuangongQq);
		yuangong.setYuangongOrgId(yuangongId);

		yuangong.setType("zhaopin");
		yuangong.setDel("no");
		yuangongDAO.save(yuangong);
		this.setMessage("操作成功");
		this.setPath("zhaopinMana1.action?yuangongId=" + yuangongId);
		return "succeed";
	}

	public String zhaopinMana1() {
		String sql = "from TYuangong where type='zhaopin' and del='no' and yuangongOrgId=" + yuangongId;
		List zhaopinList = yuangongDAO.getHibernateTemplate().find(sql);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
	
	public String zhaopinMana() {
		String sql = "from TYuangong where type='zhaopin' and del='no'";
		List zhaopinList = yuangongDAO.getHibernateTemplate().find(sql);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("zhaopinList", zhaopinList);
		return ActionSupport.SUCCESS;
	}
	

	public String zhaopinDel() {
		TYuangong zhaopin = yuangongDAO.findById(yuangongId);
		zhaopin.setDel("yes");
		yuangongDAO.attachDirty(zhaopin);
		this.setMessage("操作成功");
		this.setPath("zhaopinMana.action");
		return "succeed";
	}
	
	public String zhaopinPizhun() {
		TYuangong zhaopin = yuangongDAO.findById(yuangongId);
		
		zhaopin.setYuangongTel("请假已批准");
		yuangongDAO.attachDirty(zhaopin);
		this.setMessage("操作成功");
		this.setPath("zhaopinMana.action");
		return "succeed";
	}
	
	
	
	public String zhaopinbiangeng() {
		TYuangong zhaopin = yuangongDAO.findById(yuangongId);
		zhaopin.setType("zhaopin");
		yuangongDAO.attachDirty(zhaopin);
		this.setMessage("操作成功");
		this.setPath("zhaopinMana.action");
		return "succeed";
	}
	
	

	public String zhaopinLuyong() {
		TYuangong zhaopin = yuangongDAO.findById(yuangongId);
		zhaopin.setYuangongLoginName(yuangongLoginName);
		zhaopin.setYuangongLoginPw(yuangongLoginPw);
		zhaopin.setType("yuangong");
		zhaopin.setYuangongOrgId(yuangongOrgId);
		yuangongDAO.attachDirty(zhaopin);
		return ActionSupport.SUCCESS;
	}

	public String yuangongBiandong() {
		TYuangong yuangong = yuangongDAO.findById(yuangongId);
		yuangong.setYuangongOrgId(yuangongOrgId);
		yuangong.setYuangongOrgName(organizationService.findById(yuangongOrgId)
				.getOrgName());
		yuangongDAO.attachDirty(yuangong);
		this.setMessage("操作成功");
		this.setPath("yuangongMana.action");
		return "succeed";
	}

	public InputStream getInputStream() {
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		HSSFRow row = sheet.createRow(0);
		HSSFCell cell = row.createCell((short) 0);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("姓名");

		cell = row.createCell((short) 1);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("性别");

		cell = row.createCell((short) 2);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("年龄");

		cell = row.createCell((short) 3);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("学历");

		cell = row.createCell((short) 4);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("工作简历");

		cell = row.createCell((short) 5);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("档案信息");

		cell = row.createCell((short) 6);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("联系方式");

		cell = row.createCell((short) 7);
		cell.setEncoding(HSSFCell.ENCODING_UTF_16);
		cell.setCellValue("email");

		String sql = "from TYuangong where type='yuangong' and del='no'";
		List yuangongList = yuangongDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < yuangongList.size(); i++) {
			TYuangong yuangong = (TYuangong) yuangongList.get(i);

			row = sheet.createRow(i + 1);
			cell = row.createCell((short) 0);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongName());

			cell = row.createCell((short) 1);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongSex());

			cell = row.createCell((short) 2);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongAge());

			cell = row.createCell((short) 3);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongXueli());

			cell = row.createCell((short) 4);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongZhiwei());

			cell = row.createCell((short) 5);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongAddress());

			cell = row.createCell((short) 6);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongTel());

			cell = row.createCell((short) 7);
			cell.setEncoding(HSSFCell.ENCODING_UTF_16);
			cell.setCellValue(yuangong.getYuangongEmail());
		}

		ByteArrayOutputStream os = new ByteArrayOutputStream();
		try {
			wb.write(os);
		} catch (IOException e) {
			e.printStackTrace();
		}
		byte[] content = os.toByteArray();
		InputStream is = new ByteArrayInputStream(content);
		return is;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
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

	public OrganizationService getOrganizationService() {
		return organizationService;
	}

	public void setOrganizationService(OrganizationService organizationService) {
		this.organizationService = organizationService;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getYuangongLoginName() {
		return yuangongLoginName;
	}

	public void setYuangongLoginName(String yuangongLoginName) {
		this.yuangongLoginName = yuangongLoginName;
	}

	public String getYuangongLoginPw() {
		return yuangongLoginPw;
	}

	public void setYuangongLoginPw(String yuangongLoginPw) {
		this.yuangongLoginPw = yuangongLoginPw;
	}

	public String getYuangongAgeEnd() {
		return yuangongAgeEnd;
	}

	public void setYuangongAgeEnd(String yuangongAgeEnd) {
		this.yuangongAgeEnd = yuangongAgeEnd;
	}

	public String getYuangongAgeSta() {
		return yuangongAgeSta;
	}

	public void setYuangongAgeSta(String yuangongAgeSta) {
		this.yuangongAgeSta = yuangongAgeSta;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getYuangongAddress() {
		return yuangongAddress;
	}

	public void setYuangongAddress(String yuangongAddress) {
		this.yuangongAddress = yuangongAddress;
	}

	public int getYuangongAge() {
		return yuangongAge;
	}

	public void setYuangongAge(int yuangongAge) {
		this.yuangongAge = yuangongAge;
	}

	public TYuangongDAO getYuangongDAO() {
		return yuangongDAO;
	}

	public void setYuangongDAO(TYuangongDAO yuangongDAO) {
		this.yuangongDAO = yuangongDAO;
	}

	public String getYuangongEmail() {
		return yuangongEmail;
	}

	public void setYuangongEmail(String yuangongEmail) {
		this.yuangongEmail = yuangongEmail;
	}

	public int getYuangongId() {
		return yuangongId;
	}

	public void setYuangongId(int yuangongId) {
		this.yuangongId = yuangongId;
	}

	public String getYuangongName() {
		return yuangongName;
	}

	public void setYuangongName(String yuangongName) {
		this.yuangongName = yuangongName;
	}

	public int getYuangongOrgId() {
		return yuangongOrgId;
	}

	public void setYuangongOrgId(int yuangongOrgId) {
		this.yuangongOrgId = yuangongOrgId;
	}

	public String getYuangongQq() {
		return yuangongQq;
	}

	public void setYuangongQq(String yuangongQq) {
		this.yuangongQq = yuangongQq;
	}

	public String getYuangongSex() {
		return yuangongSex;
	}

	public void setYuangongSex(String yuangongSex) {
		this.yuangongSex = yuangongSex;
	}

	public String getYuangongTel() {
		return yuangongTel;
	}

	public void setYuangongTel(String yuangongTel) {
		this.yuangongTel = yuangongTel;
	}

	public String getYuangongXueli() {
		return yuangongXueli;
	}

	public void setYuangongXueli(String yuangongXueli) {
		this.yuangongXueli = yuangongXueli;
	}

	public String getYuangongZhiwei() {
		return yuangongZhiwei;
	}

	public void setYuangongZhiwei(String yuangongZhiwei) {
		this.yuangongZhiwei = yuangongZhiwei;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

}
