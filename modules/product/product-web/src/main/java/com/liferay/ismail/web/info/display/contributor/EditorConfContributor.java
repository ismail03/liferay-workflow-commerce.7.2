package com.liferay.ismail.web.info.display.contributor;

import com.liferay.portal.kernel.editor.configuration.BaseEditorConfigContributor;
import com.liferay.portal.kernel.editor.configuration.EditorConfigContributor;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;

@Component(
        property = {
                "editor.name=alloyeditor",
                "javax.portlet.name=com_liferay_journal_web_portlet_JournalPortlet",
                "service.ranking:Integer=100"
        },
        service = EditorConfigContributor.class
)
public class EditorConfContributor extends BaseEditorConfigContributor {

    @Override
    public void populateConfigJSONObject(JSONObject jsonObject, Map<String, Object> inputEditorTaglibAttributes,
                                         ThemeDisplay themeDisplay, RequestBackedPortletURLFactory requestBackedPortletURLFactory) {
        System.out.println("jsonObject" + jsonObject.toString());

        JSONObject toolbars = jsonObject.getJSONObject("toolbars");
        if (toolbars != null) {
            JSONObject toolbarAdd = toolbars.getJSONObject("add");

            if (toolbarAdd != null) {
                JSONArray addButtons = toolbarAdd.getJSONArray("buttons");

                addButtons.put("camera");
            }


            JSONObject stylesToolbar = toolbars.getJSONObject("styles");
            JSONArray selectionsJSONArray = stylesToolbar.getJSONArray(
                    "selections");

            for (int i = 0; i < selectionsJSONArray.length(); i++) {
                JSONObject selection = selectionsJSONArray.getJSONObject(i);
                System.out.println("IN OUTER");
                if (Objects.equals(selection.get("name"), "text")) {
                    System.out.println("IN TEXT");
                    JSONArray buttons = selection.getJSONArray("buttons");

                    buttons.put("copy");
                    buttons.put("cut");
                    buttons.put("paste");
                }
            }
            System.out.println("jsonObject" + jsonObject.toString());
        }
    }

}


