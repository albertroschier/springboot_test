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

<h1>
	<span>Testi</span>
</h1>

<table>
	<c:forEach items="${henkilo}" var="henkilo">
		<tr>
	        <td>Etunimi: <c:out value="${henkilo.etunimi}"/>‌‌ ‌‌ ‌‌ ‌‌ </td>
	        <td>Sukunimi: <c:out value="${henkilo.sukunimi}"/>‌‌ ‌‌ ‌‌ ‌‌ </td>
			<td>
				<c:url var="thisURL" value="/update">
				<c:param name="henkiloid" value="${henkilo.henkiloid}"/>
				</c:url><a href="<c:out value="${thisURL}"/>">Muokkaa</a>
				 ‌‌ ‌‌
				<c:url var="deleteURL" value="/delete">
				<c:param name="henkiloid" value="${henkilo.henkiloid}"/>
				</c:url><a href="<c:out value="${deleteURL}"/>">Poista</a> ‌
			</td>
	    </tr>
	</c:forEach>
	<c:forEach items="${juttu}" var="juttu">
		<tr>
	        <td>Jutun nimi: <c:out value="${juttu.nimi}"/></td>
	    </tr>
	</c:forEach>
</table>

<form action="/hello" method="post">
	<br>
		<p>Etunimi:</p>
		<input id="etunimi" type="text" name="etunimi" placeholder="Kirjoita etunimesi">
	<br>
	<br>
		<p>Sukunimi:</p>
		<input id="sukunimi" type="text" name="sukunimi" placeholder="Kirjoita sukunimesi"> 
	<br> 
	<br>
	<br> 
		<input type="submit" value="Lähetä">
	<br>
</form>

</html>