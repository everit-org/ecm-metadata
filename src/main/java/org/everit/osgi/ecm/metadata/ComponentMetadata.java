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

        private AttributeMetadataHolder<?>[] attributeHolders = new AttributeMetadataHolder[0];

        private Class<C> clazz = null;

        private boolean configurationFactory = false;

        private String configurationPid = null;

        private boolean configurationRequired = false;

        private String description = null;

        private String icon = null;

        private String label = null;

        private String localization = null;

        private String name = null;

        public ComponentMetadata<C> build() {
            ComponentMetadata<C> componentMeta = new ComponentMetadata<C>(this);
            return componentMeta;
        }

        public ComponentMetadataBuilder<C> withAttributeHolders(final AttributeMetadataHolder<?>[] attributeHolders) {
            this.attributeHolders = Arrays.copyOf(attributeHolders, attributeHolders.length);
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

        public ComponentMetadataBuilder<C> withConfigurationRequired(final boolean configurationRequired) {
            this.configurationRequired = configurationRequired;
            return this;
        }

        public ComponentMetadataBuilder<C> withDescription(final String description) {
            this.description = description;
            return this;
        }

        public ComponentMetadataBuilder<C> withIcon(final String icon) {
            this.icon = icon;
            return this;
        }

        public ComponentMetadataBuilder<C> withLabel(final String label) {
            this.label = label;
            return this;
        }

        public ComponentMetadataBuilder<C> withLocalization(final String localization) {
            this.localization = localization;
            return this;
        }

        public ComponentMetadataBuilder<C> withName(final String name) {
            this.name = name;
            return this;
        }

        public ComponentMetadataBuilder<C> withType(final Class<C> clazz) {
            this.clazz = clazz;
            return this;
        }
    }

    private final AttributeMetadataHolder<?>[] attributeHolders;

    private final Class<C> clazz;

    private final boolean configurationFactory;

    private final String configurationPid;

    private final boolean configurationRequired;

    private final String description;

    private final String icon;

    private final String label;

    private final String localization;

    private final String name;

    private ComponentMetadata(final ComponentMetadataBuilder<C> builder) {

        Objects.requireNonNull(builder.clazz, "Class type for ComponentMeta must be provided");
        this.clazz = builder.clazz;

        Objects.requireNonNull(builder.attributeHolders, "attributes must not be null");
        this.attributeHolders = builder.attributeHolders;

        if (builder.name != null) {
            this.name = builder.name;
        } else {
            this.name = clazz.getName();
        }

        this.configurationFactory = builder.configurationFactory;

        if (builder.configurationPid != null) {
            this.configurationPid = builder.configurationPid;
        } else {
            this.configurationPid = this.name;
        }

        if (builder.label != null) {
            this.label = builder.label;
        } else {
            this.label = "%" + this.name + ".name";
        }

        if (builder.description != null) {
            this.description = builder.description;
        } else {
            this.description = "%" + this.name + ".description";
        }

        this.configurationRequired = builder.configurationRequired;

        this.icon = builder.icon;

        this.localization = builder.localization;

    }

    public AttributeMetadataHolder<?>[] getAttributeHolders() {
        return Arrays.copyOf(attributeHolders, attributeHolders.length);
    }

    public String getConfigurationPid() {
        return configurationPid;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

    public String getLabel() {
        return label;
    }

    public String getLocalization() {
        return localization;
    }

    public String getName() {
        return name;
    }

    public Class<C> getType() {
        return clazz;
    }

    public boolean isConfigurationFactory() {
        return configurationFactory;
    }

    public boolean isConfigurationRequired() {
        return configurationRequired;
    }

}
