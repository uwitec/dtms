<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="/ueadmin_ue/include/session.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>后台管理系统V3.0</title>
		<link rel="stylesheet" type="text/css" media="screen"
			href="resource/jquery-ui-1.7.2/css/cupertino/jquery-ui-1.7.2.custom.css" />
		<link rel="stylesheet" type="text/css" media="screen"
			href="resource/jquery-ui-1.7.2/css/page.css">
		<link rel="stylesheet" type="text/css" media="screen"
			href="resource/jqgrid/ui.jqgrid.css" />
		<link rel="stylesheet" type="text/css" media="screen"
			href="resource/jquery-easyui-1.0.5/themes/default/icon.css">
		<link rel="stylesheet" type="text/css" media="screen"
			href="resource/jquery-easyui-1.0.5/themes/default/easyui.css">
		<link type="text/css" rel="stylesheet" href="style/globe.css">
		
		
		<style type="text/css">
.column {
	width: 170px;
	float: left;
	padding-bottom: 5px;
}

.portlet {
	margin: 0 1em 1em 0;
}

.portlet-header {
	margin: 0.3em;
	padding-bottom: 4px;
	padding-left: 0.2em;
}

.portlet-header .ui-icon {
	float: right;
}

.portlet-content {
	padding: 0.4em;
}

.ui-sortable-placeholder {
	border: 1px dotted black;
	visibility: visible !important;
	height: 50px !important;
}

