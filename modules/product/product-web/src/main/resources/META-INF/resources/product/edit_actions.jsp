<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
PortletURL navigationPortletURL = renderResponse.createRenderURL();
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
Product product = (Product)row.getObject();

long groupId = product.getGroupId();
String name = Product.class.getName();
String primKey = String.valueOf(product.getPrimaryKey());
%>

<liferay-ui:icon-menu
	cssClass='<%= row == null ? "entry-options inline" : StringPool.BLANK %>'
	direction="left-side"
	icon="<%= StringPool.BLANK %>"
	markupView="lexicon"
	message="<%= StringPool.BLANK %>"
	showWhenSingleIcon="<%= true %>"
>
	<c:if test="<%= ProductEntryPermission.contains(permissionChecker, product, ActionKeys.PERMISSIONS) %>">
		<liferay-security:permissionsURL
			modelResource="com.liferay.ismail.model.Product"
			modelResourceDescription="Product"
			resourcePrimKey="<%= String.valueOf(primKey) %>"
			var="permissionsEntryURL"
		/>

		<liferay-ui:icon iconCssClass="icon-lock" label="<%= true %>" markupView="lexicon" message="permissions" url="<%= permissionsEntryURL %>" />
	</c:if>

	<c:if test="<%= ProductEntryPermission.contains(permissionChecker, product, ActionKeys.VIEW) %>">
		<portlet:renderURL var="viewProductURL">
			<portlet:param name="mvcRenderCommandName" value="/product/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.VIEW %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-eye-open" label="<%= true %>" markupView="lexicon" message="view" url="<%= viewProductURL.toString() %>" />
	</c:if>

	<c:if test="<%= ProductEntryPermission.contains(permissionChecker, product, ActionKeys.UPDATE) %>">
		<portlet:renderURL var="editProductURL">
			<portlet:param name="mvcRenderCommandName" value="/product/crud" />

			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.UPDATE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:renderURL>

		<liferay-ui:icon iconCssClass="icon-edit" label="<%= true %>" markupView="lexicon" message="edit" url="<%= editProductURL.toString() %>" />
	</c:if>

	<c:if test="<%= ProductEntryPermission.contains(permissionChecker, product, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/product/crud" var="deleteProductURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.DELETE %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-remove" label="<%= true %>" markupView="lexicon" message="remove" url="<%= deleteProductURL.toString() %>" />
	</c:if>

	<c:if test="<%= ProductEntryPermission.contains(permissionChecker, product, ActionKeys.DELETE) %>">
		<portlet:actionURL name="/product/crud" var="moveToTrashProductURL">
			<portlet:param
				name="<%= Constants.CMD %>"
				value="<%= Constants.MOVE_TO_TRASH %>"
			/>

			<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
			<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
		</portlet:actionURL>

		<liferay-ui:icon iconCssClass="icon-trash" label="<%= true %>" markupView="lexicon" message="trash" url="<%= moveToTrashProductURL.toString() %>" />
	</c:if>
</liferay-ui:icon-menu>