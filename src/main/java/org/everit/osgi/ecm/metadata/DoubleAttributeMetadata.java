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
 * Metadata class for attributes that hold double, {@link Double} or their array representation as a
 * value.
 */
public class DoubleAttributeMetadata extends SelectablePropertyAttributeMetadata<double[]> {

  /**
   * Builder class for {@link DoubleAttributeMetadata}.
   */
  public static class DoubleAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<double[], DoubleAttributeMetadataBuilder> {

    @Override
    public DoubleAttributeMetadata buildInternal() {
      return new DoubleAttributeMetadata(this);
    }

    @Override
    protected double[] cloneValueArray(final double[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return double.class;
    }

    @Override
    protected DoubleAttributeMetadataBuilder self() {
      return this;
    }

  }

  protected DoubleAttributeMetadata(
      final DoubleAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected double[] cloneValueArray(final double[] value) {
    return value.clone();
  }
}
