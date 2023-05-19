document.addEventListener("DOMContentLoaded", function(){
	memberBtnInit();
})

function memberBtnInit() {
	const memberBtn = document.querySelector('#member-btn');
	const memberMenu = document.querySelector('#member-menu');
	memberBtn.addEventListener('click', function() {
		memberMenu.setAttribute("class","w-[200px] bg-white rounded absolute z-10 right-0 top-0 -translate-y-[10px] translate-x-[10px] py-4 px-6");
	})
}