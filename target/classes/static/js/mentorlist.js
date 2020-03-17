$(document).ready(function(){
	$.ajax({
		type: "GET",
		url : "/mentor/",
		cache: false,
		success : function(result){
			if(result){
				$('#getResultDiv ul').empty();
				
				var jsonResponse= $.parseJSON(JSON.stringify(result));
				console.log("json--->", jsonResponse.data);
				
				var table = $("#mentorTable").DataTable({
					"aaData" : result.data,
					"aoColumns": [
						{"mData" : "mentor_id"},
						{"mData" : "full_name"},
						{"mData" : "primary_skillset"},
						{"mData" : "secondary_skillset"},
						{"mData" : "years_of_experience"}
					],
					"paging" : true,
					"pageLength" : 20,
					"ordering" : true,
					"order" : [0,"asc"]
					
				});
				
			}else{
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("Fail : ", result);
			}
				
			},
			error : function(e){
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR : ", e);
			}
		}
	})
})