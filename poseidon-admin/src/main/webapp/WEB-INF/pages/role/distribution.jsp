<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="/common/global.jsp"%>
<%@include file="/common/basejs.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<script type="text/ecmascript" src="${staticPath}/static/plugins/layer/layer.js"></script>
<script type="text/ecmascript" src="${staticPath}/static/plugins/treeview/bootstrap-treeview.min.js"></script>
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/jqgrid/css/ui.jqgrid-bootstrap.css" />
<link rel="stylesheet" type="text/css" media="screen" href="${staticPath}/static/plugins/layer/default/layer.css" />
<div id="test">
        <fieldset>
            <input type="text" id="roleId" style="display: none" value="${model.roleId}">
            <div class="form-group">
                <label for="roleName">角色名称</label>
                <input type="text" readOnly="true" id="roleName" value="${model.roleName}" class="form-control" placeholder="input">
            </div>
            <div class="form-group">
                <label for="description">角色描述</label>
                <input type="text" readOnly="true" id="description" value="${model.description}" class="form-control" placeholder="input">
            </div>
            <div class="form-group">
                <label for="roleStatus">角色状态</label>
                <input type="text" readOnly="true" id="roleStatus" value="${model.roleStatus}" class="form-control" placeholder="input">
            </div>
           <div id="treeview-checkable"></div>
            <center><button id="submitButton"  class="btn btn-primary">提交</button></center>
        </fieldset>
</div>
<script>
    //生成树结构
    $(document).ready(function () {
        var roleId =$("#roleId").val();
        var $tree = $('#treeview-checkable').treeview({
            data: test1(roleId),
            showIcon: false,
            showCheckbox: true,
            levels:1,
            multiSelect:true,
            collapseAll:{silent:true},
            onNodeChecked: function(event, node) {//选中父节点的checked时联动选择子节点
                $('#checkable-output').prepend('<p>' + node.text + ' was checked</p>');
                var selectNodes = getNodeIdArr(node);//获取所有子节点
                if(selectNodes){ //子节点不为空，则选中所有子节点
                    $('#treeview-checkable').treeview('checkNode', [ selectNodes,{ silent: true }]);
                }
            },
            onNodeUnchecked: function (event, node) {//取消父节点时联动取消子节点
                $('#checkable-output').prepend('<p>' + node.text + ' was unchecked</p>');
                var selectNodes = getNodeIdArr(node);//获取所有子节点
                if(selectNodes){ //子节点不为空，则取消选中所有子节点
                    $('#treeview-checkable').treeview('uncheckNode', [ selectNodes,{ silent: true }]);
                }
            }
        });
        //发送ajax请求获取所有资源，并获取当前角色已拥有的资源
        function test1(roleId){
            var datafault;
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/role/rolesource",
                dataType:'json',
                async:false,
                data:{"roleId":roleId},
                success: function(data) {
                    datafault = data;
                }
            });
            return datafault;
        }
        //递归获取所有的结点id
        function getNodeIdArr( node ){
            var ts = [];
            if(node.nodes){
                for(x in node.nodes){
                    ts.push(node.nodes[x].nodeId)
                    if(node.nodes[x].nodes){
                        var getNodeDieDai = getNodeIdArr(node.nodes[x]);
                        for(j in getNodeDieDai){
                            ts.push(getNodeDieDai[j]);
                        }
                    }
                }
            }else{
                ts.push(node.nodeId);
            }
            return ts;
        }
    });
    //提交表单和树结构的所有数据
    $(function(){
        $("#submitButton").click(function () {
            //获取该树结构的所有被选中的节点
            var nodes = $('#treeview-checkable').treeview('getChecked');
            var resIds= [];
            //遍历所有被选中的节点数组对象，并取出所有sourceId放到一个数组中
            $.each(nodes,function(key,value){
                resIds[key] = value.sourceId;
            });
            var roleId =$("#roleId").val();
            var roleName =$("#roleName").val();
            var description =$("#description").val();
            var roleStatus =$("#roleStatus").val();
            $.ajax({
                type: "post",
                url: "${pageContext.request.contextPath}/role/roleWithSource",
                async:false,
                data:{"roleId":roleId,"roleName":roleName,"description":description,"roleStatus":roleStatus,"resIds":resIds},
                success: function(data) {
                   alert(data);
                    loadPage('${pageContext.request.contextPath}/role/manager','角色管理','权限管理');
                    closeWindow();
                }
            });
        });
    });
    //关闭当前弹出层
    function closeWindow(){
        var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
        parent.layer.close(index);
    }
   function loadPage(targetUrl,targetName,parentName) {
       window.parent._loadPage(targetUrl,targetName,parentName);
   }
</script>