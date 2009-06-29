package vpork.dynomite

import dynomite.Dynomite;
import dynomite.FailureException
import vpork.HashClient;

/**
 * Adapts the Dynomite interface to the one used by VPork
 */
public class DynomiteAdapter implements HashClient {
	private Dynomite.Client client
	
	public DynomiteAdapter(Dynomite.Client client) {
	    this.client = client
	}
	
	byte[] get(String key) {
	    try {
	        return client.get(key).getResults()
	    } catch (FailureException e) {
	        return null
	    }
	}
	
	void put(String key, byte[] value) {
	    client.put(key, null, new String(value))
	}
}
