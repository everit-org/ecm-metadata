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
import java.util.Objects;

/**
 * Abstract class of Metadata classes. This class contains all the variables that are available for
 * all Metadata classes that represent a component attribute.
 *
 * @param <V_ARRAY>
 *          The type of the default value that is an array..
 */
public abstract class AttributeMetadata<V_ARRAY> {

  /**
   * Builder class of {@link AttributeMetadata}.
   *
   * @param <V_ARRAY>
   *          Type of default value array.
   * @param <B>
   *          Type of the builder.
   */
  public abstract static class AttributeMetadataBuilder<V_ARRAY, B extends AttributeMetadataBuilder<V_ARRAY, B>> { // CS_DISABLE_LINE_LENGTH

    private V_ARRAY defaultValue;

    private String description = null;

    private boolean dynamic = false;

    private String label = null;

    private String mAttributeId = null;

    private boolean metatype = true;

    private boolean multiple = false;

    private boolean optional = false;

    private float priority = DEFAULT_ATTRIBUTE_PRIORITY;

    protected void beforeBuild() {
    }

    public final AttributeMetadata<V_ARRAY> build() {
      beforeBuild();
      return buildInternal();
    }

    protected abstract AttributeMetadata<V_ARRAY> buildInternal();

    public String getAttributeId() {
      return mAttributeId;
    }

    public V_ARRAY getDefaultValue() {
      return defaultValue;
    }

    public String getDescription() {
      return description;
    }

    public String getLabel() {
      return label;
    }

    public float getPriority() {
      return priority;
    }

    public abstract Class<?> getValueType();

    public boolean isDynamic() {
      return dynamic;
    }

    public boolean isMetatype() {
      return metatype;
    }

    public boolean isMultiple() {
      return multiple;
    }

    public boolean isOptional() {
      return optional;
    }

    protected abstract B self();

    public B withAttributeId(final String attributeId) {
      this.mAttributeId = attributeId;
      return self();
    }

    public B withDefaultValue(final V_ARRAY defaultValue) {
      this.defaultValue = defaultValue;
      return self();
    }

    public B withDescription(final String description) {
      this.description = description;
      return self();
    }

    public B withDynamic(final boolean dynamic) {
      this.dynamic = dynamic;
      return self();
    }

    public B withLabel(final String label) {
      this.label = label;
      return self();
    }

    public B withMetatype(final boolean metatype) {
      this.metatype = metatype;
      return self();
    }

    public B withMultiple(final boolean multiple) {
      this.multiple = multiple;
      return self();
    }

    public B withOptional(final boolean optional) {
      this.optional = optional;
      return self();
    }

    public B withPriority(final float priority) {
      this.priority = priority;
      return self();
    }

  }

  /**
   * Default priority for attributes where it is not defined otherwise.
   */
  private static final float DEFAULT_ATTRIBUTE_PRIORITY = 1000;

  private static final String LOCALIZED_STRING_PREFIX = "%";

  private final String attributeId;

  private final V_ARRAY defaultValue;

  private final String description;

  private final boolean dynamic;

  private final String label;

  private final boolean metatype;

  private final boolean multiple;

  private final boolean optional;

  private float priority;

  private final Class<?> valueType;

  /**
   * Constructor of the Metadata class.
   */
  protected <B extends AttributeMetadataBuilder<V_ARRAY, B>> AttributeMetadata(
      final AttributeMetadataBuilder<V_ARRAY, B> builder) {
    Objects.requireNonNull(builder.mAttributeId, "Attribute id must be specified");
    this.attributeId = builder.mAttributeId;

    V_ARRAY lDefaultValue = builder.defaultValue;
    if (lDefaultValue == null) {
      this.defaultValue = null;
    } else {
      this.defaultValue = cloneValueArray(lDefaultValue);
    }
    if ((lDefaultValue != null) && (Array.getLength(lDefaultValue) != 1) && !builder.multiple) {
      throw new IllegalArgumentException(
          "Only one element array or null can be specidied as default value"
              + " for non-multiple attribute: " + attributeId);
    }

    this.valueType = builder.getValueType();

    if (builder.label != null) {
      this.label = builder.label;
    } else if (attributeId != null) {
      this.label = LOCALIZED_STRING_PREFIX + this.attributeId + ".name";
    } else {
      this.label = null;
    }

    if (builder.description != null) {
      this.description = builder.description;
    } else if (attributeId != null) {
      this.description = LOCALIZED_STRING_PREFIX + this.attributeId + ".description";
    } else {
      this.description = null;
    }

    this.metatype = builder.metatype;
    this.multiple = builder.multiple;
    this.optional = builder.optional;
    this.dynamic = builder.dynamic;
    this.priority = builder.priority;
  }

  protected abstract V_ARRAY cloneValueArray(V_ARRAY value);

  public String getAttributeId() {
    return attributeId;
  }

  /**
   * Get a copy of the default value array.
   *
   * @return A copy of the default value array or <code>null</code> if there is no default value.
   */
  public V_ARRAY getDefaultValue() {
    if (this.defaultValue == null) {
      return null;
    }
    return cloneValueArray(this.defaultValue);
  }

  public String getDescription() {
    return description;
  }

  public String getLabel() {
    return label;
  }

  public float getPriority() {
    return priority;
  }

  public Class<?> getValueType() {
    return valueType;
  }

  public boolean isDynamic() {
    return dynamic;
  }

  public boolean isMetatype() {
    return metatype;
  }

  public boolean isMultiple() {
    return multiple;
  }

  public boolean isOptional() {
    return optional;
  }
}
