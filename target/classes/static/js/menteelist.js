$(document).ready(function(){
	$.ajax({
		type : "GET",
		url :"/mentee/",
		cache : false,
		success : function(result){
			if(result){
				$('#getResultDiv ul').empty();
				
				var jsonResponse = $.parseJSON(JSON.stringify(result));
				
				var table = $('#menteeTable').DataTable({
					"aaData" : result.data,
					"aoColumns": [
						{"mData" : "mentee_id"},
						{"mData" : "full_name"},
						{"mData" : "application"},
						{"mData" : "portfolio"},
						{"mData" : "logical_mapping"},
					],
					"paginga" : true,
					"pageLength":20,
					"ordering": [0,"asc"]
				});
				
			}else{
				$("#getResultDiv").html("<strong>Error<strong>");
				console.log("Fail : ",result);
			}
				
			},
			error : function(e){
				$("#getResultDiv").html("<strong>Error</strong>");
				console.log("ERROR: ", e);
			}
		}
	})
})