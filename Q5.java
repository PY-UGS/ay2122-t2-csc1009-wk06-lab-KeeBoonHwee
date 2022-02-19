import java.util.*;

public class Q5 {
 
    public static void swapValues ( LinkedList<String>              linkedListKeys , 
                                    LinkedHashMap<String,Integer>   linkedHashMap, 
                                    int                             indexOne, 
                                    int                             indexTwo)
    {
        if( linkedListKeys.size() != linkedHashMap.size() ) return;

        String  firstKey = linkedListKeys.get(indexOne);
        Integer firstValue = linkedHashMap.get(firstKey);

        String  secondKey = linkedListKeys.get(indexTwo);
        Integer secondValue = linkedHashMap.get(secondKey);
        for(int i = 0 ; i < linkedListKeys.size() ; i++)
        {
            if(i == indexOne)
            {
                linkedHashMap.remove(firstKey);
                linkedHashMap.put(secondKey,secondValue);
            }
            else if(i == indexTwo)
            {
                linkedHashMap.remove(secondKey);
                linkedHashMap.put(firstKey,firstValue);
            }
            else
            {
                String  oldKey = linkedListKeys.get(i);
                Integer oldValue = linkedHashMap.get(oldKey);
                linkedHashMap.remove(oldKey);
                linkedHashMap.put(oldKey,oldValue);
            }
        }
        linkedListKeys.remove(indexOne);
        linkedListKeys.add(indexOne,secondKey);
        linkedListKeys.remove(indexTwo);
        linkedListKeys.add(indexTwo,firstKey);
    }
    public static void main(String args[])
    {  
            LinkedList<String>              linkedListKeys   = new LinkedList<String>();
            LinkedList<Integer>             linkedListValues = new LinkedList<Integer>( Arrays.asList(1,3,5,7,9,11) );
            LinkedHashMap<String,Integer>   linkedHashMap    = new LinkedHashMap<String,Integer>();  // each key has to be unique....

            for(int i = 0 ; i < linkedListValues.size() ; i++)
            {
                linkedListKeys.add( UUID.randomUUID().toString() );
                linkedHashMap.put(                   linkedListKeys.get(i)   , 
                                    Integer.valueOf( linkedListValues.get(i) ) );
            }

    } 
}
