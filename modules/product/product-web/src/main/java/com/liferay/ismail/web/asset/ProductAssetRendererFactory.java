// 
//  //
/**
*  Copyright (C) 2020 Yasuyuki Takeo All rights reserved.
*
*  This program is free software: you can redistribute it and/or modify
*  it under the terms of the GNU Lesser General Public License as published by
*  the Free Software Foundation, either version 3 of the License, or
*  (at your option) any later version.
*
*  This program is distributed in the hope that it will be useful,
*  but WITHOUT ANY WARRANTY; without even the implied warranty of
*  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
*  GNU Lesser General Public License for more details.
*/
//  //
package com.liferay.ismail.web.asset;

import com.liferay.asset.kernel.model.AssetRenderer;
import com.liferay.asset.kernel.model.AssetRendererFactory;
import com.liferay.asset.kernel.model.BaseAssetRendererFactory;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.ResourceBundleLoaderUtil;
import com.liferay.ismail.constants.ProductConstants;
import com.liferay.ismail.constants.ProductPortletKeys;
import com.liferay.ismail.model.Product;
import com.liferay.ismail.service.ProductLocalService;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import javax.servlet.ServletContext;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Product Asset Renderer Factory
 *
 * @author user
 */
@Component(
	immediate = true,
	property = "javax.portlet.name=" + ProductPortletKeys.PRODUCT,
	service = AssetRendererFactory.class
)
public class ProductAssetRendererFactory
	extends BaseAssetRendererFactory<Product> {

	public static final String SYMBOLIC_NAME =
		ProductConstants.RESOURCE_NAME + ".web";

	public static final String TYPE = "product";

	public ProductAssetRendererFactory() {
		setClassName(Product.class.getName());
		setCategorizable(true);
		setPortletId(ProductPortletKeys.PRODUCT);
		setLinkable(true);
		setSearchable(true);
		setSelectable(true);
	}

	@Override
	public AssetRenderer<Product> getAssetRenderer(long classPK, int type)
		throws PortalException {

		ProductAssetRenderer productAssetRenderer = new ProductAssetRenderer(
			_productLocalService.getProduct(classPK),
			ResourceBundleLoaderUtil.
				getResourceBundleLoaderByBundleSymbolicName(SYMBOLIC_NAME));

		productAssetRenderer.setAssetRendererType(type);
		productAssetRenderer.setServletContext(_servletContext);

		return productAssetRenderer;
	}

	@Override
	public AssetRenderer<Product> getAssetRenderer(
			long groupId, String urlTitle)
		throws PortalException {

		Product entry = _productLocalService.getProduct(groupId, urlTitle);

		ProductAssetRenderer productAssetRenderer = new ProductAssetRenderer(
			entry,
			ResourceBundleLoaderUtil.
				getResourceBundleLoaderByBundleSymbolicName(SYMBOLIC_NAME));

		productAssetRenderer.setServletContext(_servletContext);

		return productAssetRenderer;
	}

	@Override
	public String getClassName() {
		return Product.class.getName();
	}

	@Override
	public String getType() {
		return TYPE;
	}

	@Override
	public PortletURL getURLAdd(
		LiferayPortletRequest liferayPortletRequest,
		LiferayPortletResponse liferayPortletResponse, long classTypeId) {

		PortletURL portletURL = _portal.getControlPanelPortletURL(
			liferayPortletRequest, getGroup(liferayPortletRequest),
			ProductPortletKeys.PRODUCT_ADMIN, 0, 0,
			PortletRequest.RENDER_PHASE);

		portletURL.setParameter("mvcRenderCommandName", "/product/crud");
		portletURL.setParameter(Constants.CMD, Constants.ADD);
		portletURL.setParameter("fromAsset", StringPool.TRUE);

		return portletURL;
	}

	@Override
	public PortletURL getURLView(
		LiferayPortletResponse liferayPortletResponse,
		WindowState windowState) {

		LiferayPortletURL liferayPortletURL =
			liferayPortletResponse.createLiferayPortletURL(
				ProductPortletKeys.PRODUCT_ADMIN,
				PortletRequest.RENDER_PHASE);

		liferayPortletURL.setParameter(
			"mvcRenderCommandName", "/product/view");
		liferayPortletURL.setParameter(Constants.CMD, Constants.VIEW);
		liferayPortletURL.setParameter("fromAsset", StringPool.TRUE);

		try {
			liferayPortletURL.setWindowState(windowState);
		}
		catch (WindowStateException wse) {
			_log.error("Windos state is not valid. Skip.", wse);
		}

		return liferayPortletURL;
	}

	@Override
	public boolean hasAddPermission(
			PermissionChecker permissionChecker, long groupId, long classTypeId)
		throws Exception {

		if (_portletResourcePermission.contains(
				permissionChecker, groupId, ActionKeys.VIEW)) {

			return false;
		}

		return _portletResourcePermission.contains(
			permissionChecker, groupId, ActionKeys.ADD_ENTRY);
	}

	@Override
	public boolean hasPermission(
			PermissionChecker permissionChecker, long classPK, String actionId)
		throws Exception {

		return _productModelResourcePermission.contains(
			permissionChecker, classPK, actionId);
	}

	@Reference(
		target = "(osgi.web.symbolicname=com.liferay.ismail.web)", unbind = "-"
	)
	public void setServletContext(ServletContext servletContext) {
		_servletContext = servletContext;
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ProductAssetRendererFactory.class);

	@Reference
	private Portal _portal;

	@Reference(
		target = "(resource.name=" + ProductConstants.RESOURCE_NAME + ")"
	)
	private PortletResourcePermission _portletResourcePermission;

	@Reference
	private ProductLocalService _productLocalService;

	@Reference(target = "(model.class.name=com.liferay.ismail.model.Product)")
	private ModelResourcePermission<Product> _productModelResourcePermission;

	@Reference(target = "(osgi.web.symbolicname=" + SYMBOLIC_NAME + ")")
	private ServletContext _servletContext;

}