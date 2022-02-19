import java.util.*;
public class Q2 
{
    public static void swapValues (LinkedList<Integer> list, int indexOne, int indexTwo)
    {
        Integer temp1 = list.get(indexOne);
        Integer temp2 = list.get(indexTwo);

            list.remove(indexOne);
            list.add(indexOne,temp2);

            list.remove(indexTwo);
            list.add(indexTwo,temp1);
    }
   public static void main(String args[])
   {  
    LinkedList<Integer> linkedList = new LinkedList<Integer>( Arrays.asList(1,3,5,7,9,11) );
    System.out.println("LinkedList before swap : " + linkedList);
    swapValues(linkedList, 5, 1);
    System.out.println("LinkedList after  swap : " + linkedList);
   }      
}
// javac Q2.java
// java  Q2