<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="context" value="<%=request.getContextPath() %>"/>
<c:set var="img" value="${context}/resources/img"/>
<c:set var="css" value="${context}/resources/css"/>
<c:set var="js" value="${context}/resources/js"/>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>한빛아카데미</title>
</head>
<html>
  <head>
    <title>
  	  <tiles:getAsString name="title"/>
    </title>
    <style>
    	header{width:100%; height:90px;}
    	nav{width:100%; height:70px;}
    	section{width:100%; height:540px;}
    	footer{width:100%; height:50px;}
    	.border_red{border:1px solid red}
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/jquery-ui.min.js"></script>
	<link rel="stylesheet" href="${css}/global.css" />
	<link rel="stylesheet" href="${css}/douglas.css" />
  </head>
  <body>
      <header>
        <div>
          <tiles:insertAttribute name="header" />
        </div>
      </header>
        <nav>
          <tiles:insertAttribute name="menu" />
        </nav>
        <section>
        <article>
          <tiles:insertAttribute name="body" />
          </article>
        </section>
      <footer>
          <tiles:insertAttribute name="footer" />
      </footer>
  </body>
  <script src="${js}/application.js"></script>
  <script src="${js}/admin.js"></script>
  <script src="${js}/douglas.js"></script>
  <script src="${js}/resig.js"></script>
  <script src="${js}/member.js"></script>
  <script src="${js}/grade.js"></script>
  <script src="${js}/account.js"></script>
  <script>
  app.init('${context}');
  member.init();
  admin.init();
  douglas.init();
  grade.init();
  account.init();
  </script>
</html>