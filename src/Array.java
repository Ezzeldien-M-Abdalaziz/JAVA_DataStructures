public class Array {
    private int [] items;
    private int count; //number of items in the array

    Array(int size){
        items = new int[size];   //initialize the array with the size
        count = 0;    //number of elements are zero
    }

    //add to the end of the array
    void append(int item){
        //check if there is room in the array
        if(count == items.length){
            System.out.println("Array is full , cannot add anymore items");
            return;
        }else{
            items[count] = item; //insert in the end of the array since count is the real number of elements +1
            count++;  // increase the count
        }
    }

    //get alll items
    void traverse(){
        for(int i = 0; i<count; i++){
            System.out.println(items[i]);
        }
    }

    //search for an item
    boolean search(int item){
        for(int i = 0; i<count; i++){
            if(items[i] == item){
                return true;
            }
        }
        return false;
    }

    //getter count
    public int getCount(){
        return count;
    }




}
