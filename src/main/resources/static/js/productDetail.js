/**
 * 제품 상세 페이지에서 사용하는 스크립트 
 */

function submitBuy() {
	let myForm = document.getElementById('prodForm');
	formData = new FormData(myForm);
	myForm.action="/order/purchase";
	fetch('/order/purchase', {
		method: 'post',
		body : formData
	});
	window.location.href="/order/purchase";
}

function submitCart() {
	let myForm = document.getElementById('prodForm');
	let formData = new FormData(myForm);
	myForm.action="/cart/list";
	fetch('/cart/addCart', {
		method: 'post',
		body : formData
	});
	window.location.href="/cart/list";
}
 