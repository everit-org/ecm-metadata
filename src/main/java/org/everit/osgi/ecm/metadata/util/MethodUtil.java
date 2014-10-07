package org.everit.osgi.ecm.metadata.util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MethodUtil {

    public static final String GROUP_METHOD_NAME = "methodName";

    public static final String GROUP_PARAMETER_TYPES = "parameterTypes";

    private static final String METHOD_NAME_REGEX = "(?<" + GROUP_METHOD_NAME + ">[\\p{L}_][\\p{L}\\p{N}_]*)";

    public static final Pattern METHOD_SIGNATURE_PATTERN;

    public static final String PARAM_TYPE_REGEX =
            "([\\p{L}_$][\\p{L}\\p{N}_$]*\\.)*[\\p{L}_$][\\p{L}\\p{N}_$]*(\\s*\\[\\s*\\])?";

    private static final String PARAM_TYPE_WITH_SPACES_REGEX = "\\s*" + PARAM_TYPE_REGEX + "\\s*";

    private static final String PARAM_TYPE_WITH_SPACES_REGEX_AND_COMMA = PARAM_TYPE_WITH_SPACES_REGEX + "\\,";

    private static final String PARAMETER_TYPES_REGEX = "(?<" + GROUP_PARAMETER_TYPES + ">\\((("
            + PARAM_TYPE_WITH_SPACES_REGEX_AND_COMMA + ")*(" + PARAM_TYPE_WITH_SPACES_REGEX + "))?\\))?";

    private static final Map<String, Class<?>> PRIMITIVE_CLASS_MAPPING;

    static {
        METHOD_SIGNATURE_PATTERN = Pattern
                .compile(METHOD_NAME_REGEX + PARAMETER_TYPES_REGEX);

        PRIMITIVE_CLASS_MAPPING = new HashMap<String, Class<?>>(16);
        PRIMITIVE_CLASS_MAPPING.put("boolean", boolean.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lboolean;", boolean[].class);
        PRIMITIVE_CLASS_MAPPING.put("byte", byte.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lbyte;", byte[].class);
        PRIMITIVE_CLASS_MAPPING.put("char", char.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lchar;", char[].class);
        PRIMITIVE_CLASS_MAPPING.put("double", double.class);
        PRIMITIVE_CLASS_MAPPING.put("[Ldouble;", double[].class);
        PRIMITIVE_CLASS_MAPPING.put("float", float.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lfloat;", float[].class);
        PRIMITIVE_CLASS_MAPPING.put("int", int.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lint;", int[].class);
        PRIMITIVE_CLASS_MAPPING.put("long", long.class);
        PRIMITIVE_CLASS_MAPPING.put("[Llong;", long[].class);
        PRIMITIVE_CLASS_MAPPING.put("short", short.class);
        PRIMITIVE_CLASS_MAPPING.put("[Lshort;", short[].class);
    }

    public static String createMethodSignature(Method method) {
        StringBuilder sb = new StringBuilder(method.getName());
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        int lastIndexOfParameterTypes = parameterTypes.length - 1;
        for (int i = 0; i < parameterTypes.length; i++) {
            Class<?> parameterType = parameterTypes[i];
            if (parameterType.isArray()) {
                // We support only one dimensional array here
                Class<?> componentType = parameterType.getComponentType();
                sb.append(componentType.getName());
                sb.append("[]");
            } else {
                sb.append(parameterType.getName());
            }
            if (i < lastIndexOfParameterTypes) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    private static Class<?> loadClass(ClassLoader classLoader, String parameterTypeString)
            throws ClassNotFoundException {
        int indexOfArrayBracket = parameterTypeString.indexOf('[');
        if (indexOfArrayBracket > 0) {
            parameterTypeString = "[L" + parameterTypeString.substring(0, indexOfArrayBracket).trim() + ";";
        }

        Class<?> primitiveType = PRIMITIVE_CLASS_MAPPING.get(parameterTypeString);
        if (primitiveType != null) {
            return primitiveType;
        }

        return Class.forName(parameterTypeString, true, classLoader);
    }

    public static MethodDefinition parseMethodSignature(String methodSignature, ClassLoader classLoader)
            throws ClassNotFoundException {
        Matcher matcher = METHOD_SIGNATURE_PATTERN.matcher(methodSignature);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("The method signature cannot be parsed: " + methodSignature);
        }

        String methodName = matcher.group(GROUP_METHOD_NAME);
        String parameterTypesString = matcher.group(GROUP_PARAMETER_TYPES);

        if (parameterTypesString == null) {
            return new MethodDefinition(methodName, null);
        }

        // Crop the brackets and trim
        parameterTypesString = parameterTypesString.substring(1, parameterTypesString.length() - 1);
        parameterTypesString = parameterTypesString.trim();

        if ("".equals(parameterTypesString)) {
            return new MethodDefinition(methodName, new Class<?>[0]);
        }

        String[] parameterTypeStringArray = parameterTypesString.split(",");
        Class<?>[] parameterTypeArray = new Class<?>[parameterTypeStringArray.length];
        for (int i = 0; i < parameterTypeStringArray.length; i++) {
            String parameterTypeString = parameterTypeStringArray[i].trim();
            parameterTypeArray[i] = loadClass(classLoader, parameterTypeString);
        }

        return new MethodDefinition(methodName, parameterTypeArray);
    }
}
