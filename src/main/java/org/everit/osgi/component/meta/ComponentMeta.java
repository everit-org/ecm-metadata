package org.everit.osgi.component.meta;

import java.util.Arrays;
import java.util.Objects;

import org.osgi.framework.BundleContext;

public final class ComponentMeta<C> {

    public static class ComponentMetaBuilder<C> {

        private AttributeMeta[] attributes = new AttributeMeta[0];

        private BundleContext bundleContext = null;

        private Class<C> clazz = null;

        private boolean configurationFactory = false;

        private String configurationPid = null;

        private boolean configurationRequired = false;

        private String description = null;

        private String icon = null;

        private InstanceSupplier<C> instanceSupplier = null;

        private String label = null;

        private String name = null;

        public ComponentMeta<C> build() {
            ComponentMeta<C> componentMeta = new ComponentMeta<C>(this);
            return componentMeta;
        }

        public ComponentMetaBuilder<C> withAttributes(AttributeMeta[] attributes) {
            this.attributes = Arrays.copyOf(attributes, attributes.length);
            return this;
        }

        public ComponentMetaBuilder<C> withBundleContext(BundleContext bundleContext) {
            this.bundleContext = bundleContext;
            return this;
        }

        public ComponentMetaBuilder<C> withConfigurationFactory(boolean configurationFactory) {
            this.configurationFactory = configurationFactory;
            return this;
        }

        public ComponentMetaBuilder<C> withConfigurationPid(String configurationPid) {
            this.configurationPid = configurationPid;
            return this;
        }

        public ComponentMetaBuilder<C> withConfigurationRequired(boolean configurationRequired) {
            this.configurationRequired = configurationRequired;
            return this;
        }

        public ComponentMetaBuilder<C> withDescription(String description) {
            this.description = description;
            return this;
        }

        public ComponentMetaBuilder<C> withIcon(String icon) {
            this.icon = icon;
            return this;
        }

        public ComponentMetaBuilder<C> withInstanceSupplier(InstanceSupplier<C> instanceSupplier) {
            this.instanceSupplier = instanceSupplier;
            return this;
        }

        public ComponentMetaBuilder<C> withLabel(String label) {
            this.label = label;
            return this;
        }

        public ComponentMetaBuilder<C> withName(String name) {
            this.name = name;
            return this;
        }

        public ComponentMetaBuilder<C> withType(Class<C> clazz) {
            this.clazz = clazz;
            return this;
        }
    }

    private final AttributeMeta[] attributes;

    private final BundleContext bundleContext;

    private final Class<C> clazz;

    private final boolean configurationFactory;

    private final String configurationPid;

    private final boolean configurationRequired;

    private final String description;

    private final String icon;

    private final InstanceSupplier<C> instanceSupplier;

    private final String label;

    private final String name;

    private ComponentMeta(ComponentMetaBuilder<C> builder) {

        Objects.requireNonNull(builder.bundleContext, "bundleContext must not be null");
        this.bundleContext = builder.bundleContext;

        Objects.requireNonNull(builder.clazz, "Class type for ComponentMeta must be provided");
        this.clazz = builder.clazz;

        Objects.requireNonNull(builder.attributes, "attributes must not be null");
        this.attributes = builder.attributes;

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

        if (builder.instanceSupplier != null) {
            this.instanceSupplier = builder.instanceSupplier;
        } else {
            this.instanceSupplier = new DefaultConstructorInstanceSupplier<C>(clazz);
        }
    }

    public AttributeMeta[] getAttributes() {
        return Arrays.copyOf(attributes, attributes.length);
    }

    public BundleContext getBundleContext() {
        return bundleContext;
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

    public InstanceSupplier<C> getInstanceSupplier() {
        return instanceSupplier;
    }

    public String getLabel() {
        return label;
    }

    public String getName() {
        return name;
    }

    public Class<?> getType() {
        return clazz;
    }

    public boolean isConfigurationFactory() {
        return configurationFactory;
    }

    public boolean isConfigurationRequired() {
        return configurationRequired;
    }

}
