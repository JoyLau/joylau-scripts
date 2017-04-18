/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.scripts.engine.js;


import cn.joylau.commons.utils.MD5;
import cn.joylau.commons.utils.StringUtils;
import cn.joylau.scripts.engine.common.CommonScriptEngine;

import javax.script.CompiledScript;

public class JavaScriptEngine extends CommonScriptEngine {

    @Override
    public String getScriptName() {
        return "javascript";
    }

    @Override
    public boolean compile(String id, String code) throws Exception {
        if (logger.isDebugEnabled()) {
            logger.debug("compile {} {} : {}", getScriptName(), id, code);
        }
        if (compilable == null)
            init();
        CompiledScript compiledScript = compilable.compile(StringUtils.concat("(function(){", code, "\n})();"));
        CommonScriptContext scriptContext = new CommonScriptContext(id, MD5.defaultEncode(code), compiledScript);
        scriptBase.put(id, scriptContext);
        return true;
    }
}
