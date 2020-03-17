$(function(){
	
	$('button[type=submit]').click(function(e){
		e.preventDefault();
		
		var menteeName=$("#menteeName").val();
		var application=$("#application").val();
		var portfolio=$("#portfolio").val();
		var logicalMapping=$("#logicalMapping").val();
		
		$('input').next().remove();
		
		$.post({
			url : '/mentee/save',
			data : JSON.stringify({
				full_name:menteeName,
				application : application,
				portfolio : portfolio,
				local_mapping : localMapping
			}),
			dataType : "json",
			contentType : "application/json",
			success : fubnction(res){
				if(res.validated){
					$('#resultContainer pre code').text(JSON.stringfy(res.data));
					
				}else{
					$.each(res.errorMessages,function(key,value)){
						$('input[name='+key+']').after('<span class="error">'+value+'</span>');
					}
					
				}
			}
			
		})
		
	})
	
	
	
})