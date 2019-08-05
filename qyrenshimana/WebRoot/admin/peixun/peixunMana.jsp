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
           function peixunDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/peixunDel.action?id="+id;
               }
           }
           
           function peixunAdd()
           {
                 var url="<%=path %>/admin/peixun/peixunAdd.jsp";
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
					<td height="14" colspan="8" background="<%=path %>/images/tbg.gif">&nbsp;培训管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="12%">培训人</td>
					<td width="12%">培训主题</td>
					<td width="12%">培训宗旨</td>
					<td width="16%">培训内容</td>
					<td width="12%">培训时间</td>
					<td width="12%">课程表</td>
					<td width="12%">参加人员</td>
					<td width="12%">操作</td>
		        </tr>	
				<s:iterator value="#request.peixunList" id="peixun">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixun.peixunren"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixun.peixunzhuti"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.peixunzongzhi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixun.peixunneirong"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#peixun.peixunshijian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.peixundidian"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#peixun.canjiarenyuan"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<a href="#" onclick="peixunDel(<s:property value="#peixun.id"/>)" class="pn-loperator">删除</a>
					</td>
				</tr>
				</s:iterator>
			</table>
			
			<table width='98%'  border='0'style="margin-top:8px;margin-left: 5px;">
			  <tr>
			    <td>
			      <input type="button" value="添加" style="width: 80px;" onclick="peixunAdd()" />
			    </td>
			  </tr>
		    </table>
	</body>
</html>
