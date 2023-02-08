public class DisplayArray {
    
    private int[] array = {25, 96, 87, 41};

    public void displayArrayRecursively(int first, int last) {
        if (first <= last) {
            System.out.print(array[first] + " ");
            displayArrayRecursively(first + 1, last);
        }
    }

    public void displayArrayWithStack(int first, int last) {
        StackInterface<Record> stack = new LinkedStack<Record>();
        stack.push(new Record(first, last));
        while (!stack.isEmpty()) {
            Record top = stack.pop();
            if (top.first <= top.last) {
                System.out.print(array[top.first] + " ");
                stack.push(new Record(top.first + 1, top.last));
            }
        }
    }

    public static void main(String[] args) {

        DisplayArray da = new DisplayArray();
     
        da.displayArrayRecursively(0,da.array.length-1);
        System.out.println();
        da.displayArrayWithStack(0,da.array.length-1);
     }
     
     
     private class Record
     {
     private int first, last;
         private Record(int firstIndex, int lastIndex)
        {
           first = firstIndex;
           last = lastIndex;
        } // end constructor
     } // end Record
}
