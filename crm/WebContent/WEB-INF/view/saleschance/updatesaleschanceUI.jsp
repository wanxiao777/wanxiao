<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/commons/common.jsp"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改销售机会</title>
</head>
<script type="text/javascript">
	$(function(){
		var val = $("#createDate").val();
		if(val == null || val == ""){
			$("#createDate").val(new Date().format("yyyy-MM-dd"));
		}
		$("#save").click(function(){
			$("form")[0].submit();
		})
	})
</script>
<body class="main">		
	<span class="page_title">修改销售机会</span>
	<div class="button_bar">
		<button class="common_button" onclick="javascript:history.go(-1);">返回</button>
		<button class="common_button" id="save">保存</button>
	</div>

	<form:form id="chance" action="${ctp }/saleschance/update" method="POST"
		modelAttribute="chance">
		<input type="hidden" name="_method" value="put">
		<table class="query_form_table" border="0" cellPadding="3"
			cellSpacing="0">
			<tr>
				<th>编号</th>
				<td><form:input path="id" readonly="true" /> &nbsp;</td>
				<th>机会来源</th>
				<td><form:input path="source" /></td>
			</tr>
			<tr>
				<th>客户名称</th>
				<td><form:input path="custName" /><span class="red_star">*</span></td>
				<th>成功机率（%）<br />填入数字，0~100
				</th>
				<td><form:input path="rate" /><span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>概要</th>
				<td colspan="2"><form:input path="title" /><span
					class="red_star">*</span></td>
			</tr>
			<tr>
				<th>联系人</th>
				<td><form:input path="contact" /></td>
				<th>联系人电话</th>
				<td><form:input path="contactTel" /></td>
			</tr>
			<tr>
				<th>机会描述</th>
				<td colspan="3"><form:textarea path="description" rows="6"
						cols="50" /> <span class="red_star">*</span></td>
			</tr>
			<tr>
				<th>创建人</th>
				<td>
				<c:if test="${sessionScope.user !=null }">
				${sessionScope.user.name }(${sessionScope.user.role.name })
				</c:if>
				<c:if test="${sessionScope.user == null }">
				没有创建人
				</c:if>
				</td>
				<th>创建时间</th>
				<td><form:input path="createDate" id="createDate"
						readonly="true" /><span class="red_star">*</span></td>
			</tr>
		</table>
		<br />
		<br>
	</form:form>
</body>
</html>