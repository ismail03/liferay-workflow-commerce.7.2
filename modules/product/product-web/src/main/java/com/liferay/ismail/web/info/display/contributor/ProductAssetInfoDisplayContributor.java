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
package com.liferay.ismail.web.info.display.contributor;

import com.liferay.asset.info.display.contributor.BaseAssetInfoDisplayContributor;
import com.liferay.info.display.contributor.InfoDisplayContributor;
import com.liferay.ismail.model.Product;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * Product Asset Info Display Contributor
 * 
 * @author user
 *
 */
@Component(immediate = true, service = InfoDisplayContributor.class)
public class ProductAssetInfoDisplayContributor extends BaseAssetInfoDisplayContributor<Product> {

	@Override
	public String getClassName() {
		return Product.class.getName();
	}

	@Override
	public String getInfoURLSeparator() {
		return "/product/";
	}

	@Override
	protected Map<String, Object> getClassTypeValues(Product assetEntryObject, Locale locale) {
		return new HashMap<>();
	}

}
