public class Pair<K, V> {
    private K key;
    private V val;
    private boolean deleteStatus; //True = deleted, false = not deleted

    public Pair(K key, V val) {
	this.key = key;
	this.val = val;
    this.deleteStatus = false;
    }

    public K getKey() {
	return key;
    }

    public V getValue() {
	    return val;
    }

    public void setValue(V val) {
	this.val = val;
    }

    public boolean equals(Pair<K, V> p) {
	return this.key.equals(p.getKey()) && this.val.equals(p.getValue());
    }

    public String toString() {
	return "(key = " + key.toString() + ", value = " + val.toString() + ")";
    }

    public boolean getDeletionStatus(){ //Checks if pair has been deleted
        return deleteStatus;
    }

    public void setDeleted(){   //Updates pair to be set as deleted
        this.deleteStatus = true;
    }
}
