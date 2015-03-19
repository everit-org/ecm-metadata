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
 * Options for {@link ComponentMetadata#configurationPolicy()} property.
 */
public enum ConfigurationPolicy {

  FACTORY,

  /**
   * The configuration admin is not consulted for a configuration for this component.
   */
  IGNORE,

  /**
   * If a configuration is available it will be used, if not the component will be activated anyway
   * (this is the default).
   */
  OPTIONAL,

  /**
   * In order to activate this component a configuration is required.
   */
  REQUIRE;
}
