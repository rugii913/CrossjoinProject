<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 테일윈드 cdn -->
<script src="https://cdn.tailwindcss.com"></script>
<!-- common css, js -->
<link rel="stylesheet" href="/resource/common.css" />
<script src="/resource/common.js" defer="defer"></script>
<!-- 파비콘 -->
<link rel="shortcut icon" href="/resource/favicon.ico" />
</head>
<body>
	<nav id="nav" class="grid grid-cols-12 m-3 gap-x-3">
		<div class="col-start-2 col-span-3">
			<img src="/resource/logo.png" alt="로고" class="h-14">
		</div>
		<div class="col-start-7 text-center">
			<a id="boardId-0" href="#">함께 쓰기</a>
		</div>
		<div class="col-start-8 text-center">모임</div>
		<div class="col-start-9 text-center">강연</div>
		<div class="col-start-10 text-center">공간대여</div>
		<div class="col-start-11 text-center">회원</div>
	</nav>
	<div class="h-px bg-[#c1c56f]"></div>

	<section class="mt-8 text-l">
		<div class="container mx-auto px-3">
			<div class="table-box w-10/12 mx-auto">
				<div>게시물 개수: -개</div>
				
				<ul class="divide-y divide-amber-200">
					<li>
						<div class="flex gap-x-11 my-2 justify-around text-base">
							<div>번호</div>
							<div>작성자</div>
							<div>작성일</div>
						</div>
						<div class="font-semibold my-2">제목</div>
					</li>
					
					<c:forEach var="article" items="${articles }">
						<li>
							<div class="flex gap-x-11 my-2 justify-around text-base">
								<div>${article.id}</div>
								<div>${article.memberId}</div>
								<div>${article.regDate.substring(0,16)}</div>
							</div>
							<div class="font-semibold my-2">
								<a class="hover:underline" href="/article/${article.id }">${article.title}</a>
							</div>
						</li>
					</c:forEach>
					
				</ul>
				
			</div>
		</div>

		<div class="h-40">
			<!-- 스크롤 아래로 내리기 위한 빈 공간 -->
		</div>
	</section>

	<div id="background"></div>
</body>
</html>