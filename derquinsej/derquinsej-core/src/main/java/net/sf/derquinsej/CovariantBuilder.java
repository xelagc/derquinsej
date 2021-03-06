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
package net.sf.derquinsej;

import com.google.common.base.Supplier;

/**
 * Base class for covariant builders.
 * @author Andres Rodriguez
 */
public abstract class CovariantBuilder<B extends CovariantBuilder<B, T>, T> extends This<B> implements Supplier<T> {
	/**
	 * Constructs a new builder.
	 */
	public CovariantBuilder() {
	}

	/*
	 * (non-Javadoc)
	 * @see com.google.common.base.Supplier#get()
	 */
	public final T get() {
		checkState();
		return doGet();
	}

	/**
	 * Check the state of the builder before building the object. Override to
	 * implement custom checks. Do not forget to call super.checkState.
	 * @throws IllegalStateException if the target object cannot be built with
	 *             the current state
	 */
	protected void checkState() {
	}

	/**
	 * Build the target object.
	 * @return The target object.
	 */
	protected abstract T doGet();
}
