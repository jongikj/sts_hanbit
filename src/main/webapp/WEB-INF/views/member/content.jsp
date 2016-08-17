<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>
<style>
	div.memberClass{font-size: x-large;}
</style>
<div id="" class="memberClass box">
	<h2>회원관리</h2>
	<div style="width: 300px; margin: 0 auto; text-align: left;">
		<ol>
			<li><a href="${context}/member.do?page=regist">회원가입</a></li>
			<li><a href="${context}/member.do?action=move&page=detail">내정보보기</a></li>
			<li><a href="${context}/member.do?page=update">내정보수정</a></li>
			<li><a href="${context}/member.do?page=delete">탈퇴</a></li>
			<li><a href="${context}/member.do?page=login">로그인</a></li>
			<li><a href="${context}/member.do?page=logout">로그아웃</a></li>
			<li><a href="${context}/member.do?action=list&page=list">리스트</a></li>
			<li><a href="${context}/member.do?action=move&page=find_by">검색</a></li>
			<li><a href="${context}/member.do?action=count&page=count">회원수</a></li>
		</ol>
	</div>

	<a href="${context}/home.do"> 
		<img alt="home" src="${img}/home.png" style="width: 50px">
	</a>
</div>
