package com.example;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

public final class Identity extends Object { // Tc Kimlik No
	private final String id;
	private static final Map<String, Identity> CACHE = new WeakHashMap<>();

	private Identity(String id) {
		this.id = id;
	}

	// factory method
	public static Identity valueOf(String id) {
		// validation, caching, business rule, invariant, pre-/post-condition
		Objects.requireNonNull(id);
		if (!isValid(id))
			throw new IllegalArgumentException("This is not a valid identity number.");
		// Caching -> Object Pooling -> Immutable
		Identity cachedIdentity = CACHE.get(id);
		if (Objects.isNull(cachedIdentity)) {
			cachedIdentity = new Identity(id);
			CACHE.put(id, cachedIdentity);
		}
		return cachedIdentity;
	}

	public String getId() {
		return id;
	}

	private static boolean isValid(String id) {
		return true;
	}

	@Override
	public String toString() {
		return "Identity [id=" + id + "]";
	}

}
