package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

public interface ILinkedList {
    void add(int index, Object element);
    void add(Object element);
    Object get(int index);
    void set(int index, Object element);
    void clear();
    boolean isEmpty();
    void remove(int index);
    int size();
    ILinkedList sublist(int fromIndex, int toIndex);
    boolean contains(Object o);

}

