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

import java.util.Objects;

import org.everit.osgi.ecm.util.method.MethodDescriptor;

/**
 * Common class for metadata classes that describe a reference of the component.
 */
public abstract class ReferenceMetadata extends AttributeMetadata<String[]> {

  /**
   * Builder class of {@link ReferenceMetadata}.
   */
  public abstract static class ReferenceMetadataBuilder<B extends ReferenceMetadataBuilder<B>>
      extends AttributeMetadataBuilder<String[], B> {

    private ReferenceConfigurationType referenceConfigurationType =
        ReferenceConfigurationType.FILTER;

    private String referenceId = null;

    private MethodDescriptor setter = null;

    @Override
    protected void beforeBuild() {
      Objects.requireNonNull(referenceId, "Reference id must be specified");
      String attributeId = getAttributeId();

      if (attributeId == null) {
        if (ReferenceConfigurationType.CLAUSE.equals(referenceConfigurationType)) {
          withAttributeId(referenceId + ".clause");
        } else {
          withAttributeId(referenceId + ".target");
        }
      }
    }

    public ReferenceConfigurationType getReferenceConfigurationType() {
      return referenceConfigurationType;
    }

    public String getReferenceId() {
      return referenceId;
    }

    public MethodDescriptor getSetter() {
      return setter;
    }

    @Override
    public Class<String> getValueType() {
      return String.class;
    }

    public B withReferenceConfigurationType(
        final ReferenceConfigurationType referenceConfigurationType) {
      this.referenceConfigurationType = referenceConfigurationType;
      return self();
    }

    public B withReferenceId(final String referenceId) {
      this.referenceId = referenceId;
      return self();
    }

    public B withSetter(final MethodDescriptor setter) {
      this.setter = setter;
      return self();
    }

  }

  private final ReferenceConfigurationType referenceConfigurationType;

  private final String referenceId;

  private final MethodDescriptor setter;

  /**
   * Constructor of the reference class that should be called by the builder.
   */
  protected <B extends ReferenceMetadataBuilder<B>> ReferenceMetadata(
      final ReferenceMetadataBuilder<B> builder) {
    super(builder);
    setter = builder.setter;
    referenceId = builder.referenceId;
    referenceConfigurationType = builder.referenceConfigurationType;
  }

  @Override
  protected String[] cloneValueArray(final String[] value) {
    return value.clone();
  }

  public ReferenceConfigurationType getReferenceConfigurationType() {
    return referenceConfigurationType;
  }

  public String getReferenceId() {
    return referenceId;
  }

  /**
   * The bind method that should be used to bind the reference. If the annotation is defined on a
   * method, that method and it is not specified otherwise in the annotation, the method will be
   * used as a bind method. If the annotation is attached to a field and the bind method is not
   * defined in the annotation and there is method that has the same name as the field but prefixed
   * with "bind" that method will be used as a bind method. In case there is no bind method but
   * there is a setter for the field, it will be used to set the property.
   */
  public MethodDescriptor getSetter() {
    return setter;
  }
}
