<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 수정</title>
<script type="text/javascript" src="/resources/js/update.js"></script>
</head>
<body>
	<h1>[ 가계부 수정 ] </h1>
	<form action="/moneybook/update" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>메모</td>
				<td>
					<input type="text" id="memo" name="moneybook_memo" value="${board.moneybook_memo }">
				</td>
			</tr>
			<tr>
				<td>분류</td>
				<td>
					<c:set var="type" value="${board.moneybook_type }" />
					<c:choose>
						<c:when test="${type eq '수입'}">
							<select name="moneybook_type">
								<option value="수입">수입</option>
								<option value="지출">지출</option>
							</select>
						</c:when>
						<c:otherwise>
							<select name="moneybook_type">
								<option value="지출">지출</option>
								<option value="수입">수입</option>
							</select>
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
			<tr>
				<td>금액</td>
				<td>
					<input type="text" id="amount" name="moneybook_amount" value="${board.moneybook_amount }">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="hidden" name="acc_id" value="${board.acc_id }">
					<input type="hidden" name="moneybook_no" value="${board.moneybook_no }">
					<input type="submit" value="수정하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>