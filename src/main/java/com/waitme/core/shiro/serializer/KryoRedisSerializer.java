package com.waitme.core.shiro.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;

public class KryoRedisSerializer<T> implements RedisSerializer<T> {
	
	Kryo kryo = new Kryo();

	@Override
	public byte[] serialize(T t) throws SerializationException {
        byte[] buffer = new byte[2048];  
        Output output = new Output(buffer);  
        kryo.writeClassAndObject(output, t); 
        return output.toBytes(); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public T deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null) {
			return null;
		}
        Input input = new Input(bytes);  
        T t = (T) kryo.readClassAndObject(input);
        return t; 
	}

}
