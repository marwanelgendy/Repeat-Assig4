package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

public class SList implements ILinkedList {
    Nodes head ; //where the head is a reference on the first node in the list
   public void add(int index, Object element)
   {
       Nodes n=new Nodes();
       n.setValue((int)element);
       if (index==0)
       {
           n.setNext(head);
           head=n;
           return;
       }
       Nodes node=head;
       for (int i=0;i<index-1;i++)
       {
           node=node.getNext();
       }
       n.next=node.getNext();
       node.next=n;
   }
   public void add(Object element)
    {
        Nodes n=new Nodes();
        n.setValue((int)element);
        if(head==null)
        {
            head=n;
            return;
        }
        Nodes node=head;
        while (node.next!=null)
        {
            node=node.getNext();
        }
        node.next=n;
        n.next=null;
    }
   public Object get(int index)
   {
       if (index==0)
       {
           return head.getValue();
       }
       Nodes node =head;
       for (int i=0;i<index-1;i++)
       {
           node=node.getNext();
       }
       return node.getNext().getValue();
   }
   public void set(int index, Object element)
   {
       Nodes n=new Nodes();
       n.setValue((int)element);
       if (index==0)
       {
           n.next=head.getNext();
           head=n;
           return;
       }
       Nodes node =head;
       for (int i=0;i<index-1;i++)
       {
           node=node.getNext();
       }
       n.next=node.getNext().next;
       node.getNext().next=null;
       node.next=n;
   }
   public void clear()
   {
     head =null;

   }
   public boolean isEmpty()
   {
       if(head==null)
           return true;
       return false;
   }
   public void remove(int index)
    {
        if (index==0)
        {
            head=head.getNext();
            return;
        }
        Nodes node =head;
        for (int i=0;i<index-1;i++)
            node=node.getNext();
        node.next=node.getNext().next;
    }
    public int size()
    {
        int size=0;
        Nodes node =head;
        while (node!=null)
        {
            size++;
            node=node.getNext();
        }
        return size;
    }
    public SList sublist(int fromIndex, int toIndex)
    {
        SList list=new SList();
        if(fromIndex<0||toIndex>size()||fromIndex>toIndex)
            return list;
        Nodes node=head;
        for (int i=0;i<fromIndex;i++)
            node= node.getNext();
        for (int i=fromIndex;i<=toIndex;i++)
        {
            Nodes n=new Nodes();
            n.setValue(node.getValue());
            list.add(n);
            node=node.getNext();
        }
        return list;
    }
    public boolean contains(Object o)
    {
        Nodes n=new Nodes();
        n.setValue((int)o);
        Nodes node =head;
        while (node !=null)
        {
            if(node.getValue()==n.getValue())
                return true;
            node=node.getNext();
        }
        return false;
    }
}
