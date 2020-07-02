<%--  --%>
<%--  --%>
<%--  --%>
<%@ include file="./init.jsp" %>

<%
	PortletURL portletURL = PortletURLUtil.clone(renderResponse.createRenderURL(), liferayPortletResponse);
	boolean fromAsset = ParamUtil.getBoolean(request, "fromAsset", false);
	String CMD = ParamUtil.getString(request, Constants.CMD, Constants.UPDATE);
	Product product = (Product)request.getAttribute("product");
	String redirect = ParamUtil.getString(request, "redirect");
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(redirect);
%>

<portlet:actionURL name="/product/crud" var="productEditURL">
	<portlet:param name="<%= Constants.CMD %>" value="<%= CMD %>" />
	<portlet:param name="redirect" value="<%= portletURL.toString() %>" />
</portlet:actionURL>

<div class="container-fluid-1280">
	<aui:form action="<%= productEditURL %>" method="post" name="productEdit">
		<aui:model-context bean="<%= product %>" model="<%= Product.class %>" />
		<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= CMD %>" />
		<aui:input name="fromAsset" type="hidden" value="<%= fromAsset %>" />
		<aui:input name="redirect" type="hidden" value="<%= redirect %>" />
		<aui:input name="resourcePrimKey" type="hidden" value="<%= product.getPrimaryKey() %>" />

		<%

		//This tag is only necessary in Asset publisher

		if (fromAsset) {
		%>

		<div class="lfr-form-content">

		<%
		}
		%>

		<c:if test="<%= Constants.ADD.equals(CMD) %>">
			<aui:input name="addGuestPermissions" type="hidden" value="true" />
			<aui:input name="addGroupPermissions" type="hidden" value="true" />
		</c:if>
<%--   --%>
						<liferay-ui:error key="duplicated-url-title"
												  message="duplicated-url-title" />
						<aui:input name="productTitleName" label="title" />
						<aui:input name="productSummaryName" label="summary" />
<%--  --%>

		<%
			String requiredLabel = "";
		%>
<%--   --%>
		<%
			requiredLabel = "*";
		%>
		<liferay-ui:error key="product-productname-required"
						  message="product-productname-required" />

					<aui:input name="productName" disabled="false"
						label='<%=LanguageUtil.get(request, "product-productname")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="numberOfProducts" disabled="false"
						label='<%=LanguageUtil.get(request, "product-numberofproducts")
						+ requiredLabel%>'
					/>
		<%
			requiredLabel = "";
		%>

					<aui:input name="attachment" disabled="false"
						 readonly="true" type="text" label='<%=LanguageUtil.get(request,
						"product-attachment") + requiredLabel%>' />
					<%
					String attachmentClick = renderResponse.getNamespace() + "dlBrowse('attachment Files select','" +
					renderResponse.getNamespace()+"attachment')";
					%>

					<aui:button onClick="<%=attachmentClick%>" value="select" />
<%--  --%>

		<%
			if (product.getPrimaryKey() != 0) {
		%>

		<liferay-ui:ratings
			className="<%= Product.class.getName() %>"
			classPK="<%= product.getPrimaryKey() %>"
			type="stars"
		/>

		<%
			}
		%>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="categorization">
				<aui:input name="categories" type="assetCategories" />

				<aui:input name="tags" type="assetTags" />
			</aui:fieldset>
		</aui:fieldset-group>

		<%
		if (product.getPrimaryKey() != 0 && false == fromAsset) {
		%>

		<aui:fieldset-group markupView="lexicon">
			<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="related-assets">
				<liferay-asset:input-asset-links
					className="<%= Product.class.getName() %>"
					classPK="<%= product.getPrimaryKey() %>"
				/>
			</aui:fieldset>
		</aui:fieldset-group>

		<%
		}
		%>

		<%

		//This tag is only necessary in Asset publisher

		if (fromAsset) {
		%>

		</div>

		<%
		}
		%>

		<aui:button-row>

			<%
				String publishButtonLabel = "submit";
			%>

			<%
				if (WorkflowDefinitionLinkLocalServiceUtil
					.hasWorkflowDefinitionLink(themeDisplay.getCompanyId(), scopeGroupId, Product.class.getName())) {

						publishButtonLabel = "submit-for-publication";
				}
			%>

			<aui:button
				cssClass="btn-lg"
				onClick='<%= "event.preventDefault(); " + renderResponse.getNamespace() + "saveEditors();" %>'
				primary="<%= false %>"
				type="submit"
				value="<%= publishButtonLabel %>"
			/>

			<%
				if (!fromAsset) {
			%>

			&nbsp;&nbsp;&minus; <liferay-ui:message key="or" /> &minus;
			<aui:button onClick="<%= redirect %>" type="cancel" />

			<%
				}
			%>

		</aui:button-row>
	</aui:form>

	<%
	if (product.getPrimaryKey() != 0 && false == fromAsset) {
	%>

	<liferay-ui:panel-container
		extended="<%= false %>"
		id="productCommentsPanelContainer"
		persistState="<%= true %>"
	>
		<liferay-ui:panel
			collapsible="<%= true %>"
			extended="<%= true %>"
			id="productCommentsPanel"
			persistState="<%= true %>"
			title='<%= LanguageUtil.get(request, "comments") %>'
		>
			<portlet:actionURL name="invokeTaglibDiscussion" var="discussionURL" />

			<liferay-comment:discussion
				className="<%= Product.class.getName() %>"
				classPK="<%= product.getPrimaryKey() %>"
				formName="fm2"
				ratingsEnabled="<%= true %>"
				redirect="<%= currentURL %>"
				userId="<%= product.getUserId() %>"
			/>
		</liferay-ui:panel>
	</liferay-ui:panel-container>

	<%
	}
	%>

</div>

<%--   --%>
<%--  --%>

<aui:script>
	function <portlet:namespace />saveEditors() {
<%--   --%>
<%--  --%>
		submitForm(document.<portlet:namespace />productEdit);
	}
</aui:script>

<%--   --%>
<%
ProductItemSelectorHelper productItemSelectorHelper = (ProductItemSelectorHelper)request
	.getAttribute(ProductWebKeys.PRODUCT_ITEM_SELECTOR_HELPER);
RequestBackedPortletURLFactory requestBackedPortletURLFactory = RequestBackedPortletURLFactoryUtil
	.create(liferayPortletRequest);
String selectItemName = liferayPortletResponse.getNamespace()
		+ "selectItem";
%>

<aui:script>
	function <portlet:namespace />dlBrowse (title, inputField) {
		var itemSrc = $('#'+inputField);
		AUI().use(
			'liferay-item-selector-dialog',
			function(A) {
				var itemSelectorDialog = new A.LiferayItemSelectorDialog(
					{
						eventName: '<%= selectItemName %>',
						on: {
							selectedItemChange: function(event) {
								var selectedItem = event.newVal;

								if (selectedItem) {
									var itemValue = JSON.parse(
										selectedItem.value
									);
									itemSrc.val(itemValue.url);
								}
							}
						},
						title: title,
						url: '<%= productItemSelectorHelper.getItemSelectorURL(
						requestBackedPortletURLFactory, themeDisplay, selectItemName) %>'
					}
				);
				itemSelectorDialog.open();
			}
		);
	}
</aui:script>
<%--  --%>
