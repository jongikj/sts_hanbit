//var application (function(){})(); IIFE 패턴 
var app = (function(){
	var init = function(context) {
		session.init(context);
		onCreate();
		nav.init();
		member.init();
		user.init();
		admin.init();
		account.init();
		grade.init();
	};
	var context = function(){return session.getContextPath();};
	var js = function(){return session.getJavascriptPath('js');};
	var css = function(){return session.getCssPath('css');};
	var img = function(){return session.getImagePath('img');};
	var setContentView = function(){
		$('#footer').addClass('bottom').addClass('footer');
		$('#header_brand').attr('src', app.img() + '/default/water_moon.jpg').css('width', '80').css('height', '49').addClass('cursor');
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content_a_regist').text('SIGN UP').click(function(){member.pub_sign_up();});
		$('#global_content_a_login').text('LOGIN').click(function(){member.pub_login_form();});
		$('#global_content_a_admin').text('ADMIN MODE').click(function(){admin.check()});
	};
	var onCreate = function() {
		setContentView();
		// document.querySelector(#a_member).addEventListener('click', function(){}, false)와 동일
		$('#a_member').click(function(){controller.move('member', 'main');}); 
		$('#a_grade').click(function(){controller.move('grade', 'main');});
		$('#a_account').click(function(){controller.move('account', 'main');});
		$('#a_school').click(function(){controller.move('global', 'school_info');});
		$('#free_board_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
		$('#go_public_home').click(function(){controller.home();});
		$('#school_info').click(function(){controller.move('global', 'school_info');});
		$('#contact').click(function(){controller.move('global', 'contact');});
		$('#free_board').click(function(){controller.move('global', 'free_board');});
	};
	
	return {
		init : init,
		context : context,
		onCreate : onCreate,
		setContentView : setContentView,
		img : img,
		js : js,
		css : css
	}
})();

var admin = (function() {
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#admin_content #member_img').attr('src', app.img() + '/default/member_mgmt.png').css('width', '420').css('height', '370');
		$('#admin_content #grade_img').attr('src', app.img() + '/default/grade_mgmt.jpg').css('width', '420').css('height', '370');
		$('#admin_content #account_img').attr('src', app.img() + '/default/acc_mgmt.jpg').css('width', '420').css('height', '370');
		$('#admin_content h3').addClass('text_center');
		$('#admin_header').css('height','50px');
		$('.navbar-header').css('height','50px');
		$('#admin_header #exit').addClass('cursor');
		$('#admin_nav').css('height','50px');
	};
	var onCreate = function(){
		setContentView();
		$('#admin_nav #member_mgmt #list').click(function(){controller.move('member', 'list');});
		$('#admin_nav #member_mgmt #find_by').click(function(){controller.move('member', 'find_by');});
		$('#admin_nav #member_mgmt #count').click(function(){controller.move('member', 'count');});
		$('#admin_nav #account_mgmt #list').click(function(){controller.move('account', 'list');});
		$('#admin_nav #account_mgmt #open').click(function(){controller.move('account', 'open');});
		$('#admin_nav #account_mgmt #delete').click(function(){controller.move('account', 'delete');});
		$('#admin_nav #account_mgmt #find').click(function(){controller.move('account', 'find');});
		$('#admin_nav #account_mgmt #count').click(function(){controller.move('account', 'count');});
		$('#admin_nav #grade_mgmt #regist').click(function(){controller.move('grade', 'regist');});
		$('#admin_nav #grade_mgmt #update').click(function(){controller.move('grade', 'update');});
		$('#admin_nav #grade_mgmt #delete').click(function(){controller.move('grade', 'delete');});
		$('#admin_nav #grade_mgmt #list').click(function(){controller.move('grade', 'list');});
		$('#admin_nav #grade_mgmt #count').click(function(){controller.move('grade', 'count');});
		$('#admin_nav #grade_mgmt #find').click(function(){controller.move('grade', 'find');});
		$('#go_admin_home').click(function(){controller.move('admin', 'main');});
		$('#admin_header #exit').click(function() {controller.home();});
		$('#grade_mgmt #regist').click(function(){alert('등록하시려면 회원리스트로 이동해주세요.');controller.move('member', 'list');});
		$('#grade_mgmt #update').click(function(){alert('수정하시려면 회원리스트로 이동해주세요.');controller.move('member', 'list');});
		$('#account_mgmt #list').click(function(){controller.move('account', 'list');});
		$('#account_mgmt #find').click(function(){controller.move('account', 'find');});
		$('#account_mgmt #count').click(function(){controller.move('account', 'count');});
		$('#account_list_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
		$('#grade_list_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
	};
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass = pass;};
	return {
		init : init,
		setContentView : setContentView,
		onCreate : onCreate,
		getPass : getPass,
	    setPass : setPass,
	    check : function(){
	    	setPass(1);
	    	var isAdmin = confirm('관리자입니까?');
	    	if (!isAdmin){
	    		alert('관리자만 접근 가능합니다.');
	    	} else { 
	    		var password = prompt('관리자 비번을 입력바랍니다.');
	    		if(password == getPass()){
	    			controller.move('admin', 'main');
	    		} else {
	    			alert('관리자 비번이 틀립니다.');
	    		}
	    	}
	    }
	};
})();
/*
========== JS_STUDENT ==========
@CREATE DATE : 2016-8-1
@UPDATE DATE : 2016-9-20
@DESC : 학생
================================
*/
var user = (function() {
	var key = $('#user_content_subject #major_subject_1 input[type="hidden"]').val();
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#account_content_img_home').attr('src', app.img() + '/home.png').css('width', '50px');
		$('#account_content').addClass('box').addClass('font_size_20');
		$('#account_content_a_home').click(function(){controller.home();});
		$('#user_content #kaup').addClass('cursor').click(function(){controller.move("member", "kaup");});	
		$('#user_content #rock_scissor_paper').addClass('cursor').click(function(){controller.move("member", "rock_scissor_paper");});	
		$('#user_content #lotto').addClass('cursor').click(function(){controller.move("member", "lotto");});
		$('#user_header').css('height','50px');
		$('.navbar-header').css('height','50px');
	};
	var onCreate = function(){
		setContentView();
		$('#bt_bom').click(function() {controller.move('', 'bom');}),  //콜백 함수
		$('#bt_dom').click(function() {controller.move('', 'dom');}),
		$('#bt_kaup').click(function() {controller.move('', 'kaup');}),
		$('#bt_account').click(function() {controller.move('', 'account');})
		$('#acc_regist').click(function(){controller.move('account', 'regist');});
		$('#acc_deposit').click(function(){controller.move('account', 'deposit');});
		$('#acc_withdraw').click(function(){controller.move('account', 'withdraw');});
		$('#acc_update').click(function(){controller.move('account', 'update');});
		$('#acc_delete').click(function(){controller.move('account', 'delete');});
		$('#acc_list').click(function(){controller.move('account', 'list');});
		$('#acc_search').click(function(){controller.move('account', 'search');});
		$('#acc_count').click(function(){controller.move('account', 'count');});
		$('#user_content_subject #major_subject_1 input[type="button"]').click(function(){controller.moveWithKey('subject', 'detail', key);});
		$('#user_content #major_subject_2').click(function(){});
		$('#user_content #major_subject_3').click(function(){});
		$('#go_user_home').click(function(){controller.move('member', 'content')});
		$('#user_header #a_mypage').click(function(){controller.move('member', 'content');});
		$('#user_header #a_detail').click(function(){controller.move('member', 'detail');});
		$('#user_header #a_update').click(function(){controller.move('member', 'update');});
		$('#user_header #a_delete').click(function(){controller.move('member', 'delete');});
		$('#user_header #logout').click(function(){controller.home();});
		$("#user_header #account li:eq(0) a").click(function(){controller.move('account', 'detail');});	
		$("#user_header #account li:eq(1) a").click(function(){controller.move('account', 'open');});
		$("#user_header #account li:eq(2) a").click(function(){controller.move('account', 'transaction');});	
		$("#user_header #account li:eq(3) a").click(function(){controller.move('account', 'delete');});	
		$("#user_header #grade li:eq(0) a").click(function(){controller.move('grade', 'detail');});
		$("#user_header #grade li:eq(1) a").click(function(){controller.move('grade', 'find');});
		$('#logined_header_brand').click(function(){controller.move('member', 'content');});
	};
	return{
		init : init
	};
})();
/*
========== JS_PROF ==========
@CREATE DATE : 2016-8-1
@UPDATE DATE : 2016-9-20
@DESC : 교수
=============================
*/
var member = (function() {
	var _ssn, _name, _gender, _age;
	var setAge = function(age){this._age=age;}
	var setGender = function(gender){this._gender=gender;}
	var setName = function(name){this._name=name;}
	var setSsn = function(ssn){this._ssn=ssn;}
	var getAge = function(){return this._age;}
	var getGender = function(){return this._gender;}
	var getName = function(){return this._name;}
	var getSsn = function(){return this._ssn;}
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#member_content_img_home').attr('alt', 'home').attr('src', app.img() + '/home.png').css('width', '50px');
		$('#member_content_a_home').click(function(){controller.home();});
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
		$('#member_regist').addClass('box');
		$('#member_regist #bt_join').addClass('btn').addClass('btn-primary');
		$('#member_regist #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#member_regist_form').addClass('form-horizontal');
		$('#member_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#member_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#member_regist_form > div > div').addClass('col-sm-10');
		$('#member_regist_form > div > div > input').addClass('form-control');
		$('#member_regist #rd_major > label:gt(2)').addClass('radio-inline');
		$('#member_regist #ck_subject').addClass('checkbox');
		$('#member_regist #ck_subject > label').addClass('checkbox-inline');
		$('#member_find_form').attr('action', sessionStorage.getItem('context') + '/member/search');
		$('#member_find_form input[type="hidden"]').attr('name', 'context').attr('value', app.context());
		$('#member_login_form').attr('method', 'post').attr('action',sessionStorage.getItem('context')+'/member/login');
		$('#member_login_form input[type=hidden]').attr('value',app.context());
	};
	var onCreate = function(){
		setContentView();
		$('#regist').click(function(){controller.move('member', 'regist');});
		$('#detail').click(function(){controller.move('member', 'detail');});
		$('#update').click(function(){controller.move('member', 'update');});
		$('#delete').click(function(){controller.move('member', 'delete');});
		$('#login').click(function(){controller.move('member', 'login');});
		$('#logout').click(function(){controller.move('member', 'logout');});
		$('#list').click(function(){controller.move('member', 'list');});
		$('#find_by').click(function(){controller.move('member', 'find_by');});
		$('#count').click(function(){controller.move('member', 'count');});
		$('#member_find_form input[type="submit"]').click(function(){$('#member_find_form').submit();});
		$('#member_list_table .name').click(function(){controller.moveWithKey('member', 'a_detail', 'hong');});
		$('#member_list_table .regist').click(function(){controller.moveWithKey('grade', 'regist', 'hong');});
		$('#member_list_table .update').click(function(){controller.moveWithKey('grade', 'update', 'hong');});
		$('#member_login_form input[type=submit]').click(function() {$('#member_login_from').submit();});
	};
	return {
		setSSN : setSsn,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSSN : getSsn,
		getGender : getGender,
		init : init,
		spec : function() {
			setName(document.querySelector('#name').value);
			setSsn(document.querySelector('#ssn').value);
			var ssn_sec = parseInt(getSsn().substring(7, 8));
			var date = new Date().getFullYear();
			var ssn_sub = getSsn().substring(0, 6) / 10000;
			
			switch(ssn_sec){
	    	case 1: case 5: 
			    setGender("남"); 
			    setAge(parseInt((date - 1900 - ssn_sub) + 2));
		    	break;
		    	
		    case 3: case 7:
			    setGender("남"); 
			    setAge(parseInt((date - 2000 - ssn_sub) + 2));
			    break;
			    
		    case 2: case 6:
			    setGender("여");
			    setAge(parseInt((date - 1900 - ssn_sub) + 2));
			    break;
			    
		    case 4: case 8:
			    setGender("여");
			    setAge(parseInt((date - 2000 - ssn_sub) + 2));
			    break;
			    
			default :
				setGender("default 값을 입력했습니다.");
			    break;
		}
			
		document.querySelector('#result_name').innerHTML = getName();
		document.querySelector('#result_age').innerHTML = getAge();
		document.querySelector('#result_gender').innerHTML = getGender();
		},
		pub_login_form : function(){
			var view = '<div class="box">'
				+ '<form id="member_login_form" class="form-signin">'
				+ '<h2 class="form-signin-heading">Please sign in</h2>'
				+ '<label for="inputEmail" class="sr-only">Email address</label>'
				+ '<input type="text" id="id" name="id" id="inputEmail" class="form-control" placeholder="User ID" required autofocus>'
				+ '<label for="inputPassword" class="sr-only">Password</label>'
				+ '<input type="password" id="pw" name="pw" id="inputPassword" class="form-control" placeholder="Password" required>'
				+ '<input type="hidden" name="context">'
				+ '<div class="checkbox"><label>'
				+ '<input type="checkbox" value="remember-me"> Remember me</label></div>'
				+ '<input id="login_btn" class="btn btn-lg btn-primary btn-block" type="submit" value="Sign in"/></form></div>';
			$('#pub_article').empty().append(view);
			$('#login_btn').click(function(e){
				e.preventDefault();
			$.ajax({
				url : app.context() + '/member/login',
				type : 'POST',
				data : {'id':$('#id').val(), 'pw':$('#pw').val()},
				dataType : 'json',
				success : function(data){
					if(data.id == 'NONE'){
						alert('ID나 비번이 일치하지 않습니다.');
					}else{
						var view = '<section id="user_content_service" class="box section-padded"><div>'
							+ '<div class="row text-center title">'
							+ '<h2>Services</h2>'
							+ '<h4 class="light muted">Achieve the best results with our wide variety of training options!</h4></div>'
							+ '<div class="row services">'
							+ '<div class="col-md-4">'
							+ '<div id="kaup" class="service">'
							+ '<div class="icon-holder">'
							+ '<img src="'+app.img()+'/icons/kaup.jpg" alt="" class="icon"></div>'
							+ '<h4 class="heading">KAUP INDEX</h4>'
							+ '<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p></div></div>'
							+ '<div class="col-md-4">'
							+ '<div id="rock_scissor_paper" class="service">'
							+ '<div class="icon-holder">'
							+ '<img src="'+app.img()+'/icons/RSP.jpg" alt="" class="icon"></div>'
							+ '<h4 class="heading">ROCK SCISSOR PAPER</h4>'
							+ '<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p></div></div>'
							+ '<div class="col-md-4">'
							+ '<div id="lotto" class="service">'
							+ '<div class="icon-holder">'
							+ '<img src="'+app.img()+'/icons/lotto.jpg" alt="" class="icon"></div>'
							+ '<h4 class="heading">LOTTO DRAWING</h4>'
							+ '<p class="description">A elementum ligula lacus ac quam ultrices a scelerisque praesent vel suspendisse scelerisque a aenean hac montes.</p></div></div></div></div>'
							+ '<div class="cut cut-bottom"></div></section>'
							+ '<section id="user_content_subject" class="section gray-bg">'
							+ '<div class="container">'
							+ '<div class="row title text-center">'
							+ '<h2 class="margin-top">Major Subject</h2>'
							+ '<h4 class="light muted">TOP 3</h4></div>'
							+ '<div class="row">'
							+ '<div class="col-md-4">'
							+ '<div id="major_subject_1" class="team text-center">'
							+ '<div class="cover" style="background:url(' + app.img() + '/team/java-cover.jpg); background-size:cover;">'
							+ '<div class="overlay text-center">'
							+ '<h3 class="white">Java </h3>'
							+ '<h5 class="light light-white">1 - 5 sessions / month</h5></div></div>'
							+ '<img src="'+app.img()+'/team/java.jpg" alt="Java Image" class="avatar" style="width: 120px" height="120px">'
							+ '<div class="title">'
							+ '<h4>JAVA</h4>'
							+ '<h5 class="muted regular">Server Program Language</h5></div>'
							+ '<input type="hidden" name="major_subject_1" value="java"/>'
							+ '<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/></div></div>'
							+ '<div class="col-md-4">'
							+ '<div id="major_subject_2" class="team text-center">'
							+ '<div class="cover" style="background:url(' + app.img() + '/team/javascript-cover.jpg); background-size:cover;">'
							+ '<div class="overlay text-center">'
							+ '<h3 class="white">Javascript</h3>'
							+ '<h5 class="light light-white">1 - 5 sessions / month</h5></div></div>'
							+ '<img src="'+app.img()+'/team/javascript.jpg" alt="Javascript Image" class="avatar" style="width: 120px" height="120px">'
							+ '<div class="title">'
							+ '<h4>Javascript</h4>'
							+ '<h5 class="muted regular">UI Program Language</h5></div>'
							+ '<input type="hidden" name="major_subject_2"/>'
							+ '<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/></div></div>'
							+ '<div class="col-md-4">'
							+ '<div id="major_subject_3" class="team text-center">'
							+ '<div class="cover" style="background:url(' + app.img() + '/team/sql-cover.jpg); background-size:cover;">'
							+ '<div class="overlay text-center">'
							+ '<h3 class="white">SQL</h3>'
							+ '<h5 class="light light-white">1 - 5 sessions / month</h5></div></div>'
							+ '<img src="'+app.img()+'/team/sql.jpg" alt="SQL Image" class="avatar" style="width: 120px" height="120px">'
							+ '<div class="title">'
							+ '<h4>SQL</h4>'
							+ '<h5 class="muted regular">Database Management Language</h5></div>'
							+ '<input type="hidden" name="major_subject_3"/>'
							+ '<input type="button" data-toggle="modal" data-target="#modal1" class="btn btn-blue-fill" value="과목 정보"/></div></div></div></div></section>';
//						$('#pub_header').html(view);
						$('#pub_article').html(view);
					}
				},
				error : function(xhr, status, msg){
					alert('로그인 실패 이유 ' + msg);
					}
				});
			});
		},
		pub_sign_up : function(){
			var view = '<section id="member_regist">'
				+ '<form id="member_regist_form"><div>'
				+ '<label for="exampleInputEmail1">이름</label> '
				+ '<div><input type="text" id="username" placeholder="NAME"></div></div>'
				+ '<div><label for="exampleInputEmail1">ID</label>'
				+ '<div><input type="text" id="id" placeholder="ID"></div></div>'
				+ '<div><label for="exampleInputEmail1">비밀번호</label>'
				+ '<div><input type="password" id="password" placeholder="PASSWORD"></div></div>'
				+ '<div><label for="exampleInputEmail1">SSN</label><div><input type="text" id="ssn" placeholder="예)800101-1"></div></div>'
				+ '<div><label for="exampleInputEmail1">E-MAIL</label><div><input type="email" id="email" placeholder="EMAIL"></div></div>'
				+ '<div><label for="exampleInputEmail1">전화번호</label><div><input type="text" id="phone" placeholder="PHONE"></div></div>'
				+ '<div id="rd_major"><label for="exampleInputEmail1">전공</label><br/><label class="radio-inline"><input type="radio" name="major" value="computer" checked> 컴퓨터공학과</label><label class="radio-inline"><input type="radio" name="major" value="mgmt"> 경영학과</label><label class="radio-inline"><input type="radio" name="major" value="eng">영문학과</label><label class="radio-inline"><input type="radio" name="major" value="math">수학과</label></div>'
				+ '<div><label for="exampleInputEmail1">수강과목</label><br/>'
				+ '<div><div id="ck_subject" class="checkbox">'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="java"> Java</label>'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="sql"> SQL</label>'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="cpp"> C++</label>'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="python"> 파이썬</label>'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="html"> HTML</label>'
				+ '<label class="checkbox-inline"><input type="checkbox" name="subject" value="delphi"> 델파이</label></div></div></div>'
				+ '<input type="hidden" name="action" value="regist" />'
				+ '<input type="hidden" name="page" value="login" />'
				+ '<input type="hidden" name="directory" value="member" />'
				+ '<button id="bt_join" type="submit" value="회원가입">회원가입</button>'
				+ '<button id="bt_cancel" type="reset" value="취소">취소</button></form>	</section>';
			$('#pub_article').empty().append(view);
			member.init();
		}
	};
})();
var grade = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#grade_content_img_home').attr('src', app.img() + '/home.png').css('width', '50px');
		$('#grade_content_a_home').click(function(){controller.home();});
		$('#grade_content').addClass('box').addClass('font_size_20');
		$('#grade_content').addClass('box');
		$('#img_home').css('width', '40px');
		$('#grade_content > article').css('width', '300px').css('margin', '0 auto').css('text-align', 'left');
		$('#title').css('font-size', '30px');
		$('#grade_regist').addClass('box').css('padding-top', '0');
		$('#grade_regist #bt_send').addClass('btn').addClass('btn-primary');
		$('#grade_regist #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#grade_regist_form').addClass('form-horizontal');
		$('#grade_regist_form > div').addClass('form-group').addClass('form-group-lg');
		$('#grade_regist_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#grade_regist_form > div > div').addClass('col-sm-10');
		$('#grade_regist_form > div > div > input').addClass('form-control');
		$('#grade_regist #rd_major > label:gt(2)').addClass('radio-inline');
		$('#grade_update').addClass('box').css('padding-top', '0');
		$('#grade_update #bt_send').addClass('btn').addClass('btn-primary');
		$('#grade_update #bt_cancel').addClass('btn').addClass('btn-danger');
		$('#grade_update_form').addClass('form-horizontal');
		$('#grade_update_form > div').addClass('form-group').addClass('form-group-lg');
		$('#grade_update_form > div > label').addClass('col-sm-2').addClass('control-label');
		$('#grade_update_form > div > div').addClass('col-sm-10');
		$('#grade_update_form > div > div > input').addClass('form-control');
		$('#grade_update #rd_major > label:gt(2)').addClass('radio-inline');
	};
	var onCreate = function(){
		setContentView();
		$('#grade_count').click(function(){controller.move('grade', 'count');});
		$('#grade_delete').click(function(){controller.move('grade', 'delete');});
		$('#grade_list').click(function(){controller.move('grade', 'list');});
		$('#grade_regist').click(function(){controller.move('grade', 'regist');});
		$('#grade_search').click(function(){controller.move('grade', 'search');});
		$('#grade_update').click(function(){controller.move('grade', 'update');});
		$('#a_regist').click(function(){location.href = "${context}/grade.do?page=regist";});
		$('#a_update').click(function() {location.href = "${context}/grade.do?page=update";});
		$('#a_delete').click(function() {location.href = "${context}/grade.do?page=delete";});
		$('#a_list').click(function() {location.href = "${context}/grade.do?page=list";});
		$('#a_count').click(function() {location.href = "${context}/grade.do?page=count";});
		$('#a_find').click(function() {location.href = "${context}/grade.do?page=search";});
	};
	return {
		init : init,
	};
})();
//Board
var qna = (function(){})();
var notice = (function(){})();

