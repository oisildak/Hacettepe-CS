
class Stack {
    /*
     Stacks based on "last-in-first-out" as know as "lifo"
     */
    static final int Capacity = 100;//I fixed it to 100
    int first;//our indicator
    int[] ints = new int[Capacity]; // Capacity of Stack


    Stack()
    {
        first = -1;//I started to -1 because I used pre-increment in array list
    }

    void push(int x)//that add items into stack
    {
        if (first >= (Capacity - 1)) {
            System.out.println("Stack full");
        }
        else {
            ints[++first] = x;// I fixed first to -1 in start with  help pre increment. I can start in 0 which is starting index
        }
    }

    int pop()//That remove items from stack
    {
        if (first < 0) {

            return 0;
        }
        else {
            int i = ints[first--];//in order to remove I used to post increment.
            return i;
        }
    }




}


