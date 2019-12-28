
<%@page import="org.hibernate.web.sample.UserDao"%><jsp:useBean id="obj" class="org.hibernate.web.sample.User"></jsp:useBean>
<jsp:setProperty property="*" name="obj"/>

<%
int i=UserDao.register(obj);
if(i>0)
out.print("You are successfully registered");

%>