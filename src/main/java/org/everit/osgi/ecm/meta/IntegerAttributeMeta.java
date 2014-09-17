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

public class IntegerAttributeMeta extends SelectablePropertyAttributeMeta<Integer> {

    public static class IntegerAttributeMetaBuilder
            extends SelectablePropertyAttributeMetaBuilder<Integer, IntegerAttributeMetaBuilder> {

        @Override
        public IntegerAttributeMeta build() {
            return new IntegerAttributeMeta(this);
        }

        @Override
        public Class<Integer> getValueType() {
            return Integer.class;
        }

        @Override
        protected IntegerAttributeMetaBuilder self() {
            return this;
        }
    }

    protected IntegerAttributeMeta(
            final IntegerAttributeMetaBuilder builder) {
        super(builder);
    }

}
