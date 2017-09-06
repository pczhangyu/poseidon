<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<%-- JS--%>
<section class="content-header">
	<h1> ${parentName} <small>${targetName}</small> </h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> ${parentName}</a></li>
		<li class="active">${targetName}</li>
	</ol>
</section>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/jqgrid/css/ui.jqgrid-bootstrap.css" />
<script>
	$.jgrid.defaults.width = $(window).width()*0.80;
	$.jgrid.defaults.responsive = true;
	$.jgrid.defaults.styleUI = 'Bootstrap';
</script>
<script type="text/javascript">
	$(document).ready(function () {
		$("#jqGrid").jqGrid({
			colModel: [{
				label: 'addressId',
				name: 'addressId',
				key:true,
				hidden:true
			},{
				label: '地址名称',
				name: 'addressName',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: '省份',
				name: 'provinceCode',
				hidden:true
			},{
				label: '省份',
				name: 'provinceName',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: '城市',
				name: 'cityCode',
				hidden:true
			},{
				label: '城市',
				name: 'cityName',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: '区县',
				name: 'countyCode',
				hidden:true
			},{
				label: '区县',
				name: 'countyName',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: '街道',
				name: 'street',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: '详细',
				name: 'detail',
				editable: true,
				edittype: "text",
				width: 25
			},{
				label: 'createTime',
				name: 'createTime',
				hidden:true
			},{
				label: 'isUsed',
				name: 'isUsed',
				hidden:true
			},{
				label: 'isDelete',
				name: 'isDelete',
				hidden:true
			}],
			addCaption: "Add Record",
			editCaption: "Edit Record",
			viewrecords: true, // show the current page, data rang and total records on the toolbar
			width: $(window).width()*0.80,
			height: $(window).height*0.80,
			rowNum: 15,
			rowList: [10,20,30],
			altRows: true,
			mtype: 'post',
			datatype: 'json',
			url: "${path}/address/list",
			editurl: "${path}/address/saveOrUpdate",
			emptyrecords: "Nothing to display",
			pager: "#jqGridPager"
		});
		$('#jqGrid').navGrid('#jqGridPager',
				// the buttons to appear on the toolbar of the grid
				{
					edit: true,
					add: true,
					del: true,
					search: false,
					refresh: true,
					view: true,
					position: "left",
					cloneToTop: false
				},{
					closeAfterEdit:true,
					reloadAfterSubmit:true
				},{
					closeAfterAdd:true,
					reloadAfterSubmit:true
				}
		);
	});
</script>
<body>
	<div style="margin-left:20px;margin-top: 20px;" width="80%">
		<table id="jqGrid" class="edittable" width="80%"></table>
		<div id="jqGridPager"></div>
	</div>
</body>

</html>