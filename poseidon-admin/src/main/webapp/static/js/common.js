$(document).ready(function(){
	// 新增
	$('#add-button').click(function(e){
		var form = $("#add_form");
		form.submit();
	});
	
	// 批量删除
	$('#delete-button').click(function(e){
		var models = $("input[name='modelId']:checkbox:checked");
		if(!models.length){
			alert("删除至少选择一个");
			return false;
		}
		e.preventDefault();
		var form = $("#delete_form");
		var ids = "";
		// 拿出所有要删除的id
		$("input[name='modelId']:checkbox").each(function() { 
			//alert($(this).prop('checked'));
			if ($(this).prop('checked')){
				ids += ",";
				ids += $(this).val();
			}
		});
		// 去掉第一个逗号
		if (ids.length > 0) {
			ids = ids.substring(1, ids.length);
		}
		// 放到隐藏域里
		$('#delete_model_ids').val(ids);
		// 提交
		var r=confirm("您确定删除吗");
		if (r==true){
			//alert(ids);
			form.submit();
		} else{
			return;
		}
	});
	
	// 下载模板
	$('#download-template-button').click(function(e){
		var form = $("#download_template_form");
		form.submit();
	});
	
	// 导入
	$('#import-button').click(function(e){
		var file = $("#import-input");
		if(file.val()==null||file.val()==""){
			alert("请选择文件！");
			return;
		}
		if(!/.(xls)$/.test(file.val())&&!/.(xlsx)$/.test(file.val())){
	        alert("文件格式有误！");
	        return;
	    }
		var form = $("#import_form");
		form.submit();
	});
	
	// 导出
	$('#export-button').click(function(e){
		var form = $("#export_form");
		form.submit();
	});
	
	// 批量更新
	$('#submit_button').click(function(e){
		e.preventDefault();
		var form = $("#submit_form");
		var ids = "";
		// 拿出所有要更新的id
		$("input[name='check_id']:checkbox").each(function() { 
			//alert($(this).prop('checked'));
			if ($(this).prop('checked')){
				ids += ",";
				ids += $(this).val();
			}
		});
		// 去掉第一个逗号
		if (ids.length > 0) {
			ids = ids.substring(1, ids.length);
		}
		// 放到隐藏域里
		$('#hidden_ids').val(ids);
		// 提交
		var r=confirm("确定提交?");
		if (r==true){
			//alert(ids);
			form.submit();
		} else{
			return;
		}
    });
	
});


// 分页查询
function page(n,s){
	$("#pageNum").val(n);
	$("#pageSize").val(s);
	$("#search_form").submit();
	return false;
}