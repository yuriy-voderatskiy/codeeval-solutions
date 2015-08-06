import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 0) {
            Scanner in = null;
            try {
                in = new Scanner(new File(args[0]));
                processFile(in);
            } catch (IOException e) {
                System.err.println("Error: " + e.getMessage());
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        } else {
            System.err.println("Error: no arguments specified");
        }
    }

    private static void processFile(Scanner in) {
        Tree tree = Tree.build();
        while (in.hasNextLine()) {
            String line = in.nextLine().trim();
            processLine(tree, line);
        }

    }

    private static void processLine(Tree tree, String line) {
        String[] tokens = line.trim().split("\\s+");

        int first = Integer.parseInt(tokens[0]);
        int second = Integer.parseInt(tokens[1]);

        Integer lca = tree.LCA(tree.root, first, second);

        if (lca != null) {
            System.out.println(lca);
        }
    }

    public static class Tree {
        public Node root;

        public void insert(int key) {
            Node newNode = new Node(key);

            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                Node parent;

                while (true) {
                    parent = current;

                    if (key < current.value) {
                        current = current.left;

                        if (current == null) {
                            parent.left = newNode;
                            return;
                        }
                    } else {
                        current = current.right;

                        if (current == null) {
                            parent.right = newNode;
                            return;
                        }
                    }
                }
            }
        }

        public static Tree build() {
            Tree tree = new Tree();

            tree.insert(30);
            tree.insert(8);
            tree.insert(3);
            tree.insert(20);
            tree.insert(10);
            tree.insert(29);
            tree.insert(52);

            return tree;
        }

        public Integer LCA(Node root, int first, int second) {
            if (root == null) {
                return null;
            }

            if (first < root.value && second < root.value) {
                return LCA(root.left, first, second);
            }

            if (first > root.value && second > root.value) {
                return LCA(root.right, first, second);
            }
            return root.value;
        }
    }

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }
    }

}
