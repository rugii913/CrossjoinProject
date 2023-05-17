<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../../common/head.jspf"%>
<%@ include file="../../common/nav.jspf"%>



	<section class="mt-8 text-l">
		<div class="container mx-auto px-3">
		
			<div class="w-10/12 mx-auto">
			
				<header class="h-10">${articleData.title }</header>
				<div class="flex my-2 justify-around text-sm">
					<div>글번호: ${articleData.id }</div>
					<div>${articleData.regDate.substring(0,16) }</div>
					<div>${articleData.memberId }</div>
				</div>
				
				<div class="h-px bg-amber-200"></div>
				
				<article>
					<div class="my-2 min-h-[300px]">${articleData.body}</div>
				</article>
				
				<div class="h-px bg-amber-200"></div>

				<div class="flex justify-end gap-x-5">
					<div><a href="/article/${articleData.id }/modify">수정</a></div>
					<div><form action="/article/${articleData.id }/delete" method="post"><button>삭제</button></form></div>
					<div><a href="#">뒤로가기</a></div>
				</div>
			</div>
			
		</div>
	</section>

<%@ include file="../../common/footer.jspf"%>