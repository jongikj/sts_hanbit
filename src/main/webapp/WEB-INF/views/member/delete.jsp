<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>탈퇴하기</title>
	<link rel="stylesheet" href="${css}/global.css" />
</head>
<body>
	<div class="box">
		<embed src="${img}/banana.gif">
		<h2>탈퇴하려면 비밀번호를 입력해주세요</h2>
			<form action="${context}/member.do" method="post">
				<input type="hidden" name="action" value="delete" />
         		<input type="hidden" name="directory" value="member" />
				<span class="meta">비밀번호</span><input type="password" name="pw"/><br/><br/>
				<input type="submit" value="탈퇴하기"/>
			</form>
		<a href="${context}/member/main.do">
			<img src="${img}/member.png" alt="member" style="width: 50px">
		</a>
		<a href="${context}/home.do">
			<img src="${img}/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
</body>
</html>