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

import java.util.Objects;

public class ReferenceMetadata extends AttributeMetadata<String> {

    public static class ReferenceMetadataBuilder extends AttributeMetadataBuilder<String, ReferenceMetadataBuilder> {

        private String bind = null;

        private ReferenceConfigurationType referenceConfigurationType = ReferenceConfigurationType.FILTER;

        private String referenceId = null;

        private Class<?> referenceInterface = null;

        private String unbind = null;

        @Override
        public ReferenceMetadata build() {
            Objects.requireNonNull(referenceId, "Reference id must be specified");
            String attributeId = getAttributeId();
            if (attributeId == null) {
                if (ReferenceConfigurationType.CLAUSE.equals(referenceConfigurationType)) {
                    withAttributeId(referenceId + ".clause");
                } else {
                    withAttributeId(referenceId + ".target");
                }
            }
            return new ReferenceMetadata(this);
        }

        @Override
        public Class<String> getValueType() {
            return String.class;
        }

        @Override
        protected ReferenceMetadataBuilder self() {
            return this;
        }

        public ReferenceMetadataBuilder withBind(final String bind) {
            this.bind = bind;
            return this;
        }

        public ReferenceMetadataBuilder withReferenceConfigurationType(
                final ReferenceConfigurationType referenceConfigurationType) {

            this.referenceConfigurationType = referenceConfigurationType;
            return this;
        }

        public ReferenceMetadataBuilder withReferenceId(final String referenceId) {
            this.referenceId = referenceId;
            return this;
        }

        public ReferenceMetadataBuilder withReferenceInterface(final Class<?> referenceInterface) {
            this.referenceInterface = referenceInterface;
            return this;
        }

        public ReferenceMetadataBuilder withUnbind(final String unbind) {
            this.unbind = unbind;
            return this;
        }

    }

    /**
     * The bind method that should be used to bind the reference. If the annotation is defined on a method, that method
     * and it is not specified otherwise in the annotation, the method will be used as a bind method. If the annotation
     * is attached to a field and the bind method is not defined in the annotation and there is method that has the same
     * name as the field but prefixed with "bind" that method will be used as a bind method. In case there is no bind
     * method but there is a setter for the field, it will be used to set the property.
     */
    private final String bind;

    private final ReferenceConfigurationType referenceConfigurationType;

    private final String referenceId;

    private final Class<?> referenceInterface;

    /**
     * The bind method that should be used to bind the reference. In case the unbind method is not specified but there
     * is a method starting with "un" and ending with the name of the bind method, that method will be used to unbind
     * the reference.
     */
    private final String unbind;

    private ReferenceMetadata(final ReferenceMetadataBuilder builder) {
        super(builder);
        bind = builder.bind;
        unbind = builder.unbind;
        referenceInterface = builder.referenceInterface;
        referenceId = builder.referenceId;
        referenceConfigurationType = builder.referenceConfigurationType;
    }

    public String getBind() {
        return bind;
    }

    public ReferenceConfigurationType getReferenceConfigurationType() {
        return referenceConfigurationType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public Class<?> getReferenceInterface() {
        return referenceInterface;
    }

    public String getUnbind() {
        return unbind;
    }
}
