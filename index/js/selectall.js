	var isCheckAl = 1;
	function selectall() {
		var a = document.all;
		if (isCheckAl == 1) {
			for (var i = 0; i < a.length; i++) {
				if (typeof a[i] != "undefind" && a[i].type == 'checkbox') {
					a[i].checked = true;
				}
			}
			isCheckAl = 0;
		}
		else {
			for (var i = 0; i < a.length; i++) {
				if (typeof a[i] != "undefind" && a[i].type == 'checkbox') {
					a[i].checked = false;
				}
			}
			isCheckAl = 1;
		}
	}