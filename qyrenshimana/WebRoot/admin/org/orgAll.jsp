<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<link href="<%=path %>/css/dtree.css" rel="stylesheet" type="text/css">
		<script language="JavaScript" src="<%=path %>/js/dtree.js" type="text/javascript"></script>
		<title></title>
		<script type="text/javascript">
		</script>
	</head>

	<BODY>
		<div class="dtree">
			<script type="text/javascript">
				d = new dTree('d');
		        d.add(0,-1,'公司部门组织机构图');//必须有这句
				//d.add(1,0,'Node 1','example01.html');
				//d.add(2,0,'Node 2','example01.html');
				//d.add(7,0,'Node 4','#');
				<s:iterator value="#request.orgList" id="org" status="sta">
		            d.add(<s:property value="#org.orgId"/>,<s:if test="#org.parenOrganization==null">0</s:if><s:else><s:property value="#org.parenOrganization.orgId"/></s:else>,'<s:property value="#org.orgName"/>','javaScript:onClickTreeNode(<s:property value="#org.orgId"/>);',null,null,null,null,'yes');
		        </s:iterator>
				document.write(d);
			</script>
		</div>
	</body>
</html>
