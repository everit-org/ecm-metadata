/**
 * This file is part of Everit - ECM Metadata.
 *
 * Everit - ECM Metadata is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - ECM Metadata is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - ECM Metadata.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.metadata;

import java.util.Arrays;
import java.util.Objects;

public abstract class AttributeMetadata<V> {

    public static abstract class AttributeMetadataBuilder<V, B extends AttributeMetadataBuilder<V, B>> {

        private String attributeId = null;

        private V[] defaultValue = null;

        private String description = null;

        private boolean dynamic = false;

        private String label = null;

        private boolean metatype = true;

        private boolean multiple = false;

        private boolean optional = false;

        protected void beforeBuild() {
        }

        public final AttributeMetadata<V> build() {
            beforeBuild();
            return buildInternal();
        }

        protected abstract AttributeMetadata<V> buildInternal();

        public String getAttributeId() {
            return attributeId;
        }

        public V[] getDefaultValue() {
            return defaultValue.clone();
        }

        public String getDescription() {
            return description;
        }

        public String getLabel() {
            return label;
        }

        public abstract Class<V> getValueType();

        public boolean isDynamic() {
            return dynamic;
        }

        public boolean isMetatype() {
            return metatype;
        }

        public boolean isMultiple() {
            return multiple;
        }

        public boolean isOptional() {
            return optional;
        }

        protected abstract B self();

        public B withAttributeId(final String attributeId) {
            this.attributeId = attributeId;
            return self();
        }

        public B withDefaultValue(@SuppressWarnings("unchecked") final V... defaultValue) {
            if (defaultValue == null) {
                this.defaultValue = null;
            } else {
                for (V element : defaultValue) {
                    if (element == null) {
                        throw new IllegalArgumentException("Null is not allowed as the element of default value array");
                    }
                }
                this.defaultValue = Arrays.copyOf(defaultValue, defaultValue.length);
            }
            return self();
        }

        public B withDescription(final String description) {
            this.description = description;
            return self();
        }

        public B withDynamic(final boolean dynamic) {
            this.dynamic = dynamic;
            return self();
        }

        public B withLabel(final String label) {
            this.label = label;
            return self();
        }

        public B withMetatype(final boolean metatype) {
            this.metatype = metatype;
            return self();
        }

        public B withMultiple(boolean multiple) {
            this.multiple = multiple;
            return self();
        }

        public B withOptional(boolean optional) {
            this.optional = optional;
            return self();
        }

    }

    private final String attributeId;

    private final V[] defaultValue;

    private final String description;

    private final boolean dynamic;

    private final String label;

    private final boolean metatype;

    private final boolean multiple;

    private final boolean optional;

    private final Class<V> valueType;

    protected <B extends AttributeMetadataBuilder<V, B>> AttributeMetadata(
            final AttributeMetadataBuilder<V, B> builder) {
        Objects.requireNonNull(builder.attributeId, "Attribute id must be specified");
        this.attributeId = builder.attributeId;

        this.defaultValue = builder.defaultValue;
        if (defaultValue != null && defaultValue.length != 1 && !builder.multiple) {
            throw new IllegalArgumentException(
                    "Only one element array or null can be specidied as default value for non-multiple attribute: "
                            + attributeId);
        }

        this.valueType = builder.getValueType();

        if (builder.label != null) {
            this.label = builder.label;
        } else if (attributeId != null) {
            this.label = "%" + this.attributeId + ".name";
        } else {
            this.label = null;
        }

        if (builder.description != null) {
            this.description = builder.description;
        } else if (attributeId != null) {
            this.description = "%" + this.attributeId + ".description";
        } else {
            this.description = null;
        }

        this.metatype = builder.metatype;
        this.multiple = builder.multiple;
        this.optional = builder.optional;
        this.dynamic = builder.dynamic;
    }

    public String getAttributeId() {
        return attributeId;
    }

    public V[] getDefaultValue() {
        if (defaultValue == null) {
            return null;
        } else {
            return Arrays.copyOf(defaultValue, defaultValue.length);
        }
    }

    public String getDescription() {
        return description;
    }

    public String getLabel() {
        return label;
    }

    public Class<V> getValueType() {
        return valueType;
    }

    public boolean isDynamic() {
        return dynamic;
    }

    public boolean isMetatype() {
        return metatype;
    }

    public boolean isMultiple() {
        return multiple;
    }

    public boolean isOptional() {
        return optional;
    }
}
