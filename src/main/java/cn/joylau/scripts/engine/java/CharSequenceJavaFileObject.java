/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.scripts.engine.java;


import javax.tools.SimpleJavaFileObject;
import java.io.File;

public class CharSequenceJavaFileObject  extends SimpleJavaFileObject {

    private CharSequence content;


    public CharSequenceJavaFileObject(String javaFilePath, String className, CharSequence content) throws Exception {
        super(new File(javaFilePath + className.replace('.', '/') + Kind.SOURCE.extension).toURI(), Kind.SOURCE);
        this.content = content;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return content;
    }
}