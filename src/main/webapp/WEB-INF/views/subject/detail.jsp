<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
	<div class ="box">
		<h3>과목 상세 정보</h3>
		<div style="padding: 20px"></div>
		<table id="subject_detail" class="table">
			<tr>
				<td rowspan="4" width="30%"><img src="${img}/subject/prof.jpg" alt="Profile Image" width="104" height="142"><br/></td>
				<td style="width: 20%" class="font_bold">과목명</td>
				<td style="width: 40%">Java</td>
			</tr>
			<tr>
				<td class="font_bold">담당교수</td>
				<td>제임스 고슬링</td>
			</tr>
			<tr>
				<td class="font_bold">과목코드</td>
				<td>SUB-123456</td>
			</tr>
			<tr>
				<td class="font_bold">촤근 성적</td>
				<td>92점</td>
			</tr>
		</table>
        <input type="hidden" name="action" value="find_by_id" />
		<input type="hidden" name="directory" value="subject" />
	</div>	
