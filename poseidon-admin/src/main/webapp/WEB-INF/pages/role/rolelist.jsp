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
<script type="text/ecmascript" src="${staticPath}/static/plugins/layer/layer.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/treeview/bootstrap-treeview.min.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/i18n/grid.locale-cn.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/jqgrid/js/jquery.jqGrid.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/jqgrid/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/layer/default/layer.css" />

<script>
    $.jgrid.defaults.width = $(window).width()*0.80;
    $.jgrid.defaults.responsive = true;
    $.jgrid.defaults.styleUI = 'Bootstrap';
</script>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>--%>

<body>
<div style="margin-left:40px;margin-top: 40px" width="100%">
	<table id="jqGrid" class="edittable" width="100%"></table>
	<div id="jqGridPager"></div>
</div>
<script type="text/javascript">
    $(document).ready(function () {

        $("#jqGrid").jqGrid({
            colModel: [
                {
                    label: 'roleId',
                    name: 'roleId',
                    key:true,
                    hidden:true,
                    editable:true
                },{
                    label: '角色名称',
                    name: 'roleName',
                    width: 100,
                    editable:true
                },
                {
                    label: '角色描述',
                    name: 'description',
                    editable:true,
                    width: 150
                },
                {
                    label: '状态',
                    name: 'roleStatus',
                    width: 50,
                    editable:true
                },
                {
                    label: '排序号',
                    name: 'seq',
                    width: 50,
                    editable:true
                }

            ],
            viewrecords: true, // show the current page, data rang and total records on the toolbar
            width: $(window).width()*0.80,
            height: $(window).height*0.80,
            rowNum: 15,
            rowList:[10,20,30],
            altRows: true,
            mtype:'post',
            datatype: 'json',
            url: "${pageContext.request.contextPath}/role/list",
            emptyrecords:"Nothing to display",
            pager: "#jqGridPager",
            caption: "角色列表",
            editurl:"${pageContext.request.contextPath}/role/saveOrUpdate"
        });
        $('#jqGrid').navGrid('#jqGridPager',
            // the buttons to appear on the toolbar of the grid
            { edit: true, add: true, del: true, search: false, refresh: true, view: true, position: "left", cloneToTop: false},
            {reloadAfterSubmit:true,closeAfterEdit:true},
            {closeAfterAdd:true,reloadAfterSubmit:true}
        );
        //添加一个自定义按钮
        $('#jqGrid').navButtonAdd('#jqGridPager',
                {
                    buttonicon: "ui-icon-mail-closed",
                    title: "分配",
                    caption: "分配",
                    position: "last",
                    onClickButton: customButtonClicked
                });
        //获取当前选中行的所有值
        function customButtonClicked() {
            var rowKey = $("#jqGrid").jqGrid('getGridParam',"selrow");
            if (rowKey){
                var roleId = $("#jqGrid").getGridParam("selrow");
                //使用layer插件弹出一个自定义窗口
                var index = layer.open({
                    type: 2,
                    skin: 'layui-layer-rim', //加上边框
                    area: ['800px', '600px'], //宽高
                    content: "${pageContext.request.contextPath}/role/distribution/"+roleId
                });
            } else{
                alert("请选择要分配的角色");
            }
        }
    });
</script>



