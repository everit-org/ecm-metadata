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

public class BooleanAttributeMeta extends PropertyAttributeMeta<Boolean> {

    public static class BooleanAttributeMetaBuilder
            extends PropertyAttributeMetaBuilder<Boolean, BooleanAttributeMetaBuilder> {

        @Override
        public BooleanAttributeMeta build() {
            return new BooleanAttributeMeta(self());
        }

        @Override
        public Class<Boolean> getValueType() {
            return Boolean.class;
        }

        @Override
        protected BooleanAttributeMetaBuilder self() {
            return this;
        }

    }

    protected BooleanAttributeMeta(
            final BooleanAttributeMetaBuilder builder) {
        super(builder);
    }

}
