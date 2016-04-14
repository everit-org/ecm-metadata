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
 * Metadata class for attributes that hold byte, {@link Byte} or their array representation as a
 * value.
 */
public class ByteAttributeMetadata extends SelectablePropertyAttributeMetadata<byte[]> {

  /**
   * Builder class of {@link ByteAttributeMetadata}.
   */
  public static class ByteAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<byte[], ByteAttributeMetadataBuilder> {

    @Override
    public ByteAttributeMetadata buildInternal() {
      return new ByteAttributeMetadata(this);
    }

    @Override
    protected byte[] cloneValueArray(final byte[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return byte.class;
    }

    @Override
    protected ByteAttributeMetadataBuilder self() {
      return this;
    }

  }

  protected ByteAttributeMetadata(
      final ByteAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected byte[] cloneValueArray(final byte[] value) {
    return value.clone();
  }

}
