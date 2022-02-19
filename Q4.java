import java.util.*;

public class Q4 {

    public static void addAndSort( LinkedList<String>            listkey, 
                                   LinkedHashMap<String,Integer> hashmap, 
                                   int                           value )
    {
          if( listkey.size() != hashmap.size() ) return;

          String  newkey =  UUID.randomUUID().toString();
          Integer newValue = Integer.valueOf(value);
          boolean inserted = false;
          int     insertIndex = 0;
          for(int i = 0 ; i < listkey.size() ; i++)
          {
               String  oldkey = listkey.get(i);
               Integer oldValue = hashmap.get(oldkey);
               if( !inserted )
               {
                    if( newValue <= oldValue )
                    {
                         hashmap.put( newkey , newValue);
                         hashmap.remove(oldkey);
                         hashmap.put( oldkey , oldValue);
                         insertIndex = i;
                         inserted = true;
                    }
               }
               else
               {
                    hashmap.remove(oldkey);
                    hashmap.put( oldkey , oldValue);
               }
          }
          if(!inserted)
          {
               listkey.add( newkey );
               hashmap.put( newkey , newValue);
          }
          else
          {
               listkey.add( insertIndex , newkey );
          }
    }

   public static void main(String args[])
   {  
          LinkedList<String>            linkedListKeys      = new LinkedList<String>();     
          LinkedList<Integer>           linkedListValues    = new LinkedList<Integer>( Arrays.asList(1,3,5,7,9,11) );
          LinkedHashMap<String,Integer> linkedHashMap       = new LinkedHashMap<String,Integer>();  // each key has to be unique....
          for(int i = 0 ; i < linkedListValues.size() ; i++)
          {
               linkedListKeys.add( UUID.randomUUID().toString() );
               linkedHashMap.put(                   linkedListKeys.get(i)   , 
                                   Integer.valueOf( linkedListValues.get(i) ) );
          }
          System.out.println("LinkedHashMap before insertion : \n" + linkedHashMap);
          addAndSort(linkedListKeys,linkedHashMap,6);
          System.out.println("LinkedHashMap after insertion : \n" + linkedHashMap);
   } 

}

// javac Q4.java
// java  Q4
