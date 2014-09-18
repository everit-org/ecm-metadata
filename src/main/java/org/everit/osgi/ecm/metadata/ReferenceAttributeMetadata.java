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

public class ReferenceAttributeMetadata extends AttributeMetadata<String> {

    public static class ReferenceAttributeMetadataBuilder
            extends AttributeMetadataBuilder<String, ReferenceAttributeMetadataBuilder> {

        private ReferenceConfigurationType referenceConfigurationType = ReferenceConfigurationType.FILTER;

        @Override
        public ReferenceAttributeMetadata build() {
            return new ReferenceAttributeMetadata(this);
        }

        @Override
        public Class<String> getValueType() {
            return String.class;
        }

        @Override
        protected ReferenceAttributeMetadataBuilder self() {
            return this;
        }

        public ReferenceAttributeMetadataBuilder withReferenceConfigurationType(
                final ReferenceConfigurationType referenceAttributeType) {
            referenceConfigurationType = referenceAttributeType;
            return this;
        }
    }

    private final ReferenceConfigurationType referenceAttributeType;

    protected ReferenceAttributeMetadata(
            final ReferenceAttributeMetadataBuilder builder) {
        super(builder);
        referenceAttributeType = builder.referenceConfigurationType;

    }

    public ReferenceConfigurationType getReferenceAttributeType() {
        return referenceAttributeType;
    }
}
