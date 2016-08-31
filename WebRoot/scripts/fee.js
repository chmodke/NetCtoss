$(function() {
	loadlist();
	
	$("#pages").on("click","a",function(event){
		event.stopPropagation();
//		alert(event.target.id);
		loadlist(event.target.id);
	});
});

// 排序按钮的点击事件
function sort(btnObj) {
	if (btnObj.className == "sort_desc")
		btnObj.className = "sort_asc";
	else
		btnObj.className = "sort_desc";
}

// 启用
function startFee() {
	var r = window.confirm("确定要启用此资费吗？资费启用后将不能修改和删除。");
	document.getElementById("operate_result_info").style.display = "block";
}
// 删除
function deleteFee() {
	var r = window.confirm("确定要删除此资费吗？");
	document.getElementById("operate_result_info").style.display = "block";
}
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
					var costData=result.data[i];
					var str='<tr>';
						str+='<td>'+costData.costId+'</td>';
						str+='<td><a href="fee_detail.html?costId='+costData.costId+'">'+costData.name+'</a></td>';
						str+='<td>'+costData.baseDuration+' 小时</td>';
						str+='<td>'+costData.baseCost+' 元</td>';
						str+='<td>'+costData.unitCost+' 元/小时</td>';
						str+='<td>'+(new Date(costData.creatime)).Format("yyyy-MM-dd hh:mm:ss")+'</td>';
						str+='<td>'+(new Date(costData.startime)).Format("yyyy-MM-dd hh:mm:ss")+'</td>';
						str+='<td class="width50">'+(costData.status>0?'暂停':'开通')+'</td>';
						str+='<td class="width200">';
						str+='<input type="button" value="启用" class="btn_start" onclick="startFee();" />';
						str+='<input type="button" value="修改" class="btn_modify" onclick="location.href="fee_modi.html";" />';
						str+='<input type="button" value="删除" class="btn_delete" onclick="deleteFee();" />';
						str+='</td>';
						str+='</tr>';
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
			alert("获取资费异常");
		},
		async : true
	});
}