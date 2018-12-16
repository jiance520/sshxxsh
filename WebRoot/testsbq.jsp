<%@ page language="java" import="java.util.*,com.entity.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

request.setAttribute("pnum2", 12);
session.setAttribute("snum2", 24);

request.setAttribute("jben", "<script>alert(0)<script/>");
request.setAttribute("js", 12);

  Users u2 = new Users();
                  u2.setUname("小明");
                  u2.setUsid(1);
                  
  request.setAttribute("user", u2);
  request.setAttribute("xinmin", "李华");


  Dept d1 = new Dept();
  d1.setDeptno(Integer.valueOf("10"));
  d1.setDname("soft1");
  Dept d2 = new Dept();
  d2.setDeptno(Integer.valueOf("20"));
  d2.setDname("soft2");
  Dept d3 = new Dept();
  d3.setDeptno(Integer.valueOf("30"));
  d3.setDname("soft3");
  Dept d4 = new Dept();
  d4.setDeptno(Integer.valueOf("40"));
  d4.setDname("soft4");
  
       List<Dept> dlist = new ArrayList<Dept>();
       dlist.add(d1);
       dlist.add(d2);
       dlist.add(d3);
       dlist.add(d4);
       
  request.setAttribute("dlist", dlist);

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'success.jsp' starting page</title>
    
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
   <h2>pnum:<s:property value="pnum"/></h2>
   <h2>pnum1:<s:property value="#pnum1"/></h2>
   <h2>pnum2:<s:property value="#attr.pnum2"/></h2>
   <h2>rnum2:<s:property value="#request.pnum2"/></h2>
   <h2>snum2:<s:property value="#session.snum2"/></h2>
   <h2>脚本:<s:property value="#request.jben" default="ss"/></h2>
   <h2>计算:<s:property value="#request.js == 5" /></h2>
   <h2>uname:<s:property value="#request.user.uname" /></h2>
   <h2>发言:<s:property value="#request.user.say(#attr.xinmin)" /></h2>
   <h2>pk:<s:property value="@com.entity.Users@pk(#request.xinmin)" /></h2>
   <h2>in1:<s:property value="#request.js in {1,12,3}" /></h2>
   <h2>in2:<s:property value="#request.xinmin in {'abc','李华','sfg'}" /></h2>
   <hr/>
   <s:set id="snum" scope="session" value="24"/>
   <s:set id="num"  value="12"/>
   <s:bean id="dept2" name="com.entity.Dept">
       <s:param name="deptno" value="50"/>
       <s:param name="dname" value="\"soft2\""></s:param>
       <s:param name="loc">china</s:param>
   </s:bean>
   <s:set id="d2"  value="#dept2" scope="request"/>
   <s:bean id="newdate" name="java.util.Date"></s:bean>
   <s:bean id="emp2" name="com.entity.Emp">
       <s:param name="hiredate" value="#newdate"/>
   </s:bean>
   
   <h2>snum:<s:property value="#session.snum"/></h2>
   <h2>num:<s:property value="#num"/></h2>
   <h2>loc:<s:property value="#attr.d2.dname"/></h2>
   <h2>今天:<s:date name="#newdate" format="yyyy-MM-dd HH:mm:ss"/></h2>
   <h2>hiredate:<s:property value="#emp2.hiredate"/></h2>
   <s:url action="test!sbq" id="as">
             <s:param name="pid">24</s:param>
             <s:param name="sid">25</s:param>
   </s:url>
   <h2>a:<s:a href="%{as}" >test-sbq</s:a></h2>
   <h2>sid:<s:property value="#parameters.sid"/></h2>
   <hr/>
     <table align="center" border="1" width="80%">
       <s:iterator value="#attr.dlist" id="inum" status="its">
       <s:if test="#its.odd">
        <tr style="background-color: red">
          <td><s:property value="#inum.deptno"/> -- <s:property value="#its.index"/> -- <s:property value="#its.count"/> </td><td><s:property value="#inum.dname"/> </td>
        </tr>
        </s:if>
        <s:elseif test="#its.even">
        <tr style="background-color: blue">
          <td><s:property value="#inum.deptno"/> -- <s:property value="#its.index"/> -- <s:property value="#its.count"/> </td><td><s:property value="#inum.dname"/> </td>
        </tr>
        </s:elseif>
       </s:iterator>
     </table>
   <hr/>
   <s:form action="/index" theme="simple">
     <s:hidden name="sid2" value="24"></s:hidden>
   <p>用户名:<s:textfield readonly="true" name="users" value="tom" ></s:textfield></p>
   <p>密码:<s:password name="pwd" cssClass="ts" cssStyle=""></s:password></p>
   <p>简介:
      <s:textarea name="js" cols="50" rows="5" disabled="true"></s:textarea>
   </p>
   <p><s:file name="ff"></s:file></p>
   <p><s:select name="ast" list="#{'1':'a1','2':'a2'}" listKey="key" listValue="value" value="2"></s:select></p>
   <p><s:radio name="art" list="#{'1':'a1','2':'a2'}" listKey="key" listValue="value" value="2"/></p>
    <p><s:checkbox name="sex" fieldValue="1" value="1"></s:checkbox>男<br/>
       <s:checkbox name="sex" fieldValue="%{#num}"></s:checkbox>女
    </p>
   <p><s:checkboxlist name="art" list="#{'1':'a1','2':'a2'}" listKey="key" listValue="value" value="2"/></p>
   <p><s:checkboxlist name="deptinfo" list="#attr.dlist" listKey="deptno" listValue="dname" value="20"/></p>
   <p>
      <s:submit value="提交"/>
      <s:reset value="重置"/>
   </p>
   </s:form>
   
  </body>
</html>
