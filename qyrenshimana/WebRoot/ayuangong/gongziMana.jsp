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
           function gongziDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path %>/gongziDel.action?id="+id;
               }
           }
           
           function gongziAdd()
           {
                 var url="<%=path %>/admin/gongzi/gongziAdd.jsp";
                 //var n="";
                 //var w="480px";
                 //var h="500px";
                 //var s="resizable:no;help:no;status:no;scroll:yes";
				 //openWin(url,n,w,h,s);
				 window.location.href=url;
           }
           function p()
           {
              window.print();
           }
       </script>
	</head>

	<body leftmargin="2" topmargin="2" background='<%=path %>/images/allbg.gif'>
			<table width="98%" border="0" cellpadding="2" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
				<tr bgcolor="#E7E7E7">
					<td height="14" colspan="11" background="<%=path %>/images/tbg.gif">&nbsp;工资管理&nbsp;</td>
				</tr>
				<tr align="center" bgcolor="#FAFAF1" height="22">
					<td width="8%">员工</td>
					<td width="8%">工资月份</td>
					<td width="8%">基本工资</td>
					<td width="8%">学历津贴</td>
					<td width="8%">级别工资</td>
					<td width="14%">加班工资</td>
					<td width="8%">保险费</td>
					<td width="8%">奖金</td>
					<td width="10%">个人所得税</td>
					<td width="10%">实发总工资</td>
					<td width="10%">操作</td>
		        </tr>	
				<s:iterator value="#request.gongziList" id="gongzi">
				<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.yuangongName"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.yuefen"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#gongzi.jibengongzi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.jiabanfei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.gonglingfei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					    <s:property value="#gongzi.kaoqinfei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.baoxianfei"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.jiangjin"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.gerenshui"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="#gongzi.shifagongzi"/>
					</td>
					<td bgcolor="#FFFFFF" align="center">
					</td>
				</tr>
				</s:iterator>
			</table>
	</body>
</html>
