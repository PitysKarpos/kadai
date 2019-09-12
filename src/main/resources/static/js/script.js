var head = document.getElementsByTagName("head");
var script = document.createElement("script");
script.setAttribute("src",
		"http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js");
script.setAttribute("type", "text/javascript");
$(function() {
	// ①submit()に関数をバインド
	$('form').submit(function() {
		// ②ダイアログを出していいえを選択したら…
		if (!confirm('送信しますか？')) {
			// 処理を中断
			return false;
		}
	});
});
$(function() {
	$('.radio').on('click', function() {
		$('.radio').removeClass('active');
		$(this).addClass('active');
	});
});
$(function() {
	$('.radio2').on('click', function() {
		$('.radio2').removeClass('active');
		$(this).addClass('active');
	});
});
$(function() {
	$('.radio3').on('click', function() {
		$('.radio3').removeClass('active');
		$(this).addClass('active');
	});
});

$(function() {
	$('#btn').on('click', function() {
		let isEmpty = false;
		jQuery('.form-control').each(function() {
			if (jQuery(this).val() === '') {
				alert('必須項目が入力されていません！');
				$(this).focus();
				isEmpty = true;
				return false;
			}
		});
		if (isEmpty)
			return false;
	});
});
document.head.appendChild(script);