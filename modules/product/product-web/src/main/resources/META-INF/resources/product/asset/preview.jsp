<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="/product/init.jsp" %>

<jsp:useBean id="product" scope="request" type="com.liferay.ismail.model.Product" />

<%= product.getProductTitleName() %>