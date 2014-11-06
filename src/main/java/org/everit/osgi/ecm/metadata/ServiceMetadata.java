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

public class ServiceMetadata {

    public static class ServiceMetadataBuilder {
        private Class<?>[] clazzes = new Class<?>[0];

        public ServiceMetadata build() {
            return new ServiceMetadata(clazzes);
        }

        public ServiceMetadataBuilder withClazzes(final Class<?>[] clazzes) {
            if (clazzes == null) {
                throw new MetadataValidationException(
                        "Null cannot be provided as service interface array for ServiceMetadata");
            }
            this.clazzes = clazzes.clone();

            return this;
        }

    }

    private final Class<?>[] clazzes;

    private ServiceMetadata(final Class<?>[] clazzes) {
        this.clazzes = clazzes;
    }

    public Class<?>[] getClazzes() {
        if (clazzes != null) {
            return clazzes.clone();
        } else {
            return null;
        }
    }
}
