package vpork.memory

import vpork.HashClient

import java.util.Map
import java.util.concurrent.ConcurrentHashMap
import vpork.HashClientFactory
import vpork.StatsLogger

class MemoryClientFactory implements HashClientFactory {
    private Map hash = new ConcurrentHashMap()

    HashClient createClient() {
        [ get : { String key -> hash.get(key) },
          put : { String key, byte[] value -> hash.put(key, value) }
        ] as HashClient
    }

    void setup(ConfigObject cfg, StatsLogger logger, List<String>factoryArgs) {
    }
}
