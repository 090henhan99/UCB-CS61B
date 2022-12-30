public interface Deque<itemType> {
    public void addFirst(itemType item);
    public void addLast(itemType item);
    public boolean isEmpty();
    public int size();
    public void printDeque();
    public itemType removeFirst();
    public itemType removeLast();
    public itemType get(int index);
}
