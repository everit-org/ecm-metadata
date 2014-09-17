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
package org.everit.osgi.ecm.meta;

public class ShortAttributeMeta extends SelectablePropertyAttributeMeta<Short> {

    public static class ShortAttributeMetaBuilder
            extends SelectablePropertyAttributeMetaBuilder<Short, ShortAttributeMetaBuilder> {

        @Override
        public ShortAttributeMeta build() {
            return new ShortAttributeMeta(this);
        }

        @Override
        public Class<Short> getValueType() {
            return Short.class;
        }

        @Override
        protected ShortAttributeMetaBuilder self() {
            return this;
        }
    }

    protected ShortAttributeMeta(
            final ShortAttributeMetaBuilder builder) {
        super(builder);
    }

}
