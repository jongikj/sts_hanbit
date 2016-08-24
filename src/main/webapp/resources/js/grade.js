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
		}
	};
})();