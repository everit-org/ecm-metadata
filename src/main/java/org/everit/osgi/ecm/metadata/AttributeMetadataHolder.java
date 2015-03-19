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
 * Helper interface to extend original functionlity (like an instantiation of
 * {@code AttributeDefinition}) with {@link AttributeMetadata} information.
 *
 * @param <V_ARRAY>
 *          Array type of the value type of the metadata.
 */
public interface AttributeMetadataHolder<V_ARRAY> {

  /**
   * Retrieve the {@link AttributeMetadata} that belongs to the object that implements this
   * interface.
   *
   * @return The {@link AttributeMetadata} instance.
   */
  AttributeMetadata<V_ARRAY> getMetadata();
}
