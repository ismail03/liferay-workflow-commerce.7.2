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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Product. This utility wraps
 * <code>com.liferay.ismail.service.impl.ProductServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author "user"
 * @see ProductService
 * @generated
 */
public class ProductServiceUtil {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.liferay.ismail.service.impl.ProductServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Product model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ProductValidateException
	 * @return created Product model.
	 */
	public static com.liferay.ismail.model.Product addEntry(
			com.liferay.ismail.model.Product orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.ismail.exception.ProductValidateException,
			   com.liferay.portal.kernel.exception.PortalException {

		return getService().addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Product
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().deleteEntry(primaryKey);
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
	public static com.liferay.ismail.model.Product getInitializedProduct(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getInitializedProduct(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.ismail.model.Product getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.security.auth.PrincipalException {

		return getService().getNewObject(primaryKey, serviceContext);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the sample sb
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	public static com.liferay.ismail.model.Product getProduct(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProduct(primaryKey);
	}

	/**
	 * Returns the product
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.ismail.model.Product getProduct(
			long groupId, String urlTitle)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getProduct(groupId, urlTitle);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public static com.liferay.ismail.model.Product getProductFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.portal.kernel.exception.PortalException,
			   javax.portlet.PortletException {

		return getService().getProductFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Product
	 * @throws PortalException
	 */
	public static com.liferay.ismail.model.Product moveEntryToTrash(
			long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().moveEntryToTrash(entryId);
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
	public static com.liferay.ismail.model.Product updateEntry(
			com.liferay.ismail.model.Product orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.ismail.exception.ProductValidateException,
			   com.liferay.portal.kernel.exception.PortalException {

		return getService().updateEntry(orgEntry, serviceContext);
	}

	public static ProductService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ProductService, ProductService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ProductService.class);

		ServiceTracker<ProductService, ProductService> serviceTracker =
			new ServiceTracker<ProductService, ProductService>(
				bundle.getBundleContext(), ProductService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}