$(document).ready(function(){
	$.ajax({
		type : "GET",
		url : "/course/",
		cache : false,
		success : function(result){
			console.log("result--->",result)
			if(result){
				$('#getResultDiv ul').empty();
				
				var jsonResponse= $.parseJson(JSON.stringify(result));
				
				var table = $('#courseTable').DataTable({
					"aaData" : result.data,
					"aoColumns": [
						{"mData":"course_id"},
						{"mData":"fullname"},
						{"mData":"subject"},
						{"mData":"training_duration"}
					],
					
					"paging":true,
					"pageLength":20,
					"ordering": [0,"asc"]
				});
			}else{
				$("$getResultDiv").html("<strong>Error</strong>");
				console.log("Fail :", result);
			 }
			},
			error : function(e){
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("Error :", e);
			}
		}
	});
});