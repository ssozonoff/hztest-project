package com.ikentoo.test.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by serge on 15/01/16.
 */

@Configuration
public class HazelcastConfig {
    @Bean
    public Config config() {
        Config c =  new Config().addMapConfig(
                new MapConfig()
                        .setName("test-map")
                        .setEvictionPolicy(EvictionPolicy.LRU)
                        .setTimeToLiveSeconds(2400))
                .setProperty("hazelcast.logging.type", "slf4j");


        return c;
    }
}
