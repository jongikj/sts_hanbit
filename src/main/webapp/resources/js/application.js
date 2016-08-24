//var application (function(){})(); IIFE 패턴 
var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context', context);
		sessionStorage.setItem('js', context + '/resources/js');
		sessionStorage.setItem('css', context + '/resources/css');
		sessionStorage.setItem('img', context + '/resources/img');
		move();
		$('#global_content').addClass('box');
		$('#global_content a').addClass('cursor');
		$('#global_content h2').text('서비스를 이용하시려면 회원가입을 하셔야 합니다');
		$('#global_content_a_regist')
		.text('SIGN UP')
		.click(function(){util.move('member', 'regist');});
		$('#global_content_a_login')
		.text('LOGIN')
		.click(function(){util.move('member', 'login');});
		$('#global_content_a_admin')
		.text('ADMIN MODE')
		.click(function(){admin.check()});
	};
	var context = function() {
		return sessionStorage.getItem('context');
	};
	var js = function() {
		return sessionStorage.getItem('js');
	};
	var css = function() {
		return sessionStorage.getItem('css');
	};
	var img = function(){
		return sessionStorage.getItem('img');
	};
	var move = function() {
		$('#title').click(function(){
			util.home();
		});
		$('#a_member').click(function(){// document.querySelector(#a_member).addEventListener('click', function(){}, false)와 동일
			util.move('member', 'main');
		}); 
		$('#a_grade').click(function(){
			util.move('grade', 'main');
		});
		$('#a_account').click(function(){
			util.move('account', 'main');
		});
		$('#a_school').click(function(){
			util.move('global', 'school_info');
		});
	};
	
	return {
		init : init,
		context : context,
		move : move,
		img : img,
		js : js,
		css : css
	}
})();

var admin = (function() {
	var _pass;
	var getPass = function(){return this._pass;};
	var setPass = function(pass){this._pass = pass;};
	return {
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
	    			location.href = app.context() + '/admin/main';
	    		} else {
	    			alert('관리자 비번이 틀립니다.');
	    		}
	    	}
	    }
	};
})();

var util = (function() {
	var _page, _directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory = directory;};
	var getPage = function(){return this._page;};
	var getDirectory = function(){return this._directory;};
	return {
		setPage : setPage,
		getPage : getPage,
		setDirectory : setDirectory,
		getDirectory : getDirectory,
		move : function(directory, page){
			setDirectory(directory);
			setPage(page);
			location.href = app.context() + '/' +getDirectory() + '/' + getPage();
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		},
		home : function(){location.href = app.context() + '/'}
	};
})();

var user = (function(){
	var context = sessionStorage.getItem('context');
	return{
		init : function() {
		    $('#bt_bom').click(function() {move(context, 'bom');}),  //콜백 함수
			$('#bt_dom').click(function() {move(context, 'dom');}),
			$('#bt_kaup').click(function() {move(context, 'kaup');}),
			$('#bt_account').click(function() {move(context, 'account');})
		},
		account : function(){
			$('#acc_regist').click(function(){location.href = app.context() + "/account/regist"});
			$('#acc_deposit').click(function(){location.href = app.context() + "/account/deposit"});
			$('#acc_withdraw').click(function(){location.href = app.context() + "/account/withdraw"});
			$('#acc_update').click(function(){location.href = app.context() + "/account/update"});
			$('#acc_delete').click(function(){location.href = app.context() + "/account/delete"});
			$('#acc_list').click(function(){location.href = app.context() + "/account/list"});
			$('#acc_search').click(function(){location.href = app.context() + "/account/search"});
			$('#acc_count').click(function(){location.href = app.context() + "/account/count"});
			$('#account_content_img_home').attr('src', app.img() + '/home.png').css('width', '50px');
			$('#account_content_a_home').click(function(){location.href = app.context() + "/"});
			$('#account_content').addClass('box').addClass('font_size_20');
		}
	};
})();

