<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>가계부 입력</title>
<script type="text/javascript" src="/resources/js/write.js"></script>
</head>
<body>
	<h1>[ 가계부 입력 ]</h1>
	<form action="/moneybook/write" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>메모</td>
				<td>
					<input type="text" id="memo" name="moneybook_memo">
				</td>
			</tr>
			<tr>
				<td>분류</td>
				<td>
					<select name="moneybook_type">
						<option value="수입">수입</option>
						<option value="지출">지출</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>금액</td>
				<td>
					<input type="text" id="amount" name="moneybook_amount">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>