function formCheck(){	
	var acc_id = document.getElementById("id").value;
	var acc_pw = document.getElementById("pw").value;
	if(acc_id.length == 0){
		alert("아이디를 입력해주세요");
		return false;
	}
	
	if(acc_id.length < 3 || acc_id.length > 8){
		alert("아이디는 3~8글자로 입력해주세요");
		return false;
	}
	
	if(acc_pw.length == 0){
		alert("비밀번호를 입력해주세요");
		return false;
	}
	
	if(acc_pw.length < 5 || acc_pw.length > 10){
		alert("비밀번호는 5~10글자로 입력해주세요");
		return false;
	}

	return true; 
}