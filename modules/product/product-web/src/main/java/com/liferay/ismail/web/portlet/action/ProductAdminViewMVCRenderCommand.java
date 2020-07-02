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
package com.liferay.ismail.web.portlet.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.ismail.constants.ProductPortletKeys;
import com.liferay.ismail.web.constants.ProductWebKeys;
import com.liferay.ismail.web.internal.display.context.ProductDisplayContext;
import com.liferay.ismail.web.util.ProductViewHelper;
import com.liferay.trash.TrashHelper;

// //
// //

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author user
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + ProductPortletKeys.PRODUCT_ADMIN,
		"mvc.command.name=/", "mvc.command.name=/product/view"
	},
	service = MVCRenderCommand.class
)
public class ProductAdminViewMVCRenderCommand implements MVCRenderCommand {

	@Override
	public String render(RenderRequest request, RenderResponse response) {
		request.setAttribute(
			ProductWebKeys.PRODUCT_DISPLAY_CONTEXT,
			new ProductDisplayContext(
				_portal.getLiferayPortletRequest(request),
				_portal.getLiferayPortletResponse(response), _trashHelper,
				_productViewHelper));

		request.setAttribute(
			ProductWebKeys.PRODUCT_VIEW_HELPER, _productViewHelper);

// //
// //
		
		return ProductWebKeys.ADMIN_VIEW_JSP;
	}

	@Reference
	private Portal _portal;

	@Reference
	private ProductViewHelper _productViewHelper;

	@Reference
	private TrashHelper _trashHelper;
	
// //
// //	

}