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
					var serviceData=result.data[i];
					var str='<tr>';
					 	str+='<td><a href="service_detail.html" title="查看明细">'+serviceData.serviceId+'</a></td>';
					 	str+='<td>'+serviceData.accountId+'</td>';
					 	str+='<td>'+'IDCard'+'</td>';
					 	str+='<td>'+'realName'+'</td>';
					 	str+='<td>'+serviceData.osUsername+'</td>';
						 	var temp='';
						 	if(serviceData.status=='0'){
						 		temp='开通'
						 	}
						 	if(serviceData.status=='1'){
						 		temp='暂停'
						 	}
						 	if(serviceData.status=='2'){
						 		temp='删除'
						 	}
					 	str+='<td>'+temp+'</td>';
					 	str+='<td>'+serviceData.unixHost+'</td>';
					 	str+='<td>';
					 	str+='<a class="summary" onmouseover="showDetail(true,this);" onmouseout="showDetail(false,this);">包 20 小时</a> <!--浮动的详细信息-->';
					 	str+='<div class="detail_info">20小时，24.5 元，超出部分 0.03元/分钟</div>';
					 	str+='</td>';
					 	str+='<td class="td_modi">';
						str+='<input type="button" value="暂停" class="btn_pause" onclick="setState();" />';
						str+='<input type="button" value="修改" class="btn_modify" onclick="location.href="service_modi.html";" />';
						str+='<input type="button" value="删除" class="btn_delete" onclick="deleteAccount();" />';
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
			alert("获取业务账户异常");
		},
		async : true
	});
}

//显示角色详细信息
function showDetail(flag, a) {
    var detailDiv = a.parentNode.getElementsByTagName("div")[0];
    if (flag) {
        detailDiv.style.display = "block";
    }
    else
        detailDiv.style.display = "none";
}
//删除
function deleteAccount() {
    var r = window.confirm("确定要删除此业务账号吗？删除后将不能恢复。");
    document.getElementById("operate_result_info").style.display = "block";
}
//开通或暂停
function setState() {
    var r = window.confirm("确定要开通此业务账号吗？");
    document.getElementById("operate_result_info").style.display = "block";
}