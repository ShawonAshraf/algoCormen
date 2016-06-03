/**
 * Created by Shawon on 6/4/2016.
 */
public class RodCutting {
    private int[] p;
    private int[] r;
    private int n;

    public RodCutting(int [] p) {
        this.p = p;
        r = new int[p.length];
        n = p.length;
    }

    //=========================

    public int[] getP() {
        return p;
    }

    public void setP(int[] p) {
        this.p = p;
    }

    public int[] getR() {
        return r;
    }

    public void setR(int[] r) {
        this.r = r;
    }

    //============================

    public int naiveApproach() {
        return 0;
    }

    public int max(int pn, int i) {
        if(pn >= r[n - 1]) return pn;
        else {
            return max(pn, i++);
        }
    }
}
