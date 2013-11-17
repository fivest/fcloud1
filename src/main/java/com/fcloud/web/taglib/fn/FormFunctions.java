package com.fcloud.web.taglib.fn;

import com.fcloud.core.model.Persistable;

/**
 * @author Ruben Fu
 */
public class FormFunctions {

    public static String idp(Persistable model) {
        if (model.isNew()) {
            return "";
        }
        return "/" + model.getId();
    }

    public static String action(String path, Persistable model) {
        if (model.isNew()) {
            return path;
        }
        if (path == null || path.length() == 0) {
            return path;
        }
        if (path.endsWith("/")) {
            return path + model.getId();
        }
        return path + "/" + model.getId();
    }
}
