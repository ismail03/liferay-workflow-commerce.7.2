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
 * Provides a wrapper for {@link ProductLocalService}.
 *
 * @author "user"
 * @see ProductLocalService
 * @generated
 */
public class ProductLocalServiceWrapper
	implements ProductLocalService, ServiceWrapper<ProductLocalService> {

	public ProductLocalServiceWrapper(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
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

		return _productLocalService.addEntry(orgEntry, serviceContext);
	}

	@Override
	public void addEntryResources(
			long entryId, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.addEntryResources(
			entryId, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			long entryId,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.addEntryResources(entryId, modelPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.ismail.model.Product entry, boolean addGroupPermissions,
			boolean addGuestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.addEntryResources(
			entry, addGroupPermissions, addGuestPermissions);
	}

	@Override
	public void addEntryResources(
			com.liferay.ismail.model.Product entry,
			com.liferay.portal.kernel.service.permission.ModelPermissions
				modelPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.addEntryResources(entry, modelPermissions);
	}

	/**
	 * Adds the product to the database. Also notifies the appropriate model listeners.
	 *
	 * @param product the product
	 * @return the product that was added
	 */
	@Override
	public com.liferay.ismail.model.Product addProduct(
		com.liferay.ismail.model.Product product) {

		return _productLocalService.addProduct(product);
	}

	@Override
	public int countAllInGroup(long groupId) {
		return _productLocalService.countAllInGroup(groupId);
	}

	@Override
	public int countAllInGroup(long groupId, int[] status) {
		return _productLocalService.countAllInGroup(groupId, status);
	}

	@Override
	public int countAllInUser(long userId) {
		return _productLocalService.countAllInUser(userId);
	}

	@Override
	public int countAllInUser(long userId, int[] status) {
		return _productLocalService.countAllInUser(userId, status);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId) {
		return _productLocalService.countAllInUserAndGroup(userId, groupId);
	}

	@Override
	public int countAllInUserAndGroup(long userId, long groupId, int[] status) {
		return _productLocalService.countAllInUserAndGroup(
			userId, groupId, status);
	}

	/**
	 * Creates a new product with the primary key. Does not add the product to the database.
	 *
	 * @param productId the primary key for the new product
	 * @return the new product
	 */
	@Override
	public com.liferay.ismail.model.Product createProduct(long productId) {
		return _productLocalService.createProduct(productId);
	}

	/**
	 * Delete entry
	 */
	@Override
	public com.liferay.ismail.model.Product deleteEntry(long primaryKey)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deleteEntry(primaryKey);
	}

	/**
	 * Delete entry
	 *
	 * @param entry Product
	 * @return Product oject
	 * @exception PortalException
	 */
	@Override
	public com.liferay.ismail.model.Product deleteEntry(
			com.liferay.ismail.model.Product entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deleteEntry(entry);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the product with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productId the primary key of the product
	 * @return the product that was removed
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.liferay.ismail.model.Product deleteProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.deleteProduct(productId);
	}

	/**
	 * Deletes the product from the database. Also notifies the appropriate model listeners.
	 *
	 * @param product the product
	 * @return the product that was removed
	 */
	@Override
	public com.liferay.ismail.model.Product deleteProduct(
		com.liferay.ismail.model.Product product) {

		return _productLocalService.deleteProduct(product);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.ismail.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _productLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.ismail.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _productLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _productLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _productLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.ismail.model.Product fetchProduct(long productId) {
		return _productLocalService.fetchProduct(productId);
	}

	/**
	 * Returns the product matching the UUID and group.
	 *
	 * @param uuid the product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product, or <code>null</code> if a matching product could not be found
	 */
	@Override
	public com.liferay.ismail.model.Product fetchProductByUuidAndGroupId(
		String uuid, long groupId) {

		return _productLocalService.fetchProductByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInGroup(
		long groupId) {

		return _productLocalService.findAllInGroup(groupId);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInGroup(
			groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInGroup(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator,
		int[] status) {

		return _productLocalService.findAllInGroup(
			groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInGroup(
		long groupId, int[] status) {

		return _productLocalService.findAllInGroup(groupId, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInGroup(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInGroup(groupId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInUser(
		long userId) {

		return _productLocalService.findAllInUser(userId);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInUser(
			userId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInUser(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator,
		int[] status) {

		return _productLocalService.findAllInUser(
			userId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInUser(
		long userId, int[] status) {

		return _productLocalService.findAllInUser(userId, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product> findAllInUser(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInUser(userId, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		findAllInUserAndGroup(long userId, long groupId) {

		return _productLocalService.findAllInUserAndGroup(userId, groupId);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		findAllInUserAndGroup(
			long userId, long groupId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.ismail.model.Product> orderByComparator,
			int[] status) {

		return _productLocalService.findAllInUserAndGroup(
			userId, groupId, start, end, orderByComparator, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		findAllInUserAndGroup(long userId, long groupId, int[] status) {

		return _productLocalService.findAllInUserAndGroup(
			userId, groupId, status);
	}

	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		findAllInUserAndGroup(
			long userId, long groupId,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.findAllInUserAndGroup(
			userId, groupId, orderByComparator);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _productLocalService.getActionableDynamicQuery();
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @return
	 * @throws SystemException
	 */
	@Override
	public java.util.List<com.liferay.ismail.model.Product> getCompanyEntries(
		long companyId, int status, int start, int end) {

		return _productLocalService.getCompanyEntries(
			companyId, status, start, end);
	}

	/**
	 * Get Company entries
	 *
	 * @param companyId Company Id
	 * @param status    Workflow status
	 * @param start     start index of entries
	 * @param end       end index of entries
	 * @param obc       Comparator for the order
	 * @return List of entries
	 * @throws SystemException
	 */
	@Override
	public java.util.List<com.liferay.ismail.model.Product> getCompanyEntries(
		long companyId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<com.liferay.ismail.model.Product> obc) {

		return _productLocalService.getCompanyEntries(
			companyId, status, start, end, obc);
	}

	/**
	 * Get Company entries counts
	 *
	 * @param companyId
	 * @param status
	 * @return
	 * @throws SystemException
	 */
	@Override
	public int getCompanyEntriesCount(long companyId, int status) {
		return _productLocalService.getCompanyEntriesCount(companyId, status);
	}

	/**
	 * Converte Date Time into Date()
	 *
	 * @param request PortletRequest
	 * @param prefix  Prefix of the parameter
	 * @return Date object
	 */
	@Override
	public java.util.Date getDateTimeFromRequest(
		javax.portlet.PortletRequest request, String prefix) {

		return _productLocalService.getDateTimeFromRequest(request, prefix);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _productLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _productLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param primaryKey primary key
	 * @param request    PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.ismail.model.Product getInitializedProduct(
			long primaryKey, javax.portlet.PortletRequest request)
		throws javax.portlet.PortletException {

		return _productLocalService.getInitializedProduct(primaryKey, request);
	}

	/**
	 * Get Record
	 *
	 * @param primaryKey Primary key
	 * @return Product object
	 * @throws PortletException
	 */
	@Override
	public com.liferay.ismail.model.Product getNewObject(long primaryKey) {
		return _productLocalService.getNewObject(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _productLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the product with the primary key.
	 *
	 * @param productId the primary key of the product
	 * @return the product
	 * @throws PortalException if a product with the primary key could not be found
	 */
	@Override
	public com.liferay.ismail.model.Product getProduct(long productId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getProduct(productId);
	}

	/**
	 * Get Entity
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

		return _productLocalService.getProduct(groupId, urlTitle);
	}

	/**
	 * Returns the product matching the UUID and group.
	 *
	 * @param uuid the product's UUID
	 * @param groupId the primary key of the group
	 * @return the matching product
	 * @throws PortalException if a matching product could not be found
	 */
	@Override
	public com.liferay.ismail.model.Product getProductByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.getProductByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Populate Model with values from a form
	 *
	 * @param request PortletRequest
	 * @return Product Object
	 * @throws PortletException
	 * @throws ProductValidateException
	 */
	@Override
	public com.liferay.ismail.model.Product getProductFromRequest(
			long primaryKey, javax.portlet.PortletRequest request)
		throws com.liferay.ismail.exception.ProductValidateException,
			   javax.portlet.PortletException {

		return _productLocalService.getProductFromRequest(primaryKey, request);
	}

	/**
	 * Returns a range of all the products.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.liferay.ismail.model.impl.ProductModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @return the range of products
	 */
	@Override
	public java.util.List<com.liferay.ismail.model.Product> getProducts(
		int start, int end) {

		return _productLocalService.getProducts(start, end);
	}

	/**
	 * Returns all the products matching the UUID and company.
	 *
	 * @param uuid the UUID of the products
	 * @param companyId the primary key of the company
	 * @return the matching products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		getProductsByUuidAndCompanyId(String uuid, long companyId) {

		return _productLocalService.getProductsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of products matching the UUID and company.
	 *
	 * @param uuid the UUID of the products
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of products
	 * @param end the upper bound of the range of products (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching products, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.liferay.ismail.model.Product>
		getProductsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.liferay.ismail.model.Product> orderByComparator) {

		return _productLocalService.getProductsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of products.
	 *
	 * @return the number of products
	 */
	@Override
	public int getProductsCount() {
		return _productLocalService.getProductsCount();
	}

	/**
	 * Get STATUS_ANY for DB
	 *
	 * This is equivalent of WorkflowConstants.STATUS_ANY
	 *
	 * @return All statuses for Workflow
	 */
	@Override
	public int[] getStatusAny() {
		return _productLocalService.getStatusAny();
	}

	@Override
	public com.liferay.ismail.model.Product moveEntryToTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.moveEntryToTrash(userId, entryId);
	}

	/**
	 * Moves the entry to the recycle bin.
	 *
	 * Social activity counters for this entry get disabled.
	 *
	 * @param userId the primary key of the user moving the entry
	 * @param entry  the entry to be moved
	 * @return the moved entry
	 */
	@Override
	public com.liferay.ismail.model.Product moveEntryToTrash(
			long userId, com.liferay.ismail.model.Product entry)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.moveEntryToTrash(userId, entry);
	}

	/**
	 * Restores the entry with the ID from the recycle bin. Social activity counters
	 * for this entry get activated.
	 *
	 * @param userId  the primary key of the user restoring the entry
	 * @param entryId the primary key of the entry to be restored
	 * @return the restored entry from the recycle bin
	 */
	@Override
	public com.liferay.ismail.model.Product restoreEntryFromTrash(
			long userId, long entryId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.restoreEntryFromTrash(userId, entryId);
	}

	@Override
	public void updateAsset(
			long userId, com.liferay.ismail.model.Product entry,
			long[] assetCategoryIds, String[] assetTagNames,
			long[] assetLinkEntryIds, Double priority)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.updateAsset(
			userId, entry, assetCategoryIds, assetTagNames, assetLinkEntryIds,
			priority);
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

		return _productLocalService.updateEntry(orgEntry, serviceContext);
	}

	@Override
	public void updateEntryResources(
			com.liferay.ismail.model.Product entry, String[] groupPermissions,
			String[] guestPermissions)
		throws com.liferay.portal.kernel.exception.PortalException {

		_productLocalService.updateEntryResources(
			entry, groupPermissions, guestPermissions);
	}

	/**
	 * Updates the product in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param product the product
	 * @return the product that was updated
	 */
	@Override
	public com.liferay.ismail.model.Product updateProduct(
		com.liferay.ismail.model.Product product) {

		return _productLocalService.updateProduct(product);
	}

	@Override
	public com.liferay.ismail.model.Product updateStatus(
			long userId, long entryId, int status,
			com.liferay.portal.kernel.service.ServiceContext serviceContext,
			java.util.Map<String, java.io.Serializable> workflowContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _productLocalService.updateStatus(
			userId, entryId, status, serviceContext, workflowContext);
	}

	@Override
	public ProductLocalService getWrappedService() {
		return _productLocalService;
	}

	@Override
	public void setWrappedService(ProductLocalService productLocalService) {
		_productLocalService = productLocalService;
	}

	private ProductLocalService _productLocalService;

}