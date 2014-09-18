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

public class LongAttributeMetadata extends SelectablePropertyAttributeMetadata<Long> {

    public static class LongAttributeMetadataBuilder
            extends SelectablePropertyAttributeMetadataBuilder<Long, LongAttributeMetadataBuilder> {

        @Override
        public LongAttributeMetadata build() {
            return new LongAttributeMetadata(this);
        }

        @Override
        public Class<Long> getValueType() {
            return Long.class;
        }

        @Override
        protected LongAttributeMetadataBuilder self() {
            return this;
        }
    }

    protected LongAttributeMetadata(
            final LongAttributeMetadataBuilder builder) {
        super(builder);
    }

}
