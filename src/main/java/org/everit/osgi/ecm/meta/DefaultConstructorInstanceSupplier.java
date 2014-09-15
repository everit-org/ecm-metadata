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

public class DefaultConstructorInstanceSupplier<C> implements InstanceSupplier<C> {

    private final Class<C> clazz;

    public DefaultConstructorInstanceSupplier(final Class<C> clazz) {
        this.clazz = clazz;
    }

    @Override
    public C get() {
        try {
            return clazz.newInstance();
        } catch (SecurityException e) {
            throw new ComponentInstantiationException(e);
        } catch (InstantiationException e) {
            throw new ComponentInstantiationException(e);
        } catch (IllegalAccessException e) {
            throw new ComponentInstantiationException(e);
        }
    }

}
