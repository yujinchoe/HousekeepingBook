function formCheck(){
	var searchbar = document.getElementById("searchbar").value;
	if(searchbar.length == 0){
		alert("검색어를 입력해주세요");
		return false;
	}

	return true; 
}