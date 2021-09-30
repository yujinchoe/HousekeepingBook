<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="/resources/js/join.js"></script>
</head>
<body>
	<h1>[ 회원 가입 ]</h1>
	<form action="/account/join" method="post" onsubmit="return formCheck();">
		<table>
			<tr>
				<td>아이디</td>
				<td>
					<input type="text" id="id" name="acc_id">
				</td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td>
					<input type="password" id="pw" name="acc_pw">
				</td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td>
					<input type="password" id="pwCheck">
				</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" id="name" name="acc_nm">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="가입하기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>