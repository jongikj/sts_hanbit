var account = (function(){
	return {
		init : function(){
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