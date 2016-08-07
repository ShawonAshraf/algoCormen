import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static class Graph {
        private int nVertices;
        private int nEdges;
        private ArrayList<ArrayList<Integer>> verticeList;
        private ArrayList<ArrayList<Integer>> edgeList;
        private int[] dist;
        private int[] prev;
        private PriorityQueue<Integer> q;
        private final int VAL = 100000;


        public Graph(int nVertices, int nEdges) {
            this.nEdges = nEdges;
            this.nVertices = nVertices;

            verticeList = new ArrayList<>();
            edgeList = new ArrayList<>();

            dist = new int[nVertices];
            prev = new int[nVertices];

            for(int i = 0; i < nVertices; i++) {
                verticeList.add(new ArrayList<>());
                edgeList.add(new ArrayList<>());
            }

//            q = new PriorityQueue<>(new Comparator<Integer>() {
//                @Override
//                public int compare(Integer a, Integer b) {
//                    if (dist[a] < dist[b]) return -1;
//                    if (dist[a] > dist[b]) return 1;
//                    return a - b;
//                }
//            });

            Arrays.fill(dist, 1, nVertices, VAL);
        }

        public void add(int a, int b, int w) {
            verticeList.get(a).add(b);
            verticeList.get(b).add(a);

            edgeList.get(a).add(w);
            edgeList.get(b).add(w);
        }
        
        
        public void djikstra() {
            q = new PriorityQueue<>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    if (dist[a] < dist[b]) return -1;
                    if (dist[a] > dist[b]) return 1;
                    return a - b;
                }
            });

            q.add(0);
            while (!q.isEmpty()) {
                int u = q.poll();
                for (int i = 0; i < verticeList.get(u).size(); i++) {
                    int v = verticeList.get(u).get(i);
                    int duv = edgeList.get(u).get(i);
                    if (dist[v] > dist[u] + duv) {
                        q.remove(v);
                        dist[v] = dist[u] + duv;
                        q.add(v);
                        prev[v] = u;
                    }
                }
            }
        }

        public void printShortPathAndCost() {
            if (dist[nVertices - 1] == VAL)
                System.out.println(-1);
            else {
                ArrayList<Integer> shortest = new ArrayList<Integer>();
                int ptr = nVertices - 1;
                while (true) {
                    shortest.add(ptr);
                    if (ptr == 0)
                        break;
                    ptr = prev[ptr];
                }
                for (int i = shortest.size() - 1; i > 0; i--)
                    System.out.print((shortest.get(i) + 1) + " ");
                System.out.println(shortest.get(0) + 1);
                System.out.println("Cost : " + dist[nVertices - 1] + " in " + Arrays.toString(dist));
            }
        }

    }

    public static void main(String[] args) {
        int v, e;
        Graph g;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        v = in.nextInt();
        e = in.nextInt();

        g = new Graph(v, e);

        for(int i = 0; i < e; i++) {
            g.add(in.nextInt() - 1, in.nextInt() - 1, in.nextInt());
        }

        g.djikstra();
        g.printShortPathAndCost();
    }
}

