<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	div.memberClass{font-size: x-large;}
</style>
<div id="" class="memberClass box">
	<h2 id="title">성적관리</h2>
		<div style="width: 300px; margin: 0 auto; text-align: left;">
			<ol>
			<li><a href="#" id="a_regist">등록</a></li>
			<li><a href="#" id="a_update">수정</a></li>
			<li><a href="#" id="a_delete">삭제</a></li>
			<li><a href="#" id="a_list">목록</a></li>
			<li><a href="#" id="a_count">카운트</a></li>
			<li><a href="#" id="a_search">검색</a></li>
			</ol>
		</div>
	<a href="${context}/index.jsp">
		<img id="img_home" alt="home" src="${img}/home.png">
	</a>
</div>
