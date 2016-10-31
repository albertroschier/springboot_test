<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
	response.setHeader("Cache-Control", "no-cache");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Expires", "0");
%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="ctx" value="${pageContext['request'].contextPath}" />

<html>

<head>
	<link href="style.css" rel="stylesheet" type="text/css" />
	<title>Testi</title>
</head>

<form action="/update" method="post">
		<input type="hidden" value="${henkilo.henkiloid}" id="henkiloid" type="text" name="henkiloid">
	<br>
		<p>Etunimi:</p>
		<input value="${henkilo.etunimi}" id="etunimi" type="text" name="etunimi" placeholder="Kirjoita etunimesi">
	<br>
	<br>
		<p>Sukunimi:</p>
		<input value="${henkilo.sukunimi}" id="sukunimi" type="text" name="sukunimi" placeholder="Kirjoita sukunimesi"> 
	<br> 
	<br>
	<br> 
		<input type="submit" value="Päivitä">
	<br>
</form>

</html>