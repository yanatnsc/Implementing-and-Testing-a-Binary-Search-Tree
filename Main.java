//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        TreeNode treeNode = null;
        treeNode = BinarySearchTree.insert(treeNode, 15);
        treeNode = BinarySearchTree.insert(treeNode, 10);
        treeNode = BinarySearchTree.insert(treeNode, 20);
        treeNode = BinarySearchTree.insert(treeNode, 8);
        treeNode = BinarySearchTree.insert(treeNode, 12);
        treeNode = BinarySearchTree.insert(treeNode, 17);
        treeNode = BinarySearchTree.insert(treeNode, 25);
        // print the BST
        BinarySearchTree.inorder(treeNode);
    }
}