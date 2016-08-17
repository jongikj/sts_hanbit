<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/member.css" />
<jsp:include page="../global/top.jsp"/>
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
	<div class="box">
		<h1>목록보기</h1><br/>
		<table id="member_list">
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
		<a href="${context}/member/main.do">
			<img src="${img}/member.png" alt="member" style="width: 50px">
		</a>
		<a href="${context}/home.do">
			<img src="${img}/home.png" alt="home" style="width: 50px"/>
		</a>
</div>	
<jsp:include page="../global/footer.jsp"/>	
<jsp:include page="../global/end.jsp"/>