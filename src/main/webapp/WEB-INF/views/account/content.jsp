<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<style>
	div.memberClass{font-size: x-large;}
</style>
<section id="account_content" class="memberClass box">
	<h2>계좌관리</h2>
	<article style="width: 300px; margin: 0 auto; text-align: left;">
		<ol>
			<li><a id="acc_regist" href="#">개설</a></li>
			<li><a id="acc_deposit" href="#">입금</a></li>
			<li><a id="acc_withdraw" href="#">출금</a></li>
			<li><a id="acc_update" href="#">비번수정</a></li>
			<li><a id="acc_delete" href="#">해지</a></li>
			<li><a id="acc_list" href="#">목록</a></li>
			<li><a id="acc_search" href="#">조회</a></li>
			<li><a id="acc_count" href="#">통장수</a></li>
		</ol>
	</article>

	<a id="account_content_a_home" href="#"> 
		<img alt="home" src="${img}/home.png" style="width: 50px">
	</a>
</section>
