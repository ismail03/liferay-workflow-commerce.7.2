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

package com.liferay.ismail.service.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.repository.model.ModelValidator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.ismail.exception.ProductValidateException;
import com.liferay.ismail.model.Product;

/*   */
/*  */ 

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Product Validator 
 * 
 * @author user
 *
 */
public class ProductValidator implements ModelValidator<Product> {

	@Override
	public void validate(Product entry) throws PortalException {
/*   */
        // Field productId
        validateProductId(entry.getProductId());

        // Field productName
        validateProductName(entry.getProductName());

        // Field numberOfProducts
        validateNumberOfProducts(entry.getNumberOfProducts());

        // Field attachment
        validateAttachment(entry.getAttachment());

/*  */
        validateProductTitleName(entry.getProductTitleName());

		if (0 < _errors.size()) {
			throw new ProductValidateException(_errors);
		}
		
	}

    /**
    * productTitleName field Validation
    *
    * @param productTitleName
    */
    protected void validateProductTitleName(String productTitleName) {
        if (Validator.isNotNull(productTitleName)) {
            int productTitleNameMaxLength = ModelHintsUtil.getMaxLength(
                Product.class.getName(), "productTitleName");

            if (productTitleName.length() > productTitleNameMaxLength) {
                _errors.add("productTitleName has more than " + productTitleNameMaxLength +
                " characters");
            }
        }
    }

/*   */
    /**
    * productId field Validation
    *
    * @param field productId
    */
    protected void validateProductId(long field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
    }

    /**
    * productName field Validation
    *
    * @param field productName
    */
    protected void validateProductName(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.
        if (!StringUtils.isNotEmpty(field)) {
            _errors.add("product-productname-required");
        }

    }

    /**
    * numberOfProducts field Validation
    *
    * @param field numberOfProducts
    */
    protected void validateNumberOfProducts(int field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

    /**
    * attachment field Validation
    *
    * @param field attachment
    */
    protected void validateAttachment(String field) {
        //TODO : This validation needs to be implemented. Add error message key into _errors when an error occurs.

    }

/*  */ 	
	

	protected List<String> _errors = new ArrayList<>();

}
