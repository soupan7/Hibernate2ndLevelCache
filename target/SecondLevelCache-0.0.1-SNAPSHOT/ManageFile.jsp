<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.io.IOException" %>

<%@page import="javax.servlet.ServletException" %>
<%@page import="javax.servlet.annotation.WebServlet" %>
<%@page import="javax.servlet.http.HttpServlet" %>
<%@page import="javax.servlet.http.HttpServletRequest" %>
<%@page import="javax.servlet.http.HttpServletResponse" %>

<%@page import="org.hibernate.Session" %>
<%@page import="org.hibernate.SessionFactory" %>
<%@page import="org.hibernate.Transaction" %>
<%@page import="org.hibernate.boot.Metadata" %>
<%@page import="org.hibernate.boot.MetadataSources" %>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistry" %>
<%@page import="org.hibernate.boot.registry.StandardServiceRegistryBuilder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="u1" class="Second.com.Book"></jsp:useBean>
<jsp:setProperty property="*" name="u1"/>
<% StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();  
Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();  

SessionFactory factory=meta.getSessionFactoryBuilder().build();  
Session session1=factory.openSession();  
  
 Transaction t=session1.beginTransaction();  
 session1.save(u1); 
 
 t.commit();    
 session1.close();    
 System.out.println("success");
 %>

</body>
</html>