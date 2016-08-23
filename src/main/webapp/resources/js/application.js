//var application (function(){})(); IIFE 패턴 
var app = (function(){
	var init = function(context) {
		sessionStorage.setItem('context', context);
		move();
	};
	var context = function() {
		return sessionStorage.getItem('context');
	}
	var to_douglas = function() {
		location.href = context() + "/douglas.do";
	};
	var move = function() {
		$('#title').click(function(){
			location.href = context() + "/";
		});
		$('#a_member').click(function(){
			location.href = context() + "/member/main";
		}); // document.querySelector(#a_member).addEventListener('click', function(){}, false)와 동일
		
		$('#a_grade').click(function(){
			location.href = context() + "/grade/main";
		});
		
		$('#a_account').click(function(){
			location.href = context() + "/account/main";
		});
		
		$('#a_school').click(function(){
			location.href = context() + "/school_info";
		});
	}
	return {
		init : init,
		context : context,
		to_douglas : to_douglas,
		move : move
	}
})();