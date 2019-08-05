<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
           function yuangongDel(yuangongId)
           {
               if(confirm('您确定删除该员工吗？'))
               {
                   window.location.href="<%=path %>/yuangongDel.action?yuangongId="+yuangongId;
               }
           }
           
           function yuangongbiangeng(yuangongId)
           {
               if(confirm('您确定变更该员工吗？'))
               {
                   window.location.href="<%=path %>/zhaopinbiangeng.action?yuangongId="+yuangongId;
               }
           }
           
           function yuangongEditPre(yuangongId)
           {
                   window.location.href="<%=path %>/yuangongEditPre.action?yuangongId="+yuangongId;
           }
           function yuangongAdd()
           {
                 var url="<%=path %>/admin/yuangong/yuangongAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           
           function excel()
           {
                 window.location.href="<%=path %>/yuangongExcel.action";
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="12" background="<%=path %>/images/tbg.gif">&nbsp;员工维护&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="7%">ID</td>
					<td width="7%">姓名</td>
					<td width="7%">员工编号</td>
					<td width="7%">员工密码</td>
					<td width="7%">性别</td>
					<td width="7%">年龄</td>
					<td width="7%">学历</td>
					<td width="7%">职位</td>
					<td width="7%">住址</td>
					<td width="5%">QQ</td>
					<td width="5%">部门</td>
					<td width="11%">操作</td>
		        </tr>	
				<s:iterator value="#request.yuangongList" id="yuangong">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongId"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongLoginName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					   <s:property value="#yuangong.yuangongLoginPw"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuangong.yuangongSex"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongAge"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongXueli"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#yuangong.yuangongZhiwei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongAddress"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongQq"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#yuangong.yuangongOrgName"/><!-- 部门 -->
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="yuangongDel(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">删除</a>
						|
						<a href="#" onclick="yuangongEditPre(<s:property value="#yuangong.yuangongId"/>)" class="pn-loperator">编辑</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加员工" style="width: 80px;" onclick="yuangongAdd()" />
			      <input type="button" value="导出Excel" style="width: 80px;" onclick="excel()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
