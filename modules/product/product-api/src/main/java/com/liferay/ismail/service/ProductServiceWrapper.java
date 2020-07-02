/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.ismail.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProductService}.
 *
 * @author "user"
 * @see ProductService
 * @generated
 */
public class ProductServiceWrapper
	implements ProductService, ServiceWrapper<ProductService> {

	public ProductServiceWrapper(ProductService productService) {
		_productService = productService;
	}

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Product model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ProductValidateException
	 * @return created Product model.
	 */
	@Override
	public com.liferay.ismail.model.Product addEntry(
			com.liferay.ismail.model.Product orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.ismail.exception.ProductValidateException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _productService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Product
	 * @throws PortalException
	 */
	@Override
	public void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productService.deleteEntry(primaryKey);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.ismail.model.Product getInitializedProduct(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _productService.getInitializedProduct(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	@Override
	public com.liferay.ismail.model.Product getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return _productService.getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the sample sb
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.liferay.ismail.model.Product getProduct(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productService.getProduct(primaryKey);
	}

	/**
	 * Returns the product
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	@Override
	public com.liferay.ismail.model.Product getProduct(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productService.getProduct(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	@Override
	public com.liferay.ismail.model.Product getProductFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return _productService.getProductFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Product
	 * @throws PortalException
	 */
	@Override
	public com.liferay.ismail.model.Product moveEntryToTrash(long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productService.moveEntryToTrash(entryId);
	}

	/**
	 * Edit Entry
	 *
	 * @param orgEntry       Product model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ProductValidateException
	 * @return updated Product model.
	 */
	@Override
	public com.liferay.ismail.model.Product updateEntry(
			com.liferay.ismail.model.Product orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.ismail.exception.ProductValidateException,
			   com.liferay.portal.kernel.exception.PortalException {

		return _productService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public ProductService getWrappedService() {
		return _productService;
	}

	@Override
	public void setWrappedService(ProductService productService) {
		_productService = productService;
	}

	private ProductService _productService;

}