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

import java.util.Arrays;
import java.util.Objects;

public final class ComponentMetadata<C> {

    public static class ComponentMetadataBuilder<C> {

        private String activateMethod = null;

        private AttributeMetadata<?>[] attributes = new AttributeMetadata[0];

        private Class<C> clazz = null;

        private String componentId = null;

        private boolean configurationFactory = false;

        private String configurationPid = null;

        private ConfigurationPolicy configurationPolicy = ConfigurationPolicy.OPTIONAL;

        private String deactivateMethod = null;

        private String description = null;

        private Icon[] icons = new Icon[0];

        private String label = null;

        private String localizationBase = null;

        private boolean metatype = true;

        private String updateMethod = null;

        public ComponentMetadata<C> build() {
            ComponentMetadata<C> componentMeta = new ComponentMetadata<C>(this);
            return componentMeta;
        }

        public ComponentMetadataBuilder<C> withActivateMethod(final String activateMethod) {
            this.activateMethod = activateMethod;
            return this;
        }

        public ComponentMetadataBuilder<C> withAttributes(final AttributeMetadata<?>[] attributes) {
            this.attributes = Arrays.copyOf(attributes, attributes.length);
            return this;
        }

        public ComponentMetadataBuilder<C> withComponentId(final String componentId) {
            this.componentId = componentId;
            return this;
        }

        public ComponentMetadataBuilder<C> withConfigurationFactory(final boolean configurationFactory) {
            this.configurationFactory = configurationFactory;
            return this;
        }

        public ComponentMetadataBuilder<C> withConfigurationPid(final String configurationPid) {
            this.configurationPid = configurationPid;
            return this;
        }

        public ComponentMetadataBuilder<C> withConfigurationPolicy(final ConfigurationPolicy configurationPolicy) {
            this.configurationPolicy = configurationPolicy;
            return this;
        }

        public ComponentMetadataBuilder<C> withDeactivateMethod(final String deactivateMethod) {
            this.deactivateMethod = deactivateMethod;
            return this;
        }

        public ComponentMetadataBuilder<C> withDescription(final String description) {
            this.description = description;
            return this;
        }

        public ComponentMetadataBuilder<C> withIcons(Icon[] icons) {
            if (icons != null) {
                this.icons = Arrays.copyOf(icons, icons.length);
            } else {
                this.icons = null;
            }
            return this;
        }

        public ComponentMetadataBuilder<C> withLabel(final String label) {
            this.label = label;
            return this;
        }

        public ComponentMetadataBuilder<C> withLocalizationBase(final String localizationBase) {
            this.localizationBase = localizationBase;
            return this;
        }

        public ComponentMetadataBuilder<C> withMetatype(boolean metatype) {
            this.metatype = metatype;
            return this;
        }

        public ComponentMetadataBuilder<C> withType(final Class<C> clazz) {
            this.clazz = clazz;
            return this;
        }

        public ComponentMetadataBuilder<C> withUpdateMethod(final String updateMethod) {
            this.updateMethod = updateMethod;
            return this;
        }
    }

    private final String activateMethod;

    private final AttributeMetadata<?>[] attributes;

    private final Class<C> clazz;

    private final String componentId;

    private final boolean configurationFactory;

    private final String configurationPid;

    private final ConfigurationPolicy configurationPolicy;

    private final String deactivateMethod;

    private final String description;

    private final Icon[] icons;

    private final String label;

    private final String localizationBase;

    private final boolean metatype;

    private final String updateMethod;

    private ComponentMetadata(final ComponentMetadataBuilder<C> builder) {

        Objects.requireNonNull(builder.clazz, "Class type for ComponentMeta must be provided");
        this.clazz = builder.clazz;

        Objects.requireNonNull(builder.attributes, "attributes must not be null");
        this.attributes = builder.attributes;

        if (builder.componentId != null) {
            this.componentId = builder.componentId;
        } else {
            this.componentId = clazz.getName();
        }

        this.configurationFactory = builder.configurationFactory;

        if (builder.configurationPid != null) {
            this.configurationPid = builder.configurationPid;
        } else {
            this.configurationPid = this.componentId;
        }

        if (builder.label != null) {
            this.label = builder.label;
        } else {
            this.label = "%" + this.componentId + ".name";
        }

        if (builder.description != null) {
            this.description = builder.description;
        } else {
            this.description = "%" + this.componentId + ".description";
        }

        this.configurationPolicy = builder.configurationPolicy;
        this.icons = builder.icons;
        this.localizationBase = builder.localizationBase;
        this.metatype = builder.metatype;
        this.activateMethod = builder.activateMethod;
        this.updateMethod = builder.updateMethod;
        this.deactivateMethod = builder.deactivateMethod;

    }

    public String getActivateMethod() {
        return activateMethod;
    }

    public AttributeMetadata<?>[] getAttributes() {
        return Arrays.copyOf(attributes, attributes.length);
    }

    public String getComponentId() {
        return componentId;
    }

    public String getConfigurationPid() {
        return configurationPid;
    }

    public ConfigurationPolicy getConfigurationPolicy() {
        return configurationPolicy;
    }

    public String getDeactivateMethod() {
        return deactivateMethod;
    }

    public String getDescription() {
        return description;
    }

    public Icon[] getIcons() {
        if (icons != null) {
            return Arrays.copyOf(icons, icons.length);
        } else {
            return null;
        }
    }

    public String getLabel() {
        return label;
    }

    public String getLocalizationBase() {
        return localizationBase;
    }

    public Class<C> getType() {
        return clazz;
    }

    public boolean isConfigurationFactory() {
        return configurationFactory;
    }

    public boolean isMetatype() {
        return metatype;
    }

    public String getUpdateMethod() {
        return updateMethod;
    }
}
