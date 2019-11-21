package iot.turntabl.springweb;

import iot.turntabl.springweb.controllers.Maths;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;

@EnableSwagger2
@SpringBootApplication
public class SpringwebApplication {

	public static void main(String[] args) throws InterruptedException, URISyntaxException {
		SpringApplication.run(SpringwebApplication.class, args);

		Jedis  jedis = new Jedis(System.getenv("REDIS_URL"));
		try {
			jedis = new Jedis(System.getenv("REDIS_URL"));
			JedisPubSub jedisPubSub = new JedisPubSub() {
				@Override
				public void onMessage(String channel, String message) {
					System.out.println("Channel " + channel + " has sent a message : " + message );
//					write the message to file
//					if(channel.equals("C1")) {
//						/* Unsubscribe from channel C1 after first message is received. */
//						unsubscribe(channel);
//					}
				}
				@Override
				public void onSubscribe(String channel, int subscribedChannels) {
					System.out.println("Client is Subscribed to channel : "+ channel);
				}
			};
				jedis.ping();
				jedis.subscribe(jedisPubSub, "cusotmerUpdates", "customerDelete");
		}
		catch (Exception e){
			System.out.printf("Exc:::  "+e.getMessage());
		}
		finally {
			if(jedis != null) {
				jedis.close();
			}
		}

	}


	@Bean
	public Maths ops(){
		return new Maths();
	}
}
