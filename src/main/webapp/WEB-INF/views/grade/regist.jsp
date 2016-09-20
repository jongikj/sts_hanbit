<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<section id="grade_regist">
<div class="box">
	<form id="grade_regist_form">
		<ul class="list-group">
 			<li class="list-group-item">이름 : 홍길동</li>
 			<li class="list-group-item">성별 : 남</li>
 			<li class="list-group-item">전공 : 컴퓨터 공학</li>
 			<li class="list-group-item">학년 : 3학년</li>
		</ul>
		<div>
			<label for="exampleInputEmail1">Java</label> 
			<div><input type="text" id="id" name="id" placeholder="점수 입력"></div>
		</div>
		<div>
			<label for="exampleInputEmail1">Javascript</label> 
			<div><input type="text" id="id" name="id" placeholder="점수 입력"></div>
		</div>
		<div>
			<label for="exampleInputEmail1">SQL</label> 
			<div><input type="text" id="id" name="id" placeholder="점수 입력"></div>
		</div>
		<div>
			<label for="exampleInputEmail1">HTML</label> 
			<div><input type="text" id="id" name="id" placeholder="점수 입력"></div>
		</div>
		<input type="hidden" name="action" value="regist" />
		<input type="hidden" name="page" value="login" />
		<input id="bt_send" type="submit" value="등록"/>		
		<input id="bt_cancel" type="reset" value="취소"/>
	</form>
	</div>
</section>
