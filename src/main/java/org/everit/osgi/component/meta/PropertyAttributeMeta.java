package org.everit.osgi.component.meta;

public abstract class PropertyAttributeMeta extends AttributeMeta {

    public static abstract class PropertyAttributeMetaBuilder<B extends AttributeMetaBuilder<B>>
            extends AttributeMetaBuilder<B> {

        private String setter;

        public B withSetter(String setter) {
            this.setter = setter;
            return self();
        }

    }

    private final String setter;

    protected <B extends PropertyAttributeMetaBuilder<B>> PropertyAttributeMeta(
            PropertyAttributeMetaBuilder<B> builder) {

        super(builder);
        this.setter = builder.setter;
    }

    public String getSetter() {
        return setter;
    }

}
