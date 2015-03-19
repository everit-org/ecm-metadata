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
 * Reference items can be configured with {@link #CLAUSE}s or OSGi {@link #FILTER}.
 */
public enum ReferenceConfigurationType {

  /**
   * In case a clause is defined, the programmer of the component can specify additional attributes
   * that can or has to be provided to process the reference. Filter is the only directive that can
   * be part of the clause. E.g.: If the component is a ServletContext, it can process servlets in
   * the way that the clause contain the url-pattern of the servlet.
   *
   * <p>
   * <code>myServlet;url-pattern=/getme;filter:=(service.pid=...)</code>
   */
  CLAUSE,

  /**
   * The simple way to configure references is providing an OSGi filter. In this case the
   * configuration of the reference is similar to the method that is used Declarative Services.
   */
  FILTER

}
