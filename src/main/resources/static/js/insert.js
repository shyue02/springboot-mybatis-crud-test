let isproductNameSameCheck = false;

$("#btnProductSameCheck").click(() => {
	checkProductName();
});// 리스너


function checkProductName() {
	let productName = $("#name").val();
	

	$.ajax("/api/product/productNameSameCheck?productName="+productName, {
		type: "GET",
		dataType: "json",
		async: true
	}).done((res) => {
		if (res.code == 1) { // 통신 성공
			if (res.data == false) {
				alert("상품명이 중복되지 않았습니다.");
				isproductNameSameCheck = true;
			} else {
				alert("상품명이 중복되었어요. 다른 상품명을 입력하세요.");
				isproductNameSameCheck = false;
				$("#name").val("");
			}
		}
	});
}
