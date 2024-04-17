public class Heapsort {
    public static int sort(int[] list){
        int count = 0;
        int n = list.length;
        // Построение кучи
        count+=heapify(list, n);
        for (int ii = 0; ii < list.length; ii++) {
            swap(list, 0, --n);            
            count+=recursivelyDownwards(list, n, 0, 1);
    
        }
        return count;
    }
    static void swap(int[] list, int i, int j){
        int temp=list[i];
        list[i] = list[j];
        list[j] = temp;
    }


    static int recursivelyDownwards(int[] list, int size, int i, int count){
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        if (leftChild >= size){return count;}
        if (rightChild >= size && list[leftChild] > list[i]) {
            swap(list, leftChild, i);
            return count;
        }
        if(rightChild >= size && list[leftChild] <= list[i]){
            return count;
        }
        if (list[leftChild] > list[i] || list[rightChild] > list[i]){
            if (list[leftChild] > list[rightChild]){
                swap(list, i, leftChild);
                return recursivelyDownwards(list, size, leftChild, count+1);
            } else{
                swap(list, i, rightChild);
                return recursivelyDownwards(list, size, rightChild, count+1);
            }
        } 
        return count;
    }


    static int recursivelyUpwards(int[] list, int size, int i, int count){
        int parent=(i-1)/2;
        if(i==0 || parent>=size){
            return count;
        }

        if (list[parent] < list[i]){
            swap(list, i, parent);
            return recursivelyUpwards(list, size, parent, count+1);
        }
        return count;
    }

    
    static int heapify(int list[], int size){
        int q = 0;
        for (int i = 0; i < size;i++){
            q += recursivelyUpwards(list, size, i, 1);
        }
        return q;
    }
}
