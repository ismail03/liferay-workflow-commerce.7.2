<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
String iconChecked = "checked";
String iconUnchecked = "unchecked";
SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatVal);
SimpleDateFormat dateTimeFormat = new SimpleDateFormat(datetimeFormatVal);


ProductDisplayContext productDisplayContext = (ProductDisplayContext)request.getAttribute(ProductWebKeys.PRODUCT_DISPLAY_CONTEXT);

String displayStyle = productDisplayContext.getDisplayStyle();
SearchContainer entriesSearchContainer = productDisplayContext.getSearchContainer();

PortletURL portletURL = entriesSearchContainer.getIteratorURL();

ProductManagementToolbarDisplayContext productManagementToolbarDisplayContext = new ProductManagementToolbarDisplayContext(liferayPortletRequest, liferayPortletResponse, request, entriesSearchContainer, trashHelper, displayStyle);
%>

<clay:management-toolbar
	actionDropdownItems="<%= productManagementToolbarDisplayContext.getActionDropdownItems() %>"
	clearResultsURL="<%= productManagementToolbarDisplayContext.getSearchActionURL() %>"
	componentId="productManagementToolbar"
	creationMenu="<%= productManagementToolbarDisplayContext.getCreationMenu() %>"
	disabled="<%= productManagementToolbarDisplayContext.isDisabled() %>"
	filterDropdownItems="<%= productManagementToolbarDisplayContext.getFilterDropdownItems() %>"
	itemsTotal="<%= productManagementToolbarDisplayContext.getItemsTotal() %>"
	searchActionURL="<%= productManagementToolbarDisplayContext.getSearchActionURL() %>"
	searchContainerId="product"
	searchFormName="fm"
	showSearch="true"
	sortingOrder="<%= productManagementToolbarDisplayContext.getOrderByType() %>"
	sortingURL="<%= productManagementToolbarDisplayContext.getSortingURL() %>"
/>

<portlet:actionURL name="/product/crud" var="restoreTrashEntriesURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= Constants.RESTORE %>" />
</portlet:actionURL>

<liferay-trash:undo
	portletURL="<%= restoreTrashEntriesURL %>"
/>

<div class="container-fluid container-fluid-max-xl main-content-body">
	<aui:form action="<%= portletURL.toString() %>" method="get" name="fm">
		<aui:input name="<%= Constants.CMD %>" type="hidden" />
		<aui:input name="redirect" type="hidden" value="<%= portletURL.toString() %>" />
		<aui:input name="deleteEntryIds" type="hidden" />
		<aui:input name="selectAll" type="hidden" value="<%= false %>" />

		<liferay-ui:search-container
			emptyResultsMessage="no-record-was-found"
			id="product"
			rowChecker="<%= new EmptyOnClickRowChecker(renderResponse) %>"
			searchContainer="<%= entriesSearchContainer %>"
		>
			<liferay-ui:search-container-row
				className="com.liferay.ismail.model.Product"
				escapedModel="<%= true %>"
				keyProperty="productId"
				modelVar="product"
			>
<%--  --%>
				<liferay-ui:search-container-column-text
					align="left"
					name="ProductId"
					orderable="true"
					orderableProperty="productId"
					property="productId"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="ProductName"
					orderable="true"
					orderableProperty="productName"
					property="productName"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="NumberOfProducts"
					orderable="true"
					orderableProperty="numberOfProducts"
					property="numberOfProducts"
				/>

				<liferay-ui:search-container-column-text
					align="left"
					name="Attachment"
					orderable="true"
					orderableProperty="attachment"
					property="attachment"
				/>

<%--  --%>
				<liferay-ui:search-container-column-jsp
					align="right"
					path="/product/edit_actions.jsp"
				/>
			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator displayStyle="list" markupView="lexicon" />
		</liferay-ui:search-container>
	</aui:form>
</div>

<aui:script>
	function <portlet:namespace />deleteEntries() {
		if (<%=trashHelper.isTrashEnabled(scopeGroupId) %> || confirm('<%=UnicodeLanguageUtil.get(request, "are-you-sure-you-want-to-delete-the-selected-entries") %>')) {
			var form = AUI.$(document.<portlet:namespace />fm);

			form.attr('method', 'post');
			form.fm('<%=Constants.CMD%>').val('<%=trashHelper.isTrashEnabled(scopeGroupId) ? Constants.MOVE_TO_TRASH : Constants.DELETE%>');
			form.fm('deleteEntryIds').val(Liferay.Util.listCheckedExcept(form, '<portlet:namespace />allRowIds'));

			submitForm(form, '<portlet:actionURL name="/product/crud" />');
		}
	}
</aui:script>
