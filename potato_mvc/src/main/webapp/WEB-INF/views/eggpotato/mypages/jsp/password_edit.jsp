<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" info=""%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 수정</title>
<link rel="shortcut icon"  href="css/images/logo.png"/>
<link rel="stylesheet" type="text/css" href="css/common/reset.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_wrap_container.css"/>
<link rel="stylesheet" type="text/css" href="css/common/user_navi.css"/><%-- 네비바 필요한 사람만 --%>
<link rel="stylesheet" type="text/css" href="css/mypages/password_edit.css"/>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">

<c:if test="${updateCnt eq 1}">
alert("비밀번호가 변경되었습니다. 다시 로그인해주세요.");
location.href="login_page.do";
</c:if>

<c:if test="${updateCnt eq 0}">
alert("비밀번호를 다시 확인해주세요.");
location.href="password_edit.do";
</c:if>

$(function() {
	$(".pw_edit_form_btn").click(function() {
		//현재 비밀번호 유효성 검사
		
		//새 비밀번호 유효성 검사
		newPw=$("#new_pw").val();
		newPwChk=$("#newPwChk").val();
		
		if(newPw !=newPwChk){
			alert("신규 비밀번호와 신규 비밀번호 확인이 일치하지 않습니다.");
			return;
		}
		$("#passEditFrm").submit();
		confirm("비밀번호가 수정되었습니다.")
	});//click
});//ready
</script>

</head>
<body>
<div class="wrap">

<!-- header -->
<%@ include file="../../common/jsp/user_header.jsp" %>
<!-- header end-->

<!-- container -->
<div class="container">

	<%-- 마이페이지용 --%>
<div class="wrap-navi">
		<div class="navi">
			<div class="profileWrap">
				<div class="img">
					<img src="http://localhost/potato/css/images/${ img }"   id="profileImg" name="profileImg" class="img" style="margin: 5px 30px; width: 150px; height: 150px; background: #f8edeb; border-radius: 50%;">
				</div>
				<div class="nickname"><c:out value="${ nick }"/></div>
			</div>			
			<a class="navi-link" href="my_info_edit.do">내 정보 수정</a>
			<a class="navi-link2" href="password_edit.do">비밀번호 수정</a>
			<a class="navi-link2" href="unregister.do">회원탈퇴</a>
			<a class="navi-link" href="my_review.do">내가 쓴 리뷰</a>
			<a class="navi-link" href="like_review.do">좋아요한 리뷰</a>
			<a class="navi-link" href="bookmark.do">휴게소 즐겨찾기</a>
		</div><!-- navi -->
	

<%-- 네비바 끝 --%>
<!-- 작업 시작 -->
<div class="pw_edit_wrap">
<div class="pw_edit_title">비밀번호 수정</div> 
<form action="password_edit_process.do" id="passEditFrm" method="get">
	<div class="pw_edit_form">
		<table>
			<tr>
				<th><label for="password">현재 비밀번호</label></th>
				<td>
					<input type="password" id="pass"  name="pass"  placeholder="비밀번호를 입력해주세요." class="pw">
				</td>
			</tr>
			<tr>
				<th><label for="password">신규 비밀번호</label></th>
				<td>
					<input type="password" id="new_pw" name="new_pw"  placeholder="비밀번호를 입력해주세요." class="pw">
					<span class="txt">* 비밀번호는 *8~20자의 영문,숫자,특수문자를 혼합하여 입력해주세요.</span>
				</td>
			</tr>
			<tr>
				<th><label for="password">신규 비밀번호 확인</label></th>
				<td>
					<input type="password" id="newPwChk"  name="newPwChk" placeholder="비밀번호를 입력해주세요." class="pw">
				</td>
			</tr>
		</table>
	</div><!-- pw_edit_form -->
	</form>
	<button class="pw_edit_form_btn">확인</button>

</div><!-- wrap-navi -->

</div><!-- container 건들면 안됩니다....! -->
</div>
<!-- container end -->

<!-- footer -->
<%@ include file="../../common/jsp/user_footer.jsp" %>
<!-- footer end -->

</div><!-- wrap -->
</body>
</html>