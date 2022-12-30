public class LinkedListDeque<itemType> implements Deque<itemType> {
    /**-------------------------------- */
    /**---------Class Definition------- */
    /**-------------------------------- */
    private class linkNode{
        itemType item;
        linkNode next;
        linkNode prev;

        public linkNode (itemType item,linkNode prev, linkNode next){
            this.item=item;
            this.next=next;
            this.prev=prev;
        }
        public linkNode (){
            this.item=null;
            this.next=null;
            this.prev=null;
        }
    }
    /**-------------------------------- */
    /**-------Attribute Definition----- */
    /**-------------------------------- */
    private linkNode sentinal;
    /** Comment: circular sentinal
     * sentinal.next = first
     * sentinal = first.prev
     * sentinal = last.next
     * last = sentinal.prev
     */
    private int size;




    /**-------------------------------- */
    /**---------Method Definition------ */
    /**-------------------------------- */
    public LinkedListDeque(){
        this.size = 0;
        this.sentinal = new linkNode();
        this.sentinal.next = this.sentinal;
        this.sentinal.prev = this.sentinal;
    }

    @Override
    public void addFirst(itemType item){
        this.size += 1;
        this.sentinal.next = new linkNode(item, this.sentinal, this.sentinal.next);
        this.sentinal.prev = this.sentinal.prev.prev.next;
    }

    @Override
    public void addLast(itemType item){
        this.size += 1;
        this.sentinal.prev = new linkNode(item, this.sentinal.prev, this.sentinal);
        this.sentinal.next = this.sentinal.next.next.prev;
    }

    @Override
    public itemType removeFirst(){
        itemType removeditem;
        if (sentinal.next == sentinal){
            return null;
        }
        removeditem = sentinal.next.item;
        sentinal.next = sentinal.next.next;
        sentinal.next.prev = sentinal;
        return removeditem;
    }
    @Override
    public itemType removeLast(){
        itemType removeditem;
        if (sentinal.prev == sentinal){
            return null;
        }
        removeditem = sentinal.prev.item;
        sentinal.prev = sentinal.prev.prev;
        sentinal.prev.next = sentinal;
        return removeditem;
    }
    /**helper for get item*/
    private itemType getRecursive(int index, linkNode p){
        if (index == 0){
            return p.next.item;
        }
        return get(index-1, p.next);
    }

    /**public get */
    public itemType getRecursive(int index){
        if (sentinal.next == sentinal)
        {
            return null;
        }
        else {
            return getRecursive(index, sentinal);
        }

    }
    /**helper for get item*/
    private itemType get(int index, linkNode p){
        for (int i =0; i<index; i++)
        {
            p = p.next;
        }
        return p.item;
    }

    /**public get */
    @Override
    public itemType get(int index){
        if (sentinal.next == sentinal)
        {
            return null;
        }
        else {
            return get(index, sentinal.next);
        }

    }
    @Override
    public boolean isEmpty(){
        return (sentinal.next == sentinal);
    }

    @Override
    public int size(){
        return this.size;
    }

    @Override
    public void printDeque(){
        linkNode p=this.sentinal;
        while (p.next != sentinal){
            System.out.println(p.next.item);
            p = p.next;
        }
    }
}
