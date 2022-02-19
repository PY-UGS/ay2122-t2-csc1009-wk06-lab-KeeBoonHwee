import java.util.*;

public class Q6 {
    public static int findValue(    LinkedList<String> keys,
                                    LinkedHashMap<String,Integer> list, 
                                    int searchVal)
    {
        if( keys.size() != list.size() ) return -1;
        Integer findVal = Integer.valueOf(searchVal);
        for(int i = 0 ; i < keys.size() ; i++)
        {
            String  key = keys.get(i);
            Integer value = list.get(key);
            if(findVal == value)
            {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[])
    {  
        final int size = 500;
        final int minVal = 1000;
        final int maxVal = 9999;
        boolean invalid_value = false;
        int[] primitive_array = new Random().ints(size, minVal, maxVal).toArray();
        LinkedList<String>              linkedListKeys   = new LinkedList<String>();
        LinkedHashMap<String,Integer>   linkedHashMap    = new LinkedHashMap<String,Integer>();  // each key has to be unique....
        for(int i = 0 ; !invalid_value && i < size ; i++)
        {
            if(primitive_array[i] < minVal || primitive_array[i] > maxVal)
            {
                System.out.println("Invalid random integer found!");
                invalid_value = true;
            }
            else
            {
                String key =  UUID.randomUUID().toString();
                linkedListKeys.add(key);
                linkedHashMap.put( key, Integer.valueOf( primitive_array[i] ) );
            }
        }
        System.out.println("LinkedHashMap before search : " + linkedHashMap);
        int[] searchVal = new Random().ints(1, minVal, maxVal).toArray();
        int index = findValue(linkedListKeys,linkedHashMap, searchVal[0] );
        if(index > -1) System.out.println( searchVal[0] + " has been found within LinkedHashMap at LinkedHashMap[" + index + "] = " + linkedHashMap.get( linkedListKeys.get(index)));
        else           System.out.println( searchVal[0] + " cannot be found within LinkedHashMap." );
    }
}

// javac Q6.java
// java  Q6