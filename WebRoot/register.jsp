<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'reg.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
    <style type="text/css">
	    ul{
	      list-style-type: none;
	    }
   
    </style>
  </head>
  
  <body>
    <h1>注册页面</h1>
    <h2><s:actionerror/></h2>
    <h2><s:actionmessage/></h2>
      <s:form action="register" theme="simple" id="myform" >
       <p>
	     用户名:<s:textfield name="name"/><s:fielderror fieldName="name2"/>
	   </p>
	   <p>
	     密码:<s:password name="password"/><s:fielderror fieldName="password2"/>
	   </p>
       <p>
	     <s:submit value="注册"/>
	   </p>
      </s:form>
  </body>
</html>
