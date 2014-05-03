/**
表格控件
*/
(
function($){
	$.fn.extend ({
		ojdfGrid : function (){
			return this.each (
				function (){
					var formId = $(this).attr('formId');
					var action =$("#"+formId).attr('action');
					$("#"+formId).attr('method','post');
					var el = this;
					var elId = this.id;
					$("#"+formId).bind('submit',function (){
						$.showWait();
					});
					$("#"+formId).ajaxForm(function (data) {
						$(el).html (data);
						$("#"+formId).attr('action',action);
						$.hideWait();
						var pageIndex = $(".common_table",$(el)).attr('pageIndex');
						var pageTotal = $(".common_table",$(el)).attr('pageTotal');
						var recordTotal = $(".common_table",$(el)).attr('recordTotal');
						var rowsEveryPage = $(".common_table",$(el)).attr('rowsEveryPage');
						$(".main_table tr",$(el)).hover(
							function (){
								$(this).addClass("count_red");
							},
							function (){
								$(this).removeClass("count_red");
							}
						);
						$(el).trigger("complete");

						$(".main_table").find ("input[name='selAll']").click(
							function()
							{
								if($(this).attr('checked')==true)
								{
								$(".main_table").each(
											function(){									
												$(this).find("input[name='ids']").attr("checked", true);
											}
									);
								}
								else
								{
									$(".main_table").each(
											function(){							
												$(this).find("input[name='ids']").attr("checked", false);
											}
									);
								}
							}
						);
												
						$("div.pager",$(el)).each (
							function (){
								var forTable = $(this).attr('title');
								var pager = this;
								$(this).find ("span.pageTotal").html (pageTotal);
								$(this).find ("span.pageIndex").html (pageIndex);
								$(this).find ("select[name=rows]").val(rowsEveryPage);
								$(this).find ("input[name=page]").val(pageIndex);
								
								var value = $(pager).find ("input[name=page]").val();
								if (value==1){
									$(this).find (".jdf_firstPage").css('color','#6E6E6E');//.css('cursor','arraw');
									$(this).find (".jdf_pageBack").css('color','#6E6E6E');//.css('cursor','arraw');
								}
								if (value==pageTotal){
									$(this).find (".jdf_pageForward").css('color','#6E6E6E');//.css('cursor','arraw');
									$(this).find (".jdf_endPage").css('color','#6E6E6E');//.css('cursor','arraw');
								}
								
								$(this).find (".jdf_firstPage").click (
									function (){
										var value = $(pager).find ("input[name=page]").val();
										if (value ==1 ){
											return;
										};	
										value = 1;
										$(pager).find ("input[name=page]").val(value);
										$("#"+formId).submit();
									}
								);
								
								$(this).find (".jdf_pageBack").click (
									function (){
										var value = $(pager).find ("input[name=page]").val();
										if (value ==1 ){
											return;
										};
										
										value--;
										$(pager).find ("input[name=page]").val(value);
										$("#"+formId).submit();
									}
								);
								$(this).find (".jdf_pageForward").click (
									function (){
										var value = $(pager).find ("input[name=page]").val();
										if (value ==pageTotal ){
											return;
										};
										value++;
										$(pager).find ("input[name=page]").val(value);
										$("#"+formId).submit();
									}
								);
								$(this).find (".jdf_endPage").click (
										
									function (){
										var value = $(pager).find ("input[name=page]").val();
										if (value ==pageTotal ){
											return;
										};			
										value = pageTotal;
										$(pager).find ("input[name=page]").val(value);
										$("#"+formId).submit();
									}
								);
								
								$(this).find (".jdf_pageGo_span").css('cursor','hand');
								$(this).find (".jdf_pageGo_span").click (
									function (){
										
										$("#"+formId).submit();
									}
								);
								
								$(this).find (".jdf_pageDisplay").change (
									function (){
										
										$("#"+formId).submit();
									}
								);
								
								$(this).find (".sel").unbind('click');
								$(this).find (".sel").click(function (){
									var method = $(this).attr('method');
									var link = $(this).attr('link');
									var singleSelect = $(this).attr('singleSelect');
									var paramId = $(this).attr('paramId');
									var openWidth = $(this).attr('openWidth');
									var openHeight = $(this).attr('openHeigth');
									var name = $(this).attr('name'); 
									var paramIdMethod = $(this).attr('paramIdMethod');
									var code = $(this).attr('code');
									var idColumn = $(this).attr('idColumn');
									if (singleSelect=='true'){
										
										if($(".main_table",$(el)).find("input[name='ids']").filter("[checked=true]").size()>1){
											
											alert ('只能选中一个复选框1');
											$(".main_table",$(el)).find("input[name='ids']").attr("checked", false);
											return;
										}
										if($(".main_table",$(el)).find("input[name='ids']").filter("[checked=true]").size()==0){
											alert ('必须选中一个复选框1');
											return;
										}
									}
									var script = link;
									if (paramId=='true'){
										var ccbox = $(".main_table").find("input[name='ids']").filter("[checked=true]");
										var id = ccbox.attr('id');
										if (paramIdMethod=='ID'){
											if (link.indexOf("?")>0){
												link=link+"&id="+id;
											}else{
												link=link+"?id="+id;
											}
										}else if (paramIdMethod=='REST'){
											if (code=='show'){
												link=link+"/"+id;
											}else{
												link=link+"/"+id+'/'+code;
											}
										}else if (paramIdMethod=='ID_COLUMN'){
											if (link.indexOf("?")>0){
												link=link+"&"+idColumn+"="+id;
											}else{
												link=link+"?"+idColumn+"="+id;
											}
										}
									}
									if (link.indexOf("?")>0){
										link=link+"&random="+Math.random();
									}else{
										link=link+"?random="+Math.random();
									}
									if (method=='OPEN'){
										openModalWindow(link,openWidth,openHeight,false);
										$("#"+formId).submit();
									}else if (method=='SUBMIT'){
										if($(".main_table",$(el)).find("input[name='ids']").filter("[checked=true]").size()>0){
											if (confirm('是否执行批量'+name+"?")){
												$("#"+formId).attr('action',link);
												$("#"+formId).submit();
											}
										}
									}else if (method=='DOWNLOAD'){
										var param = '?';
										if (action.indexOf('?')>0){
											param = '?';
										}else{
											param = '&';
										}
										var link = link+param+$("#"+formId).formSerialize();
										
										
										
										//alert(link);
										window.location.href = link;
									}else if (method=='SCRIPT'){
                                        $(el).trigger(script);
                                    }
								});
							}
						);
					});
					if ($(this).attr('init')=='true'){
						$("#"+formId).submit();
					}else{
						//如果不初始化表格
						var action = $("#"+formId).attr('action');
						var url = action+"?init=false"
						$.post(url,function (data){
							$(el).html (data);
						});
						return false;
					}
				}
			);
		} 
	});
}
)(jQuery);

