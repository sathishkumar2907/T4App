$(function(){
	$('button[type=submit]').click(function(e){
		e.preventDefault();
		
		var fullname= $("#fullname").val();
		var subject= $("#subject").val();
		var trainingDuration= $("#trainingDuration").val();
		
		var courseName= $.trim($("#fullname").val());
		if(courseName=="" || courseName==null){
			
			$("#fullname-error").removeClass().html("Enter Course name");
			return false;
		}
		
		var subject= $.trim($("#subject").val());
		if(subject=="" || subject == null){
			
			$("#subject-error").removeClass().html("Enter subject");
			return false;
		}
		
		var trainingDuration= $.trim($("#trainingDuration").val());
		if(trainingDuration=="" || trainingDuration == null){
			
			$("#trainingDuration-error").removeClass().html("Enter training Duration");
			return false;
		}

		$('input').next().remove();
		
		$.post({
			url : '/course/save',
			data : JSON.stringify({
				fullname : fullname,
				subject : subject,
				training_duration : trainingDuration
			}),
			dataType : "json",
			contentType : "application/json",
			success: function(res){
				if(res){
					 var jsonResponse=$.parseJSON.stringify(res);
					 
				$('#info').html(jsonResponse.message);	 
                
				$('#resultContainer pre code').text(JSON.stringify(res.data));
					 
					 
				}else{
					$.each(res.errorMessages,function(key,value){
						$('input[name='+key+']').after('<span class="error">'+value+'</span>');
					})
				}
			}
			
			
			
		})
		
		
		
	})
	
})