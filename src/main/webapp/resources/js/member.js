var member = (function(){
	return {
		init : function(){
			$('#regist').click(function(){location.href = app.context() + "/member/regist"});
			$('#detail').click(function(){location.href = app.context() + "/member/detail"});
			$('#update').click(function(){location.href = app.context() + "/member/update"});
			$('#delete').click(function(){location.href = app.context() + "/member/delete"});
			$('#login').click(function(){location.href = app.context() + "/member/login"});
			$('#logout').click(function(){location.href = app.context() + "/member/logout"});
			$('#list').click(function(){location.href = app.context() + "/member/list"});
			$('#find_by').click(function(){location.href = app.context() + "/member/find_by"});
			$('#count').click(function(){location.href = app.context() + "/member/count"});
			$('#member_content_img_home').attr('alt', 'home').attr('src', app.img() + '/home.png').css('width', '50px');
			$('#member_content_a_home').click(function(){location.href = app.context() + "/"});
			$('#member_content').addClass('box').css('font-size', '20px');
			$('#member_content > article').css('width', '300px').addClass('center').addClass('text_left');
			$('#member_content  a').css('font-size', '17px').addClass('cursor');
			$('#member_content > h1').text('MEMBER MGMT');
			$('#member_content_ol > li > a').addClass('remove_underline');
			$('#member_content_ol > li:first > a').text('SIGN UP');
			$('#member_content_ol > li:nth(1) > a').text('내정보보기');
			$('#member_content_ol > li:nth(2) > a').text('내정보수정');
			$('#member_content_ol > li:nth(3) > a').text('탈퇴');
			$('#member_content_ol > li:nth(4) > a').text('로그인');
			$('#member_content_ol > li:nth(5) > a').text('로그아웃');
			$('#member_content_ol > li:nth(6) > a').text('리스트');
			$('#member_content_ol > li:nth(7) > a').text('검색');
			$('#member_content_ol > li:nth(8) > a').text('회원수');
		}
	};
})();