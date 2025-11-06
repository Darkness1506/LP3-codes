// DAA_2_HuffmanCoding.java
import java.util.PriorityQueue;

class HuffmanNode {
    int data;
    char c;
    HuffmanNode left, right;
}

class MyComparator implements java.util.Comparator<HuffmanNode> {
    public int compare(HuffmanNode x, HuffmanNode y) {
        return x.data - y.data;
    }
}

public class DAA_2_HuffmanCoding {
    // Recursive function to print Huffman codes
    static void printCode(HuffmanNode root, String s) {
        if (root == null)
            return;

        // If it's a leaf node, print character and code
        if (root.left == null && root.right == null && Character.isLetter(root.c)) {
            System.out.println(root.c + ": " + s);
            return;
        }

        // Traverse left and right subtrees
        printCode(root.left, s + "0");
        printCode(root.right, s + "1");
    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = {'a', 'b', 'c', 'd', 'e', 'f'};
        int[] charFreq = {5, 9, 12, 13, 16, 45};

        // Priority Queue to store nodes based on frequency
        PriorityQueue<HuffmanNode> q = new PriorityQueue<>(n, new MyComparator());

        // Create leaf nodes for each character
        for (int i = 0; i < n; i++) {
            HuffmanNode node = new HuffmanNode();
            node.c = charArray[i];
            node.data = charFreq[i];
            node.left = null;
            node.right = null;
            q.add(node);
        }

        HuffmanNode root = null;

        // Build the Huffman Tree
        while (q.size() > 1) {
            HuffmanNode x = q.poll();
            HuffmanNode y = q.poll();

            HuffmanNode f = new HuffmanNode();
            f.data = x.data + y.data;
            f.c = '-';
            f.left = x;
            f.right = y;

            root = f;
            q.add(f);
        }

        // Display Huffman codes
        System.out.println("Character Encoding:");
        printCode(root, "");
    }
}

/*
Time Complexity:  O(n log n)
Space Complexity: O(n)
*/
