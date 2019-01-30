public class Tree {
  private Node wurzel = new Node(null, null, null, 0);
  public static void main(String[] args) {
    Tree tree = new Tree();
    tree.wurzel.setLeft(12);
    tree.wurzel.setRight(142);
    tree.wurzel.right.setLeft(1233);
    
    tree.preorder(tree, tree.wurzel);
    tree.postorder(tree, tree.wurzel);
    tree.inorder(tree, tree.wurzel);
  }
  
  private void preorder(Tree tree, Node node) {
    if (node != null) {
      System.out.println(node.payload);
      preorder(tree, node.left);
      preorder(tree, node.right);
    }
  }
  
  private void inorder(Tree tree, Node node) {
    if (node != null) {
      inorder(tree, node.left);
      System.out.println(node.payload);
      inorder(tree, node.right);
    }
  }
  
  private void postorder(Tree tree, Node node) {
    if (node != null) {
      preorder(tree, node.left);
      preorder(tree, node.right);
      System.out.println(node.payload);
    }
  }
}
