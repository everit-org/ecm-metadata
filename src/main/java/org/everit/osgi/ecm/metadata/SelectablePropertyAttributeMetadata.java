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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class SelectablePropertyAttributeMetadata<P> extends PropertyAttributeMetadata<P> {

    public static abstract class SelectablePropertyAttributeMetadataBuilder<V, B extends PropertyAttributeMetadataBuilder<V, B>>
            extends PropertyAttributeMetadataBuilder<V, B> {

        private Map<V, String> options = null;

        public B withOptions(final Map<V, String> options) {
            if (options != null) {
                this.options = Collections.unmodifiableMap(new LinkedHashMap<V, String>(options));
            } else {
                this.options = null;
            }
            return self();
        }
    }

    private final Map<P, String> options;

    protected <B extends SelectablePropertyAttributeMetadataBuilder<P, B>> SelectablePropertyAttributeMetadata(
            final SelectablePropertyAttributeMetadataBuilder<P, B> builder) {
        super(builder);
        this.options = builder.options;
    }

    public Map<P, String> getOptions() {
        return options;
    }
}
