function mentor(){
	$.ajax({
		type: "GET",
		url :"/mentor/",
		cache: false,
		data : "",
		success: function(result){
			if(result){
				
				var json = $.parseJSON(JSON.stringify(result));
				console.log(json.data);
				
				$.each(json.data,function(i, userData){
					$("#mentorList").append($("<option></option>").val(userData.mentor_id).html(userData.full_name));
				});
				
				
			}else{
				$("$mentorlist").html("<srtong>Error</strong>");
				console.log("FAIL: ", result);
			}
		},
		
		error : function(e){
			$("#mentorlist").html("<strong>ERROR</strong>");
			console.log("ERROR: ", e);
		}
		
	})
}

function menteeList(){
	$.ajax({
		type: "GET",
		url : "/mentee/",
		cache :false,
		data:"",
		success : function(result){
			if(result){
				var json=$.parseJSON(JSON.stringify(result));
				console.log("mentee", json.data);
				
				$.each(json.data,function(i,userData){
					$("#menteeList").append($("<option></option>").val(userData.mentee_id).html(userData.full_name));
				});
				
				
			}else{
				$("#menteelist").html("<strong>ERROR</strong>");
				console.log("FAIL : ", result);
			}
		}
	})
}

function(){
	mentorList();
	menteeList();
	
	$("#menteeList").on('change',function(event){
		$('button[type=submit]').click(function(e){
			e.preventDefault();
			
			var mentee_id=$("#menteesList").val();
			var mentor_id =$("#mentorsList").val();
		
			$.ajax({
				
				type : "POST",
				url : "/mentee/"+mentee_id+"/save",
				data : JSON.stringify({
					mentor_id:mentor_id
				}),
				dataType:"json",
				contentType: "application/json",
				success:function(result){
					console.log("mentor_id",mentor_id);
					
					if(result){
						var json = $.parseJSON(JSON.stringify(result));
						console.log("mentee", json.data);
					}else{
						$("#menteelist").html("<strong>Error</strong>");
						console.log("FAIL : ",result);
					}
				},
				
				error : function(e){
					$("#menteelist").html("<>strong>Error</strong>");
					console.log("ERROR : ",e);
				}
				
				
			})
			
		})
	})
	
}











































