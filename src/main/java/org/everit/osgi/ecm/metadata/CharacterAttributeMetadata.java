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
 * Metadata class for attributes that hold char, {@link Character} or their array representation as
 * a value.
 */
public class CharacterAttributeMetadata extends SelectablePropertyAttributeMetadata<char[]> {

  /**
   * Builder class for {@link CharacterAttributeMetadata}.
   */
  public static class CharacterAttributeMetadataBuilder
      extends
      SelectablePropertyAttributeMetadataBuilder<char[], CharacterAttributeMetadataBuilder> { // CS_DISABLE_LINE_LENGTH

    @Override
    public CharacterAttributeMetadata buildInternal() {
      return new CharacterAttributeMetadata(this);
    }

    @Override
    protected char[] cloneValueArray(final char[] value) {
      return value.clone();
    }

    @Override
    public Class<?> getValueType() {
      return char.class;
    }

    @Override
    protected CharacterAttributeMetadataBuilder self() {
      return this;
    }
  }

  protected CharacterAttributeMetadata(
      final CharacterAttributeMetadataBuilder builder) {
    super(builder);
  }

  @Override
  protected char[] cloneValueArray(final char[] value) {
    return value.clone();
  }

}
