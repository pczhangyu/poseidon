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
                    label: 'dictDataId',
                    name: 'dictDataId',
                    key:true,
                    hidden:true,
                    editable:true
                },{
                    label: '字典类型编号',
                    name: 'dictId',
                    editable:true,
                    edittype: "select",
                    editoptions: {value:'${dictionaryTypes}'},
                    width: 30
                },{
                    label: '字典类型名称',
                    name: 'dictNameCn',
                    editable:false,
                    width: 30
                },{
                    label: '字典值名称',
                    name: 'dataNameCn',
                    width: 50,
                    editable:true
                },
                {
                    label: '字典英文名称',
                    name: 'dataNameEn',
                    width: 80,
                    editable:true
                },
                {
                    label: '字典值编码',
                    name: 'dataCode',
                    width: 40,
                    editable:true
                },
                {
                    label: '字典值描述',
                    name: 'dataDesc',
                    width: 40,
                    editable:true
                },
                {
                    label: '状态序列号',
                    name: 'dicSeq',
                    width: 40,
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
            url: "${pageContext.request.contextPath}/dictionary/data/list",
            emptyrecords:"Nothing to display",
            pager: "#jqGridPager",
            caption: "字典值列表",
            editurl:"${pageContext.request.contextPath}/dictionary/data/saveOrUpdate"
        });
        $('#jqGrid').navGrid('#jqGridPager',
            // the buttons to appear on the toolbar of the grid
            {edit: true, add: true, del: true, search: true, refresh: true, view: true, position: "left", cloneToTop: false },
            {reloadAfterSubmit:true,closeAfterEdit:true},
            {closeAfterAdd:true,reloadAfterSubmit:true}
        );
    });
</script>


