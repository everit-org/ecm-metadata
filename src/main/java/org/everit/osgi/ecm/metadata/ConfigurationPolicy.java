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

import java.awt.Component;

/**
 * Options for {@link Component#configurationPolicy()} property.
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
