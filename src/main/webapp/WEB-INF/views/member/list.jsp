<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/member.css" />
<div class="box">
	<div class="panel panel-default">
		<div class="panel-heading">학생 목록</div>
			<table id="member_list" class="table">
				<tr>
					<th>ID</th>
					<th>이 름</th>
					<th>등록일</th>
					<th>생년월일</th>
					<th>이메일</th>
					<th>전화번호</th>
				</tr>
				<c:forEach var="member" items="${list}">
				<tr>
					<td>${member.id }</td>
					<td><a href="${context}/member.do?action=find_by_id&page=find_by_id&id=${member.id}&keyword=${member.id}">${member.name }</a></td>
					<td>${member.regDate}</td>
					<td>${member.birth}</td>
					<td>${member.email}</td>
					<td>${member.phone}</td>
				</tr>
				</c:forEach>
			</table>
	</div>
</div>	
