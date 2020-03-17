$(document).ready(function(){
	$(function(){
		
		$('button[type=submit]').click(function(e){
			e.preventDefault();
			
			var courseName=$.trim($("#courseName").val());
			if(courseName=="" || courseName==null || !courseName){
				$('#courseName-error').removeClass("hidden").html("Enter course Name");
				return false;
			}
			
			var subject=$.trim($("#subject").val());
			if(subject=="" || subject==null || !subject){
				$('#subject-error').removeClass("hidden").html("Enter Subject");
				return false;
			}
			
			var trainingDuration=$.trim($("#trainingDuration").val());
			if(trainingDuration=="" || trainingDuration==null || !trainingDuration){
				$('#trainingDuration-error').removeClass("hidden").html("Enter Training Duration");
				return false;
			}
			
			$('input').next().remove();
			
			$.post({
				url : '/course/save',
				data : $('form[name=course]').serialize(),
				success : function(res){
					if(res){
						$('#info').html("course has been added successfully");
					}else{
						$.each(res.errorMessage,function(key,value){
							$('input[name='+key+']').after('<span class="error">'+value+'</span>'');
						})
					}
				}
			})

			
		})
		
		
	})
	
})