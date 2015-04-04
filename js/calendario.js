$('#data_1').focus(function(){
	$(this).calendario({
		target:'#data_1'
	});
});

$('#data_2').focus(function(){
	$(this).calendario({
		target:'data_2',
		top:0,
		left:130
	});
});

$('#data_3').focus(function(){
	$(this).calendario({
		target:'data_3',
		closeClick:false
	});
});