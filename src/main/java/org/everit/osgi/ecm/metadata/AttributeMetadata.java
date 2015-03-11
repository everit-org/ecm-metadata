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
import java.util.Objects;

public abstract class AttributeMetadata<V_ARRAY> {

  public static abstract class AttributeMetadataBuilder<V_ARRAY, B extends AttributeMetadataBuilder<V_ARRAY, B>> {

    private String attributeId = null;

    private V_ARRAY defaultValue;

    private String description = null;

    private boolean dynamic = false;

    private String label = null;

    private boolean metatype = true;

    private boolean multiple = false;

    private boolean optional = false;

    protected void beforeBuild() {
    }

    public final AttributeMetadata<V_ARRAY> build() {
      beforeBuild();
      return buildInternal();
    }

    protected abstract AttributeMetadata<V_ARRAY> buildInternal();

    public String getAttributeId() {
      return attributeId;
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
      this.attributeId = attributeId;
      return self();
    }

    public B withDefaultValue(V_ARRAY defaultValue) {
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

    public B withMultiple(boolean multiple) {
      this.multiple = multiple;
      return self();
    }

    public B withOptional(boolean optional) {
      this.optional = optional;
      return self();
    }

  }

  private final String attributeId;

  private final V_ARRAY defaultValue;

  private final String description;

  private final boolean dynamic;

  private final String label;

  private final boolean metatype;

  private final boolean multiple;

  private final boolean optional;

  private final Class<?> valueType;

  protected <B extends AttributeMetadataBuilder<V_ARRAY, B>> AttributeMetadata(
      final AttributeMetadataBuilder<V_ARRAY, B> builder) {
    Objects.requireNonNull(builder.attributeId, "Attribute id must be specified");
    this.attributeId = builder.attributeId;

    V_ARRAY defaultValue = builder.defaultValue;
    if (defaultValue == null) {
      this.defaultValue = null;
    } else {
      this.defaultValue = cloneValueArray(defaultValue);
    }
    if (defaultValue != null && Array.getLength(defaultValue) != 1 && !builder.multiple) {
      throw new IllegalArgumentException(
          "Only one element array or null can be specidied as default value for non-multiple attribute: "
              + attributeId);
    }

    this.valueType = builder.getValueType();

    if (builder.label != null) {
      this.label = builder.label;
    } else if (attributeId != null) {
      this.label = "%" + this.attributeId + ".name";
    } else {
      this.label = null;
    }

    if (builder.description != null) {
      this.description = builder.description;
    } else if (attributeId != null) {
      this.description = "%" + this.attributeId + ".description";
    } else {
      this.description = null;
    }

    this.metatype = builder.metatype;
    this.multiple = builder.multiple;
    this.optional = builder.optional;
    this.dynamic = builder.dynamic;
  }

  protected abstract V_ARRAY cloneValueArray(V_ARRAY value);

  public String getAttributeId() {
    return attributeId;
  }

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
