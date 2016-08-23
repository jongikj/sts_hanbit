var util = (function() {
	var _page, _directory;
	var setPage = function(page){this._page=page;};
	var setDirectory = function(directory){this._directory = directory;};
	return {
		move : function(directory, page){
			setDirectory(directory);
			setPage(page);
			location.href = sessionStorage.getItem('context') + '/' + getDirectory() + '.do?page=' + getPage();
		},
		isNumber : function(value){
			return typeof value === 'number' && isFinite(value);
		}
	};
})();

var move = function(context, page) {
	location.href = context + '/douglas.do?page=' + page;
}

var douglas = (function(){
	var context = sessionStorage.getItem('context');
	return{
		init : function() {
		    $('#bt_bom').click(function() {move(context, 'bom');}),  //콜백 함수
			$('#bt_dom').click(function() {move(context, 'dom');}),
			$('#bt_kaup').click(function() {move(context, 'kaup');}),
			$('#bt_account').click(function() {move(context, 'account');})
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