<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jspf"%>
<%@ include file="../common/nav.jspf"%>



<div class="h-10"><!-- 임시 빈 공간 --></div>

<!-- <article class="gathering relative left-[5%] text-white z-50">
	<div class="w-full">
		<img src="/resource/gatheringImg/gathering1.png" alt="" class="object-contain w-[20%]" />
	</div>
	<div>
		<div>마감임박</div>
		<div>모임 이름</div>
		<div>모임 설명</div>
		<div>모임 일정</div>
	</div>
</article> -->

<article class="gathering">
	<div class="w-full">
		<img src="/resource/gatheringImg/gathering1.png" alt=""  class="object-contain" />
	</div>
	<div>
		<div>진행 중</div>
		<div>모임 １</div>
		<div>어쩌구 독서 모임</div>
		<div>2023-01-01 ~ 2023-12-31</div>
	</div>
</article>

<script type="text/javascript">
	let gatherings = document.body.querySelectorAll('.gathering');
	
	gatherings.forEach(gathering => {
		gathering.addEventListener('click', function() {
			setModalBg();
			let gatheringImg = gathering.querySelector('img');
			gatheringTransition(gathering);
		})
	});
	
	function setModalBg() {
		let modalBg = document.createElement('div');
		modalBg.setAttribute('class', 'w-screen h-screen bg-black fixed z-40 top-0 left-0 opacity-60 modal-bg');
		document.body.appendChild(modalBg);
		
		modalBg.addEventListener('click', function() {
			document.body.removeChild(modalBg);
		})
	}
	
	function gatheringTransition(gathering) {
		gathering.classList.add('fixed');
	}
	
	function memberJoinBtnInit() {
		
		const memberJoinForm = document.querySelector('#member-join-form');
		
		const memberJoinBtn = document.querySelector('#member-join-btn');
		
		let modalBg = document.createElement('div');
		modalBg.setAttribute('class', 'w-screen h-screen bg-black fixed z-40 top-0 left-0 opacity-60 modal-bg');
		
		let container = document.createElement('div');
		let memberJoinFormDiv = document.querySelector('#member-join-form-div'); //jspf 파일로 포함된 join.jspf의 member-join-form-div을 변수로 지정
		let closeBtn = document.querySelector('.close-btn')
		
		container.setAttribute('class', 'flex justify-center modal-container');
		
		memberJoinBtn.addEventListener('click', ()=>{
			document.body.appendChild(modalBg);
			document.body.appendChild(container);
			container.appendChild(memberJoinFormDiv);
			memberJoinFormDiv.setAttribute('class', 'h-[600px] w-[450px] top-[10%] mx-auto bg-white rounded-lg fixed z-50 flex flex-col');
			
		})
			
		modalBg.addEventListener('click', ()=>{
			document.body.removeChild(modalBg);
		    document.body.removeChild(container);
		})
		
		closeBtn.addEventListener('click', ()=>{
			document.body.removeChild(modalBg);
		    document.body.removeChild(container);
		})
	} 
</script>



<%@ include file="../common/footer.jspf"%>
