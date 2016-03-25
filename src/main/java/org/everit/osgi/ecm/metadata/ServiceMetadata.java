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
 * Metadata that indicates that the component instance should be instantiated as an OSGi service.
 */
public class ServiceMetadata {

  /**
   * Builder for {@link ServiceMetadata}.
   */
  public static class ServiceMetadataBuilder {
    private String[] clazzes = new String[0];

    public ServiceMetadata build() {
      return new ServiceMetadata(clazzes);
    }

    /**
     * One or more types that the OSGi service should be registered with.
     *
     * @throws NullPointerException
     *           if the clazzes parameter is <code>null</code>.
     */
    public ServiceMetadataBuilder withClazzes(final String[] clazzes) {
      if (clazzes == null) {
        throw new MetadataValidationException(
            "Null cannot be provided as service interface array for ServiceMetadata");
      }
      this.clazzes = clazzes.clone();

      return this;
    }

  }

  private final String[] clazzes;

  protected ServiceMetadata(final String[] clazzes) {
    this.clazzes = clazzes;
  }

  public String[] getClazzes() {
    return MetadataUtil.returnClonedOrNull(clazzes);
  }
}
