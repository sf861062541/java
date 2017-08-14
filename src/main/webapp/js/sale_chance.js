function formatState(value, row, index) {
	
//	JSON.parse(json字符串); eval
//	console.log(value + '----' + JSON.stringify(row) + '---' + index);
	if(value == null) {
		return '未知';
	} else if (value == 0) {
		return '未分配';
	} else if (value == 1) {
		return '已分配';
	}
}

function searchSaleChance() {
	var customerName = $("#s_customerName").val();
	var overview = $("#s_overview").val();
	var createMan = $("#s_createMan").val();
	var state = $("#s_state").combobox('getValue');
	
	$('#dg').datagrid('reload',{
		customerName: customerName,
		overview: overview,
		createMan: createMan,
		state: state
	});
}

function openSaleChanceAddDialog(){
	$("#fm").form("clear");
	$('#dlg').dialog("open").dialog('setTitle', '添加');
}

function openSaleChanceModifyDialog(){
	var gs=$('#dg').datagrid("getSelections");    
	if(gs.length!=1){
		$.messager.alert('警告','请选择一条记录');
		return;
	}
	$('#fm').form('load',gs[0]);
	$("#dlg").dialog("open").dialog('setTitle', '修改');
}

/**
 * 添加或更新按钮提交
 */
function saveSaleChance(){
	/*var v1=$("#customerId").combobox("getValue")*/
	var customerName=$("#customerId").combobox("getText");
	var customerId=$("#customerId").combobox("getValue");
	$("#customerName").val(customerName);
	if(customerName==null||$.trim(customerName).length==0){
		$.messager.alert('警告','请选择客户名称');
		return;
	}
	var id=$("#id").val();
	if(id==null||id==""){
		addSaleChance();
	}else{
		updateSaleChance();
	}
}
function updateSaleChance(){
	$('#fm').form('submit', {
		url: "update",
		onSubmit: function(){
			return isValid = $(this).form('validate');
		},
		success: function(data){
			data = JSON.parse(data);
			$.messager.confirm('确认对话框', '您确定要提交么？', function(r){
				if (r){
					if(data.code==200){
						$.messager.alert('提示',data.msg);
						$("#dlg").dialog("close");
						$("#fm").form("clear");
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('提示',data.msg);
					}
				}
			});
		}
	});
}
function addSaleChance(){
	$('#fm').form('submit', {
		url: "add",
		onSubmit: function(){
			return isValid = $(this).form('validate');
		},
		success: function(data){
			data = JSON.parse(data);
			$.messager.confirm('确认对话框', '您确定要提交么？', function(r){
				if (r){
					if(data.code==200){
						$.messager.alert('提示',data.msg);
						$("#dlg").dialog("close");
						$("#fm").form("clear");
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('提示',data.msg);
					}
				}
			});
		}
	});
}

/**
 * 删除
 */
function deleteSaleChance(){
	var ids=[];
	var gs=$("#dg").datagrid("getSelections");
	if(gs.length>0){
		for(var i=0;i<gs.length;i++){
			ids.push(gs[i].id);
		}
	}else{
		$.messager.alert('提示',"请选择至少一条记录");
	}
	$.messager.confirm('确认对话框', '您确定要删除么？', function(r){
		if (r){
			$.ajax({
				type:"post",
				url:"delete",
				data:"ids="+ids.join(","),
				dataType:"json",
				success:function(data){
					if(data.code==200){
						$.messager.alert('提示',data.msg);
						$('#dg').datagrid('reload');
					}else{
						$.messager.alert('提示',data.msg);
					}
				}
			})
		}
	});
}

/**
 * 更新
 */


function closeSaleChanceDialog(){
	$("#dlg").dialog("close");
	$("#fm").form("clear");
}

