function formCheck(){
	var memo = document.getElementById("memo").value;
	var amount = document.getElementById("amount").value;
	if(memo.length == 0){
		alert("메모를 입력해주세요");
		return false;
	}
	
	if(amount.length == 0){
		alert("금액을 입력해주세요");
		return false;
	}

	return true; 
}