/*
构造树
*/
(
function ($) {
$.fn.extend({
ojdfTree : function (){
	return this.each (function (){
		var el = this;
		var url = $(this).attr('url');
		if (url == null) {
			alert ("未配置action的url");
		}
		var childSize = $(el).children().size();
		//alert (childSize);
			//ajax树
			$(this).treeview({
				//persist: "cookie",
				animated: "fast",
				toggle: function (){			
					var id= this.id;
					var ul =$("ul",$("#"+id));
					if (ul.children().size()>0) {
						return;
					}
					$(el).ojdfTree_reload(id);
				}
			});
			if (childSize==0){
				//如果树不包含静态内容,一开始就要提交AJAX请求
				$(this).ojdfTree_reload();
				//$(this).ojdfTree_reload();
			}
			$(el).ojdfTree_event();
	});
}
});
}
)(jQuery);


(
function ($){
$.fn.extend({
getSelectIds:function (){
	var checks = this.find("input[name='ids']").filter("[checked=true]");
	var ids='';
	checks.each(
		function (i){
			if (i>0){
				ids=ids+',';
			}
			ids = ids+$(this).val();
		}
	);
	
	return ids;
}
});
}
)(jQuery);

/**
重新加载树的节点
*/
(
function ($){
$.fn.extend ({
ojdfTree_reload : function (pid){
return this.each (
	function (){
		var url = $(this).attr('url');
		
		var el = this;
		
			if(pid){
				var aUrl = url+'!ajax?parentId='+pid+"&random="+Math.random();
				$("#"+pid+" ul").html('');
			}else{
				var aUrl = url+'!ajax'+"&random="+Math.random();
				$(this).html('');
			}
			$.post(aUrl,function(data){
				//alert($(data).size());
				try{
					if ($(data).size()==0){
						return;
					}
				}catch(e){
					return;
				}
				var branches = null;
				if (pid){
					branches = $(data).appendTo($("#"+pid +" ul"));
				}else{
					branches = $(data).appendTo($(el));
				}
				$(el).treeview({
					add:branches,
					persist: "cookie"
				});
				
				$(el).ojdfTree_event();
			});
	}
);
}
});
}
)(jQuery);

