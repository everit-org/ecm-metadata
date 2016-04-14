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
 * Metadata class for attributes that hold <code>int</code>, {@link Integer} or their array
 * representation as a value.
 */
public class IntegerAttributeMetadata extends SelectablePropertyAttributeMetadata<int[]> {

  /**
   * Builder class for {@link IntegerAttributeMetadata}.
   */
  public static class IntegerAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<int[], IntegerAttributeMetadataBuilder> {

    @Override
    public IntegerAttributeMetadata buildInternal() {
      return new IntegerAttributeMetadata(this);
    }

    @Override
    protected int[] cloneValueArray(final int[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return int.class;
    }

    @Override
    protected IntegerAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected IntegerAttributeMetadata(
      final IntegerAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected int[] cloneValueArray(final int[] value) {
    return value.clone();
  }
}
