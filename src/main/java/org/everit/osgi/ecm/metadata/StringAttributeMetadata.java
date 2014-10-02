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

public class StringAttributeMetadata extends SelectablePropertyAttributeMetadata<String> {

    public static class StringAttributeMetadataBuilder
            extends SelectablePropertyAttributeMetadataBuilder<String, StringAttributeMetadataBuilder> {

        private boolean multiLine = false;

        @Override
        public StringAttributeMetadata buildInternal() {
            return new StringAttributeMetadata(this);
        }

        @Override
        public Class<String> getValueType() {
            return String.class;
        }

        @Override
        protected StringAttributeMetadataBuilder self() {
            return this;
        }

        public StringAttributeMetadataBuilder withMultiLine(final boolean multiline) {
            multiLine = multiline;
            return self();
        }
    }

    private final boolean multiLine;

    protected StringAttributeMetadata(
            final StringAttributeMetadataBuilder builder) {
        super(builder);
        multiLine = builder.multiLine;
    }

    public boolean isMultiLine() {
        return multiLine;
    }

    @Override
    public Class<?> getPrimitiveTypeInternal() {
        return null;
    }

}
