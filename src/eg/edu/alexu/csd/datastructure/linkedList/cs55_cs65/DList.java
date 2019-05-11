package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

public class DList implements ILinkedList {
    NodeD head  ;
    NodeD tail  ;

    public void add(int index, Object element){
        int x = (int) element ;
        if(index > size() || index < 0 )
            return ;
        NodeD n = head ;
        if(head == null && tail == null){
            NodeD i = new NodeD();
            i.value = x ;
            i.previous = null ;
            i.next = null ;
            head = i ;
            tail = i ;
            return;
        }
        if(index == 0 ){
            NodeD i = new NodeD();
            i.value = x ;
            i.previous = null;
            i.next = head ;
            head.previous = i ;
            head = i ;
            return;
        }
        int counter = 0 ;
        while(counter<index-1){
            counter++;
            n=n.next;
        }
        NodeD i = new NodeD();
        i.value = x ;
        i.previous = n ;
        i.next = n.next ;
        if(n.next == null){
            n.next = i ;
            tail = i ;
        }
        else {
            n.next.previous=i ;
            n.next = i ;
        }
    }
    public void add(Object element){
        int x = (int) element ;
        if(tail == null && head == null){
            NodeD i = new NodeD();
            i.value = x ;
            i.next = null;
            i.previous = null;
            head = i ;
            tail = i ;
            return;
        }
        NodeD n = tail ;
        NodeD i = new NodeD();
        i.value = x ;
        i.previous = tail ;
        i.next = null ;
        tail.next = i;
        tail = i ;
    }
    public Object get(int index){
        NodeD n = null ;
        if(index >= size() || index < 0 )
            return n ;
        n = head ;
        int counter = 0 ;
        while (counter<index){
            counter++;
            n=n.next;
        }
        return n.value ;
    }
    public void set(int index, Object element){
        int x = (int) element ;
        if(index >= size() || index < 0 )
            return  ;
        NodeD n = head ;
        int counter = 0 ;
        if(index==0){
            NodeD i = new NodeD();
            i.value = x ;
            i.previous = null ;
            i.next = n.next ;
            n.next.previous = i ;
            head = i ;
            return;
        }
        while(counter < index){
            counter++;
            n=n.next ;
        }
        if(n.next==null){
            NodeD i = new NodeD();
            i.value = x ;
            i.previous = n.previous ;
            i.next = null ;
            n.previous.next = i ;
            tail = i ;
            return;
        }
        NodeD i = new NodeD();
        i.value = x ;
        i.next = n.next ;
        i.previous = n.previous ;
        n.next.previous = i ;
        n.previous.next = i ;
    }
    public void clear(){
        head = null ;
        tail = null ;
    }
    public boolean isEmpty(){
        if (head== null)
            return true;
        else
            return false ;
    }
    public void remove(int index){
        if(index >= size() || index < 0 )
            return ;
        if(head.next == null && tail.previous == null){
            head = null;
            tail = null ;
            return ;
        }
        NodeD n = head ;
        if(index == 0){
            head.next.previous = null;
            head = head.next ;
            return;
        }
        int counter = 0 ;
        while(counter < index){
            counter++;
            n=n.next;
        }
        if(n.next == null){
            n.previous.next = null ;
            tail = tail.previous ;
            return;
        }
        n.previous.next = n.next;
        n.next.previous = n.previous ;
    }
    public int size(){
        NodeD n = head ;
        if(head == null && tail == null)
            return 0 ;
        int counter = 1 ;
        while(n.next !=null){
            n=n.next;
            counter++;
        }
        return counter ;
    }
    public boolean contains(Object o){
        int x = (int) o ;
        if(head == null)
            return false ;
        NodeD n = head ;
        while(n.next != null){
            if(n.value == x){
                return true ;
            }
            n=n.next ;
        }
        if(n.value == x)
            return true ;
        return false ;
    }
    public DList sublist(int fromIndex, int toIndex){
        DList temp = new DList() ;
        if (fromIndex < 0 || toIndex >= size() || toIndex < fromIndex)
            return temp;
        for(int i = 0 ; i <= toIndex-fromIndex ; i++ ){
            int x = (int) get(i+fromIndex);
            temp.add(i,x);
        }
        return temp ;
    }
}
