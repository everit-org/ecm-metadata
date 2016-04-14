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
 * Metadata class for attributes that hold float, {@link Float} or their array representation as a
 * value.
 */
public class FloatAttributeMetadata extends SelectablePropertyAttributeMetadata<float[]> {

  /**
   * Builder class for {@link FloatAttributeMetadata}.
   */
  public static class FloatAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<float[], FloatAttributeMetadataBuilder> {

    @Override
    public FloatAttributeMetadata buildInternal() {
      return new FloatAttributeMetadata(this);
    }

    @Override
    protected float[] cloneValueArray(final float[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return float.class;
    }

    @Override
    protected FloatAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected FloatAttributeMetadata(
      final FloatAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected float[] cloneValueArray(final float[] value) {
    return value.clone();
  }
}
