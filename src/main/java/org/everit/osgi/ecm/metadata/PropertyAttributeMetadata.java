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

import org.everit.osgi.ecm.util.method.MethodDescriptor;

/**
 * Abstract class for those component attributes that behave as a property (might have a setter
 * function).
 *
 * @param <V_ARRAY>
 *          The type of the default value array.
 */
public abstract class PropertyAttributeMetadata<V_ARRAY> extends AttributeMetadata<V_ARRAY> {

  /**
   * Builder class for {@link PropertyAttributeMetadata}.
   */
  public abstract static class PropertyAttributeMetadataBuilder<V_ARRAY, B extends PropertyAttributeMetadataBuilder<V_ARRAY, B>> // CS_DISABLE_LINE_LENGTH
      extends AttributeMetadataBuilder<V_ARRAY, B> {

    private MethodDescriptor setter = null;

    public MethodDescriptor getSetter() {
      return setter;
    }

    public B withSetter(final MethodDescriptor setter) {
      this.setter = setter;
      return self();
    }
  }

  private final MethodDescriptor setter;

  /**
   * Constructor of the metadata class that should be called by the builder.
   */
  protected <B extends PropertyAttributeMetadataBuilder<V_ARRAY, B>> PropertyAttributeMetadata(
      final PropertyAttributeMetadataBuilder<V_ARRAY, B> builder) {

    super(builder);

    this.setter = builder.setter;
  }

  public MethodDescriptor getSetter() {
    return setter;
  }
}
