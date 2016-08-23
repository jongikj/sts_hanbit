<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	div.memberClass{font-size: x-large;}
</style>
<div id="" class="memberClass box">
	<h2>회원관리</h2>
	<div style="width: 300px; margin: 0 auto; text-align: left;">
		<ol>
			<li><a id="regist" href="#">회원가입</a></li>
			<li><a id="detail" href="#">내정보보기</a></li>
			<li><a id="update" href="#">내정보수정</a></li>
			<li><a id="delete" href="#">탈퇴</a></li>
			<li><a id="login" href="#">로그인</a></li>
			<li><a id="logout" href="#">로그아웃</a></li>
			<li><a id="list" href="#">리스트</a></li>
			<li><a id="find_by" href="#">검색</a></li>
			<li><a id="count" href="#">회원수</a></li>
		</ol>
	</div>

	<a href="${context}/home.do"> 
		<img alt="home" src="${img}/home.png" style="width: 30px">
	</a>
</div>
