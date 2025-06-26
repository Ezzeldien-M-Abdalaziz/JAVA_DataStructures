public class Array {
    private int [] items;
    private int count; //number of items in the array

    Array(int size){
        items = new int[size];   //initialize the array with the size
        count = 0;    //number of elements are zero
    }

    //check if the array is full
    boolean isFull(){
        return count == items.length;
    }

    //add to the end of the array
    void append(int item){
        //check if there is room in the array
        if(isFull()){
            System.out.println("Array is  , cannot append");
        }
        else{
            items[count] = item; //insert in the end of the array since count is the real number of elements +1
            count++;  // increase the count
        }
    }

    //get all items
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


    //insert in chosen place
    void insert (int position , int newItem){
            if(isFull()){
                System.out.println("Array is full, cannot insert ");
                return;
            }
            for(int i = count; i > position; i--){   //this for loop shifts elements to the second index of every element so we have the position empty for the new item.
              items[i] = items[i-1];   //shifts element.
            }
            items[position] = newItem;
            count++;
    }

    //delete an item
    void remove(int position){
        for(int i = position; i < count -1; i++){
            items[i] = items[i+1];
        }
        count--;
    }

    //enlarge the size of the array
//    int[] enlarge (int newSize){
//        if(newSize < items.length){
//            System.out.println("Array is  enlarged");
//            return items;
//        }
//
//        int[] newArr = new int[newSize];
//        for(int i=0 , j=0; i<count; i++ , j++){
//            newArr[j] = items[i];
//        }
//        return newArr;
//    }

        //enlarge the size of the array
        Array enlarge (int newSize){
            if(newSize > items.length){
                Array newArr = new Array(newSize);
                for(int i=0 , j=0; i<count; i++ , j++){
                    newArr.items[j] = this.items[i];
                }
                return newArr;
            }else{
                return this;
            }
        }

         int[] merge(int[] other){
            int[] largeArray = new int[items.length + other.length];
            int index = 0;   //to track all the elements pos

            for(int i = 0; i < count; i++ , index++){   //f irst array
                largeArray[index] = items[i];
            }
            for(int i = 0; i < other.length; i++ , index++){ //second array
                largeArray[index] = other[i];
            }

            return largeArray;
         }

}

































































