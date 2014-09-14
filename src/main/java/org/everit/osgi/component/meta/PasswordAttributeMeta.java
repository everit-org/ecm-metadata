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
package org.everit.osgi.component.meta;

public class PasswordAttributeMeta extends PropertyAttributeMeta<String> {

    public static class PasswordAttributeMetaBuilder
            extends PropertyAttributeMetaBuilder<String, PasswordAttributeMetaBuilder> {

        @Override
        public PasswordAttributeMeta build() {
            return new PasswordAttributeMeta(this);
        }

        @Override
        protected PasswordAttributeMetaBuilder self() {
            return this;
        }

    }

    protected PasswordAttributeMeta(final PasswordAttributeMetaBuilder builder) {
        super(builder);
    }

}
