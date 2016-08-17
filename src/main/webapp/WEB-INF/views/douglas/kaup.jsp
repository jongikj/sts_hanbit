<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="../global/top.jsp"/>   
<jsp:include page="../global/header.jsp"/>
<jsp:include page="../global/navi.jsp"/>
<script src="${js}/douglas.js"></script>
<link rel="stylesheet" href="${css }/douglas.css" />
<div id="container">
<section class="formbox"> 
    <form name="form">
        <p>카우프 지수 구하기</p>
        <p>이름</p> <input type="text" name="name" id="name" />
        <p>키</p> <input type="text" name="height" id="height" />
        <p>몸무게</p> <input type="text" name="weight" id="weight" />
        <input type="button" value="결과보기" id="kaup_calc" />
    </form>
</section>
<section id="databox">
    결과 : <span id="result"></span>
</section>
</div>
<jsp:include page="../global/footer.jsp"/>
<jsp:include page="../global/end.jsp"/>
<script>
    kaup.init();
</script>