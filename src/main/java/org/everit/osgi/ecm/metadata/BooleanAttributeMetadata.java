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
 * Metadata class for attributes that hold boolean, {@link Boolean} or their array representation as
 * a value.
 */
public class BooleanAttributeMetadata extends PropertyAttributeMetadata<boolean[]> {

  /**
   * Builder class for {@link BooleanAttributeMetadata}.
   */
  public static class BooleanAttributeMetadataBuilder
      extends PropertyAttributeMetadataBuilder<boolean[], BooleanAttributeMetadataBuilder> {

    @Override
    public BooleanAttributeMetadata buildInternal() {
      return new BooleanAttributeMetadata(self());
    }

    @Override
    public Class<?> getValueType() {
      return boolean.class;
    }

    @Override
    protected BooleanAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected BooleanAttributeMetadata(
      final BooleanAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected boolean[] cloneValueArray(final boolean[] value) {
    return value.clone();
  }
}
