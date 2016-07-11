import java.util.*;

public class Main {
    private static class Graph {
        private ArrayList<Integer> mat[];
        private ArrayList<Integer> cost[];
        private int[] distance;
        private int[] p;

        private final static int SENTINEL = 0;

        private int numNodes;
        private int numEdges;

        public Graph() {}
        public Graph(int numNodes, int numEdges) {
            this.numNodes = numNodes;
            this.numEdges = numEdges;

            mat = new ArrayList[this.numNodes];
            cost = new ArrayList[this.numNodes];
            distance = new int[this.numNodes];
            p = new int[this.numNodes];

            Arrays.fill(distance, SENTINEL, 1, distance.length - 1);

            for(int i = 0; i < this.numNodes; i++) {
                mat[i] = new ArrayList<>();
                cost[i] = new ArrayList<>();

                for(int j = 0; j < this.numNodes; j++) { cost[i].add(0); }
            }
        }

        public void add(int node1, int node2, int edge) {
            mat[node1 - 1].add(node2 - 1);
            cost[node1 - 1].add(node2 - 1, edge);
        }


        public void djikstra() {
            PriorityQueue<Integer>q = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if(distance[a] < distance[b]) return -1;
                    if(distance[a] > distance[b]) return 1;
                    return a - b;
                }
            });

            q.add(0);
            while(!q.isEmpty()) {
                int temp = q.poll();
                for (int i = 0; i < mat[temp].size(); i++) {
                    int t = mat[temp].get(i);
                    int c = cost[temp].get(i);

                    if (distance[t] > distance[temp] + c) {
                        q.remove(t);
                        distance[t] = distance[temp] + c;
                        q.add(t);
                        p[t] = temp;
                    }
                }
            }
        }

        public void printShortestPath() {
            if(distance[distance.length - 1] == SENTINEL) System.out.println("No shortest path");
            else {
                ArrayList<Integer> sp = new ArrayList<>();
                int i = p.length - 1;
                while(i != 0) {
                    sp.add(i);
                    i = p[i];
                    i--;
                }

                System.out.print("Shortest Path : ");
                sp.forEach(k -> System.out.print(k + " "));
                System.out.println();
            }
        }
    }



    public static void main(String[] args) {
        int v, e;
        Scanner in = new Scanner(System.in);

        v = in.nextInt();
        e = in.nextInt();

        Graph g = new Graph(v, e);

        for(int i = 0; i < e; i++) {
            int a, b, w;
            a = in.nextInt();
            b = in.nextInt();
            w = in.nextInt();

            g.add(a, b, w);
        }

        g.djikstra();
        g.printShortestPath();
    }
}
