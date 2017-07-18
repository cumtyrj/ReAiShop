$(document).ready(function(){
	if($.cookie("rmbUser")=="true"){
		$("#ck_rmbUser").attr("checked",true);
		$("#loginname").val($.cookie("lgn"));
		$("#password").val($.cookie("psw"));
	}
});

function Save(){
	if($("#ck_rmbUser").attr("checked")){
		var str_loginname=$("#loginname").val();
		var str_password=$("#password").val();
		$.cookie("rmbUser","true",{expires:7});
		$.cookie("lgn",str_loginname,{expires:7});
		$.cookie("psw",str_password,{expires:7});
	}else{
		$.cookie("rmbUser","false",{expires:-1});
		$.cookie("lgn","",{expires:-1});
		$.cookie("psw","",{expires:-1});
	}
};
