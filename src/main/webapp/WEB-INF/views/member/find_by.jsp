<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="box">
	<form id="member_find_form" class="navbar-form navbar-left" role="search" style="width:100%">
		<div class="form-group">
		<div class="col-lg-6" style="width: 100%">
		<select name="search_option" style='width:100px;height:30px'>
  			<option value="id">ID</option>
  			<option value="name">NAME</option>
  			<option value="gender">GENDER</option>
		</select>
     	<input type="text" name="keyword" class="form-control" placeholder="Search"/>
     	<input type="hidden"/>
		<input type="submit" class="btn btn-primary" value="SEARCH"/>
	  	</div>
	  	</div>
	</form>	
</div>