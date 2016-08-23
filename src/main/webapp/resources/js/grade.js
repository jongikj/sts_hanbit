var grade = (function(){
	return {
		init : function(context){
			$('#a_count').click(function(){location.href = app.context() + "/grade/count"});
			$('#a_delete').click(function(){location.href = app.context() + "/grade/delete"});
			$('#a_list').click(function(){location.href = app.context() + "/grade/list"});
			$('#a_regist').click(function(){location.href = app.context() + "/grade/regist"});
			$('#a_search').click(function(){location.href = app.context() + "/grade/search"});
			$('#a_update').click(function(){location.href = app.context() + "/grade/update"});
		}
	};
})();