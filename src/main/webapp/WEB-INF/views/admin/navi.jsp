<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<ul id="admin_nav" class="nav nav-tabs">
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      회원관리<span class="caret"></span>
    </a>
    <ul id="member_mgmt" class="dropdown-menu">
		<li><a id="list"><span style="cursor:pointer">목록</span></a></li>
		<li><a id="find_by"><span style="cursor:pointer">검색</span></a></li>
		<li><a id="count"><span style="cursor:pointer">학생수</span></a></li>
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      성적관리 <span class="caret"></span>
    </a>
    <ul id="grade_mgmt" class="dropdown-menu">
		<li><a href="#" id="grade_regist">등록</a></li>
		<li><a href="#" id="grade_update">수정</a></li>
		<li><a href="#" id="grade_delete">삭제</a></li>
		<li><a href="#" id="grade_list">목록</a></li>
		<li><a href="#" id="grade_count">카운트</a></li>
		<li><a href="#" id="grade_search">검색</a></li>
    </ul>
  </li>
  <li role="presentation" class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
      계좌관리 <span class="caret"></span>
    </a>
    <ul id="acc_mgmt" class="dropdown-menu">
		<li><a id="list">목록</a></li>
		<li><a id="find">조회</a></li>
		<li><a id="count">통장수</a></li>
    </ul>
  </li>
</ul>