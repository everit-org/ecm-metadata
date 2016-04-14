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
 * Metadata class for attributes that hold long, {@link Long} or their array representation as a
 * value.
 */
public class LongAttributeMetadata extends SelectablePropertyAttributeMetadata<long[]> {

  /**
   * Builder class for {@link LongAttributeMetadata}.
   */
  public static class LongAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<long[], LongAttributeMetadataBuilder> {

    @Override
    public LongAttributeMetadata buildInternal() {
      return new LongAttributeMetadata(this);
    }

    @Override
    protected long[] cloneValueArray(final long[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return long.class;
    }

    @Override
    protected LongAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected LongAttributeMetadata(
      final LongAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected long[] cloneValueArray(final long[] value) {
    return value.clone();
  }
}
