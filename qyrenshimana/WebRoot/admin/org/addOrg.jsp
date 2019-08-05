<%@ page language="java" pageEncoding="utf-8"%>
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
		<link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
		<base target="_self">
		
		<script type="text/javascript">
		    function closeOpen()
		    {
		       window.returnValue=false;
		       window.close();
		    }
		    
		    function check()
		    {
		        var orgName=document.addOrg.orgName.value;
		        var orgDescription=document.addOrg.orgDescription.value; 
		        if(orgName=="")
		        {
		            alert("请输入部门名称");
		            return false;
		        }
		        if(orgDescription=="")
		        {
		            alert("请输入部门要求");
		            return false;
		        }
                return true;		        
		    }
		</script>
	</head>

	<body>
		<center>
			<form action="<%=path %>/addOrg.action" name="addOrg" method="post">
			   <input type="hidden" name="depId" value='<%=request.getParameter("depId") %>'>
			   <br><br>
			     部门名称：<input type="text" name="orgName" size="30"/><br><br>
                   部门要求：<input type="text" name="orgDescription" size="30"/><br><br>
                <input type="submit" value="确定" class="ButtonCss" onclick="return check();"/>
                <input type="reset" value="重填" class="ButtonCss"/>
                <input type="button" value="取消" class="ButtonCss" onclick="closeOpen()"/>
			</form>
		</center>
	</body>
</html>
