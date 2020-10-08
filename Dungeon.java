public class LongList implements MyList{
    long data;
    LongList next;
    public LongList(LongList n, long data){
        this.data = data;
        next = n;

    }

    public long getData( ){
        return this.data;
    }

    public LongList next( ){
        return this.next;
    }

    public void printNode( ){
        System.out.print("LongList Node, data is : "+this.data);
    }
}
