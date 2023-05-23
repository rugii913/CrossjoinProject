<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/head.jspf"%>
<%@ include file="../../common/nav.jspf"%>
	


	<section class="mt-8">
		<div class="container mx-auto px-3">
			<div class="w-10/12 mx-auto">
				
				<ul class="divide-y divide-amber-200">
					<c:forEach var="articleData" items="${articles }">
						<li>
							<div class="flex gap-x-11 my-2 justify-around text-base">
								<div>${articleData.id}</div>
								<div>${articleData.memberNickname}</div>
								<div>${articleData.regDate.substring(0,16)}</div>
							</div>
							<div class="font-semibold my-2">
								<a class="hover:underline" href="/article/general/${articleData.id }">${articleData.title}</a>
							</div>
						</li>
					</c:forEach>
				</ul>
				
				<div class="h-px bg-amber-200"><!-- 목록 하단 구분선 --></div>
				
				<!-- 버튼 -->
				<div class="flex justify-end">
					<div class="mr-2"><a class="hover:underline" href="/article/general/write">글쓰기</a></div>
				</div>
				
				<!-- 페이지 -->
				<div class="flex justify-center gap-4">
					<span>
						<a href="?page=1"> &lt;&lt; </a>
					</span>
					<c:forEach begin="${startPage }" end="${endPage }" var="i">
						<a ${page == i ? 'class="text-pink-700"':'' } href="?page=${i }">${i }</a>
					</c:forEach>
					<span>
						<a href="?page=${pagesCount }"> &gt;&gt; </a>
					</span>
				</div>

		</div>
		</div>
	</section>
	
	
	
<%@ include file="../../common/footer.jspf"%>