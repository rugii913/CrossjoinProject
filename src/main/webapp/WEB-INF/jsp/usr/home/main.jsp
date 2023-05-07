<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Cross Join - Home</title>

<!-- 테일윈드 cdn -->
<script src="https://cdn.tailwindcss.com"></script>
<!-- common css, js -->
<link rel="stylesheet" href="/resource/common.css" />
<script src="/resource/common.js" defer="defer"></script>
<!-- 파비콘 -->
<!-- <link rel="shortcut icon" href="/resource/favicon.ico" /> -->
</head>

<body>
	<nav id="nav" class="grid grid-cols-12 m-4 gap-x-3">
		<div class="col-start-2">로고</div>
		<div class="col-start-7">메뉴아이템1</div>
		<div class="col-start-8">메뉴아이템2</div>
		<div class="col-start-9">메뉴아이템3</div>
		<div class="col-start-10">메뉴아이템4</div>
		<div class="col-start-11">메뉴아이템5</div>
	</nav>
	<div class="h-px bg-[#c1c56f]"></div>
	<section class="grid grid-cols-12 py-10">
		<article class="col-start-2 col-span-4">강연회 포스터<div class="w-40 h-40 bg-[#c6cd7d] mx-auto"></div></article>
		<article class="col-start-7 col-span-4">동네서점 바로대출<div class="w-40 h-40 bg-[#c6cd7d] mx-auto"></div></article>
	</section>
	<div id="background"></div>
</body>

</html>