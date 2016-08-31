$(document).ready(function(){
	$("#menu li").click(function(event){
		var aim=event.target.id;
		if(aim=='index'){
			location.href="../login/toIndex.do";
		}
		if(aim=='cost'){
			location.href="../cost/toList.do";
		}
		if(aim=='account'){
			location.href="../account/toList.do";
		}
	});
});
