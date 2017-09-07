<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script type="application/javascript" src="${pageContext.request.contextPath}/static/plugins/treeview/bootstrap-treeview.min.js">


</script>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1> ${parentName} <small>${targetName}</small> </h1>
	<ol class="breadcrumb">
		<li><a href="#"><i class="fa fa-dashboard"></i> ${parentName}</a></li>
		<li class="active">${targetName}</li>
	</ol>
</section>

<!-- Main content -->
<section class="content">
	<!-- 内容开始 -->
	<div class="row">
		<div class="col-md-3">
			<div class="panel box box-primary">
				<div class="box-header" id="tree1"></div>
			</div>
		</div>
		<div class="col-md-9">
			<div class="box box-solid">
				<div class="nav-tabs-custom">
					<ul class="nav nav-tabs">
						<li class="active"><a href="#tab_1" data-toggle="tab" aria-expanded="true">详情</a></li>
						<li><a href="#tab_2" data-toggle="tab" aria-expanded="false">新增</a></li>
						<li><a href="#tab_3" data-toggle="tab" aria-expanded="false">编辑</a></li>
						<li class="pull-left header">
							<button class="btn btn-primary" data-toggle="modal" data-target="#myModal1">启用</button>
							<button class="btn btn-primary" data-toggle="modal" data-target="#myModal2">停用</button>
						</li>
					</ul>
					<div class="tab-content">
						<div class="tab-pane active" id="tab_1">
							<div class="box-body">
								<p>机构名称：技术部</p>
								<p>上级机构：北京久囍科技有限公司</p>
								<p>备       注：技术研发部门，包含开发、测试</p>
								<p>机构人员数量：18个 <button type="button" class="btn btn-primary margin-l">查看</button></p>
							</div>
						</div>
						<div class="tab-pane" id="tab_2">
							<form class="form-horizontal">
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">机构名称</label>
										<div class="col-sm-10">
											<input class="form-control" placeholder="机构名称">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">上级机构</label>
										<div class="col-sm-10">
											<select class="form-control">
												<option>婚礼定制</option>
												<option>婚纱摄影</option>
												<option>婚纱礼服</option>
												<option>婚礼酒店</option>
												<option>珠宝钻戒</option>
												<option>蜜月旅行</option>
												<option>智能家具</option>
												<option>婚品采购</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="3"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">状态</label>
										<div class="col-sm-10">
											<select class="form-control">
												<option>启用</option>
												<option>停用</option>
											</select>
										</div>
									</div>

								</div>

								<div class="box-footer text-center">
									<button type="submit" class="btn btn-info">保存</button>
									<button type="submit" class="btn btn-default">取消</button>
								</div>
							</form>
						</div>
						<div class="tab-pane" id="tab_3">
							<form class="form-horizontal">
								<div class="box-body">
									<div class="form-group">
										<label class="col-sm-2 control-label">机构名称</label>
										<div class="col-sm-10">
											<input type="email" class="form-control" placeholder="机构名称">
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">上级机构</label>
										<div class="col-sm-10">
											<select class="form-control">
												<option>婚礼定制</option>
												<option>婚纱摄影</option>
												<option>婚纱礼服</option>
												<option>婚礼酒店</option>
												<option>珠宝钻戒</option>
												<option>蜜月旅行</option>
												<option>智能家具</option>
												<option>婚品采购</option>
											</select>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">备注</label>
										<div class="col-sm-10">
											<textarea class="form-control" rows="3"></textarea>
										</div>
									</div>

									<div class="form-group">
										<label class="col-sm-2 control-label">状态</label>
										<div class="col-sm-10">
											<select class="form-control">
												<option>启用</option>
												<option>停用</option>
											</select>
										</div>
									</div>

								</div>

								<div class="box-footer text-center">
									<button type="submit" class="btn btn-info">保存</button>
									<button type="submit" class="btn btn-default">取消</button>
								</div>
							</form>
						</div>
					</div>
					<!-- /.tab-content -->
				</div>
			</div>
		</div>
	</div>
	<!-- 内容结束 -->
</section>
<!-- /.content -->
<script>
	var tree1 = [
		{
			text: "北京久囍科技有限公司",
			nodes: [
				{
					text: "技术部",
				},
				{
					text: "产品部"
				},
				{
					text: "运营中心"
				},
				{
					text: "销售部"
				},
				{
					text: "商务拓展部"
				},
				{
					text: "品牌推广部"
				},
				{
					text: "财务部"
				},
				{
					text: "人事行政部"
				},
			]
		}
	];
	function getTree(data) {
		return data;
	}
	$.ajax({
		type: "GET",
		url: "response.php",
		dataType: "json",
		success: function(response)
		{
			initTree(response)
		}
	});
	$('#tree1').treeview({data: getTree(tree1)});
</script>