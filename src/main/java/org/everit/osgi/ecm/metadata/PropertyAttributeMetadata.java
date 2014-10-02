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
package org.everit.osgi.ecm.metadata;

import java.lang.reflect.Method;

public abstract class PropertyAttributeMetadata<V> extends AttributeMetadata<V> {

    public static abstract class PropertyAttributeMetadataBuilder<V, B extends PropertyAttributeMetadataBuilder<V, B>>
            extends AttributeMetadataBuilder<V, B> {

        private Method setter = null;

        public B withSetter(final Method setter) {
            this.setter = setter;
            return self();
        }
    }

    private final Method setter;

    protected <B extends PropertyAttributeMetadataBuilder<V, B>> PropertyAttributeMetadata(
            final PropertyAttributeMetadataBuilder<V, B> builder) {

        super(builder);

        if (builder.setter != null) {
            Class<?>[] parameterTypes = builder.setter.getParameterTypes();
            if (parameterTypes.length != 1) {
                throw new MetadataValidationException("Setter '" + builder.setter.toGenericString()
                        + "' of attribute '" + getAttributeId() + "' must have exactly one argument.");
            }
            Class<V> valueType = getValueType();
            boolean paramTypeSameAsValueType = valueType.equals(parameterTypes[0]);
            if (isOptional() && !paramTypeSameAsValueType) {
                throw new MetadataValidationException("Argument of setter '" + builder.setter.toGenericString()
                        + "' of optional attribute '" + getAttributeId() + "' must be '" + valueType.toString() + "'");
            } else {
                Class<?> primitiveType = getPrimitiveTypeInternal();
                if (!isOptional() && !paramTypeSameAsValueType && primitiveType != null
                        && !valueType.equals(primitiveType)) {
                    throw new MetadataValidationException("Argument of setter '" + builder.setter.toGenericString()
                            + "' of attribute '" + getAttributeId() + "' must be "
                            + ((primitiveType != null) ? "either" : "")
                            + " '" + valueType.toString() + "'"
                            + ((primitiveType != null) ? (" or '" + getPrimitiveTypeInternal() + "'") : ""));
                }
            }
        }
        this.setter = builder.setter;
    }

    public Class<?> getPrimitiveType() {
        if (isOptional()) {
            return null;
        }
        return getPrimitiveTypeInternal();
    }

    public abstract Class<?> getPrimitiveTypeInternal();

    public Method getSetter() {
        return setter;
    }
}