/**
处理树的事件
*/
(
function ($){
$.fn.extend ({
ojdfTree_event:function (){
				var el = this;
				$(el).find ('a').hover(
					function (){
						$(this).addClass("hover");
					},
					function (){
						$(this).removeClass("hover");
					}
				);
				$(el).find ('a').unbind('click');
				$(el).find("input[name='ids']").click(function (){
					$(el).trigger('nodeSelect');
				});
				$(el).find ('a').click(
					function (){
						var checkBox = $(this).parent().find('input')[0];
						var id =$(this).parent().attr('id');
						var value = $(this).parent().attr('data');
						var text = $(this).parent().attr('text');
						//alert($(checkBox).attr('checked'));
						if ($(checkBox).attr('checked') ){
							$(checkBox).removeAttr('checked');
						}else{
							$(checkBox).attr('checked',true);
						}
						//$(el).attr('selectedId',id);
						//$(el).attr('selectedValue',value);
						var isCheckBox =($(this).parent().find('input').size());
						if (isCheckBox==0){
							$(el).attr('selected',null);
							var data = {
								id:id,
								value:value,
								text:text
							};
							//alert(data.text);
							$(el).attr('selected',data);
							var data1 = $(el).attr('selected');
							
						}
						$(el).trigger('nodeSelect');
						return false;
					}
				);
}
});
}
)(jQuery);


(
function ($){
$.fn.extend ({
showWait : function (){
return this.each (
        function (){
                var el = $("<div class=\"wait\">正在处理,请稍候</div>");
                el.prependTo ($(this));
                var bodyLeft =  ($("body").scrollLeft());
                var bodyTop =  ($("body").scrollTop());
                var bodyWidth =  ($("body").width());
                var bodyHeight =  ($("body").height());
                var x = bodyLeft+(bodyWidth - el.width())/2;
                var y = bodyTop+(bodyHeight - el.height())/2;
                el.css("left",x);
                el.css("top",y);
        }
);
}        
});
}
)(jQuery);

/**
打开模式窗口
*/
var openModalWindow = function (url, width, height, scrolled) {
	if (window.showModalDialog) {
		var varWindow = window.showModalDialog(url, this.window,
		"dialogWidth:"+width+"px;dialogHeight:"+height+"px;center:yes;resizable:true;status:yes;scroll:"+scrolled+";edge:sunken;help:no;");
		return varWindow;
	} 
}
/**
打开窗口
*/
var openWindow = function (url, width, height) {
	//var bodyLeft =  window.;
	//var bodyTop =  window.top.;
	//alert(window.parent);
	var bodyWidth =  window.screen.width;
	var bodyHeight =  window.screen.height;
	var x = 0+(bodyWidth - width)/2;
	var y = 0+(bodyHeight - height)/2;
	//alert(bodyHeight);
	//alert(x);
	//alert(y);
	window.open (url, "", "height="+height+", width="+width+",left="+x+", top="+y+" center=yes, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no");
}

//显示等待进度
jQuery.showWait = function (){
	var el = $("<div class=\"wait\">正在处理,请稍候</div>");
	el.appendTo ($("body"));
	el.css('position','absolute');
	el.css('z-index',2);
	el.css('border','1px solid')
	var bodyLeft =  ($("body").scrollLeft());
	var bodyTop =  ($("body").scrollTop());
	var bodyWidth =  ($("body").width());
	var bodyHeight =  ($("body").height());
	var x = bodyLeft+(bodyWidth - el.width())/2;
	var y = bodyTop+(bodyHeight - el.height())/2;
	el.css("left",x);
	el.css("top",y);
}


//隐藏等待进度
jQuery.hideWait = function (){
	$(".wait").remove();
}



