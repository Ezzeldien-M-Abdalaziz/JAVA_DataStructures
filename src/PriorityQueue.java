import java.util.ArrayList;

public class PriorityQueue<T extends Comparable<T>>{

    private ArrayList<T> dataList;

    public PriorityQueue() {
        this.dataList = new ArrayList<>();
    }

    void insert(T data){
        int i = dataList.size();
        this.dataList.add(data);

        int parent_index = (i - 1) / 2;
        while(i != 0 && this.dataList.get(i).compareTo(this.dataList.get(parent_index)) < 0){


            this.dataList.set(i, this.dataList.get(parent_index));

            this.dataList.set(parent_index, data);

            i = parent_index;
            parent_index = (i - 1) / 2;
        }
    }

    T pop(){

        if(this.dataList.isEmpty()){
            return null;
        }


        int i = 0;
        T data = this.dataList.get(i);

        this.dataList.set(i, this.dataList.getLast());
        this.dataList.removeLast();

        int left_index = 2 * i + 1;

        while(left_index < this.dataList.size()){
            int right_index = 2 * i + 2;
            int smallest_index = left_index;

            if (right_index < this.dataList.size() &&
                    this.dataList.get(right_index).compareTo(this.dataList.get(smallest_index)) < 0) {
                smallest_index = right_index;
            }

            if(this.dataList.get(smallest_index).compareTo(this.dataList.get(i)) >= 0){
                break;
            }

            T temp = this.dataList.get(i);
            this.dataList.set(i, this.dataList.get(smallest_index));
            this.dataList.set(smallest_index, temp);

            i = smallest_index;
            left_index = 2 * i + 1;

        }
        return data;

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
