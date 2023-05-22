<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/head.jspf"%>
<%@ include file="../common/nav.jspf"%>


<div class="h-24">
	<!-- 빈 공간 -->
</div>


<section id="schedule" class="mx-auto w-10/12 bg-white">

	<div class="col-span-7 flex justify-center gap-10 h-10">
		<div>
			<button type="button" class="go-prev">&lt;</button>
		</div>
		<div class="current-year-month"></div>
		<div>
			<button type="button" class="go-next">&gt;</button>	
		</div>
	</div>

	<div class="days grid grid-cols-7">
		<div class="day text-center h-10">월</div>
		<div class="day text-center h-10">화</div>
		<div class="day text-center h-10">수</div>
		<div class="day text-center h-10">목</div>
		<div class="day text-center h-10">금</div>
		<div class="day text-center h-10">토</div>
		<div class="day text-center h-10">일</div>
	</div>
	<div class="dates grid grid-cols-7"></div>

</section>


<script type="text/javascript">
		document.addEventListener("DOMContentLoaded", function(){
			scheduleInit();
		})
		
		/*
			달력 렌더링할 때 필요한 정보 목록
			- 현재 월(초기값: 현재 시간)
			- 이번 달 마지막일 날짜와 요일
			- 이전 달 마지막일 날짜와 요일
		*/
		function scheduleInit() {
			// 날짜 정보 가져오기
			let date = new Date(); //현재 날짜(로컬 기준) 가져오기
			let utc = date.getTime() + (date.getTimezoneOffset() * 60 * 1000); //utc 표준 시 도출
			let kstGap = 9 * 60 * 60 * 1000; //한국 kst 기준시간 더하기
			let today = new Date(utc + kstGap); //한국 시간으로 date 객체 만들기(오늘)

			let initialYear = today.getFullYear();
			let initialMonth = today.getMonth();
			let initailDate = today.getDate();
		
			let currentYear = initialYear; //달력에 표시되는 연도
			let currentMonth = initialMonth; //달력에 표시되는 연도 *getMonth()는 0~11을 반환(1씩 작음에 유의)
			let currentDate = initailDate; //달력에 표시되는 일
		
			renderSchedule(currentYear, currentMonth);
			 
			function renderSchedule(currentYear, currentMonth) {
				
				//이전 달의 마지막 날 날짜와 요일 구하기
				let prevMonthLastDate = new Date(currentYear, currentMonth, 0); //new Date(~~~) 파라미터 중 day=0이면 전달 마지막 날짜를 가리킴
				let prevDate = prevMonthLastDate.getDate();
				let prevDay = prevMonthLastDate.getDay(); //getDay()는 일~토 0~6을 반환
				
				//이번 달의 마지막 날 날짜와 요일 구하기
				let currentMonthLastDate = new Date(currentYear, currentMonth + 1, 0);
				let nextDate = currentMonthLastDate.getDate();
				let nextDay = currentMonthLastDate.getDay();
				
				//현재 월 렌더링
				document.querySelector('.current-year-month').textContent = currentYear + '.' + (currentMonth + 1);
				
				//렌더링 html 요소 생성
				let schedule = document.querySelector('.dates')
				schedule.innerHTML = ' ';
				
				//이전 달
				for (let i = prevDate - prevDay + 1; i <= prevDate; i ++) {
					//prevDay = 3 -> 수요일이고, prevDate = 31이라면
					//prevDate-prevDay+1 = 29 -> 월 화 수 - 29 30 31 렌더링
					schedule.innerHTML = schedule.innerHTML + '<div class="min-h-[150px] text-gray-300 ">' + i + '</div>';
				}
				//이번 달
				for (let i = 1; i <= nextDate; i++) {
					schedule.innerHTML = schedule.innerHTML + '<div class="min-h-[150px]">' + i + '</div>';
				}
				//다음 달
				for (let i = 1; i <= (7 - nextDay == 7 ? 0 : 7 - nextDay); i++) {
					schedule.innerHTML = schedule.innerHTML + '<div class="min-h-[150px] text-gray-300 	">' + i + '</div>';
				}
				
			 }
			 
			 //이전 달로 이동
			 document.querySelector('.go-prev').addEventListener('click', function() {
				if (currentMonth == 0) {
					currentYear = --currentYear;
					currentMonth = 11;
					renderSchedule(currentYear, currentMonth);
				} else {
					renderSchedule(currentYear, --currentMonth);
				}
			 });
			 //다음 달로 이동
			 document.querySelector('.go-next').addEventListener('click', function() {
				if (currentMonth == 11) {
					currentYear = ++currentYear;
					currentMonth = 0;
					renderSchedule(currentYear, currentMonth);
				} else {
					renderSchedule(currentYear, ++currentMonth);
				}
			 });
			
		}
</script>


<%@ include file="../common/footer.jspf"%>
