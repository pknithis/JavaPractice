import java.util.*;

class Bucket<Key,Value>
{
  Key k;
  Value v;
  Bucket next;

  Bucket(Key k, Value v)
  {
    this.k = k;
    this.v = v;
    next = null;
  }
  void set(Value val)
  {
          v = val;
  }
}

public class MyHashMap<Key,Value>
{
    int capacity ;
    float loadFactor;
    Bucket<Key,Value> hash[] ;
    int curLoad ;
    MyHashMap(int c)
    {
      capacity = c;
      loadFactor = 0.75f;
      hash = new Bucket[capacity];
      System.out.println("Created Hash With size: "+capacity);
    
      curLoad = 0;
    }
    int getHashCode(Key k)
    {
      int hashcode = k.hashCode() % capacity;
      System.out.println("Key : "+k+" Hashcode: "+hashcode);
  
      return hashcode;
    }

    public void rehash()
    {
        capacity *= 2; 
        System.out.println("Rehashing to size: "+capacity);
        Bucket<Key,Value> newhash [] = new Bucket[capacity];

        for(Bucket<Key,Value> b:hash)
        {
          Bucket<Key,Value> oldBucket = b;
          while(oldBucket  != null)
          {
              Bucket<Key,Value> prev = newhash[getHashCode(oldBucket.k)];
              
              if(prev == null)
              {
                      newhash[getHashCode(oldBucket.k)] = new Bucket(oldBucket.k,oldBucket.v);
              }
              else
              {
                     
                      Bucket<Key,Value> cur = prev;
                      while(cur != null)
                      {
                              prev = cur;
                              cur = cur.next;                     
                      }
                      prev.next = new Bucket(oldBucket.k,oldBucket.v);
             }
             oldBucket = oldBucket.next;
          }
        }
        hash = newhash;
    }

    public void put(Key k , Value v)
    {
            int hashcode = getHashCode(k);

            Bucket<Key,Value> prev = hash[hashcode];
            
            //check if the key is already present
            if(prev == null)
            {
                    hash[hashcode] = new Bucket(k,v);
            }
            else
            {
                
                    Bucket<Key,Value>  cur = prev;
                    while(cur != null)
                    {
                            if(cur.k.equals(k))
                                    {
                                      System.out.println("Key already present "+k+" : "+v);
                                      cur.set(v);
                                      return;
                                    }
                            prev = cur;
                            cur = cur.next;
                    }
                    prev.next = new Bucket(k,v);            
                        
            }
            //calculate load
            curLoad++;

            if(curLoad > (loadFactor*capacity))
            {
                    rehash();
            }

    }

    public Value get(Key k)
    {
        int hashcode = getHashCode(k);

        Bucket<Key,Value> cur = hash[hashcode];

        while(cur != null)
        {
                if(cur.k.equals(k))
                {
                        return cur.v;
                }
                cur = cur.next;
        }

        return null;
  }

  public static void main(String []args)
  {
          MyHashMap <Integer,Integer>hm = new MyHashMap(4);
          hm.put(1,1);
          hm.put(5,5);
          hm.put(17,17);
          System.out.println("Get 2:"+hm.get(2)+"");
          hm.put(3,3);
          hm.put(4,4);
          hm.put(3,5);
          
          System.out.println("Get 4:"+hm.get(4)+"");
          System.out.println("Get 3:"+hm.get(3)+"");
          System.out.println("Get 17:"+hm.get(17)+"");
          System.out.println("Get 5:"+hm.get(5)+"");

  }
}
