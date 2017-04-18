/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.scripts.engine.java;

import java.util.Map;

public interface Executor {
    Object execute(Map<String, Object> var) throws Exception;
}
