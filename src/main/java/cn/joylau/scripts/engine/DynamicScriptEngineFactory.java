/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.scripts.engine;


import cn.joylau.scripts.engine.SpEL.SpElEngine;
import cn.joylau.scripts.engine.groovy.GroovyEngine;
import cn.joylau.scripts.engine.java.JavaEngine;
import cn.joylau.scripts.engine.js.JavaScriptEngine;
import cn.joylau.scripts.engine.ognl.OgnlEngine;
import cn.joylau.scripts.engine.python.PythonScriptEngine;
import cn.joylau.scripts.engine.ruby.RubyScriptEngine;

import java.util.HashMap;
import java.util.Map;

public final class DynamicScriptEngineFactory {
    private static final Map<String, DynamicScriptEngine> map = new HashMap<>();

    static {
        JavaScriptEngine engine = new JavaScriptEngine();
        map.put("js", engine);
        map.put("javascript", engine);
        map.put("groovy", new GroovyEngine());
        map.put("ruby", new RubyScriptEngine());
        map.put("python", new PythonScriptEngine());
        try {
            map.put("java", new JavaEngine());
        } catch (Exception e) {

        }
        try {
            Class.forName("org.springframework.expression.ExpressionParser");
            map.put("spel", new SpElEngine());
        } catch (ClassNotFoundException e) {
        }
        try {
            Class.forName("ognl.Ognl");
            map.put("ognl", new OgnlEngine());
        } catch (ClassNotFoundException e) {
        }
    }

    public static final DynamicScriptEngine getEngine(String type) {
        return map.get(type);
    }

}
