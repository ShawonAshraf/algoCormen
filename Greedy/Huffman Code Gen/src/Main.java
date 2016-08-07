import java.util.*;

public class Main {

    private static class HuffNode {
        public char c; // character data
        public int f; // frequency
        public HuffNode left;
        public HuffNode right;

        public HuffNode(char c, int f) {
            this.c = c;
            this.f = f;
            left = null;
            right = null;
        }
    }

    //==========================

    private static class NodeComparator implements Comparator<HuffNode> {
        @Override
        public int compare(HuffNode o1, HuffNode o2) {
//            Integer x1 = new Integer(o1.f);
//            Integer x2 = new Integer(o2.f);
//            return x1.compareTo(x2);

            if(o1.f > o2.f) return 1;
            else return 0;
        }
    }

    //===========================

    private static class HuffCode {
        public Map<Character, String> codemap = new HashMap<>();
        public NodeComparator cmp = new NodeComparator();
        public PriorityQueue<HuffNode> pq = new PriorityQueue<>(cmp);
        public final static char sChar = '|';

        //==========================

        public HuffCode(ArrayList<HuffNode> nodeList) {
            int s = nodeList.size();
            for(int i = 0; i < s; i++) {
                HuffNode temp = nodeList.get(i);
                pq.add(temp);
            }
        }

        //===============================

        public void makeHuffTree() {
            HuffNode newNode = null;
            HuffNode left = null;
            HuffNode right = null;

            while(pq.size() != 1) {
                left = pq.remove();
                right = pq.remove();

                newNode = new HuffNode(sChar, left.f + right.f);
                newNode.left = left;
                newNode.right = right;
                pq.add(newNode);
            }
        }

        //==========================

        public void genCode(HuffNode node, String code) {
            if(node == null) return;
            if(node.c != '|') {
                codemap.put(node.c, code);
            }

            // right side mapped with 0
            // left side mapped with 1

            genCode(node.left, code + "1");
            genCode(node.right, code + "0");
        }
    }

    //=====================

    public static void main(String[] args) {
        ArrayList<HuffNode> nodeList = new ArrayList<>();
        int n, data;
        char c;

        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        for(int i = 0; i < n; i++) {
            c = in.next().charAt(0);
            data = in.nextInt();

            nodeList.add(new HuffNode(c, data));
        }

        HuffCode codeTree = new HuffCode(nodeList);
        codeTree.makeHuffTree();
        codeTree.genCode(codeTree.pq.peek(), "");

        // lambda to print the map. JDK 8

        codeTree.codemap.forEach((k,v)-> {
            System.out.println("Char : " + k + "\tHuffman Code : " + v);
        });
    }
}
