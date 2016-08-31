$(document).ready(function() {
	$('#adminCode').focus();
	$('#login').click(login);
});

function login() {
	$('#login_error_info_code').html('');
	$('#login_error_info_pwd').html('');
	$('#login_error_info_vali').html('');
	$('#login_error_info_msg').html('');
	var adminCode = $('#adminCode').val().trim();
	var adminPwd = $('#adminPwd').val().trim();
	var valiCode = $('#valicode').val().trim();
	var flag = true;
	if (adminCode == '') {
		flag = false;
		$('#login_error_info_code').html("用户名不可为空");
	}
	if (adminCode.length>30) {
		flag = false;
		$('#login_error_info_code').html("30长度的字母、数字和下划线");
	}
	if (adminPwd == '') {
		flag = false;
		$('#login_error_info_pwd').html("密码不可为空");
	}
	if (adminPwd.length>30) {
		flag = false;
		$('#login_error_info_pwd').html("30长度的字母、数字和下划线");
	}
	if (valiCode == '') {
		$('#login_error_info_vali').html("验证码不可为空");
	}
	if (flag) {
		var msg = adminCode + ":" + adminPwd;
		var base64_msg = Base64.encode(msg);
		$.ajax({
			url : "checkLogin.do",
			type : "post",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("header", "Base " + base64_msg);
			},
			success : function(result) {
				if (result.status == 0) {
					var adminInfoId=result.data.adminInfoId;
					var adminInfoCode=result.data.adminInfoCode;
					addCookie("adminInfoId",adminInfoId);
					addCookie("adminInfoCode",adminInfoCode);
					window.location.href="toIndex.do";
				}
				if(result.status == 1){
					$('#login_error_info_code').html(result.msg);
				}
				if(result.status == 2){
					$('#login_error_info_pwd').html(result.msg);
				}
			},
			error : function(result) {
				alert("登录异常");
			},
			async : true
		});
	}
}