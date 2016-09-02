<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class ="box">
		<form>
		<table id="member_update" class="table">
			<tr>
				<td rowspan="5" width="30%"><img src="${img}/member/${user.img}" alt="W3Schools.com" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold">ID</td>
				<td style="width: 40%">${user.id}</td>
			</tr>
			<tr>
				<td class="font_bold">이름</td>
				<td>${user.name}</td>
			</tr>
			<tr>
				<td class="font_bold">비밀번호</td>
				<td><input type="password" name="pw" value=""/></td>
			</tr>
			<tr>
				<td class="font_bold">성별</td>
				<td><%-- ${user.gender} --%></td>
			</tr>
			<tr>
				<td class="font_bold">이메일</td>
				<td><input type="text" name="email" value="${user.email}"/></td>
			</tr>
			<tr>
				<td class="font_bold">생년월일</td>
				<td colspan="2">${user.ssn}</td>
			</tr>
			<tr>
				<td class="font_bold">등록일</td>
				<td colspan="2">${user.reg}</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="update" />
		<input type="hidden" name="page" value="find_by_id" />
		<input type="hidden" name="directory" value="member" />
		<div style="margin: 0 auto">
			<input type="submit" value="수정" /> 
			<input type="reset" value="취소"/>
		</div>
		</form>
	</div>	
