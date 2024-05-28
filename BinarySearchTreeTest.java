import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private TreeNode tn = null;

    @org.junit.jupiter.api.Test
    void insert() {
        tn = BinarySearchTree.insert(tn, 15);
        tn = BinarySearchTree.insert(tn, 10);
        tn = BinarySearchTree.insert(tn, 20);
        tn = BinarySearchTree.insert(tn, 8);
        tn = BinarySearchTree.insert(tn, 12);
        tn = BinarySearchTree.insert(tn, 17);
        tn = BinarySearchTree.insert(tn, 25);

        assertNotNull(BinarySearchTree.search(tn, 15));
        assertNotNull(BinarySearchTree.search(tn, 10));
        assertNotNull(BinarySearchTree.search(tn, 20));
        assertNotNull(BinarySearchTree.search(tn, 8));
        assertNotNull(BinarySearchTree.search(tn, 12));
        assertNotNull(BinarySearchTree.search(tn, 17));
        assertNotNull(BinarySearchTree.search(tn, 25));
    }

    @org.junit.jupiter.api.Test
    void search() {
        tn = BinarySearchTree.insert(tn, 15);
        tn = BinarySearchTree.insert(tn, 10);
        tn = BinarySearchTree.insert(tn, 20);
        tn = BinarySearchTree.insert(tn, 8);
        tn = BinarySearchTree.insert(tn, 12);
        tn = BinarySearchTree.insert(tn, 17);
        tn = BinarySearchTree.insert(tn, 25);

        assertNotNull(BinarySearchTree.search(tn, 25));
        assertNull(BinarySearchTree.search(tn, 24));
    }

    @org.junit.jupiter.api.Test
    void delete() {
        tn = BinarySearchTree.insert(tn, 15);
        tn = BinarySearchTree.insert(tn, 10);
        tn = BinarySearchTree.insert(tn, 20);
        tn = BinarySearchTree.insert(tn, 8);
        tn = BinarySearchTree.insert(tn, 12);
        tn = BinarySearchTree.insert(tn, 17);
        tn = BinarySearchTree.insert(tn, 25);

        tn = BinarySearchTree.delete(tn, 25); // Delete a leaf
        assertNull(BinarySearchTree.search(tn, 25));

        tn = BinarySearchTree.delete(tn, 20); // Delete a node with one child
        assertNull(BinarySearchTree.search(tn, 20));
        assertNotNull(BinarySearchTree.search(tn, 17));

        tn = BinarySearchTree.delete(tn, 15); // Delete a node with two children
        assertNull(BinarySearchTree.search(tn, 15));
        assertNotNull(BinarySearchTree.search(tn, 17));
    }

    @org.junit.jupiter.api.Test
    void inorder() {
        tn = BinarySearchTree.insert(tn, 15);
        tn = BinarySearchTree.insert(tn, 10);
        tn = BinarySearchTree.insert(tn, 20);
        tn = BinarySearchTree.insert(tn, 8);
        tn = BinarySearchTree.insert(tn, 12);
        tn = BinarySearchTree.insert(tn, 17);
        tn = BinarySearchTree.insert(tn, 25);

        assertEquals("8 10 12 15 17 20 25 ", BinarySearchTree.inorder(tn));
    }
}