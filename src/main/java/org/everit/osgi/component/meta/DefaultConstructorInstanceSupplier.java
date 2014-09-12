package org.everit.osgi.component.meta;


public class DefaultConstructorInstanceSupplier<C> implements InstanceSupplier<C> {

    private final Class<C> clazz;

    public DefaultConstructorInstanceSupplier(Class<C> clazz) {
        this.clazz = clazz;
    }

    @Override
    public C get() {
        try {
            return clazz.newInstance();
        } catch (SecurityException e) {
            throw new ComponentInstantiationException(e);
        } catch (InstantiationException e) {
            throw new ComponentInstantiationException(e);
        } catch (IllegalAccessException e) {
            throw new ComponentInstantiationException(e);
        }
    }

}
