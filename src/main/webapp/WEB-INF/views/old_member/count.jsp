<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="box">
		<h1>회원은 <span style="color: green; font-size: 50px">${count}명 </span>입니다.</h1>
		<a href="${context}/member/main.do">
			<img src="${img}/member.png" alt="member" style="width: 50px">
		</a>
		<a href="${context}/home.do">
			<img src="${img}/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