.ui-sortable-placeholder * {
	visibility: hidden;
}
</style>
		<script type="text/javascript" src="resource/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="resource/jquery-ui-1.7.2/js/jquery-ui-1.7.2.custom.min.js"></script>
		<script type="text/javascript"
			src="resource/jqgrid/jquery.jqGrid.min.js"></script>
		<script type="text/javascript"
			src="resource/jquery-easyui-1.0.5/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="resource/jquery.form.js"></script>
		<script type="text/javascript" src="resource/ojdf.js"></script>
		<script type="text/javascript" src="resource/jquery.timers-1.2.js"></script>
		<script type="text/javascript">
			//自适应Tab页中Iframe的高度

			var adjustTabIframe = function (iframe){
				$(iframe).width($("body").width()-$("div[region=west]").width()-11-2);
				$(iframe).height($("div[region=center]").innerHeight()-31);
				
			};
			
			
			var adjust = function (){
							
							$("#tabs").width($("body").width()-$("div[region=west]").width()-11);
							$("#tabs .tabs-header").width($("body").width()-$("div[region=west]").width()-11);
							$("#tabs .tabs-wrap").width($("body").width()-$("div[region=west]").width()-11-2);
							$("#tabs .tabs-scroller-right").css('position','absolute');
							$("#tabs .tabs-scroller-right").css('z-index','1');
							$("#tabs .tabs-scroller-left").css('position','absolute');
							$("#tabs .tabs-scroller-left").css('z-index','1');
							
							
							//alert ($("#tabs").html());
							$("div[region=center] iframe").each (
								function (){
									adjustTabIframe(this);
								}
							);
							
			}

		</script>
		<script type="text/javascript">
			//添加或选择Tab页

			var addOrSelect = function (el,tabTitle,url){
				while (tabTitle.indexOf(' ')>0){
					tabTitle = tabTitle.replace (' ','');
				}
				
				var tab =  $('#'+el).find(" >div.tabs-header li:has(a span:contains(\""+tabTitle+"\"))");
				if (tab.length>0) {
					//如果已经存在该tab页,则选中该Tab页

					$('#'+el).tabs('select',tabTitle);
					$("iframe[title='"+tabTitle+"']").each (
						function (){
							//alert (this.src);
							//this.src = url;
							var el = this;
							$(this).oneTime(10,'reload',function (){
								//alert(url);
								el.src = url;
							});
						}
					);
				}else{
					//如果不存在该Tab页,则新增一个Tab页

					$('#'+el).tabs('add',{
						title:tabTitle,
						content:"<iframe title="+tabTitle+"  onload='adjust()' style='width:800;height:600'  scrolling='yes'  marginwidth='0' frameborder='0' vspace='0' hspace='0'>" +"</iframe>",
						closable:true
					});
					
					$("iframe[title='"+tabTitle+"']").each (
						function (){
							//alert (this.src);
							//this.src = url;
							var el = this;
							$(this).oneTime(10,'reload',function (){
								//alert(url);
								el.src = url;
							});
						}
					);
					
					
				}
				
				$("a.tabs-close",$('#'+el)).bind ('click.tabs',
					function (){
						
						$('#debug-input').each(
							function (){
								this.focus();
							}
						);
					}
				);
				
			};
			
			
			$(
				function () {
					$('.easyui-layout').bind ('resize',adjust);
					$('div[region=west]').bind ('resize',adjust);
				}
			);
			
			$(
				function (){
					$('#'+"tabs").tabs('select',"首页");
				}
			);
			
		


			$(
					function (){
						$("#customerInfo").click(
							function (){
								var url = "";	
								openModalWindow (url+"?random="+Math.random(),500,280,'yes');
							}
						);
					}
				);
			$(
					function (){
						$("#rsviewlogin").click(
							function (){
								var url = "";	
								window.open (url+"&random="+Math.random(),'rscview','scrollbars=yes,fullscreen=yes');
							}
						);
					}
				);

		</script>
		<script type="text/javascript">
			$(function() {
				$(".column").sortable({
					connectWith: '.column'
				});
		
				$(".portlet").addClass("ui-widget ui-widget-content ui-helper-clearfix ui-corner-all")
					.find(".portlet-header")
						.addClass("ui-widget-header ui-corner-all")
						.prepend('<span class="ui-icon ui-icon-plusthick"></span>')
						.end()
					.find(".portlet-content");
		
				$(".portlet-header .ui-icon").click(function() {
					$(this).toggleClass("ui-icon-minusthick");
					$(this).parents(".portlet:first").find(".portlet-content").toggle();
				});
		
				$(".column").disableSelection();
			});
			$(function (){
				$("a.tabs-close",$('#tabs')).bind ('click.tabs',
					function (){
						
						$('#debug-input').each(
							function (){
								this.focus();
							}
						);
					}
				);
			})
			
	</script>

	</head>
	<body style="padding: 0px; margin: 0px">
	
		<div
			style="color: #FFFFFF; width: 100%; text-align: right; padding-right: 150px; top: 15px; position: absolute; z-index =1; filter: alpha(opacity =   100);"
			id="info_content"> 欢迎您: ${session.user.sysUserName }!登录时间：${session.user.loginDate }，IP：${session.user.loginIp } &nbsp;&nbsp;<a id='logout' href='/rootAction!logout.action' class='firstPageTopButton'>退出系统</a>
		</div>
		<div class="easyui-layout" id="layoutPanel"
			style="width: 100%; height: 100%; padding: 0px; margin: 0px">
			<div region="north" border="false" id="header">
			</div>
			<div region="west" id="westPanel" onresize="adjust()" split="true"
				title="系统导航" style="width: 200px; padding: 0px;">
				<div id="tree-according" class="easyui-accordion" fit="true"
					style="width: 180px; height: 100%; padding: 0px">
						<c:forEach items="${roles}" var="roles">
						   <c:if test="${roles == 'wdxx'}">
						<div title="我的信息"" icon="icon-ok"
							style="overflow: auto; padding: 0px;">
							<table class="tree-grid" id="tree_1"
								 width="100%">
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								  <a href="/rootAction!mypower.action" target='frmright'>
								我的权限
								</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/rootAction!pwd.action" target='frmright'>
								修改密码
								</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/rootAction!logout.action" >安全退出</a>
								</td>
								</tr>
								</table>
						</div>
						</c:if>
						 </c:forEach>
						  <c:forEach items="${roles}" var="roles">
						   <c:if test="${roles == 'WEBSYSTEM'}">
						<div title="网站参数"" icon="icon-ok"
							style="overflow: auto; padding: 0px;">
							<table class="tree-grid" id="tree_1"
								 width="100%">
								 <tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/ueadmin_ue/include/JSP.jsp" target='frmright' >服务器信息</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/siteConfigAction!getById.action" target='frmright'>
								网站参数</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								  <a href="/rootAction!add.action" target='frmright'>
								开通用户
								</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								  <a href="/rootAction!list.action" target='frmright'>
								网站用户
								</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/sysRoleAction!list.action" target='frmright'>
								网站角色
								</a>
								</td>
								</tr>
								<tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/sysJurAction!list.action" target='frmright'>角色权限</a>
								</td>
								</tr>
								</table>
						</div>
						</c:if>
						 </c:forEach>
						 <c:forEach items="${roles}" var="roles">
						   <c:if test="${roles == 'rzglxt'}">
						 <div title="日志管理系统" icon="icon-ok"
							style="overflow: auto; padding: 0px;">
							<table class="tree-grid" id="tree_2"
								 width="100%">
								 <tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/filesAction!list.action" target='frmright' >日志管理</a>
								</td>
								</tr>
								 <tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/filesAction!saveFile.action" target='frmright' >SQL管理</a>
								</td>
								</tr>
								 <tr>
								<td style="width: 100%; height: 30px;padding-left:20px;" >
								<a href="/filesAction!listFile.action" target='frmright' >登录管理</a>
								</td>
								</tr>
								</table>
						</div>
						 </c:if>
						 </c:forEach>
						 
				</div>
			</div>

			<div region="south" border="false" style="height: 15px;">
			
			</div>
			<div region="center" title="" style="overflow-x: hidden;">
				<div id="tabs" class="easyui-tabs"
					style="height: auto; overflow: hidden; width: auto;">
					
					
					<div id="firstPage" title="首页"
						style="padding: 0px; padding-left: 14">
							<div id="blockDiv">
							
									<div class="column" style="width: 99%" >
												<div class="portlet-content"  >
												<div id="content" >
												<iframe width='100%' height='765px' frameborder="0" scrolling="yes" id="frmright" name="frmright" src="${indexurl }" class="td_upload"></iframe>
												</div>
												</div>
									</div>
															
							</div>												
					
						
					</div>
					
				</div>
			</div>
			
		</div>
	</body>
</html>
