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

/**
 * Metadata class for {@link org.osgi.framework.ServiceReference} references.
 */
public class ServiceReferenceMetadata extends ReferenceMetadata {

  /**
   * Builder for {@link ServiceReferenceMetadata}.
   */
  public static class ServiceReferenceMetadataBuilder extends
      ReferenceMetadataBuilder<ServiceReferenceMetadataBuilder> {

    private String serviceInterface = null;

    @Override
    protected ReferenceMetadata buildInternal() {
      return new ServiceReferenceMetadata(this);
    }

    public String getServiceInterface() {
      return serviceInterface;
    }

    @Override
    protected ServiceReferenceMetadataBuilder self() {
      return this;
    }

    public ServiceReferenceMetadataBuilder withServiceInterface(final String referenceInterface) {
      this.serviceInterface = referenceInterface;
      return self();
    }

  }

  private final String serviceInterface;

  protected ServiceReferenceMetadata(final ServiceReferenceMetadataBuilder builder) {
    super(builder);
    serviceInterface = builder.serviceInterface;
  }

  public String getServiceInterface() {
    return serviceInterface;
  }

}
