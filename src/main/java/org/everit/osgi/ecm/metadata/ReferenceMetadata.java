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

import java.util.Objects;

import org.everit.osgi.ecm.util.method.MethodDescriptor;

public abstract class ReferenceMetadata extends AttributeMetadata<String[]> {
    public abstract static class ReferenceMetadataBuilder<B extends ReferenceMetadataBuilder<B>> extends
            AttributeMetadataBuilder<String[], B> {

        private ReferenceConfigurationType referenceConfigurationType = ReferenceConfigurationType.FILTER;

        private String referenceId = null;

        private MethodDescriptor setter = null;

        @Override
        protected void beforeBuild() {
            Objects.requireNonNull(referenceId, "Reference id must be specified");
            String attributeId = getAttributeId();

            if (attributeId == null) {
                if (ReferenceConfigurationType.CLAUSE.equals(referenceConfigurationType)) {
                    withAttributeId(referenceId + ".clause");
                } else {
                    withAttributeId(referenceId + ".target");
                }
            }
        }

        public ReferenceConfigurationType getReferenceConfigurationType() {
            return referenceConfigurationType;
        }

        public String getReferenceId() {
            return referenceId;
        }

        public MethodDescriptor getSetter() {
            return setter;
        }

        @Override
        public Class<String> getValueType() {
            return String.class;
        }

        public B withReferenceConfigurationType(
                final ReferenceConfigurationType referenceConfigurationType) {

            this.referenceConfigurationType = referenceConfigurationType;
            return self();
        }

        public B withReferenceId(final String referenceId) {
            this.referenceId = referenceId;
            return self();
        }

        public B withSetter(final MethodDescriptor setter) {
            this.setter = setter;
            return self();
        }

    }

    private final ReferenceConfigurationType referenceConfigurationType;

    private final String referenceId;

    /**
     * The bind method that should be used to bind the reference. If the annotation is defined on a method, that method
     * and it is not specified otherwise in the annotation, the method will be used as a bind method. If the annotation
     * is attached to a field and the bind method is not defined in the annotation and there is method that has the same
     * name as the field but prefixed with "bind" that method will be used as a bind method. In case there is no bind
     * method but there is a setter for the field, it will be used to set the property.
     */
    private final MethodDescriptor setter;

    protected <B extends ReferenceMetadataBuilder<B>> ReferenceMetadata(final ReferenceMetadataBuilder<B> builder) {
        super(builder);
        setter = builder.setter;
        referenceId = builder.referenceId;
        referenceConfigurationType = builder.referenceConfigurationType;
    }

    @Override
    protected String[] cloneValueArray(String[] value) {
        return value.clone();
    }

    public ReferenceConfigurationType getReferenceConfigurationType() {
        return referenceConfigurationType;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public MethodDescriptor getSetter() {
        return setter;
    }
}
