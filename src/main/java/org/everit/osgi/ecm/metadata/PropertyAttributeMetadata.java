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

import org.everit.osgi.ecm.util.method.MethodDescriptor;

public abstract class PropertyAttributeMetadata<V> extends AttributeMetadata<V> {

    public static abstract class PropertyAttributeMetadataBuilder<V, B extends PropertyAttributeMetadataBuilder<V, B>>
            extends AttributeMetadataBuilder<V, B> {

        private MethodDescriptor setter = null;

        public abstract Class<?> getPrimitiveType();

        public MethodDescriptor getSetter() {
            return setter;
        }

        public B withSetter(final MethodDescriptor setter) {
            this.setter = setter;
            return self();
        }
    }

    private final Class<?> primitiveType;

    private final MethodDescriptor setter;

    protected <B extends PropertyAttributeMetadataBuilder<V, B>> PropertyAttributeMetadata(
            final PropertyAttributeMetadataBuilder<V, B> builder) {

        super(builder);

        this.setter = builder.setter;
        this.primitiveType = builder.getPrimitiveType();
    }

    public Class<?> getPrimitiveType() {
        return primitiveType;
    }

    public MethodDescriptor getSetter() {
        return setter;
    }
}
