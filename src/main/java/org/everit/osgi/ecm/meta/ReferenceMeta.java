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
package org.everit.osgi.ecm.meta;

public class ReferenceMeta implements AttributeMetaHolder<String> {

    public static class ReferenceMetaBuilder {

        private ReferenceAttributeMeta attribute = null;

        private String bind = null;

        private ReferenceCardinality cardinality = ReferenceCardinality.MANDATORY;

        private boolean dynamic = false;

        private String name = null;

        private Class<?> referenceInterface = null;

        private String unbind = null;

        public ReferenceMeta build() {
            return new ReferenceMeta(this);
        }

        public ReferenceMetaBuilder withAttribute(final ReferenceAttributeMeta attribute) {
            this.attribute = attribute;
            return this;
        }

        public ReferenceMetaBuilder withBind(final String bind) {
            this.bind = bind;
            return this;
        }

        public ReferenceMetaBuilder withCardinality(final ReferenceCardinality cardinality) {
            this.cardinality = cardinality;
            return this;
        }

        public ReferenceMetaBuilder withDynamic(final boolean dynamic) {
            this.dynamic = dynamic;
            return this;
        }

        public ReferenceMetaBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public ReferenceMetaBuilder withReferenceInterface(Class<?> referenceInterface) {
            this.referenceInterface = referenceInterface;
            return this;
        }

        public ReferenceMetaBuilder withUnbind(final String unbind) {
            this.unbind = unbind;
            return this;
        }

    }

    private final ReferenceAttributeMeta attribute;

    /**
     * The bind method that should be used to bind the reference. If the annotation is defined on a method, that method
     * and it is not specified otherwise in the annotation, the method will be used as a bind method. If the annotation
     * is attached to a field and the bind method is not defined in the annotation and there is method that has the same
     * name as the field but prefixed with "bind" that method will be used as a bind method. In case there is no bind
     * method but there is a setter for the field, it will be used to set the property.
     */
    private final String bind;

    private final ReferenceCardinality cardinality;

    /**
     * If true, the reference is re-binded without restarting the component in case of a service switch. The component
     * also does not stop if the configuration is updated behind in the way that the reference can remain satisfied
     * after the actualization of the clause(s) or filter(s). In case of false, the component is stopped and
     * re-instantiated every time there is a change for any item of the reference.
     */
    private final boolean dynamic;

    private final String name;

    private final Class<?> referenceInterface;

    /**
     * The bind method that should be used to bind the reference. In case the unbind method is not specified but there
     * is a method starting with "un" and ending with the name of the bind method, that method will be used to unbind
     * the reference.
     */
    private final String unbind;

    private ReferenceMeta(final ReferenceMetaBuilder builder) {
        bind = builder.bind;
        cardinality = builder.cardinality;
        dynamic = builder.dynamic;
        unbind = builder.unbind;
        referenceInterface = builder.referenceInterface;
        name = builder.name;

        attribute = evaluateAttribute(builder);
    }

    private ReferenceAttributeMeta evaluateAttribute(final ReferenceMetaBuilder builder) {
        if (builder.attribute.getName() != null) {
            return builder.attribute;
        }

        ReferenceAttributeMeta builderAttribute = builder.attribute;

        String attributeNameExtension = ".target";
        if (ReferenceConfigurationType.CLAUSE.equals(builderAttribute.getReferenceAttributeType())) {
            attributeNameExtension = ".clause";
        }
        return new ReferenceAttributeMeta.ReferenceAttributeMetaBuilder()
                .withDefaultValue(builderAttribute.getDefaultValue())
                .withDescription(builderAttribute.getDescription())
                .withLabel(builderAttribute.getLabel())
                .withMetatype(builderAttribute.isMetatype())
                .withName(name + attributeNameExtension)
                .withReferenceConfigurationType(builderAttribute.getReferenceAttributeType())
                .build();

    }

    @Override
    public ReferenceAttributeMeta getAttribute() {
        return attribute;
    }

    public String getBind() {
        return bind;
    }

    public ReferenceCardinality getCardinality() {
        return cardinality;
    }

    public String getName() {
        return name;
    }

    public Class<?> getReferenceInterface() {
        return referenceInterface;
    }

    public String getUnbind() {
        return unbind;
    }

    public boolean isDynamic() {
        return dynamic;
    }

}
