<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="nav">
	<ul>
		<li class="active"><a href="#" id="a_member">회원관리</a></li>
		<li><a href="#" id="a_grade">성적관리</a></li>
		<li><a href="#" id="a_account">계좌관리</a></li>
		<li><a href="#" id="a_school">학교소개</a></li>
		<div style="text-align:right ;color:white ;background-color: #333;">${user.name}님 환영합니다.</div>
	</ul>
</div>
<script type="text/javascript">
$(function() {
	$('#a_member').click(function(){
		location.href = "${context}/member.do";
	}); // document.querySelector(#a_member).addEventListener('click', function(){}, false)와 동일
	
	$('#a_grade').click(function(){
		location.href = "${context}/grade.do";
	});
	
	$('#a_account').click(function(){
		location.href = "${context}/account.do";
	});
	
	$('#a_school').click(function(){
		location.href = "${context}/global.do?page=school_info";
	});
}); //window.onload와 동일하다.
</script>