package hasing;

public class Hashing {
    class Node{
        int key;
        Node next;
        Node(int key , Node next){
            this.key = key;
            this.next = next;
        }
    }
    private Node[]arr = new Node[10];
    private int count = 0;
    public boolean add(int key){
        int index = key % arr.length;
        if (arr[index] == null){
            arr[index] = new Node(key,null);
            count++;
            return true;
        }
        Node curr = arr[index];
        Node prev = null;
        while (curr != null){
            if (key == curr.key)
                return false;
            prev = curr;
            curr = curr.next;
        }
        prev.next = new Node(key,null);
        count++;
        return true;
    }
    public int size(){
        return count;
    }
    public void display(){
        for (int i = 0; i < arr.length; i++){
            Node curr = arr[i];
            while (curr != null){
                System.out.println(curr.key);
                curr = curr.next;
            }
        }
    }
    public static void main(String[] args) {
        Hashing h = new Hashing();
        h.add(10);
        h.add(20);
        h.add(30);
        h.add(40);
        System.out.println(h.size());
        h.display();
    }
}
