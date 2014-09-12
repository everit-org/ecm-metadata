package org.everit.osgi.component.meta;

import java.util.Objects;

public abstract class AttributeMeta {

    public static abstract class AttributeMetaBuilder<B extends AttributeMetaBuilder<B>> {
        private String description;

        private String label;

        private boolean metatype;

        private String name;

        public abstract AttributeMeta build();

        protected abstract B self();

        public B withDescription(String description) {
            this.description = description;
            return self();
        }

        public B withLabel(String label) {
            this.label = label;
            return self();
        }

        public B withMetatype(boolean metatype) {
            this.metatype = metatype;
            return self();
        }

        public B withName(String name) {
            this.name = name;
            return self();
        }
    }

    private final String description;

    private final String label;

    private final boolean metatype;

    private final String name;

    protected <B extends AttributeMetaBuilder<B>> AttributeMeta(AttributeMetaBuilder<B> builder) {
        Objects.requireNonNull(builder.name, "Name must be provided for the attribute");
        this.name = builder.name;

        if (builder.label != null) {
            this.label = builder.label;
        } else {
            this.label = "%" + this.name + ".name";
        }

        if (builder.description != null) {
            this.description = builder.description;
        } else {
            this.description = "%" + this.name + ".description";
        }

        this.metatype = builder.metatype;

    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public boolean isMetatype() {
        return metatype;
    }

}
