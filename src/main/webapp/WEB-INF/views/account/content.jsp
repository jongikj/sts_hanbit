<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	div.memberClass{font-size: x-large;}
</style>
<div id="" class="memberClass box">
	<h2>계좌관리</h2>
	<div style="width: 300px; margin: 0 auto; text-align: left;">
		<ol>
			<li><a id="b_regist" href="#">개설</a></li>
			<li><a id="b_deposit" href="#">입금</a></li>
			<li><a id="b_withdraw" href="#">출금</a></li>
			<li><a id="b_update" href="#">비번수정</a></li>
			<li><a id="b_delete" href="#">해지</a></li>
			<li><a id="b_list" href="#">목록</a></li>
			<li><a id="b_search" href="#">조회</a></li>
			<li><a id="b_count" href="#">통장수</a></li>
		</ol>
	</div>

	<a href="${context}/index.jsp"> <img alt="home" src="${img}/home.png"
		style="width: 50px">
	</a>
</div>
