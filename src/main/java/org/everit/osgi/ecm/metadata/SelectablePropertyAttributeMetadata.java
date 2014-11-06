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

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class SelectablePropertyAttributeMetadata<V> extends PropertyAttributeMetadata<V> {

    public static abstract class SelectablePropertyAttributeMetadataBuilder<V, B extends PropertyAttributeMetadataBuilder<V, B>>
            extends PropertyAttributeMetadataBuilder<V, B> {

        private Map<V, String> options = null;

        public Map<V, String> getOptions() {
            return options;
        }

        public B withOptions(final Map<V, String> options) {
            if (options != null) {
                this.options = Collections.unmodifiableMap(new LinkedHashMap<V, String>(options));
            } else {
                this.options = null;
            }
            return self();
        }
    }

    private final Map<V, String> options;

    protected <B extends SelectablePropertyAttributeMetadataBuilder<V, B>> SelectablePropertyAttributeMetadata(
            final SelectablePropertyAttributeMetadataBuilder<V, B> builder) {
        super(builder);
        this.options = builder.options;
    }

    public Map<V, String> getOptions() {
        return options;
    }
}
