<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
		<!--
		body {
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
		}
		.STYLE1 {
			color: #FFFFFF;
			font-weight: bold;
			font-size: 12px;
		}
		.STYLE2 {
			font-size: 12px;
			color: #03515d;
		}
		a:link {font-size:12px; text-decoration:none; color:#03515d;}
		a:visited{font-size:12px; text-decoration:none; color:#03515d;}
		-->
	</style>
	<link rel="StyleSheet" href="<%=path %>/css/dtree.css" type="text/css" />
	<script type="text/javascript" src="<%=path %>/js/dtree.js"></script>
  </head>
  
  <body>
		<table width="156" height="100%" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td align="center" valign="top">
					<table width="100%" height="100%" border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td height="33" background="<%=path %>/images/main_21.gif">
								&nbsp;
							</td>
						</tr>
						<tr>
							<td align="center" valign="top">
								<table width="145" border="0" align="center" cellpadding="0" cellspacing="0">
									<tr>
										<td>
										    <script type="text/javascript">
												d = new dTree('d');
										        d.add(0,-1,'功能菜单');
												
												d.add(1,0,'系统属性','#');
												d.add(11,1,'系统属性','<%=path %>/admin/index/sysPro.jsp','','I2','','','true');
												
												d.add(2,0,'密码修改','#');
												d.add(21,2,'密码修改','<%=path %>/admin/userinfo/userPw.jsp','','I2');
												
												d.add(3,0,'账号管理','#');
												d.add(31,3,'管理员账号管理','<%=path %>/adminManage.action','','I2');
												
												d.add(4,0,'企业信息','#');
												d.add(41,4,'企业信息','<%=path %>/qiyexinxi.action','','I2');
												
												d.add(5,0,'部门管理','#');
												d.add(51,5,'部门管理','<%=path %>/orgMana.action','','I2');
												
												d.add(6,0,'员工资料管理','#');
												d.add(61,6,'员工资料管理','<%=path %>/yuangongMana.action','','I2');
												d.add(62,6,'新员工录入','<%=path %>/admin/yuangong/yuangongAdd.jsp','','I2');
												d.add(63,6,'员工查询','<%=path %>/admin/yuangong/yuangongSearch.jsp','','I2');
												d.add(64,6,'部门查询','<%=path %>/orgMana1.action','','I2');
												
												d.add(7,0,'请假管理','#');
												d.add(71,7,'请假管理','<%=path %>/zhaopinMana.action','','I2');
																							
												d.add(8,0,'工资管理','#');
												d.add(81,8,'工资管理','<%=path %>/gongziMana.action','','I2');
												d.add(82,8,'工资录入','<%=path %>/admin/gongzi/gongziAdd.jsp','','I2');
												d.add(83,8,'工资查询','<%=path %>/admin/gongzi/gongziSearch.jsp','','I2');
												
												d.add(9,0,'奖惩管理','#');
												d.add(91,9,'奖惩管理','<%=path %>/jiangchengMana.action','','I2');
												d.add(92,9,'奖惩录入','<%=path %>/admin/jiangcheng/jiangchengAdd.jsp','','I2');

												document.write(d);
										   </script>
											<%--
											<table width="130" border="0" align="center" cellpadding="0" cellspacing="0">
												<tr height="10">
												   <td></td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="<%=path %>/images/left_1.gif" width="31" height="31">
														</div>
													</td>
													<td width="89" height="35">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<tr>
																<td height="23" style="cursor:hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">
																	    <a href='<%=path %>/admin/index/sysPro.jsp' target='I2'>系统属性</a>
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
												<tr>
													<td width="41" height="35">
														<div align="center">
															<img src="<%=path %>/images/left_1.gif" width="31" height="31">
														</div>
													</td>
													<td width="89" height="35">
														<table width="100%" border="0" cellspacing="0" cellpadding="0">
															<tr>
																<td height="23" style="cursor:hand"
																	onMouseOver="this.style.borderStyle='solid';this.style.borderWidth='1';borderColor='#adb9c2'; "
																	onmouseout="this.style.backgroundImage='url()';this.style.borderStyle='none'">
																	<span class="STYLE2">
																	    <a href='<%=path %>/admin/index/sysPro.jsp' target='I2'>系统属性</a>
																	</span>
																</td>
															</tr>
														</table>
													</td>
												</tr>
											</table>--%>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</body>
</html>
