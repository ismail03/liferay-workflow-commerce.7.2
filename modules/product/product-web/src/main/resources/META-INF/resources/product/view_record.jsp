<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
Product product = (Product)request.getAttribute("product");
String redirect = ParamUtil.getString(request, "redirect");
boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);

%>

<div class="container-fluid-1280">
	<aui:fieldset>
<%--  --%>
	    <div class="form-group">
	        <h3><liferay-ui:message key="asset-title" /></h3>
	        <p class="form-control"><%=product.getProductTitleName()%></p>
	    </div>
	    <div class="form-group">
	        <h3><liferay-ui:message key="asset-title" /></h3>
	        <p class="form-control"><%=product.getProductSummaryName()%></p>
	    </div>

		<div class="form-group">
	        <h3><liferay-ui:message key="product-productId" /></h3>
			<p class="form-control"><%=product.getProductId()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="product-productName" /></h3>
			<p class="form-control"><%=product.getProductName()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="product-numberOfProducts" /></h3>
			<p class="form-control"><%=product.getNumberOfProducts()%></p>
		</div>
		<div class="form-group">
	        <h3><liferay-ui:message key="product-attachment" /></h3>
			<p class="form-control"><%=product.getAttachment()%></p>
		</div>
<%--  --%>		
	</aui:fieldset>
</div>