var account = (function(){
	return {
		init : function(context){
			$('#b_regist').click(function(){location.href = app.context() + "/account/regist"});
			$('#b_deposit').click(function(){location.href = app.context() + "/account/deposit"});
			$('#b_withdraw').click(function(){location.href = app.context() + "/account/withdraw"});
			$('#b_update').click(function(){location.href = app.context() + "/account/update"});
			$('#b_delete').click(function(){location.href = app.context() + "/account/delete"});
			$('#b_list').click(function(){location.href = app.context() + "/account/list"});
			$('#b_search').click(function(){location.href = app.context() + "/account/search"});
			$('#b_count').click(function(){location.href = app.context() + "/account/count"});
		}
	};
})();