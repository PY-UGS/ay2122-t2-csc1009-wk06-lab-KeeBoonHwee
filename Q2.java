import java.util.*;
public class Q2 
{
    public static void swapValues (LinkedList<Integer> list, int indexOne, int indexTwo)
    {
        Integer temp1 = list.get(indexOne);
        Integer temp2 = list.get(indexTwo);
        if(indexTwo > indexOne)
        {
            list.remove(indexTwo);
            list.remove(indexOne);
            list.add(indexOne,temp2);
            list.add(indexTwo,temp1);
        }
        else
        {
            list.remove(indexOne);
            list.remove(indexTwo);
            list.add(indexTwo,temp1);
            list.add(indexOne,temp2);
        }
    }
   public static void main(String args[])
   {  
    LinkedList<Integer> linkedList = new LinkedList<Integer>( Arrays.asList(1,3,5,7,9,11) );
    System.out.println("LinkedList before swap : " + linkedList);
    swapValues(linkedList, 1, 5);
    System.out.println("LinkedList after  swap : " + linkedList);
   }      
}
