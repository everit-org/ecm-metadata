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

public class BundleCapabilityReferenceMetadata extends ReferenceMetadata {

    public static class BundleCapabilityReferenceMetadataBuilder extends
            ReferenceMetadataBuilder<BundleCapabilityReferenceMetadataBuilder> {

        private String namespace = null;

        @Override
        protected ReferenceMetadata buildInternal() {
            return new BundleCapabilityReferenceMetadata(this);
        }

        public String getNamespace() {
            return namespace;
        }

        @Override
        protected BundleCapabilityReferenceMetadataBuilder self() {
            return this;
        }

        public BundleCapabilityReferenceMetadataBuilder withNamespace(final String namespace) {
            this.namespace = namespace;
            return self();
        }

    }

    private final String namespace;

    private BundleCapabilityReferenceMetadata(final BundleCapabilityReferenceMetadataBuilder builder) {
        super(builder);

        Objects.requireNonNull(builder.namespace, "Namespace must be defined for BundleCapabilityReference");

        namespace = builder.namespace;
    }

    public String getNamespace() {
        return namespace;
    }

}
