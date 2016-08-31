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
					var billData=result.data[i];
					var str='<tr>';
						str+='<td>'+billData.billId+'</td>';
						str+='<td>'+'Name'+'</td>';
						str+='<td>'+'IDCard'+'</td>';
						str+='<td>'+billData.accountId+'</td>';
						str+='<td>'+billData.cost+'</td>';
						str+='<td>'+(new Date().Format("yyyy年"))+billData.billMonth+'月</td>';
						var temp='';
						if(billData.paymentMode=='0'){
							temp='现金';
						}
						if(billData.paymentMode=='1'){
							temp='银行转账';
						}
						if(billData.paymentMode=='2'){
							temp='邮局汇款';
						}
						if(billData.paymentMode=='3'){
							temp='其他';
						}
						str+='<td>'+temp+'</td>';
						str+='<td>'+(billData.payState=="0"?"未支付":"支付")+'</td>';
						str+='<td><a href="bill_item.html" title="账单明细">明细</a>';
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
//写入下拉框中的年份和月份
function initialYearAndMonth() {
	// 写入最近3年
	var yearObj = document.getElementById("selYears");
	var year = (new Date()).getFullYear();
	for (var i = 0; i <= 2; i++) {
		var opObj = new Option(year - i, year - i);
		yearObj.options[i] = opObj;
	}
	// 写入 12 月
	var monthObj = document.getElementById("selMonths");
	var opObj = new Option("全部", "全部");
	monthObj.options[0] = opObj;
	for (var i = 1; i <= 12; i++) {
		var opObj = new Option(i, i);
		monthObj.options[i] = opObj;
	}
}