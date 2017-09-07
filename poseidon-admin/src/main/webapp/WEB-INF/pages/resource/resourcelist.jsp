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
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/jquery.jqGrid.min.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/jqgrid/css/ui.jqgrid-bootstrap.css" />
<script>
    $.jgrid.defaults.width = $(window).width()*0.80;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
</script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>

<div style="margin-left:40px;margin-top: 40px" width="100%">
	<table id="jqGrid" width="100%"></table>
	<div id="jqGridPager"></div>
</div>

<script type="text/javascript">
	$(document).ready(function () {
		$("#jqGrid").jqGrid({
            width: $(window).width()*0.80,
            hoverrows:false,
            height: $(window).height*0.80,
			viewrecords: false, // show the current page, data rang and total records on the toolbar
            gridview:true,
			rowNum: 15,
			rowList:[10,20,30],
			altRows: true,
			mtype:'post',
			datatype: 'json',
			url: '${pageContext.request.contextPath}/resource/list',
			emptyrecords:"Nothing to display",
			pager: "#jqGridPager",
			caption: "菜单功能列表",
            editurl:"${pageContext.request.contextPath}/resource/saveOrUpdate",
            ExpandColumn:"sourceName",
            sortname:"sourceId",
            scrollrows:true,
            treeGrid:true,
            treedatatype:'json',
            collapsible:true,
            treeGridModel:"adjacency",
            loadonce:true,
            treeReader:{
                parent_id_field:"pid",
                level_field:"level",
                leaf_field:"isLeaf",
                expanded_field:"expanded",
                loaded:"loaded",
                icon_field:"url"
            },
            datatype:"json",
            colModel: [
                {
                    label: 'sourceId',
                    name: 'sourceId',
                    key:true,
                    hidden:true,
                    editable:true
                },{
                    label: '资源名称',
                    name: 'sourceName',
                    width: 100,
                    editable:true
                },
                {
                    label: '资源地址',
                    name: 'sourceUrl',
                    width: 80,
                    editable:true
                },
                {
                    label: '打开方式',
                    name: 'openMode',
                    width: 40,
                    editable:true
                },
                {
                    label: '描述信息',
                    name: 'description',
                    width: 40,
                    editable:true
                },
                {
                    label: '图标',
                    name: 'icon',
                    width: 25,
                    editable:true
                },
                {
                    label: '父id',
                    name: 'pid',
                    hidden:true,
                    editable:true
                },
                {
                    label: 'resourceStatus',
                    name: 'resourceStatus',
                    hidden:true,
                    editable:true
                },
                {
                    label: 'resourceType',
                    name: 'resourceType',
                    hidden:true,
                    editable:true
                },
                {
                    label: '资源类型',
                    name: 'typeCn',
                    hidden:true,
                    editable:true
                },
                {
                    label: '状态',
                    name: 'statusCn',
                    hidden:true,
                    editable:true
                },
                {
                    label: '排序号',
                    name: 'seq',
                    width: 25,
                    editable:true
                }
            ]

		});
		$('#jqGrid').navGrid('#jqGridPager',
				// the buttons to appear on the toolbar of the grid
			{edit: true, add: true, del: true, search: false, refresh: true, view: true, position: "left", cloneToTop: false },
            {reloadAfterSubmit:true,closeAfterEdit:true},
            {closeAfterAdd:true,reloadAfterSubmit:true},
            {drag:true,resize:true,closeOnEscape:true,dataheight:150},
            {drag:true,resize:true,closeOnEscape:true,dataheight:150}
		);
        $("#jqGrid").jqGrid('bindKeys');
	});
</script>


