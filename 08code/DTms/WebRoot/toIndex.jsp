<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="f"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>${session.siteConfig.siteName }</title>
<meta name="${session.siteConfig.siteMeta1}" content="${session.siteConfig.siteMeta1},${session.siteConfig.siteMeta2}"/>
<META content="${session.siteConfig.siteMeta1},${session.siteConfig.siteMeta2}" name="${session.siteConfig.siteMeta1}">
<link href="css/index.css" rel="stylesheet" type="text/css" />
</head>

<body>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<table width="100%" border="0" cellspacing="0" cellpadding="10">
      <tr>
        <td width="33%" align="center"  valign="middle" class="text3">
前台界面待设计中，<a href="http://localhost:8088/rootAction_index.action">进入后台管理</a><br>
登录&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;免费注册
</td>
</table>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<br/>
<jsp:include page="include/bot.jsp"></jsp:include>
</body>
</html>