//META 
var session = (function() {
	var init = function(context){
		sessionStorage.setItem('context', context);
		sessionStorage.setItem('js', context + '/resources/js');
		sessionStorage.setItem('css', context + '/resources/css');
		sessionStorage.setItem('img', context + '/resources/img');
	};
	var getContextPath = function(){return sessionStorage.getItem('context');};
	var getJavascriptPath = function(){return sessionStorage.getItem('js');};
	var getCssPath = function(){return sessionStorage.getItem('js');};
	var getImagePath = function(){return sessionStorage.getItem('img');};
	return {
		init : init,
		getContextPath : getContextPath,
		getJavascriptPath : getJavascriptPath,
		getCssPath : getCssPath,
		getImagePath : getImagePath
	};
})();

var util = (function(){
	return {
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}		
	};
})();

var controller = (function() {
	var _page, _directory, _key;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory = directory;};
	var setKey = function(key){this._key=key;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory;};
	var getKey = function(){return this._key;};
	return {
		setPage : setPage,
		getPage : getPage,
		setKey : setKey,
		getKey : getKey,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		moveWithKey : function(directory, page, key){
			setDirectory(directory);
			setPage(page);
			setKey(key);
			location.href = app.context() + '/' +getDirectory() + '/' + getPage() + '?key=' + getKey();
		},
		move : function(directory, page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context() + '/' +getDirectory() + '/' + getPage();
		},
		home : function(){location.href = app.context() + '/'}
	};
})();

var nav = (function(){
	var init = function(){onCreate();};
	var setContentView = function(){
		$('#nav ul').addClass('list_style_none').addClass('over_hidden').addClass('bg_color_black').css('margin', '0').css('padding', '0');
		$('#nav li').addClass('float_left').addClass('display_inline').css('border-right', '1px').css('solid', '#bbb');
		$('#nav li:last-child').css('border-right', 'none');
		$('#nav li a').addClass('display_block').addClass('text_decoration_none').css('color', 'white').css('text-align', 'center').css('padding', '14px').css('padding', '16px');
		$('#nav li a:hover:not(.active)').addClass('bg_color_green');
		$('#nav .active').addClass('active');
	};
	var onCreate = function(){
		setContentView();
	};
	return {
		init : init
	};
})();

