<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html >
<html>
<head>
<meta charset="utf-8">
<script>
	function fn_overlapped() {
		var _id = $("#_userid").val();
		if (_id == '') {
			alert("ID를 입력하세요");
			return;
		}
		$.ajax({
			type : "post",
			async : false,
			url : "${contextPath}/member/overlapped.do",
			dataType : "text",
			data : {
				id : _id
			},
			success : function(data, textStatus) {
				if (data == 'false') {
					alert("사용할 수 있는 ID입니다.");
					$('#btnOverlapped').prop("disabled", true);
					$('#_userid').prop("disabled", true);
					$('#userid').val(_id);
				} else {
					alert("사용할 수 없는 ID입니다.");
				}
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다.");
				ㅣ
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
			}
		}); //end ajax	 
	}
</script>
</head>
<body>
	<h3>필수입력사항</h3>
	<form action="${contextPath}/member/addMember.do" method="post">
		<div id="detail_table">
			<table>
				<tbody>
					<tr class="dot_line">
						<td class="fixed_join">아이디</td>
						<td><input type="text" name="_userid" id="_userid"
							size="20" /> <input type="hidden" name="userid"
							id="userid" /> <input type="button" id="btnOverlapped"
							value="중복체크" onClick="fn_overlapped()" /></td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">비밀번호</td>
						<td><input name="userpw" type="password" size="20" /></td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">이름</td>
						<td><input name="username" type="text" size="20" /></td>
					</tr>
					<tr class="dot_line">
						<td class="fixed_join">휴대폰번호</td>
						<td><select name="userphone">
								<option>없음</option>
								<option selected value="010">010</option>
								<option value="011">011</option>
								<option value="016">016</option>
								<option value="017">017</option>
								<option value="018">018</option>
								<option value="019">019</option>
						</select> - <input size="10px" type="text" name="hp2"> - <input
							size="10px" type="text" name="hp3"><br> <br> <input
							type="checkbox" name="smssts_yn" value="Y" checked /> 쇼핑몰에서 발송하는
							SMS 소식을 수신합니다.</td>
					</tr>
				</tbody>
			</table>
		</div>
		<div class="clear">
			<br>
			<br>
			<table align=center>
				<tr>
					<td><input type="submit" value="회원 가입"> <input
						type="reset" value="다시입력"></td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>