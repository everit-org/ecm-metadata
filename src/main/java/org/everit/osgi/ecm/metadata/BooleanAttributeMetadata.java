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

public class BooleanAttributeMetadata extends PropertyAttributeMetadata<boolean[]> {

    public static class BooleanAttributeMetadataBuilder
            extends PropertyAttributeMetadataBuilder<boolean[], BooleanAttributeMetadataBuilder> {

        @Override
        public BooleanAttributeMetadata buildInternal() {
            return new BooleanAttributeMetadata(self());
        }

        @Override
        public Class<?> getValueType() {
            return boolean.class;
        }

        @Override
        protected BooleanAttributeMetadataBuilder self() {
            return this;
        }
    }

    protected BooleanAttributeMetadata(
            final BooleanAttributeMetadataBuilder builder) {
        super(builder);
    }

    @Override
    protected boolean[] cloneValueArray(boolean[] value) {
        return value.clone();
    }
}
