/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.sf.derquinsej.i18n;

import java.util.Locale;

/**
 * Skeletal implementation for localized objects.
 * @author Andres Rodriguez
 */
public abstract class AbstractLocalized<T> implements Localized<T> {
	/**
	 * Default constructor.
	 */
	public AbstractLocalized() {
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.derquinsej.i18n.Localized#get()
	 */
	public T get() {
		return get(Locale.getDefault());
	}

	/*
	 * (non-Javadoc)
	 * @see net.sf.derquinsej.i18n.Localized#get(java.util.Locale,
	 * java.lang.Object)
	 */
	public T get(Locale locale, T fallback) {
		try {
			T value = get(locale);
			return (value == null) ? fallback : value;
		} catch (UnableToLocalizeException e) {
			return fallback;
		}
	}
}
