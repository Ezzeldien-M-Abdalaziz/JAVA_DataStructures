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
        if(this.top_index < this.current_size -1) return ;  //if elements < the actual size of stack
        System.out.println("will be resized");
        int[] newArray = new int[this.current_size + this.initial_size];
        System.arraycopy(this.dataList, 0, newArray, 0, this.initial_size + this.current_size);
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

    int pop(){
        if(this.top_index == -1) return 0;
        int head_data = this.dataList[this.top_index];
        this.dataList[this.top_index] = 0;
        this.top_index--;   //
        return head_data;
    }


}
