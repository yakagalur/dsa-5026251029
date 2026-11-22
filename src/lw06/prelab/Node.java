package lw06.prelab;

class Node {
  int data;
  Node kiri, kanan;

  Node(int data) {
    this.data = data;
    this.kiri = null;
    this.kanan = null;
  }
}