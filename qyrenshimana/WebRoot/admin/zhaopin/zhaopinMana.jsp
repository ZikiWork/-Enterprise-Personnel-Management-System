<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />

		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<script type="text/javascript" src="<%=path %>/js/popup.js"></script>
        <script language="javascript">
           function zhaopinDel(yuangongId)
           {
               if(confirm('您确定审批吗？'))
               {
                   window.location.href="<%=path %>/zhaopinDel.action?yuangongId="+yuangongId;
               }
           }
           
            function zhaopinPizhun(yuangongId)
           {
               if(confirm('您确定批准请假吗？'))
               {
                   window.location.href="<%=path %>/zhaopinPizhun.action?yuangongId="+yuangongId;
               }
           }          
           
           
           function zhaopinAdd()
           {
                 var url="<%=path %>/admin/zhaopin/zhaopinAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function zhaopinLuyong(yuangongId)
		   {
		        var pop=new Popup({ contentType:1,isReloadOnClose:false,width:400,height:300});
	            pop.setContent("contentUrl","<%=path %>/admin/zhaopin/zhaopinLuyong.jsp?yuangongId="+yuangongId);
	            pop.setContent("title","招聘录用");
	            pop.build();
	            pop.show();
		   }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="4" background="<%=path %>/images/tbg.gif">&nbsp;请假管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">请假人名称</td>
					<td width="10%">请假类型</td>
					<td width="10%">请假状态</td>
					<td width="60%">请假内容</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.zhaopinList" id="yuangong">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongXueli"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<font color="red"><s:property value="#yuangong.yuangongTel"/></font>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuangong.yuangongZhiwei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="zhaopinDel(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">删除</a>
						<c:if test="${sessionScope.userType == 0}">
							<a href="#" onclick="zhaopinPizhun(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">批准</a>
						</c:if>
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