var account = (function(){
	var _account_no, _money;
	var setAccountNo = function(account_no){this._account_no=account_no;};
	var getAccountNo = function(){return this._account_no;};
	var setMoney = function(money){this._money=money;};
	var getMoney = function(){return this._money;};
	return {
		setAccountNo : setAccountNo,
		getAccountNo : getAccountNo,
		setMoney : setMoney,
		getMoney : getMoney,
		init : function() {
			$('#bt_spec_show').click(member.spec());
			$('#bt_make_account').click(this.spec());
			$('#bt_deposit').click(this.deposit());
			$('#bt_withdraw').click(this.withdraw());
		},
		spec : function (){ 
            setAccountNo(Math.floor(Math.random() * 899999) + 100000);
			setMoney(0);
			document.querySelector('#result_account').innerHTML = getAccountNo();
			document.querySelector('#rest_money').innerHTML = getMoney();
		},
		deposit : function (){
			var r_acc = document.querySelector('#result_account').innerText;
			
			console.log('계좌번호 : '+r_acc);
			switch(typeof r_acc){
				case 'number' : console.log('this is number type');break;
				case 'string' : console.log('this is string type');break;
				case 'undefined' : console.log('this is undefined type');break;
				default : console.log('type check fail !!');
			}
			
			if(!r_acc) { // null 체크
			    alert('먼저 통장 개설이 되어야 합니다.');
			} else {
			    var rest_money = getMoney();
				var inputMoney = Number(document.querySelector('#money').value);
				console.log('인풋머니 타입체크 : ' + (typeof inputMoney === 'number'));
				console.log('잔액  타입체크 : ' + (typeof rest_money === 'number'));
				setMoney(inputMoney + rest_money);
			    document.querySelector('#rest_money').innerHTML = getMoney();	
			}
		},
		withdraw : function (){
			var r_acc = document.querySelector('#result_account').innerText;
			if(!r_acc) {
	            alert('먼저 통장 개설이 되어야 합니다.');
            } else {
            	var rest_money = getMoney();
    			var inputMoney = Number(document.querySelector('#money').value);
    			console.log('인풋머니 타입체크 : ' + (typeof inputMoney === 'number'));
    			console.log('잔액  타입체크 : ' + (typeof rest_money === 'number'));
    			setMoney(rest_money - inputMoney);
    			document.querySelector('#rest_money').innerHTML = getMoney();	
            }
		}
	}; 
})();


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
	return {
		setSSN : setSsn,
		setName : setName,
		setAge : setAge,
		setGender : setGender,
		getName : getName,
		getAge : getAge,
		getSSN : getSsn,
		getGender : getGender,
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
		}
	};
})();

var kaup = (function() {
	return {
		init : function() {
		    document.querySelector('#kaup_calc').addEventListener('click', this.calc, false);
		},
		go : function() {
			location.href = getContext() + '/douglas.do?page=kaup';
		},
		calc : function() {
			var name = document.querySelector('#name').value;
			var height = document.querySelector('#height').value;
			var weight = document.querySelector('#weight').value;
			console.log('name : ' + name);
			console.log('height : ' + height);
			console.log('weight : ' + weight);
			var result = '';
			var kaup = weight / (height / 100) / (height / 100);

			if (kaup < 18.5) {
				result = "저체중"; 
			} else if (kaup > 18.5 && kaup < 23) {
				result = "정상체중"; 
			} else if (kaup > 23 && kaup < 25) {
				result = "위험체중"; 
			} else if (kaup > 25 && kaup < 30) {
				result = "비만 1단계"; 
			} else if (kaup > 30 && kaup < 40) {
				result = "비만 2단계"; 
			} else if (kaup >= 40) {
				result = "비만 3단계";
			}
			document.querySelector('#result').innerHTML = name + '의 카우프 결과 : ' + result;
			/*return name + "의 BMI지수는 " + Double.parseDouble(String.format("%.2f", kaup)) + "이고, " + result + "이다";*/
		}
	};
})();

var grade = (function(){
	return {
		init : function(){
			$('#grade_count').click(function(){location.href = app.context() + "/grade/count"});
			$('#grade_delete').click(function(){location.href = app.context() + "/grade/delete"});
			$('#grade_list').click(function(){location.href = app.context() + "/grade/list"});
			$('#grade_regist').click(function(){location.href = app.context() + "/grade/regist"});
			$('#grade_search').click(function(){location.href = app.context() + "/grade/search"});
			$('#grade_update').click(function(){location.href = app.context() + "/grade/update"});
			$('#grade_content_img_home').attr('src', app.img() + '/home.png').css('width', '50px');
			$('#grade_content_a_home').click(function(){location.href = app.context() + "/"});
			$('#grade_content').addClass('box').addClass('font_size_20');
		},
		init2 : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width', '40px');
			$('#grade_content > article')
			    .css('width', '300px')
			    .css('margin', '0 auto')
			    .css('text-align', 'left');
			$('#title').css('font-size', '30px');
			$('#a_regist').click(function(){
				location.href = "${context}/grade.do?page=regist";
			});
			
			$('#a_update').click(function() {
				location.href = "${context}/grade.do?page=update";
			});
			
			$('#a_delete').click(function() {
				location.href = "${context}/grade.do?page=delete";
			});
			
			$('#a_list').click(function() {
				location.href = "${context}/grade.do?page=list";
			});
			
			$('#a_count').click(function() {
				location.href = "${context}/grade.do?page=count";
			});
			
			$('#a_find').click(function() {
				location.href = "${context}/grade.do?page=search";
			});
		} 
	};
})();

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

