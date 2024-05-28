public class BinarySearchTree {
    private TreeNode treeNode;

    // Constructor
    public BinarySearchTree() {
        this.treeNode = null;
    }

    // Insert a new node with given value
    public static TreeNode insert(TreeNode treeNode, int value) {
        // If the tree is empty, return a new node
        if (treeNode == null) {
            treeNode = new TreeNode(value);
            return treeNode;
        }
        // Otherwise, recur down the tree
        if (value < treeNode.value)
            treeNode.left = insert(treeNode.left, value);
        else if (value > treeNode.value)
            treeNode.right = insert(treeNode.right, value);
        // Return the node pointer
        return treeNode;
    }

    // Search for a value
    public static TreeNode search(TreeNode treeNode, int value) {
        // Base Cases: root is null or key is present at root
        if (treeNode == null || treeNode.value == value) {
            return treeNode;
        }
        // Key is greater than root's key
        if (treeNode.value < value) {
            return search(treeNode.right, value);
        }
        // Key is smaller than root's key
        return search(treeNode.left, value);
    }

    // Helping method that returns the node with minimum key value found in that tree (to support deletion)
    public static TreeNode minValueNode(TreeNode treeNode) {
        TreeNode current = treeNode;
        // Loop down to find the leftmost leaf
        while (current != null && current.left != null) {
            current = current.left;
        }
        return current;
    }

    // Delete the given value and returns the new root
    public static TreeNode delete(TreeNode treeNode, int value) {
        // Base Case
        if (treeNode == null) {
            return null;
        }
        // If the key to be deleted is smaller than the root's key, then it lies in left subtree
        if (value < treeNode.value) {
            treeNode.left = delete(treeNode.left, value);
        }
        // If the key to be deleted is greater than the root's key, then it lies in right subtree
        else if (value > treeNode.value) {
            treeNode.right = delete(treeNode.right, value);
        }
        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (treeNode.left == null) {
                TreeNode temp = treeNode.right;
                return temp;
            }
            else if (treeNode.right == null) {
                TreeNode temp = treeNode.left;
                return temp;
            }
            // Node with two children: Get the inorder successor (smallest in the right subtree)
            TreeNode temp = minValueNode(treeNode.right);
            // Copy the inorder successor's content to this node
            treeNode.value = temp.value;
            // Delete the inorder successor
            treeNode.right = delete(treeNode.right, temp.value);
        }
        return treeNode;
    }

    // https://stackoverflow.com/questions/47686199/binary-search-tree-traversal-method-in-order-tostring
    public static String inorder(TreeNode treeNode) {
        if (treeNode == null) {
            return "Tree is empty";
        }
        StringBuilder result = new StringBuilder();
        inorderHelper(treeNode, result);
        return result.toString();
    }

    private static void inorderHelper(TreeNode treeNode, StringBuilder result) {
        if (treeNode != null) {
            inorderHelper(treeNode.left, result);
            result.append(treeNode.value).append(" ");
            inorderHelper(treeNode.right, result);
        }
    }
}
