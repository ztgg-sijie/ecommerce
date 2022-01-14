$(function() {
	var shopId = getQueryString('shopId');
	var shopInfoUrl = '/ecommerce/shopadmin/getshopmanagementinfo?shopId=' + shopId;
	$.getJSON(shopInfoUrl, function(data) {
		if (data.redirect) {
			alert('redirect triggered');
			window.location.href = data.url;
		} else {
			if (data.shopId != undefined && data.shopId != null) {
				shopId = data.shopId;
			}
			$('#shopInfo')
					.attr('href', '/ecommerce/shopadmin/shopoperation?shopId=' + shopId);
		}
	});
});