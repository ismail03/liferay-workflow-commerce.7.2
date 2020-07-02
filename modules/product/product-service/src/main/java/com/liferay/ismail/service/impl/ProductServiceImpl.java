// 
/*   */ 
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
/*  */ 


package com.liferay.ismail.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermissionFactory;
import com.liferay.portal.kernel.security.permission.resource.PortletResourcePermission;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.ismail.constants.ProductConstants;
import com.liferay.ismail.exception.ProductValidateException;
import com.liferay.ismail.model.Product;
import com.liferay.ismail.service.base.ProductServiceBaseImpl;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.component.annotations.ReferencePolicyOption;

/**
 * The implementation of the Product remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.liferay.ismail.service.ProductService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author user
 * @see ProductServiceBaseImpl
 */
@Component(
	property = {
		"json.web.service.context.name=product",
		"json.web.service.context.path=Product"
	},
	service = AopService.class
)
public class ProductServiceImpl extends ProductServiceBaseImpl {

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
	public Product addEntry(Product orgEntry, ServiceContext serviceContext)
		throws PortalException, ProductValidateException {

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return productLocalService.addEntry(orgEntry, serviceContext);
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Product
	 * @throws PortalException
	 */
	public void deleteEntry(long primaryKey) throws PortalException {
		_productModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.DELETE);

		productLocalService.deleteEntry(primaryKey);
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
	public Product getInitializedProduct(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.ADD_ENTRY);

		return productLocalService.getNewObject(primaryKey);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public Product getNewObject(long primaryKey, ServiceContext serviceContext)
		throws PrincipalException {

		primaryKey = (primaryKey <= 0) ? 0 :
		counterLocalService.increment(Product.class.getName());

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.UPDATE);

		return productLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the sample sb
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public Product getProduct(long primaryKey) throws PortalException {
		_productModelResourcePermission.check(
			getPermissionChecker(), primaryKey, ActionKeys.VIEW);

		return productLocalService.getProduct(primaryKey);
	}

	/**
	 * Returns the product
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public Product getProduct(long groupId, String urlTitle)
		throws PortalException {

		Product entry = productLocalService.getProduct(groupId, urlTitle);

		_productModelResourcePermission.check(
			getPermissionChecker(), entry, ActionKeys.VIEW);

		return entry;
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 * @throws PortalException
	 */
	public Product getProductFromRequest(
			long primaryKey, PortletRequest request)
		throws PortalException, PortletException {

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			request);

		_portletResourcePermission.check(
			getPermissionChecker(), serviceContext.getScopeGroupId(),
			ActionKeys.VIEW);

		return productLocalService.getProductFromRequest(primaryKey, request);
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Product
	 * @throws PortalException
	 */
	public Product moveEntryToTrash(long entryId) throws PortalException {
		_productModelResourcePermission.check(
			getPermissionChecker(), entryId, ActionKeys.DELETE);

		return productLocalService.moveEntryToTrash(getUserId(), entryId);
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
	public Product updateEntry(
			Product orgEntry, ServiceContext serviceContext)
		throws PortalException, ProductValidateException {

		_productModelResourcePermission.check(
			getPermissionChecker(), orgEntry.getPrimaryKey(),
			ActionKeys.UPDATE);

		return productLocalService.updateEntry(orgEntry, serviceContext);
	}

	private static volatile ModelResourcePermission<Product>
		_productModelResourcePermission =
			ModelResourcePermissionFactory.getInstance(
				ProductServiceImpl.class, "_productModelResourcePermission",
				Product.class);

	@Reference(
		policy = ReferencePolicy.DYNAMIC,
		policyOption = ReferencePolicyOption.GREEDY,
		target = "(resource.name=" + ProductConstants.RESOURCE_NAME + ")"
	)
	private volatile PortletResourcePermission _portletResourcePermission;

}