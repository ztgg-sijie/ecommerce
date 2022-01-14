$(function() {

	var initUrl = '/ecommerce/shopadmin/getshopinitinfo'
	var addShopCategoryUrl = '/ecommerce/shopadmin/addshopcategory'
	
	
	getShopCategoryList()
	alert('js triggered')
	
	// 1. get shop_category list from DB
	function getShopCategoryList() {
		$.getJSON(initUrl, function(data) {
			if (data.success) {
				var tempShopCategoryHtml = '';

				data.shopCategoryList.map(function(item, index) {
					tempShopCategoryHtml += '<option data-id="' + item.shopCategoryId
							+ '">' + item.shopCategoryName + '</option>';
				});
				$('#shop-category').html(tempShopCategoryHtml);
			}
		});
	}
	
	// 2. call controller and register a shop category when submitted
	$('#submit').click(function() {
	
		var shopCategory = {};
		
		shopCategory.shopCategoryName = $('#shop-category-name').val();
		shopCategory.shopCategoryDesc = $('#shop-category-desc').val();
		shopCategory.priority = $('#shop-category-priority').val();
		// shopCategory.parent = $('#shop-category-parent').val();
		
		var formData = new FormData();
		formData.append('shopCategoryStr', JSON.stringify(shopCategory));
		
		alert(JSON.stringify(shopCategory))
		
		// call backend controller
		$.ajax({
			url : addShopCategoryUrl,
			type : 'POST',
			data : formData,
			contentType : false,
			processData : false,
			cache : false,
			success : function(data) {
				if (data.success) {
					$.toast('Success！');
				} else {
					alert('Fail！' + data.errMsg);
				}
		
			}
		});
	});
})