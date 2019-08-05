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
		
        <script language="javascript">
           function jiangchengDel(jiangchengId)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/jiangchengDel.action?jiangchengId="+jiangchengId;
               }
           }
           
           function jiangchengAdd()
           {
                 var url="<%=path %>/admin/jiangcheng/jiangchengAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="6" background="<%=path %>/images/tbg.gif">&nbsp;奖惩管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="10%">员工</td>
					<td width="10%">奖惩时间</td>
					<td width="10%">奖惩项目</td>
					<td width="10%">奖惩金额</td>
					<td width="50%">奖惩备注</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.jiangchengList" id="jiangcheng">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiangcheng.jiangchengYuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#jiangcheng.jiangchengDate"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#jiangcheng.jiangchengXiangmu"/>
					</td>
										<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#jiangcheng.jiangchengJine"/>
					</td>
										<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#jiangcheng.jiangchengBeizhu"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<c:if test="${sessionScope.userType==0}">
						<a href="#" onclick="jiangchengDel(<s:property value="#jiangcheng.jiangchengId"/>)" class="pn-loperator">删除</a>
						</c:if>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="jiangchengAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
