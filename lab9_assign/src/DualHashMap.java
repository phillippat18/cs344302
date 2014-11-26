import java.util.HashMap;

/** Class to keep individual keys and values unique.
 * @author Haley, K.
 * */
public class DualHashMap<K, V> implements DualMap<K, V> {
	
	/** HashMap designed to track individual keys.*/
	private HashMap<K, V> keys = null;
	
	/** HashMap designed to track individual values.*/
	private HashMap<V, K> values = null;

	/** Instantiate a basic DualHashMap. This HashMap is designed to keep
	 * individual keys and individual values unique.
	 * */
	public DualHashMap() {
		this.keys = new HashMap<K, V>();
		this.values = new HashMap<V, K>();
	}

	/** Adds a key and value to the DualHashMap. If the key is 
	 * associated with an existing value, that key will be removed 
	 * and vice versa. 
	 * @param key The key to be added. 
	 * @param value The value to be added and associated with a key.
	 * */
	@Override
	public void put(K key, V value) {
		K tempKey = this.values.get(value);
		V tempValue = this.keys.get(key);
		if(tempValue != null){
			this.values.remove(tempValue);
		}
		if(tempKey != null){
			this.keys.remove(tempKey);
		}
		this.values.put(value, key);
		this.keys.put(key, value);
	}

	/** Remove a key and a value from the DualHashMap.
	 * @param key The key to be removed.
	 * @param value The value to be removed.
	 * */
	@Override
	public void remove(K key, V value) {
		this.keys.remove(key);
		this.values.remove(value);
	}

	/** Retrieves the value associated with the key.
	 * @param key The key used to associate with the value.
	 * */
	@Override
	public V get(K key) {
		return this.keys.get(key);
	}

	/** Retrieves the key associated with the value.
	 * @param value The value used to associate with the key.
	 * */
	@Override
	public K reverseGet(V value) {
		return this.values.get(value);
	}

}
