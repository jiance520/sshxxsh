<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
    <h1>文件上传</h1>
    <s:form action="/uploadfile" enctype="multipart/form-data" theme="simple" >
      <s:token/>
      <p>标题:<s:textfield name="title"/></p>
      <p><s:file name="upfile"/></p>
      <p><s:file name="upfile"/></p>
      <p><s:submit value="提交"/></p>
    </s:form>
    <h2><a href="<%=basePath%>download?fileName=ojdbc14.jar">oracle驱动</a></h2>
    <h2><a href="<%=basePath%>download?fileName=lizi.png">图片</a></h2>
  </body>
</html>