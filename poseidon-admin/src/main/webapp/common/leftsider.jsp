<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${staticPath}/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${sessionScope.user.username}</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a></div>
        </div>
        <ul class="sidebar-menu">
            <c:forEach items="${parentMenus}" var="menu">
                <c:if test="${empty menu.pid}">
                    <li class="treeview"> <a href="#"><i class="fa fa-link"></i> <span>${menu.sourceName}</span> <span class="pull-right-container"> <i class="fa fa-angle-left pull-right"></i> </span> </a>
                        <ul class="treeview-menu">
                        <c:forEach items="${childrenMenus}" var="menuChild">
                            <c:if test="${menuChild.pid eq menu.sourceId}">
                            <li><a href='#' onclick="_loadPage('<c:url value="${menuChild.url}"/>','${menuChild.sourceName}','${menu.sourceName}')" >${menuChild.sourceName}</a></li>
                            </c:if>
                        </c:forEach>
                        </ul>
                    </li>
                </c:if>
            </c:forEach>
        </ul>
    </section>
</aside>
<script type="application/javascript">
  function  _loadPage(targetUrl,targetName,parentName){
      $("#content_frigga").load(encodeURI(targetUrl+'?targetName='+targetName +'&parentName='+parentName));
  }
</script>