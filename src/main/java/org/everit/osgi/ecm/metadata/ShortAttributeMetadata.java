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
 * Metadata class for attributes that hold short, {@link Short} or their array representation as a
 * value.
 */
public class ShortAttributeMetadata extends SelectablePropertyAttributeMetadata<short[]> {

  /**
   * Builder for {@link ShortAttributeMetadata}.
   */
  public static class ShortAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<short[], ShortAttributeMetadataBuilder> {

    @Override
    public ShortAttributeMetadata buildInternal() {
      return new ShortAttributeMetadata(this);
    }

    @Override
    public Class<?> getValueType() {
      return short.class;
    }

    @Override
    protected ShortAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected ShortAttributeMetadata(
      final ShortAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected short[] cloneValueArray(final short[] value) {
    return value.clone();
  }
}
