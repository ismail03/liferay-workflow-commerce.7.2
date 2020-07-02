<%--  --%>
<%--  --%>
<%--  --%>

<%@ include file="../init.jsp" %>

<jsp:useBean id="product" scope="request" type="com.liferay.ismail.model.Product" />

<portlet:defineObjects />

<%--  --%>
<%= product.getProductTitleName()
<%--  --%>