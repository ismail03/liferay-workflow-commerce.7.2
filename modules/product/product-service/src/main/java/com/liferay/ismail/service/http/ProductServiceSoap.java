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

package com.liferay.ismail.service.http;

import com.liferay.ismail.service.ProductServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ProductServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.liferay.ismail.model.ProductSoap</code>. If the method in the
 * service utility returns a
 * <code>com.liferay.ismail.model.Product</code>, that is translated to a
 * <code>com.liferay.ismail.model.ProductSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author "user"
 * @see ProductServiceHttp
 * @generated
 */
public class ProductServiceSoap {

	/**
	 * Add Entry
	 *
	 * @param orgEntry       Product model
	 * @param serviceContext ServiceContext
	 * @exception PortalException
	 * @exception ProductValidateException
	 * @return created Product model.
	 */
	public static com.liferay.ismail.model.ProductSoap addEntry(
			com.liferay.ismail.model.ProductSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.addEntry(
					com.liferay.ismail.model.impl.ProductModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Delete Entry
	 *
	 * @param primaryKey
	 * @return Product
	 * @throws PortalException
	 */
	public static void deleteEntry(long primaryKey) throws RemoteException {
		try {
			ProductServiceUtil.deleteEntry(primaryKey);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return ServiceContext serviceContext
	 * @throws PrincipalException
	 * @throws PortletException
	 */
	public static com.liferay.ismail.model.ProductSoap getNewObject(
			long primaryKey,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.getNewObject(primaryKey, serviceContext);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the sample sb
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	public static com.liferay.ismail.model.ProductSoap getProduct(
			long primaryKey)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.getProduct(primaryKey);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Returns the product
	 *
	 * @param groupId
	 * @param urlTitle
	 * @return
	 * @throws PortalException
	 */
	public static com.liferay.ismail.model.ProductSoap getProduct(
			long groupId, String urlTitle)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.getProduct(groupId, urlTitle);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	/**
	 * Move an entry to the trush can
	 *
	 * @param userId
	 * @param entryId
	 * @return Product
	 * @throws PortalException
	 */
	public static com.liferay.ismail.model.ProductSoap moveEntryToTrash(
			long entryId)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.moveEntryToTrash(entryId);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
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
	public static com.liferay.ismail.model.ProductSoap updateEntry(
			com.liferay.ismail.model.ProductSoap orgEntry,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws RemoteException {

		try {
			com.liferay.ismail.model.Product returnValue =
				ProductServiceUtil.updateEntry(
					com.liferay.ismail.model.impl.ProductModelImpl.toModel(
						orgEntry),
					serviceContext);

			return com.liferay.ismail.model.ProductSoap.toSoapModel(
				returnValue);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ProductServiceSoap.class);

}