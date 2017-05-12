package com.shine.web.config.wrapper;

import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.security.oauth2.provider.token.store.redis.StandardStringSerializationStrategy;

public class JsonSerializationStrategy extends StandardStringSerializationStrategy {

	private static final Jackson2JsonRedisSerializer<Object> jackson2 = new Jackson2JsonRedisSerializer<>(Object.class);

	@Override
	@SuppressWarnings("unchecked")
	protected <T> T deserializeInternal(byte[] bytes, Class<T> clazz) {
		// TODO Auto-generated method stub
		return (T) jackson2.deserialize(bytes);
	}

	@Override
	protected byte[] serializeInternal(Object object) {
		// TODO Auto-generated method stub
		return jackson2.serialize(object);
	}

}
