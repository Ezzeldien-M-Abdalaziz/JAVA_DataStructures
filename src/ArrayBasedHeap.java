
import java.util.ArrayList;

public class ArrayBasedHeap<T extends Comparable<T>> {

    private ArrayList<T> dataList;

    public ArrayBasedHeap() {
        this.dataList = new ArrayList<>();
    }


    //🔹 Example
    //
    //Insert 5 into heap [10, 20, 30]:
    //
    //Add 5 at the end: [10, 20, 30, 5]
    //
    //Compare with parent 20: shift down → [10, 20, 30, 20]
    //
    //Compare with parent 10: shift down → [10, 10, 30, 20]
    //
    //Place 5 at root → [5, 10, 30, 20]
    //
    //No temp variable needed ✅

    //min heap insert
    void insert(T data){
        int i = dataList.size();   //get the size of the array  // index of the new element , because array start form 0
        this.dataList.add(data);  //add the data to the last of the array

        int parent_index = (i - 1) / 2;    // compute parent index
        while(i != 0 && this.dataList.get(i).compareTo(this.dataList.get(parent_index)) < 0){

            // shift parent down
            this.dataList.set(i, this.dataList.get(parent_index));  //overwrite the new element with the parent element

            // temporarily put data up
            this.dataList.set(parent_index, data);

            // Move up
            i = parent_index;
            parent_index = (i - 1) / 2;
        }
    }

    void delete(){
        int i = dataList.size();

    }
















    public void print() {
        System.out.println(dataList);
    }

    public void draw() {
        int n = dataList.size();
        int level = 0;
        int index = 0;

        while (index < n) {
            int levelCount = (int) Math.pow(2, level); // nodes at this level
            for (int j = 0; j < levelCount && index < n; j++) {
                System.out.print(dataList.get(index) + " ");
                index++;
            }
            System.out.println(); // new line after each level
            level++;
        }
    }




}
