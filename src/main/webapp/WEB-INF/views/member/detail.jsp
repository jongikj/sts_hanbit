<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class ="box">
		<h1>내 정보 보기</h1><br/>
		<table id="member_detail">
			<tr>
				<td rowspan="5" width="30%"><img src="${img}/member/${member.profileImg}" alt="Profile Image" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold bg_color_yellow">ID</td>
				<td style="width: 40%">${member.id}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이름</td>
				<td>${member.name}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">성별</td>
				<td><%-- ${member.gender} --%></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">이메일</td>
				<td>${member.email}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">전공과목</td>
				<td></td>
			</tr>
			<tr>
			<tr>
				<td class="font_bold bg_color_yellow">수강과목</td>
				<td colspan="2"></td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">SSN</td>
				<td colspan="2">${member.ssn}</td>
			</tr>
			<tr>
				<td class="font_bold bg_color_yellow">등록일</td>
				<td colspan="2">${member.regDate }</td>
			</tr>
		</table>
        <input type="hidden" name="action" value="find_by_id" />
		<input type="hidden" name="directory" value="member" />
		<a href="${context}/member/main.do">
			<img src="${img}/member.png" alt="member" style="width: 50px">
		</a>
		<a href="${context}/home.do">
			<img src="${img}/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>	
