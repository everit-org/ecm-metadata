package org.everit.osgi.ecm.metadata.util;

public class MethodDefinition {

    private final String methodName;

    private final Class<?>[] parameterTypes;

    public MethodDefinition(String name, Class<?>[] parameterTypes) {
        this.methodName = name;
        this.parameterTypes = parameterTypes;
    }

    public String getMethodName() {
        return methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

}
