//导航栏控制JS
$(document).ready(function(){
	$("#menu li").click(function(event){
		var aim=event.target.id;
		if(aim=='index'){
			location.href="../login/toIndex.do";
		}
		if(aim=='admin'){
			location.href="../admin/toList.do";
		}
		if(aim=='cost'){
			location.href="../cost/toList.do";
		}
		if(aim=='account'){
			location.href="../account/toList.do";
		}
		if(aim=='service'){
			location.href="../service/toList.do";
		}
		if(aim=='bill'){
			location.href="../bill/toList.do";
		}
	});
});