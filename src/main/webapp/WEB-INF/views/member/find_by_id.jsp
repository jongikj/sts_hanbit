<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class ="box">
		<h1>검색된 회원 정보</h1><br/>
		<table id="member_detail" class="table">
			<tr>
				<td rowspan="4" width="30%"><img src="${img}/member/${member.profileImg}" alt="W3Schools.com" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold">ID</td>
				<td style="width: 40%">${member.id}</td>
			</tr>
			<tr>
				<td class="font_bold">이름</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td class="font_bold">성별</td>
				<td>${member.gender}</td>
			</tr>
			<tr>
				<td class="font_bold">이메일</td>
				<td>${member.email}</td>
			</tr>
			<tr>
				<td class="font_bold">생년월일</td>
				<td colspan="2">${member.birth}</td>
			</tr>
			<tr>
				<td class="font_bold">등록일</td>
				<td colspan="2">${member.regDate}</td>
			</tr>
		</table>
        <input type="hidden" name="action" value="find_by_id" />
		<input type="hidden" name="directory" value="member" />
	</div>	
