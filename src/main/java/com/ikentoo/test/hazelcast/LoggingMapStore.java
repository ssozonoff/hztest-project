package com.ikentoo.test.hazelcast;

import com.hazelcast.core.MapStore;

import java.util.Collection;
import java.util.Map;

/**
 * Created by serge on 15/01/16.
 */
public class LoggingMapStore implements MapStore {

    @Override
    public void store(Object o, Object o2) {
        System.out.println("store");

    }

    @Override
    public void storeAll(Map map) {
        System.out.println("storeAll");

    }

    @Override
    public void delete(Object o) {
        System.out.println("delete");

    }

    @Override
    public void deleteAll(Collection collection) {
        System.out.println("deleteAll");

    }

    @Override
    public Object load(Object o) {
        System.out.println("load");
        return null;
    }

    @Override
    public Map loadAll(Collection collection) {
        System.out.println("loadAll");
        return null;
    }

    @Override
    public Iterable loadAllKeys() {
        System.out.println("loadAllKeys");
        return null;
    }
}
