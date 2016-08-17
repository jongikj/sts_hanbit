var grade = (function(){ //함수표현식 !() 과 ()()는 동일하다
	return {
		init : function(){
			$('#grade_content').addClass('box');
			$('#img_home').css('width', '40px');
			$('#grade_content > article')
			    .css('width', '300px')
			    .css('margin', '0 auto')
			    .css('text-align', 'left');
			$('#title').css('font-size', '40px');
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