public class Node {
  Node parent;  
  Node left;
  Node right;
  Object payload;
  public Node(Node parent, Node left, Node right, Object payload) {
    this.parent = parent;
    this.right = right;
    this.left = left;
    this.payload = payload;
  }
  public void setLeft(Object payload) {
    this.left = new Node(this, null, null, payload);
  }
  public void setRight(Object payload) {
    this.right = new Node(this, null, null, payload);
  }
}