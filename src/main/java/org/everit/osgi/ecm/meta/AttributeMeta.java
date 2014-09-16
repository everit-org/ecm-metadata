/**
 * This file is part of Everit - Component Metadata.
 *
 * Everit - Component Metadata is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Component Metadata is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Component Metadata.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.meta;

import java.util.Arrays;
import java.util.Objects;

public abstract class AttributeMeta<V> implements AttributeMetaHolder<V> {

    public static abstract class AttributeMetaBuilder<V, B extends AttributeMetaBuilder<V, B>> {

        @SuppressWarnings("unchecked")
        private V[] defaultValue = (V[]) new Object[0];

        private String description;

        private String label;

        private boolean metatype;

        private String name;

        public abstract AttributeMeta<V> build();

        protected abstract B self();

        public B withDefaultValue(final V[] defaultValue) {
            this.defaultValue = Arrays.copyOf(defaultValue, defaultValue.length);
            return self();
        }

        public B withDescription(final String description) {
            this.description = description;
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

        public B withName(final String name) {
            this.name = name;
            return self();
        }
    }

    private final V[] defaultValue;

    private final String description;

    private final String label;

    private final boolean metatype;

    private final String name;

    protected <B extends AttributeMetaBuilder<V, B>> AttributeMeta(final AttributeMetaBuilder<V, B> builder) {
        Objects.requireNonNull(builder.name, "Name must be provided for attribute");
        this.name = builder.name;

        if (builder.label != null) {
            this.label = builder.label;
        } else if (name != null) {
            this.label = "%" + this.name + ".name";
        } else {
            this.label = null;
        }

        if (builder.description != null) {
            this.description = builder.description;
        } else if (name != null) {
            this.description = "%" + this.name + ".description";
        } else {
            this.description = null;
        }

        this.defaultValue = builder.defaultValue;

        this.metatype = builder.metatype;
    }

    @Override
    public AttributeMeta<V> getAttribute() {
        return this;
    }

    public V[] getDefaultValue() {
        return Arrays.copyOf(defaultValue, defaultValue.length);
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
