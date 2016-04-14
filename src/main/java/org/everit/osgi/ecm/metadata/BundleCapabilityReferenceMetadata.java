/*
 * Copyright (C) 2011 Everit Kft. (http://www.everit.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.everit.osgi.ecm.metadata;

import java.util.Objects;

import org.osgi.framework.Bundle;

/**
 * Metadata class for {@link org.osgi.framework.wiring.BundleCapability} references.
 */
public class BundleCapabilityReferenceMetadata extends ReferenceMetadata {

  /**
   * Builder class for {@link BundleCapabilityReferenceMetadata}.
   */
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

  /**
   * Constructor that is should be called by the builder class.
   */
  protected BundleCapabilityReferenceMetadata(
      final BundleCapabilityReferenceMetadataBuilder builder) {

    super(builder);

    Objects.requireNonNull(builder.namespace,
        "Namespace must be defined for BundleCapabilityReference");

    namespace = builder.namespace;
    stateMask = builder.stateMask;
  }

  public String getNamespace() {
    return namespace;
  }

  public int getStateMask() {
    return stateMask;
  }

}
