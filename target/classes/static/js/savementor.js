$(function(){
	$('button[type=submit]').click(function(e){
		e.preventDefault();
		
		var full_name=$("#mentorName").val();
		var primary_skillset=$("#primarySkillset").val();
		var secondary_skillset=$("#secondarySkillset").val();
		var years_of_experience=$("#yearsOfExperience").val();
		var mentor_id=$("#mentor_id").val();
		console.log("mentor_Id",mentor_id);
		
		$.post({
			url : "mentor/save",
			data : JSON.stringify({
				full_name:full_name,
				primary_skillset:primary_skillset,
				secondary_skillset:secondary_skillset,
				years_of_experience:years_of_experience
				
			}),
			dataType:"json",
			contentType:"application/json",
			success: function(res){
				if(res.validated){
					$('#resultContainer pre code').text(JSON.stringfy(res.data));
				}else{
					$.each(res.errorMessages,function(key,value){
						$('input[name='+key+']').after('<span class="error">'+value+'</span>');
					})
				}
			}
		})
		
	})
})