public class Heapsort {
    public static void sort(int[] list){
        int n = list.length;
        // Построение кучи
        heapify(list, n);
        for (int ii = 0; ii < list.length; ii++) {
            swap(list, 0, --n);            
            recursivelyDownwards(list, n, 0);
    
        }
    }
    static void swap(int[] list, int i, int j){
        int temp=list[i];
        list[i] = list[j];
        list[j] = temp;
    }


    static void recursivelyDownwards(int[] list, int size, int i){
        int leftChild = 2*i + 1;
        int rightChild = 2*i + 2;
        if (leftChild >= size){return;}
        if (rightChild >= size && list[leftChild] > list[i]) {
            swap(list, leftChild, i);
            return;
        }
        if(rightChild >= size && list[leftChild] <= list[i]){
            return;
        }
        if (list[leftChild] > list[i] || list[rightChild] > list[i]){
            if (list[leftChild] > list[rightChild]){
                swap(list, i, leftChild);
                recursivelyDownwards(list, size, leftChild);
            } else{
                swap(list, i, rightChild);
                recursivelyDownwards(list, size, rightChild);
            }
        } 
    }


    static void recursivelyUpwards(int[] list, int size, int i){
        int parent=(i-1)/2;
        if(i==0 || parent>=size){
            return;
        }

        if (list[parent] < list[i]){
            swap(list, i, parent);
            recursivelyUpwards(list, size, parent);
        }
    }

    
    static void heapify(int list[], int size){
        for (int i = 0; i < size;i++){
            recursivelyUpwards(list, size, i);
        }
    }
}
