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

import java.lang.reflect.Array;

/**
 * Abstract Metadata class for those {@link PropertyAttributeMetadata}s that have selectable
 * functionality (e.g.: a combo list on the configuration screen).
 *
 * @param <V_ARRAY>
 *          The type of the default value array.
 */
public abstract class SelectablePropertyAttributeMetadata<V_ARRAY> extends
    PropertyAttributeMetadata<V_ARRAY> {

  /**
   * Builder for {@link SelectablePropertyAttributeMetadata}.
   */
  public abstract static class SelectablePropertyAttributeMetadataBuilder<V_ARRAY, B extends PropertyAttributeMetadataBuilder<V_ARRAY, B>> // CS_DISABLE_LINE_LENGTH
      extends PropertyAttributeMetadataBuilder<V_ARRAY, B> {

    private String[] optionLabels;

    private V_ARRAY optionValues;

    public String[] getOptionLabels() {
      return MetadataUtil.returnClonedOrNull(optionLabels);
    }

    public V_ARRAY getOptionValues() {
      return optionValues;
    }

    /**
     * Sets the options that the user can choose during configuration of this property of the
     * component.
     *
     * @param optionLabels
     *          The labels that should be shown on the configuration screen for each option.
     * @param optionValues
     *          The values of the options.
     */
    public B withOptions(final String[] optionLabels, final V_ARRAY optionValues) {
      this.optionLabels = MetadataUtil.returnClonedOrNull(optionLabels);
      this.optionValues = optionValues;
      return self();
    }
  }

  private final String[] optionLabels;

  private final V_ARRAY optionValues;

  /**
   * Constructor of the metadata class that should be called by the builder.
   */
  protected <B extends SelectablePropertyAttributeMetadataBuilder<V_ARRAY, B>> SelectablePropertyAttributeMetadata(// CS_DISABLE_LINE_LENGTH
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
    return MetadataUtil.returnClonedOrNull(optionLabels);
  }

  public V_ARRAY getOptionValues() {
    return optionValues;
  }
}
