<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부</title>
<script type="text/javascript" src="/resources/js/jquery-3.4.1.js"></script>
<script type="text/javascript" src="/resources/js/moneybook.js"></script>
<script type="text/javascript">
function totalIncome(){
	$.ajax({
		url:"/moneybook/totalIncome"
       	,success:function(data){
              	console.log("컨트롤러에서 보낸 데이터: " + data);
              	$("#totalInOut").val(data);
       	}
	});
}

function totalExpense(){
	$.ajax({
		url:"/moneybook/totalExpense"
       	,success:function(data){
              	console.log("컨트롤러에서 보낸 데이터: " + data);
              	$("#totalInOut").val(data);
       	}
	});
}

function getmax(){
	$.ajax({
		url:"/moneybook/max"
       	,success:function(data){
              	console.log("컨트롤러에서 보낸 데이터: " + data);
              	$("#minmax").val(data);
       	}
	});
}

function getmin(){
	$.ajax({
		url:"/moneybook/min"
       	,success:function(data){
              	console.log("컨트롤러에서 보낸 데이터: " + data);
              	$("#minmax").val(data);
       	}
	});
}
</script>
</head>
<body>
	<h1>[ 가계부 ]</h1>
		<!-- 가계부 테이블 -->
		<table border ="1">
			<tr>
				<th>번호</th>
				<th>메모</th>
				<th>종류</th>
				<th>금액</th>
				<th>작성일</th>
				<th></th>
				<th></th>
			</tr>
			<c:set var="size" value="${fn:length(board)}" />
			<c:if test="${size eq 0 }">
			<tr>
				<td colspan="7">등록된 데이터가 없습니다.</td>
			</tr>
			</c:if>
			<c:if test="${size > 0 }">
			<c:forEach items="${board }" var="board">
			<c:set var="i" value="${i+1 }" />
				<tr>
					<td>${i }</td>
					<td>${board.moneybook_memo }</td>
					<td>${board.moneybook_type }</td>
					<td>${board.moneybook_amount }</td>
					<td>${board.moneybook_indate }</td>
					<%-- <td>${board.moneybook_indate2 }</td> --%>
					<td>
						<input type="button" value="수정" onclick="location.href='/moneybook/update?moneybook_no=${board.moneybook_no}';">
					</td>
					<td>
						<input type="button" value="삭제" onclick="location.href='/moneybook/delete?moneybook_no=${board.moneybook_no}';">
					</td>
				</tr>
			</c:forEach>
			</c:if>
		</table>
		<input type="button" value="가계부 작성" onclick="location.href='/moneybook/write';">
		<br><br>
		<form action="/moneybook/search" method="get" onsubmit="return formCheck();">
			<select name="condition">
				<option value="전체">전체</option>
				<option value="수입">수입</option>
				<option value="지출">지출</option>
			</select>
			<input type="text" id="searchbar" name="searchWord" placeholder ="검색어 입력">
			<input type="submit" value="검색">
			<input type="hidden" id="acc_id" name="acc_id" value="${sessionScope.loginid}">
		</form>
		<br>
		<input type="button" value="총 수입 구하기" onclick="totalIncome();">
		<input type="button" value="총 지출 구하기" onclick="totalExpense();">
		<input type="text" id="totalInOut" value="" placeholder ="총 수입 또는 지출" readonly="readonly">
		<br><br>
		<input type="button" value="최소 금액 구하기" onclick="getmin();">
		<input type="button" value="최대 금액 구하기" onclick="getmax();">
		<input type="text" id="minmax" value="" placeholder ="최소 또는 최대 금액" readonly="readonly">
</body>
</html>