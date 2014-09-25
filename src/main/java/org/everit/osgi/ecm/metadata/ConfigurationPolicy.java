/**
 * This file is part of Everit - Component Metadata.
 *
 * Everit - Component Metadata is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Everit - Component Metadata is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Everit - Component Metadata.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.everit.osgi.ecm.metadata;


/**
 * Options for {@link Component#configurationPolicy()} property.
 */
public enum ConfigurationPolicy {

    /**
     * The configuration admin is not consulted for a configuration for this component.
     */
    IGNORE,

    /**
     * If a configuration is available it will be used, if not the component will be activated anyway (this is the
     * default).
     */
    OPTIONAL,

    /**
     * In order to activate this component a configuration is required.
     */
    REQUIRE;
}
