function goPage(pageNum) {
	var obj = document.forms["pagingForm"];
	obj.pageNum.value = pageNum;
	obj.submit();
}