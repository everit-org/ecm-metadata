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

public class PasswordAttributeMetadata extends PropertyAttributeMetadata<String[]> {

    public static class PasswordAttributeMetadataBuilder
            extends PropertyAttributeMetadataBuilder<String[], PasswordAttributeMetadataBuilder> {

        @Override
        public PasswordAttributeMetadata buildInternal() {
            return new PasswordAttributeMetadata(this);
        }

        @Override
        public Class<String> getValueType() {
            return String.class;
        }

        @Override
        protected PasswordAttributeMetadataBuilder self() {
            return this;
        }
    }

    protected PasswordAttributeMetadata(final PasswordAttributeMetadataBuilder builder) {
        super(builder);
    }

    @Override
    protected String[] cloneValueArray(String[] value) {
        return value.clone();
    }
}
