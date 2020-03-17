$(document).ready(function(){
	$.ajax({
		type: "GET",
		url: "/mentor/",
		success : function(result){
			if(result){
				
				var jsonResponse= $.parseJSON(JSON.stringify(result)).data;
				console.log("json-->", jsonResponse[2].menteeDTO[0].full_name);
				
				$.each(jsonResponse,function(i, userData){
					$.each(jsonResponse[i].menteeDTO, function(j, userData1){
						
						var user = "<tr><td>"+jsonResponse[i].full_name+"</td><td>"+jsonResponse[i].menteeDTO[j].full_name+"</td></tr>";
						$("#mentorToMenteeTable").append(user);
						
					});
					
				});
				
			}else{
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("Fail :", result);
			}
				
			},
			
			error : function(e){
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR :", e);
			}
		
		
	})
})