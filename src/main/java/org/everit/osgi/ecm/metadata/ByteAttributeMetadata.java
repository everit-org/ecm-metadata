/**
 * This file is part of Everit - ECM Metadata.
 *
 * Everit - ECM Metadata is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - ECM Metadata is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - ECM Metadata.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.metadata;

public class ByteAttributeMetadata extends SelectablePropertyAttributeMetadata<byte[]> {

  public static class ByteAttributeMetadataBuilder
      extends SelectablePropertyAttributeMetadataBuilder<byte[], ByteAttributeMetadataBuilder> {

    @Override
    public ByteAttributeMetadata buildInternal() {
      return new ByteAttributeMetadata(this);
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
  protected byte[] cloneValueArray(byte[] value) {
    return value.clone();
  }

}
