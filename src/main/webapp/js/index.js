$(function(){
	$("#submitBtn").click(function(){
		var userName=$("#userName").val();
		var password=$("#password").val();
		if(null==userName||userName.trim().length==0){
			alert("请输入用户名");
			return;
		}
		if(null==password||password.trim().length==0){
			alert("请输入密码");
			return;
		}
		$.ajax({
			type:"post",
			url:"user/login",
			data:"userName="+userName+"&password="+password,
			dataType:"json",
			success:function(data){
					if(data.code==200){
						$.cookie("userId", data.result.id,{ expires: 7 });
						$.cookie("userName", data.result.userName,{ expires: 7 });
						$.cookie("trueName", data.result.trueName,{ expires: 7 });
						window.location.href="main"
					}else{
						alert(data.msg);
					}
			}
		})
	})
})