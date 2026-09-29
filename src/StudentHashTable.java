/**
 * A hand-written hash table (separate chaining) that gives O(1) average
 * lookup of a student record by Student ID (Requirement 6).
 */
public class StudentHashTable {

    private static class Entry {
        String key;
        Student value;
        Entry next;
        Entry(String key, Student value) { this.key = key; this.value = value; }
    }

    private Entry[] buckets;
    private int capacity;
    private int count;

    public StudentHashTable() {
        this(16);
    }

    public StudentHashTable(int capacity) {
        this.capacity = capacity;
        this.buckets = new Entry[capacity];
    }

    private int hash(String key) {
        int h = 0;
        for (int i = 0; i < key.length(); i++) {
            h = 31 * h + key.charAt(i);
        }
        return Math.abs(h) % capacity;
    }

    public void put(String studentId, Student student) {
        // grow the table once load factor gets high, to keep lookups fast
        if (count >= capacity * 0.75) resize();

        int idx = hash(studentId);
        Entry cur = buckets[idx];
        while (cur != null) {
            if (cur.key.equalsIgnoreCase(studentId)) {
                cur.value = student; // update existing
                return;
            }
            cur = cur.next;
        }
        Entry newEntry = new Entry(studentId, student);
        newEntry.next = buckets[idx];
        buckets[idx] = newEntry;
        count++;
    }

    public Student get(String studentId) {
        int idx = hash(studentId);
        Entry cur = buckets[idx];
        while (cur != null) {
            if (cur.key.equalsIgnoreCase(studentId)) return cur.value;
            cur = cur.next;
        }
        return null;
    }

    public boolean remove(String studentId) {
        int idx = hash(studentId);
        Entry cur = buckets[idx], prev = null;
        while (cur != null) {
            if (cur.key.equalsIgnoreCase(studentId)) {
                if (prev == null) buckets[idx] = cur.next;
                else prev.next = cur.next;
                count--;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    public void clear() {
        buckets = new Entry[capacity];
        count = 0;
    }

    private void resize() {
        Entry[] old = buckets;
        capacity *= 2;
        buckets = new Entry[capacity];
        int oldCount = count;
        count = 0;
        for (Entry head : old) {
            Entry cur = head;
            while (cur != null) {
                put(cur.key, cur.value);
                cur = cur.next;
            }
        }
        count = oldCount;
    }

    public int size() { return count; }
}
