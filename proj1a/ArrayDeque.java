public class ArrayDeque<itemType> implements Deque<itemType> {
    /**Implemented with circular pointer*/
    /** @source https://docs.google.com/presentation/d/1XBJOht0xWz1tEvLuvOL4lOIaY0NSfArXAvqgkrx0zpc/edit#slide=id.g15cbbcb770b_47_40*/
    public itemType[] list;
    private int size;
    private int nextFirst;
    private int nextLast;
    public void resize(int capacity){
        itemType[] temp = (itemType[]) new Object[list.length];
        int remapedIndex = 0;
        for (int i =0;i<size;i++){
            remapedIndex = indexRemap(nextFirst+1+i);
            temp[i] = list[remapedIndex];
        }
        list = (itemType[]) new Object[capacity];
        for (int i=0;i<capacity;i++){
            list[indexRemap(i)] = temp[i];
        }
        nextFirst = -1;
        nextLast = size;
    }
    public ArrayDeque(itemType[] s){
        size = s.length;
        int capacity = 8;
        for (capacity=8;capacity<s.length;capacity*=2){}
        list = (itemType[]) new Object[capacity];
        for (int i = 0;i<size;i++){
            list[indexRemap(i)] = s[i];
        }
        nextFirst = -1 ;
        nextLast = size;
    }
    public ArrayDeque(){
        size = 0;
        list = (itemType[]) new Object[8];
        nextFirst = 0;
        nextLast = 0;
    }
    private int indexRemap(int index){
        return +((list.length/2+index) % list.length + list.length) % list.length;
    }
    public void printDeque(){
        for (int i=0;i<size;i++){
            System.out.print(list[indexRemap(i+1+nextFirst)]);
        }
    }

    @Override
    public void addFirst(itemType item){
        if (size == list.length){
            resize(list.length*2);
        }
        list[indexRemap(nextFirst)] = item;
        nextFirst -= 1;
    }
    @Override
    public void addLast(itemType item){
        if (size == list.length){
            resize(list.length*2);
        }
        list[indexRemap(nextLast)] = item;
        nextLast += 1;
    }
    @Override
    public boolean isEmpty(){
        return (size == 0);
    }

    @Override
    public int size(){
        return size;
    }
    @Override
    public itemType removeFirst(){
        if (this.isEmpty()) {
            return null;
        }
        itemType removedItem = list[indexRemap(nextFirst+1)];
        nextFirst = nextFirst + 1;
        list[indexRemap(nextFirst)] = null;
        return removedItem;
    }
    @Override
    public itemType removeLast(){
        if (this.isEmpty()) {
            return null;
        }
        itemType removedItem = list[indexRemap(nextLast-1)];
        nextLast = nextLast - 1;
        list[indexRemap(nextLast)] = null;
        return removedItem;
    }
    @Override
    public itemType get(int index){
        return list[indexRemap(nextFirst+1+index)];
    }

}
