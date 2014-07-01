objcaigoushangs = new Object();
objcaigoushangs = {
	caigoushangs : [  {
		caigoushang_id : '6',
		caigoushang_name : '金仕利 '
	}, {
		caigoushang_id : '8',
		caigoushang_name : '吴德生 '
	}, {
		caigoushang_id : '9',
		caigoushang_name : '新天空2'
	}, {
		caigoushang_id : '5',
		caigoushang_name : '邝雄辉'
	}, {
		caigoushang_id : '7',
		caigoushang_name : '张禄萍 '
	}, {
		caigoushang_id : '2',
		caigoushang_name : '王海芹'
	}, {
		caigoushang_id : '3',
		caigoushang_name : '王海林'
	}, {
		caigoushang_id : '4',
		caigoushang_name : '王海生'
	}, {
		caigoushang_id : '1',
		caigoushang_name : '新天空'
	}, {
		caigoushang_id : '10',
		caigoushang_name : '二连浩特'
	}, {
		caigoushang_id : '11',
		caigoushang_name : '中体国旅'
	}, ]
};

function initcaigoushangsdakehu(obj) {
	for ( var i = 0; i < objcaigoushangs.caigoushangs.length; i++) {
		obj.options[i] = new Option(
				objcaigoushangs.caigoushangs[i]['caigoushang_name'],
				objcaigoushangs.caigoushangs[i]['caigoushang_id']);
	}
}
