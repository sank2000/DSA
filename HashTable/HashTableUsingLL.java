package HashTable;

import java.util.LinkedList;

/**
 * HashTableUsingLL
 */
public class HashTableUsingLL {
  private class Entry {
    private int key;
    private String value;

    public Entry(int k,String v) {
      key = k;
      value = v;
    }
  }

  LinkedList<Entry>[] hashtable;
  int SIZE = 5;

  HashTableUsingLL() {
    hashtable = new LinkedList[SIZE];
  }
  
  HashTableUsingLL(int size) {
    SIZE = size;
    hashtable = new LinkedList[SIZE];
  }

  public void put(int k, String v) {
    var entry = new Entry(k, v);
    var hash = getHash(k);

    if (hashtable[hash] == null) {
      hashtable[hash] = new LinkedList<Entry>();
    } else {
      for (Entry e : hashtable[hash]) {
        if (e.key == k) {
          e.value = v;
          return;
        }
      }
    }

    hashtable[hash].addLast(entry);
  }
  
  public String get(int k) {
    var hash = getHash(k);

    if (hashtable[hash] != null) {
      for (Entry entry : hashtable[hash]) {
        if (entry.key == k)
          return entry.value;
      }
    }

    return null;
  }
  
  public void remove(int k) {
    var hash = getHash(k);

    if (hashtable[hash] != null) {
      for (Entry entry : hashtable[hash]) {
        if (entry.key == k)
        {
          hashtable[hash].remove(entry);
          return;
        }
      }
    }

    throw new IllegalStateException();
  }

  private int getHash(int value) {
    return value % SIZE;
  }
  
  public void print() {
    for (LinkedList<Entry> linkedList : hashtable) {
      if (linkedList == null)
        continue;
      System.out.println(linkedList);
      for (Entry entry : linkedList) {
        System.out.println(entry.key + " - " + entry.value);
      }
    }
  }

  
}