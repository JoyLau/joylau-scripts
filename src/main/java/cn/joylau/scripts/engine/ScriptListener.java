/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.scripts.engine;

public interface ScriptListener {
    void before(ScriptContext context);

    void after(ScriptContext context, ExecuteResult result);
}
