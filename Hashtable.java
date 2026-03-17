@SuppressWarnings("unchecked")
public class Hashtable<K, V> {
    private Pair<K, V>[] table;
    private int n;//the number of key-value pairs in the table
    private int m;//the size of the table
    private double alphaHigh = 0.5;//resize if n/m exceeds this (1/2)
    private double alphaLow = 0.125;//resize if n/m goes below this (1/8)

    //constructor--default table size is 11
    public Hashtable() {
	n = 0;
	m = 11;
	table = new Pair[m];
    }

    //constructor
    public Hashtable(int m) {
	n = 0;
	this.m = m;
	table = new Pair[m];
    }

    //returns the value associated with key <key>
    //return null if key is not in table
    //do not forget that you will have to cast the result to (V)
    public V get(K key) {
        int hashValue = findHashValue(key);
        int index = Math.floorMod(hashValue, this.m);

        for(int i = 0; i < this.m; i++){
            Pair<K, V> p = (Pair<K,V>) this.table[index];

            if( p!= null && !(p.getDeletionStatus()) ){
                    if(key.equals(p.getKey())){ //check if input key equals the one of current table index
                        return p.getValue();
                    }
            }
            index = (index + 1) % this.m; //%this.m allows for wrapping around to beginning of table if you reach end
        }

        return null; //Value was either deleted or did not exist
    }

    //puts (key, val) into the table or updates value
    //if the key is already in the table
    //resize to getNextNum(2*m) if (double)n/m exceeds alphaHigh after the insert
    public void put(K key, V val) {
        int hashValue = findHashValue(key);
        int index = Math.floorMod(hashValue, this.m);

        for(int i = 0; i < this.m; i++){ //first check if value exists in table
            if(this.table[index] != null){
                if( key.equals(this.table[index].getKey()) && !(this.table[index].getDeletionStatus())  ){ //should only set new value if pair has not been deleted
                    this.table[index].setValue(val);
                    return;
                }
            }
            index = (index + 1) % this.m;
        }

        index = Math.floorMod(hashValue, this.m); //reset index to check for a null position or deleted position available

        for(int i = 0; i < this.m; i++){
            if(this.table[index] == null){
                this.table[index] = new Pair<>(key, val);
                this.n++;
                if( ((double)this.n/this.m) > this.alphaHigh    ){this.resizeTable(true);}
                return;
            }

            else if((this.table[index].getDeletionStatus())){
                this.table[index] = new Pair<>(key, val);
                this.n++;
                if( ((double)this.n/this.m) > this.alphaHigh    ){this.resizeTable(true);}
                return;
            }

            index = (index + 1) % this.m;
        }
    }

    //removes the (key, value) pair associated with <key>
    //returns the deleted value or null if the element was not in the table
    //resize to getNextNum(m/2) if m/2 >= 11 AND (double)n/m < alphaLow after the delete
    public V delete(K key) {
	    int hashValue = findHashValue(key);
        int index = Math.floorMod(hashValue, this.m);
        V returnValue;

        for(int i = 0; i < this.m; i++){ //first check if value exists in table
            if(this.table[index] != null){
                if( key.equals(this.table[index].getKey()) && !(this.table[index].getDeletionStatus())  ){ //should only set new value if pair has not been deleted
                    returnValue = this.table[index].getValue();
                    this.table[index].setDeleted();
                    n--;
                    if( (m/2 >= 11) && ((double)this.n/this.m) < this.alphaLow ){this.resizeTable(false);}
                    return returnValue;
                }
            }
            index = (index + 1) % this.m;
        }

        return null;
    }

    //return true if table is empty
    public boolean isEmpty() {
        return (this.n == 0);
    }

    //return the number of (key,value) pairs in the table
    public int size() {
        return this.n;
    }

    //This method is used for testing only. Do not use this method yourself for any reason
    //other than debugging. Do not change this method.
    public Pair<K,V>[] getTable() {
	    return table;
    }


    //PRIVATE
    private int findHashValue(K key){
        return key.hashCode();
    }
    private void resizeTable(boolean grow) {
        // compute new size
        int newSize = 0;
        
        if(grow){
             newSize = getNextNum(2 * m);
        }
        else {
            newSize = getNextNum(m / 2);
        }
        // shrinking cannot go below 11
        if (!grow && newSize < 11) {
            newSize = 11;
        }

        // keep old table
        Pair<K, V>[] oldTable = this.table;

        // create new table
        this.table = new Pair[newSize];
        this.m = newSize;
        this.n = 0;   // reset count and reinsert everything

        // reinsert all non-deleted keys
        for (Pair<K, V> p : oldTable) {
            if (p != null && !p.getDeletionStatus()) {
                reInsert(p.getKey(), p.getValue());
            }
        }
    }


    private void reInsert(K key, V val) {
        int hashValue = findHashValue(key);
        int index = Math.floorMod(hashValue, m);

        for (int i = 0; i < m; i++) {
            Pair<K, V> curr = table[index];

            if (curr == null) {   // empty slot → insert here
                table[index] = new Pair<>(key, val);
                n++;
                return;
            }

            index = (index + 1) % m;
        }

    }


    //gets the next multiple of 6 plus or minus 1,
    //which has a decent probability of being prime.
    //Use this method when resizing the table.
    private int getNextNum(int num) {
	if(num == 2 || num == 3)
	    return num;
	int rem = num % 6;
	switch(rem) {
	case 0: num++; break;
	case 2: num+=3; break;
	case 3: num+=2; break;
	case 4: num++; break;
	}
	return num;
    }
}
      
