
function checkForm(){ 
	var flag = 1;
	
	if ($("#userName").val() == "") {
		$("#userName_error").html("&emsp;&emsp;用户名不能为空");
		flag = 0;
	} else if ($("#userName").val() != ""
			&& ($("#userName").val().length < 4
			|| $("#userName").val().length > 17)) {
		$("#userName_error").html("&emsp;&emsp;用户名为4~17个字符");
		flag = 0;
	}else{
		$("#userName_error").html("");
	}
	
	if ($("#password").val() == "") {
		$("#password_error").html("&emsp;&emsp;请输入密码");
		flag = 0;
	}else if($("#password").val() != ""
		&& ($("#password").val().length < 6
				|| $("#password").val().length > 20)){
		$("#password_error").html("&emsp;&emsp;密码为6~20个字符");
		flag = 0;
	}else{
		$("#password_error").html("");
	}
	
	if ($("#repassword").val() == "") {
		$("#repassword_error").html("&emsp;&emsp;请确认密码");
		flag = 0;
	} else if ($("#repassword").val() != ""
			&& $("#repassword").val() != $("#password").val()) {
		$("#repassword_error").html("&emsp;&emsp;两次输入的密码不一致");
		flag = 0;
	}else{
		$("#repassword_error").html("");
	}
	
	if ($("#name").val() == "") {
		$("#name_error").html("&emsp;&emsp;姓名不能为空");
		flag = 0;
	}else{
		$("#name_error").html("");
	}
	
	var mobil = $("#mobil").val(); //获取手机号码输入框值
	
	var reg = /^1[0-9]{10}$/; //   /^1[3|4|5|8][0-9]\d{4,8}$/
	
	if ($("#mobil").val() == "") {
		$("#mobil_error").html("&emsp;&emsp;手机号不能为空");
		flag = 0;
	} else if (!reg.test(mobil)) { //校验手机号码格式  
		$("#mobil_error").html("&emsp;&emsp;手机号格式有误");
		flag = 0;
	} else {
		$("#mobil_error").html("");
	}
	
	if (flag == 0) {
		return false;
	}

	return true;
	
}
