public class ArrayBased_Stack {
    private int[] dataList;
    private int top_index;
    private int initial_size;
    private int current_size;

    public ArrayBased_Stack(){
        this.initial_size = 5;
        this.dataList = new int[this.initial_size];
        this.current_size = this.initial_size;
        this.top_index = -1;
    }

    void resizeOrNot(){
        if(this.top_index < this.current_size -1) return ;  //if num of elements < the actual size of stack
        System.out.println("will be resized");
        int[] newArray = new int[this.current_size + this.initial_size];
        System.arraycopy(this.dataList, 0, newArray, 0, this.current_size);  //copies array
        this.current_size += this.initial_size;
        this.dataList = newArray;
    }


    void push(int data){
        this.resizeOrNot();   //check first if there is space in the stack
        this.dataList[++this.top_index] = data; // exp -> top_index = 5 which is arr[5] = 20 , then the new top index will be 6 , arr[6] = data
    }

    int peek(){
        if(this.top_index == -1) return 0;
        return this.dataList[this.top_index];
    }

    /*
        in the pop we can check after pop the element ,
        if the elements in the stack are less than the actual size of the array then we can resize it
        and shrink it, but it's considered overcomplicated since we can use the free size later on.
     */
    int pop(){
        if(this.top_index == -1) return 0;
        int head_data = this.dataList[this.top_index];
        this.dataList[this.top_index] = 0;
        this.top_index--;   //
        return head_data;
    }

    boolean isEmpty(){
        return this.top_index == -1;     //here we check by top_index because it's the real size of the stack , but the current_size is the size of the array even if it's empty.
    }

    int size(){
        return this.top_index+1;   //this returns the actual size of the stack , THE NUM OF ELEMENTS.
    }

    void print (){
        System.out.println("_ _ _");
        for(int i = this.top_index; i >= 0; i--){
            System.out.println("| " + this.dataList[i] + " |");
        }
            System.out.println("_ _ _");
    }






}
