class BinaryTree{
    private static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data) {
            this.data = data;
        }
    }
    TreeNode root;
    private int num_of_elements = 0;
    public void insert(int data){
        TreeNode newNode = new TreeNode(data);
        if(this.root == null){
            this.root = newNode;
        }else{
            insert_helper(this.root, newNode);
        }
        ++this.num_of_elements;
    }
    private void insert_helper(TreeNode current, TreeNode newNode) {
        if (newNode.data < current.data) { // Place smaller values in left subtree
            if (current.left == null) {
                current.left = newNode;
            } else {
                insert_helper(current.left, newNode);
            }
        } else { 
            if (current.right == null) {
                current.right = newNode;
            } else {
                insert_helper(current.right, newNode);
            }
        }
    }
    public boolean contains(int data){
        if(this.root == null){
            System.out.println("The Binary Search Tree is empty!");
            return false;
        }
        return contains_helper(this.root, data);
    }
    private boolean contains_helper(TreeNode node, int data){
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        if(node.data > data){
            return contains_helper(node.left, data);
        }else{
            return contains_helper(node.right, data);
        }
    }
    public void remove(int data){
        if(this.root == null){
            System.out.println("Underflow! The BST is empty!");
            return;
        }
        if(!contains(data)){
            System.out.println("This " + data + " does not exists in BST!");
            return;
        }
        this.root = remove_helper(this.root, data);
        
    }
    private TreeNode remove_helper(TreeNode node, int data){
        if(node == null){
            return node;
        }
        else if(node.data > data){
            node.left = remove_helper(node.left, data);
        }
        else if(node.data < data){
            node.right = remove_helper(node.right, data);
        }else{
            if(node.left == null && node.right == null){
                return null;
            }
            else if(node.left == null && node.right != null){
                return node.right;
            }
            else if(node.left != null && node.right == null){
                return node.left;
            }
            else{
                int newValue = successor(node.right, data);
                node.data = newValue;
                node.right = remove_helper(node.right, newValue);
                //int newValue = predecesssor(node.left, data)
                //node.data = predecesssor(node.left, data);
                //node.left = remove_helper(node.left, newValue);
            }   
        }
        return node;
    }
    private int predecesssor(TreeNode node, int data){
        while(node.right != null){
            node = node.right;
        }
        int temp = node.data;
        node = null;
        return temp;
    }
    private int successor(TreeNode node, int data){
        while(node.left != null){
            node = node.left;
        }
        return node.data;
    }

    public void display_in_order(){
        if(this.root == null){
            System.out.println("Tree is empty!");
            return;
        }
        System.out.print("In order traversal in binary tree: ");
        inOrder_traversal(root);
        System.out.println();

    }
    private void inOrder_traversal(TreeNode node){
        if(node == null){
            return;
        }
        inOrder_traversal(node.left);
        System.out.print(node.data + " ");
        inOrder_traversal(node.right);
    }
    public void display_post_order(){
        if(this.root == null){
            System.out.println("Tree is empty!");
            return;
        }
        System.out.print("Post order traversal in binary tree: ");
        post_order_traversal(root);
        System.out.println();
    }
    private void post_order_traversal(TreeNode node){
        if(node == null){
            return;
        }
        post_order_traversal(node.left);
        post_order_traversal(node.right);
        System.out.print(node.data + " ");
    }
    public void display_pre_order(){
        if(this.root == null){
            System.out.println("Tree is empty!");
            return;
        }
        System.out.print("Pre order traversal in binary tree: ");
        pre_order_traversal(root);
        System.out.println();
    }
    private void pre_order_traversal(TreeNode node){
        if(node == null){
            return;
        }
        System.out.print(node.data + " ");
        pre_order_traversal(node.left);
        pre_order_traversal(node.right);
    }

}


public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(2);
        tree.insert(6);
        tree.insert(8);
        tree.insert(0);
        tree.insert(7);
        tree.insert(5);
        tree.insert(1);
        tree.insert(-1);
        tree.insert(4);
        tree.insert(65);
        

        System.out.println(tree.contains(65));

        tree.display_in_order();
        tree.display_pre_order();
        tree.display_post_order();

        tree.remove(65);
        System.out.println("\nAfter deleting a node");
        tree.display_in_order();
        tree.display_pre_order();


        // """
        //     1. Library Managament System
        //     2. Student Grades & database system
        //     3. Inventory Managment System
        //     4. Event registration System
        //     5. Employement Managment System
        //     6. MINE    
        //         """;
    }
}
