<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("reset", "重置");
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

  </head>
  
  <body>
    <h1>注册页面</h1>
      <s:form action="register" theme="simple" id="myform" >
       <p>
	     <s:text name="name"/>:<s:textfield name="name"/>
	   </p>
	   <p>
	     <s:text name="password"/>:<s:password name="password"/>
	   </p>
       <p>
	    <input type="submit" value="<s:text name='submit'/>" />
	    <br/>
	    <%-- <s:property value="#attr.reset"/>    --%> 
	    <s:reset value="%{#attr.reset}"></s:reset>
	   </p>
      </s:form>
  </body>
</html>
