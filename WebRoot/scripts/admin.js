$(function() {
	loadlist();
	//分页控制
	$("#pages").on("click","a",function(event){
		event.stopPropagation();
//		alert(event.target.id);
		loadlist(event.target.id);
	});
});

function loadlist(p) {
	p=(p==null?1:p);
	$.ajax({
		url : "getListByPage.do",
		type : "post",
		data : "page="+p,
		dataType : "json",
		success : function(result) {
			if (result.status == 0) {
				$("#datalist tbody").empty();
				$("#pages").empty();
				for(var i=0;i<result.data.length;i++){
					var adminData=result.data[i];
					var str='<tr>';
					str+='<td><input type="checkbox" /></td>';
					str+='<td>'+adminData.adminId+'</td>';
					str+='<td>'+adminData.name+'</td>';
					str+='<td>'+adminData.adminCode+'</td>';
					str+='<td>'+adminData.telephone+'</td>';
					str+='<td>'+adminData.email+'</td>';
					str+='<td>'+(new Date(adminData.enrolldate)).Format("yyyy-MM-dd")+'</td>';
					str+='<td>';
					str+='<a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">超级管理员...</a> <!--浮动的详细信息-->';
					str+='<div class="detail_info">超级管理员，角色管理员，账单管理员，报表管理员，业务账号管理员，账务账号管理员，aa，bb</div>';
					str+='</td>';
					str+='<td class="td_modi">';
					str+='<input type="button" value="修改" class="btn_modify" onclick="location.href="admin_modi.html";" />';
					str+='<input type="button" value="删除" class="btn_delete" onclick="deleteAdmin();" />';
					str+='</td></tr>';
					
					$("#datalist tbody").append(str);
				}
				var pageConts=result.msg.split(":")[1];//获取到页数
				$("#pages").append('<a id="'+(p==1?1:(p-1))+'" href="javascript:;">上一页</a>');
				for(var j=pageConts;j>0;j--){
					if(p==j){
//						var $str1=$('<a id="'+j+'" class="current_page" href="javascript:;">'+j+'</a>');
						$("#pages a").eq(0).after('<a id="'+j+'" class="current_page" href="javascript:;">'+j+'</a>');
					}else{
//						var $str2=$('<a id="'+j+'" href="javascript:;">'+j+'</a>');
						$("#pages a").eq(0).after('<a id="'+j+'" href="javascript:;">'+j+'</a>');
					}
				}
				$("#pages").append('<a id="'+(p==pageConts?pageConts:(p-(-1)))+'" href="javascript:;">下一页</a>');
			}
		},
		error : function() {
			alert("获取管理员账户异常");
		},
		async : true
	});
}

//显示角色详细信息
function showDetail(flag, a) {
	var detailDiv = a.parentNode.getElementsByTagName("div")[0];
	if (flag) {
		detailDiv.style.display = "block";
	} else
		detailDiv.style.display = "none";
}
// 重置密码
function resetPwd() {
	alert("请至少选择一条数据！");
	// document.getElementById("operate_result_info").style.display = "block";
}
// 删除
function deleteAdmin() {
	var r = window.confirm("确定要删除此管理员吗？");
	document.getElementById("operate_result_info").style.display = "block";
}
// 全选
function selectAdmins(inputObj) {
	var inputArray = document.getElementById("datalist").getElementsByTagName(
			"input");
	for (var i = 1; i < inputArray.length; i++) {
		if (inputArray[i].type == "checkbox") {
			inputArray[i].checked = inputObj.checked;
		}
	}
}