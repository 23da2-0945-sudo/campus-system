/**
 * A hand-written Binary Search Tree that organizes student records
 * by Student ID for ordered display and searching (Requirement 5).
 */
public class StudentBST {

    private static class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }

    private Node root;

    public void insert(Student student) {
        root = insertRec(root, student);
    }

    private Node insertRec(Node node, Student student) {
        if (node == null) return new Node(student);
        int cmp = student.getStudentId().compareTo(node.data.getStudentId());
        if (cmp < 0) node.left = insertRec(node.left, student);
        else if (cmp > 0) node.right = insertRec(node.right, student);
        else node.data = student; // same ID -> keep tree consistent, just refresh data
        return node;
    }

    public Student search(String studentId) {
        Node cur = root;
        while (cur != null) {
            int cmp = studentId.compareTo(cur.data.getStudentId());
            if (cmp == 0) return cur.data;
            cur = (cmp < 0) ? cur.left : cur.right;
        }
        return null;
    }

    public void delete(String studentId) {
        root = deleteRec(root, studentId);
    }

    private Node deleteRec(Node node, String studentId) {
        if (node == null) return null;
        int cmp = studentId.compareTo(node.data.getStudentId());
        if (cmp < 0) node.left = deleteRec(node.left, studentId);
        else if (cmp > 0) node.right = deleteRec(node.right, studentId);
        else {
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;
            Node successor = node.right;
            while (successor.left != null) successor = successor.left;
            node.data = successor.data;
            node.right = deleteRec(node.right, successor.data.getStudentId());
        }
        return node;
    }

    /** Rebuilds the tree from scratch (used after bulk edits/deletes for simplicity). */
    public void clear() { root = null; }

    /** In-order traversal => students sorted by Student ID. */
    public void displayInOrder() {
        if (root == null) {
            System.out.println("No student records in the tree.");
            return;
        }
        System.out.println("---- Student Records sorted by ID (BST in-order) ----");
        int[] count = {1};
        inOrderRec(root, count);
    }

    private void inOrderRec(Node node, int[] count) {
        if (node == null) return;
        inOrderRec(node.left, count);
        System.out.println(count[0]++ + ". " + node.data);
        inOrderRec(node.right, count);
    }
}
