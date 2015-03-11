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

import java.lang.reflect.Array;

public abstract class SelectablePropertyAttributeMetadata<V_ARRAY> extends
    PropertyAttributeMetadata<V_ARRAY> {

  public static abstract class SelectablePropertyAttributeMetadataBuilder<V_ARRAY, B extends PropertyAttributeMetadataBuilder<V_ARRAY, B>>
      extends PropertyAttributeMetadataBuilder<V_ARRAY, B> {

    private String[] optionLabels;

    private V_ARRAY optionValues;

    public String[] getOptionLabels() {
      return optionLabels;
    }

    public V_ARRAY getOptionValues() {
      return optionValues;
    }

    public B withOptions(final String[] optionLabels, final V_ARRAY optionValues) {
      this.optionLabels = optionLabels;
      this.optionValues = optionValues;
      return self();
    }
  }

  private final String[] optionLabels;

  private final V_ARRAY optionValues;

  protected <B extends SelectablePropertyAttributeMetadataBuilder<V_ARRAY, B>> SelectablePropertyAttributeMetadata(
      final SelectablePropertyAttributeMetadataBuilder<V_ARRAY, B> builder) {
    super(builder);
    if (builder.optionLabels != null && builder.optionValues == null) {
      throw new MetadataValidationException(
          "Option labels have a value while option value array is null");
    }
    if (builder.optionLabels != null && builder.optionValues != null
        && builder.optionLabels.length != Array.getLength(builder.optionValues)) {
      throw new MetadataValidationException("Option values and labels must have the same length");
    }

    if (builder.optionValues == null) {
      this.optionLabels = null;
      this.optionValues = null;
    } else {
      this.optionValues = cloneValueArray(builder.optionValues);
      if (builder.optionLabels == null) {
        this.optionLabels = null;
      } else {
        this.optionLabels = builder.optionLabels.clone();
      }
    }
  }

  public String[] getOptionLabels() {
    return optionLabels;
  }

  public V_ARRAY getOptionValues() {
    return optionValues;
  }
}
