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

import org.everit.osgi.ecm.util.method.MethodDescriptor;

public final class ComponentMetadata {

    public static class ComponentMetadataBuilder {

        private MethodDescriptor activate = null;

        private AttributeMetadata<?>[] attributes = new AttributeMetadata[0];

        private String clazz = null;

        private String componentId = null;

        private String configurationPid = null;

        private ConfigurationPolicy configurationPolicy = ConfigurationPolicy.OPTIONAL;

        private MethodDescriptor deactivate = null;

        private String description = null;

        private Icon[] icons = new Icon[0];

        private String label = null;

        private String localizationBase = null;

        private boolean metatype = true;

        private ServiceMetadata service = null;

        private MethodDescriptor update = null;

        public ComponentMetadata build() {
            ComponentMetadata componentMeta = new ComponentMetadata(this);
            return componentMeta;
        }

        public MethodDescriptor getActivate() {
            return activate;
        }

        public AttributeMetadata<?>[] getAttributes() {
            return attributes;
        }

        public String getClazz() {
            return clazz;
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

        public MethodDescriptor getDeactivate() {
            return deactivate;
        }

        public String getDescription() {
            return description;
        }

        public Icon[] getIcons() {
            return icons;
        }

        public String getLabel() {
            return label;
        }

        public String getLocalizationBase() {
            return localizationBase;
        }

        public ServiceMetadata getService() {
            return service;
        }

        public MethodDescriptor getUpdate() {
            return update;
        }

        public boolean isMetatype() {
            return metatype;
        }

        public ComponentMetadataBuilder withActivate(final MethodDescriptor activate) {
            this.activate = activate;
            return this;
        }

        public ComponentMetadataBuilder withAttributes(final AttributeMetadata<?>[] attributes) {
            Objects.requireNonNull(attributes);
            this.attributes = Arrays.copyOf(attributes, attributes.length);
            return this;
        }

        public ComponentMetadataBuilder withComponentId(final String componentId) {
            this.componentId = componentId;
            return this;
        }

        public ComponentMetadataBuilder withConfigurationPid(final String configurationPid) {
            this.configurationPid = configurationPid;
            return this;
        }

        public ComponentMetadataBuilder withConfigurationPolicy(final ConfigurationPolicy configurationPolicy) {
            Objects.requireNonNull(configurationPolicy);
            this.configurationPolicy = configurationPolicy;
            return this;
        }

        public ComponentMetadataBuilder withDeactivate(final MethodDescriptor deactivate) {
            this.deactivate = deactivate;
            return this;
        }

        public ComponentMetadataBuilder withDescription(final String description) {
            this.description = description;
            return this;
        }

        public ComponentMetadataBuilder withIcons(Icon[] icons) {
            if (icons != null) {
                this.icons = Arrays.copyOf(icons, icons.length);
            } else {
                this.icons = null;
            }
            return this;
        }

        public ComponentMetadataBuilder withLabel(final String label) {
            this.label = label;
            return this;
        }

        public ComponentMetadataBuilder withLocalizationBase(final String localizationBase) {
            this.localizationBase = localizationBase;
            return this;
        }

        public ComponentMetadataBuilder withMetatype(boolean metatype) {
            this.metatype = metatype;
            return this;
        }

        public ComponentMetadataBuilder withService(final ServiceMetadata service) {
            this.service = service;
            return this;
        }

        public ComponentMetadataBuilder withType(final String clazz) {
            Objects.requireNonNull(clazz);
            this.clazz = clazz;
            return this;
        }

        public ComponentMetadataBuilder withUpdate(final MethodDescriptor update) {
            this.update = update;
            return this;
        }
    }

    private final MethodDescriptor activate;

    private final AttributeMetadata<?>[] attributes;

    private final String clazz;

    private final String componentId;

    private final String configurationPid;

    private final ConfigurationPolicy configurationPolicy;

    private final MethodDescriptor deactivate;

    private final String description;

    private final Icon[] icons;

    private final String label;

    private final String localizationBase;

    private final boolean metatype;

    private final ServiceMetadata service;

    private final MethodDescriptor update;

    private ComponentMetadata(final ComponentMetadataBuilder builder) {

        if (builder.clazz == null) {
            throw new MetadataValidationException("Class type for ComponentMeta must be provided: "
                    + builder.componentId);
        }
        this.clazz = builder.clazz;

        if (builder.componentId != null) {
            this.componentId = builder.componentId;
        } else {
            this.componentId = clazz;
        }

        this.attributes = builder.attributes;

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
        this.activate = builder.activate;
        this.update = builder.update;
        this.deactivate = builder.deactivate;
        this.service = builder.service;

    }

    public MethodDescriptor getActivate() {
        return activate;
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

    public MethodDescriptor getDeactivate() {
        return deactivate;
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

    public ServiceMetadata getService() {
        return service;
    }

    public String getType() {
        return clazz;
    }

    public MethodDescriptor getUpdate() {
        return update;
    }

    public boolean isMetatype() {
        return metatype;
    }
}
