package com.Jobportal.demo;

//import com.Jobportal.demo.Model.SessionIds;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
//@EnableAutoConfiguration
//@EnableRedisRepositories
@EnableCaching
public class DemoApplication {

/*	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
		return new JedisConnectionFactory();
	}

	@Bean
	RedisTemplate<String, SessionIds> redisTemplate() {
		RedisTemplate<String, SessionIds> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		return redisTemplate;
	}*/
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);



	}

}
