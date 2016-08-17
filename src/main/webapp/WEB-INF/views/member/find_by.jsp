<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
	<div class="box">
	<h1>ID 검색</h1>
	<form action="${context}/member.do" method="get">
	    <input type="text" name="keyword" placeholder="검색할 ID"/>
	    <input type="hidden" name="action" value="find_by_id"/>
	    <input type="hidden" name="page" value="find_by_id"/>
	    <input type="submit" value="ID검색"/>
	    <input type="reset" value="취소"/>
	</form>
	<h1>이름 검색</h1>
	<form action="${context}/member.do" method="get">
	    <input type="text" name="keyword" placeholder="검색할 이름"/>
	    <input type="hidden" name="action" value="find_by_name"/>
	    <input type="hidden" name="page" value="list"/>
	    <input type="submit" value="이름검색"/>
	    <input type="reset" value="취소"/>
	</form>
	
	<iframe src="${context}/member.do?page=image" class="ifrm" style="border:none"></iframe><br/>
		
		<a href="${context}/member/main.do">
			<img src="${img}/member.png" alt="member" style="width: 50px">
		</a>
		<a href="${context}/home.do">
			<img src="${img}/home.png" alt="home" style="width: 50px"/>
		</a>
	</div>
<jsp:include page="../global/footer.jsp"/>	
<jsp:include page="../global/end.jsp"/>