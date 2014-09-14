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
package org.everit.osgi.component.meta;

public abstract class PropertyAttributeMeta<V> extends AttributeMeta<V> {

    public static abstract class PropertyAttributeMetaBuilder<V, B extends PropertyAttributeMetaBuilder<V, B>>
            extends AttributeMetaBuilder<V, B> {

        /**
         * Return the cardinality of this attribute.
         *
         * The OSGi environment handles multi valued attributes in arrays ([]) or in {@code Vector} objects. The return
         * value is defined as follows:
         *
         * <pre>
         *
         *    x = Integer.MIN_VALUE    no limit, but use Vector
         *    x &lt; 0                    -x = max occurrences, store in Vector
         *    x &gt; 0                     x = max occurrences, store in array []
         *    x = Integer.MAX_VALUE    no limit, but use array []
         *    x = 0                     1 occurrence required
         *
         * </pre>
         *
         * @return The cardinality of this attribute.
         */
        int cardinality;

        private boolean dynamic = false;

        private String setter;

        public B withCardinality(final int cardinality) {
            this.cardinality = cardinality;
            return self();
        }

        public B withDynamic(final boolean dynamic) {
            this.dynamic = dynamic;
            return self();
        }

        public B withSetter(final String setter) {
            this.setter = setter;
            return self();
        }

    }

    private final int cardinality;

    private final boolean dynamic;

    private final String setter;

    protected <B extends PropertyAttributeMetaBuilder<V, B>> PropertyAttributeMeta(
            final PropertyAttributeMetaBuilder<V, B> builder) {

        super(builder);
        this.setter = builder.setter;
        this.dynamic = builder.dynamic;
        this.cardinality = builder.cardinality;
    }

    public int getCardinality() {
        return cardinality;
    }

    public String getSetter() {
        return setter;
    }

    public boolean isDynamic() {
        return dynamic;
    }
}
