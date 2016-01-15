package com.ikentoo.test.hazelcast;

import com.hazelcast.config.Config;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by serge on 15/01/16.
 */

@Configuration
public class HazelcastConfig {
    @Bean
    public Config config() {
        MapConfig map = new MapConfig()
                .setName("test-map")
                .setEvictionPolicy(EvictionPolicy.LRU)
                .setTimeToLiveSeconds(2400);


        MapStoreConfig ms = new MapStoreConfig();
        ms.setClassName("com.ikentoo.test.hazelcast.LoggingMapStore");
        ms.setEnabled(true);
        ms.setWriteDelaySeconds(30);
        ms.setWriteCoalescing(true);

        map.setMapStoreConfig(ms);

        Config c = new Config().addMapConfig(map).setProperty("hazelcast.logging.type", "slf4j");
        return c;
    }
}
