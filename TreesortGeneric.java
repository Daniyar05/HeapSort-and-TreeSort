public class TreesortGeneric<T extends Number & Comparable<T>> {
    DoubleLinkedList<T> tree;
    int size;
    int indexNext = 0;
    int count=0;
    public TreesortGeneric(T[] a) {
        createTree(a);
    }
    
    private void createTree(T[] a){
        size = a.length;
        tree = new DoubleLinkedList<>();
        for (T i : a) {
            put(i);
        }
        
    }
    public void put(T elem){
        count+=tree.add(elem);
    }

    private LinkedElement<T> up(LinkedElement<T> nowElement){count++; return nowElement.getParent();}
    private LinkedElement<T> downLessAll(LinkedElement<T> nowElement){
        while (nowElement.getNextLess() != null) {
            nowElement = nowElement.getNextLess();
            count++;
        }
        count++;
        return nowElement;
    }


    public int getSortedArray(){
        ArrayListGeneric<T> sort = new ArrayListGeneric<>();
        boolean normalStatus = tree.getFirstElement().getStatus();
        LinkedElement<T> nowElement = tree.getFirstElement();
        nowElement = downLessAll(nowElement);//доходим до минимального значения в дереве
        sort.add(nowElement.getElem());
        nowElement.reworkStatus();
        while (sort.size() < size) {
            if (nowElement.getNextMore() == null || nowElement.getNextMore().getStatus() != normalStatus) {
                nowElement = up(nowElement);
            }else{
                nowElement = downLessAll(nowElement.getNextMore());
                
            }
            if (nowElement.getStatus() == normalStatus){
                sort.add(nowElement.getElem());
                nowElement.reworkStatus();
                count++;
            }
            
        }
        return count;
    }
}
