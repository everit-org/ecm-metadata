package org.everit.osgi.ecm.metadata.test;

import java.lang.reflect.Method;

import org.everit.osgi.ecm.metadata.util.MethodDefinition;
import org.everit.osgi.ecm.metadata.util.MethodUtil;
import org.junit.Assert;
import org.junit.Test;

public class MethodUtilTest {

    private static final ClassLoader CL = MethodUtilTest.class.getClassLoader();

    @Test
    public void testCreateMethodSignatureWithArrayParam() {
        // System.out.println(MethodUtil.METHOD_SIGNATURE_PATTERN.toString());

        Class<String> stringType = String.class;
        Method method;
        try {
            method = stringType.getMethod("getChars", int.class, int.class, char[].class, int.class);
            String methodSignature = MethodUtil.createMethodSignature(method);
            Assert.assertEquals("getChars(int, int, char[], int)", methodSignature);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateMethodSignatureWithMultipleParameters() {
        Class<String> stringType = String.class;
        Method method;
        try {
            method = stringType.getMethod("regionMatches", boolean.class, int.class, String.class, int.class,
                    int.class);
            String methodSignature = MethodUtil.createMethodSignature(method);
            Assert.assertEquals("regionMatches(boolean, int, java.lang.String, int, int)", methodSignature);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testCreateMethodSignatureWithNoParameter() {
        Class<String> stringType = String.class;
        Method method;
        try {
            method = stringType.getMethod("trim");
            String methodSignature = MethodUtil.createMethodSignature(method);
            Assert.assertEquals("trim()", methodSignature);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testParseSignatureArrayParams() throws ClassNotFoundException {
        MethodDefinition methodDefinition = MethodUtil.parseMethodSignature(
                "myMethod(boolean[], byte[], char[], double[], float[], int[], long[], short[], java.lang.String[])",
                CL);
        Class<?>[] parameterTypes = methodDefinition.getParameterTypes();
        Assert.assertEquals(boolean[].class, parameterTypes[0]);
        Assert.assertEquals(byte[].class, parameterTypes[1]);
        Assert.assertEquals(char[].class, parameterTypes[2]);
        Assert.assertEquals(double[].class, parameterTypes[3]);
        Assert.assertEquals(float[].class, parameterTypes[4]);
        Assert.assertEquals(int[].class, parameterTypes[5]);
        Assert.assertEquals(long[].class, parameterTypes[6]);
        Assert.assertEquals(short[].class, parameterTypes[7]);
        Assert.assertEquals(String[].class, parameterTypes[8]);
    }

    @Test(expected = ClassNotFoundException.class)
    public void testParseSignatureClassNotFound() throws ClassNotFoundException {
        MethodUtil.parseMethodSignature("test(nonClass)", CL);
    }

    @Test
    public void testParseSignatureEmptyParameters() throws ClassNotFoundException {
        MethodDefinition methodDefinition = MethodUtil.parseMethodSignature("myMethod()", CL);
        Assert.assertEquals("myMethod", methodDefinition.getMethodName());
        Assert.assertEquals(0, methodDefinition.getParameterTypes().length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseSignatureInvalidSignature() throws ClassNotFoundException {
        MethodUtil.parseMethodSignature("test(.)", CL);
    }

    @Test
    public void testParseSignatureMethodNameOnly() throws ClassNotFoundException {
        MethodDefinition methodDefinition = MethodUtil.parseMethodSignature("myMethod", CL);
        Assert.assertEquals("myMethod", methodDefinition.getMethodName());
        Assert.assertNull(methodDefinition.getParameterTypes());
    }

    @Test
    public void testParseSignatureOneParameter() throws ClassNotFoundException {
        MethodDefinition methodDefinition = MethodUtil.parseMethodSignature("myMethod(java.lang.String)", CL);
        Assert.assertEquals("myMethod", methodDefinition.getMethodName());
        Assert.assertArrayEquals(new Class<?>[] { String.class }, methodDefinition.getParameterTypes());
    }

    @Test
    public void testParseSignaturePrimitiveParams() throws ClassNotFoundException {
        MethodDefinition methodDefinition = MethodUtil.parseMethodSignature(
                "myMethod(boolean, byte, char, double, float, int, long, short)", CL);
        Class<?>[] parameterTypes = methodDefinition.getParameterTypes();
        Assert.assertEquals(boolean.class, parameterTypes[0]);
        Assert.assertEquals(byte.class, parameterTypes[1]);
        Assert.assertEquals(char.class, parameterTypes[2]);
        Assert.assertEquals(double.class, parameterTypes[3]);
        Assert.assertEquals(float.class, parameterTypes[4]);
        Assert.assertEquals(int.class, parameterTypes[5]);
        Assert.assertEquals(long.class, parameterTypes[6]);
        Assert.assertEquals(short.class, parameterTypes[7]);
    }
}
