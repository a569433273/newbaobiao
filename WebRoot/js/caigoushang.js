objcaigoushangs = new Object();
objcaigoushangs = {
	caigoushangs : [  {
		caigoushang_id : '6',
		caigoushang_name : '������ '
	}, {
		caigoushang_id : '8',
		caigoushang_name : '����� '
	}, {
		caigoushang_id : '9',
		caigoushang_name : '�����2'
	}, {
		caigoushang_id : '5',
		caigoushang_name : '���ۻ�'
	}, {
		caigoushang_id : '7',
		caigoushang_name : '��»Ƽ '
	}, {
		caigoushang_id : '2',
		caigoushang_name : '������'
	}, {
		caigoushang_id : '3',
		caigoushang_name : '������'
	}, {
		caigoushang_id : '4',
		caigoushang_name : '������'
	}, {
		caigoushang_id : '1',
		caigoushang_name : '�����'
	}, {
		caigoushang_id : '10',
		caigoushang_name : '��������'
	}, {
		caigoushang_id : '11',
		caigoushang_name : '�������'
	}, ]
};

function initcaigoushangsdakehu(obj) {
	for ( var i = 0; i < objcaigoushangs.caigoushangs.length; i++) {
		obj.options[i] = new Option(
				objcaigoushangs.caigoushangs[i]['caigoushang_name'],
				objcaigoushangs.caigoushangs[i]['caigoushang_id']);
	}
}
