import java.util.ArrayList;
import java.util.List;

/**
 * A hand-written singly linked list that is the master storage
 * for all student records (Requirement 2).
 */
public class StudentLinkedList {

    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;
    private int size;

    /** Adds a new student at the end of the list. Returns false if the ID already exists. */
    public boolean add(Student student) {
        if (contains(student.getStudentId())) {
            return false; // duplicate ID
        }
        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = newNode;
        }
        size++;
        return true;
    }

    /** Finds a student by ID, or null if not present. */
    public Student find(String studentId) {
        Node cur = head;
        while (cur != null) {
            if (cur.data.getStudentId().equalsIgnoreCase(studentId)) return cur.data;
            cur = cur.next;
        }
        return null;
    }

    public boolean contains(String studentId) {
        return find(studentId) != null;
    }

    /** Updates an existing student's name/programme/marks. Returns false if not found. */
    public boolean update(String studentId, String name, String programme, Double marks) {
        Student s = find(studentId);
        if (s == null) return false;
        if (name != null && !name.isBlank()) s.setName(name);
        if (programme != null && !programme.isBlank()) s.setProgramme(programme);
        if (marks != null) s.setMarks(marks);
        return true;
    }

    /** Removes a student by ID. Returns the removed Student, or null if not found. */
    public Student delete(String studentId) {
        Node cur = head, prev = null;
        while (cur != null) {
            if (cur.data.getStudentId().equalsIgnoreCase(studentId)) {
                if (prev == null) head = cur.next;
                else prev.next = cur.next;
                size--;
                return cur.data;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    public int size() { return size; }

    public boolean isEmpty() { return head == null; }

    /** Returns all students as a List, useful for feeding the BST/hash table. */
    public List<Student> toList() {
        List<Student> list = new ArrayList<>();
        Node cur = head;
        while (cur != null) {
            list.add(cur.data);
            cur = cur.next;
        }
        return list;
    }

    /** Prints every record in insertion order. */
    public void display() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }
        System.out.println("---- Student Records (Linked List order) ----");
        Node cur = head;
        int i = 1;
        while (cur != null) {
            System.out.println(i++ + ". " + cur.data);
            cur = cur.next;
        }
    }
}
