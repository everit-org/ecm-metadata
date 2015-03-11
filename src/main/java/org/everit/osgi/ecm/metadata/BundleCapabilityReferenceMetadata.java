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

import org.osgi.framework.Bundle;

public class BundleCapabilityReferenceMetadata extends ReferenceMetadata {

  public static class BundleCapabilityReferenceMetadataBuilder extends
      ReferenceMetadataBuilder<BundleCapabilityReferenceMetadataBuilder> {

    private String namespace = null;

    private int stateMask = Bundle.ACTIVE;

    @Override
    protected ReferenceMetadata buildInternal() {
      return new BundleCapabilityReferenceMetadata(this);
    }

    public String getNamespace() {
      return namespace;
    }

    public int getStateMask() {
      return stateMask;
    }

    @Override
    protected BundleCapabilityReferenceMetadataBuilder self() {
      return this;
    }

    public BundleCapabilityReferenceMetadataBuilder withNamespace(final String namespace) {
      this.namespace = namespace;
      return self();
    }

    public BundleCapabilityReferenceMetadataBuilder withStateMask(final int stateMask) {
      this.stateMask = stateMask;
      return self();
    }
  }

  private final String namespace;

  private final int stateMask;

  private BundleCapabilityReferenceMetadata(final BundleCapabilityReferenceMetadataBuilder builder) {
    super(builder);

    Objects.requireNonNull(builder.namespace,
        "Namespace must be defined for BundleCapabilityReference");

    namespace = builder.namespace;
    stateMask = builder.stateMask;
  }

  @Override
  protected String[] cloneValueArray(String[] value) {
    return value.clone();
  }

  public String getNamespace() {
    return namespace;
  }

  public int getStateMask() {
    return stateMask;
  }

}
