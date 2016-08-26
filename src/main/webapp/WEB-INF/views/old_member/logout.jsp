<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<link rel="stylesheet" href="${css}/global.css" />
	<div class="box">
		<form action="${context}/member.do" method="post">
		    <input type="hidden" name="action" value="logout" />
            <input type="hidden" name="directory" value="member" />
			<input type="submit" value="로그아웃" />
		</form>
	</div>	
