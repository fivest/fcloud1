package com.fcloud.core.model;

import java.io.Serializable;

/**
 * @author Ruben Fu
 */
public interface Persistable extends Serializable {

    String getId();

    boolean isNew();
}
