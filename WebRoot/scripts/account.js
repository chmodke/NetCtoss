$(function() {
	loadlist();
	
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
					var accountData=result.data[i];
					var str='<tr>';
						str+='<td>'+accountData.accountId+'</td>';
						str+='<td><a href="account_detail.html">'+accountData.realName+'</a></td>'
						str+='<td>'+accountData.idcardNo+'</td>';
						str+='<td>'+accountData.loginName+'</td>';
						str+='<td>'+(accountData.status>0?'暂停':'开通')+'</td>';
						str+='<td>'+(new Date(accountData.creatime)).Format("yyyy-MM-dd")+'</td>';
						str+='<td>'+(new Date(accountData.lastLoginTime)).Format("yyyy-MM-dd hh:mm:ss")+'</td>';
						str+='<td class="td_modi"><input type="button" value="暂停" class="btn_pause" onclick="setState();" /> ';
						str+='<input type="button" value="修改" class="btn_modify" onclick="location.href="account_modi.html";" />';
						str+='<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />';
						str+='</td></tr>';
					$("#datalist tbody").append(str);
				}
				var pageConts=result.msg.split(":")[1];//获取到页数
				$("#pages").append('<a id="'+1+'" href="javascript:;">首页</a>');
				$("#pages").append('<a id="'+(p==1?1:(p-1))+'" href="javascript:;">上一页</a>');
				for(var j=pageConts;j>0;j--){
					if(p==j){
//						var $str1=$('<a id="'+j+'" class="current_page" href="javascript:;">'+j+'</a>');
						$("#pages a").eq(1).after('<a id="'+j+'" class="current_page" href="javascript:;">'+j+'</a>');
					}else{
//						var $str2=$('<a id="'+j+'" href="javascript:;">'+j+'</a>');
						$("#pages a").eq(1).after('<a id="'+j+'" href="javascript:;">'+j+'</a>');
					}
				}
				$("#pages").append('<a id="'+(p==pageConts?pageConts:(p-(-1)))+'" href="javascript:;">下一页</a>');
				$("#pages").append('<a id="'+pageConts+'" href="javascript:;">末页</a>');
			}
		},
		error : function() {
			alert("获取账务账户异常");
		},
		async : true
	});
}

//删除
function deleteAccount() {
	var r = window.confirm("确定要删除此账务账号吗？\r\n删除后将不能恢复，且会删除其下属的所有业务账号。");
	document.getElementById("operate_result_info").style.display = "block";
}
// 开通或暂停
function setState() {
	var r = window.confirm("确定要开通此账务账号吗？");
	document.getElementById("operate_result_info").style.display = "block";
}