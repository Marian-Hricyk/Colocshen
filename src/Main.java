import java.util.Random;
public class Main {
    public static void main(String[] args) {
       testMyArrayList();
System.out.print("0");

    }

    private static void testMyArrayList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        MyQueue<Integer> queue = new MyQueue<>();
        MyStack<Integer> stack = new MyStack<>();
        MyHashMap<Integer,Integer> hashMap = new MyHashMap<>();
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            arrayList.add(random.nextInt(1000));
            linkedList.add(random.nextInt(1000));
            queue.add(random.nextInt(1000));
            stack.push(random.nextInt(1000));
            hashMap.put(i,random.nextInt(1000));
        }

        // Тут можна перевірити інші методи, такі як get, remove, size і т.д.
        // Наприклад:
        System.out.println("MyArrayList size: " + arrayList.size());
        System.out.println("Element at index 500: " + arrayList.get(500));
        arrayList.remove(300);
        System.out.println("MyArrayList size after removal: " + arrayList.size());

        System.out.println("MyLinkedList size: " + linkedList.size());
        System.out.println("Element at index 500: " + linkedList.get(500));
        linkedList.remove(300);
        System.out.println("MyLinkedList size after removal: " + linkedList.size());

        System.out.println("MyQueue size: " + queue.size());
        System.out.println("Element head: " + queue.peek());

        System.out.println("MyQueue remove end print head: " + queue.poll());

        System.out.println("MyStack size: " + stack.size());
        System.out.println("Element top: " + stack.peek());
        arrayList.remove(300);
        System.out.println("MyStack remove top: " + stack.size());

        System.out.println("MyHashMap size: " + hashMap.size());
        System.out.println("Element at cey 500: " + hashMap.get(500));
        arrayList.remove(300);
        System.out.println("MyHashMap size after removal: " + arrayList.size());
    }



    }
