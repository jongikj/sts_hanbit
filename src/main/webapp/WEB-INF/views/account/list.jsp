<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/member.css" />
<div class="box">
	<div class="panel panel-default">
		<div class="panel-heading">계좌 목록</div>
			<table id="acc_list" class="table">
				<tr>
					<th>ID</th>
					<th>이 름</th>
					<th>계좌번호</th>
					<th>잔액</th>
				</tr>
				<c:forEach var="account" items="${list}">
				<tr>
					<td>${account.id }</td>
					<td><a href="${context}/member.do?action=find_by_id&page=find_by_id&id=${member.id}&keyword=${member.id}">${account.name }</a></td>
					<td>${account.accountNo}</td>
					<td>${account.money}</td>
				</tr>
				</c:forEach>
			</table>
	</div>
</div>	
