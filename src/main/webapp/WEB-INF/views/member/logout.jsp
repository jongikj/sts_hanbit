<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>로그아웃</title>
	<link rel="stylesheet" href="${css}/global.css" />
</head>
<body>
	<div class="box">
		<form action="${context}/member.do" method="post">
		    <input type="hidden" name="action" value="logout" />
            <input type="hidden" name="directory" value="member" />
			<input type="submit" value="로그아웃" />
		</form>
	</div>	
</body>
</html>