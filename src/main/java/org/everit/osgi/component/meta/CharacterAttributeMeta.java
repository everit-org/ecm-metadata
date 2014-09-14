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

public class CharacterAttributeMeta extends SelectablePropertyAttributeMeta<Character> {

    public static class CharacterAttributeMetaBuilder
            extends SelectablePropertyAttributeMetaBuilder<Character, CharacterAttributeMetaBuilder> {

        @Override
        public CharacterAttributeMeta build() {
            return new CharacterAttributeMeta(this);
        }

        @Override
        protected CharacterAttributeMetaBuilder self() {
            return this;
        }

    }

    protected CharacterAttributeMeta(
            final CharacterAttributeMetaBuilder builder) {
        super(builder);
    }

}
