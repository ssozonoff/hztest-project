package com.ikentoo.test.hazelcast;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by serge on 15/01/16.
 */
@Service
public class Bootstrap {
    @Autowired
    private HazelcastInstance instance;


    private static int[] keys = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

    public Bootstrap() {

    }

    @PostConstruct
    public void doNow() throws InterruptedException {
        Random r = new Random();
        Random r2 = new Random();

        IMap m = instance.getMap("test-map");

        while(true) {

            int i = r.nextInt(15);

            boolean aquiredLock = false;
            try {
                aquiredLock = m.tryLock(i, 500, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                // node is probably shutting down
                Thread.currentThread().interrupt();
                return;
            }
            try {
                if (!aquiredLock) {
                    System.out.println("Map lock was not aquired");
                }

                m.set(i, r2.nextInt());
            } finally {
                if (aquiredLock) {
                    m.unlock(i);
                }
            }

            Thread.sleep(50);
        }

    }

}
