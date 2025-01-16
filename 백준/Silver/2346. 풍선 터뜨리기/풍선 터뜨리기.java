import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int value;
        int index;
        Node prev;
        Node next;

        Node(int index, int value) {
            this.index = index;
            this.value = value;
        }
    }

    static class CircularDoubleLinkedList {
        Node head;

        public void add(int index, int value) {
            Node newNode = new Node(index, value);
            if (head == null) {
                head = newNode;
                head.next = head;
                head.prev = head;
            } else {
                Node tail = head.prev;
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = head;
                head.prev = newNode;
            }
        }

        public void remove(Node node) {
            if (node.next == node) {
                head = null;
                return;
            }

            node.prev.next = node.next;
            node.next.prev = node.prev;

            if (head == node) {
                head = node.next;
            }
        }

        public Node move(Node current, int steps) {
            if (steps > 0) {
                for (int i = 0; i < steps; i++) {
                    current = current.next;
                }
            } else {
                for (int i = 0; i < Math.abs(steps); i++) {
                    current = current.prev;
                }
            }
            return current;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        CircularDoubleLinkedList cl = new CircularDoubleLinkedList();

        for(int i=0;i<n;i++) {
            cl.add(i, Integer.parseInt(st.nextToken()));
        }

        Node current = cl.head;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < n; i++) {
            result.append(current.index+1).append(" ");
            int steps = current.value;
            cl.remove(current);

            if (cl.head == null) {
                break;
            }

            current = cl.move(current, steps);
        }

        System.out.println(result);
    }
}