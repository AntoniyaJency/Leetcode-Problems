class Solution {
    int[] seg;
    int n;

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        seg = new int[4 * n];
        build(baskets, 0, 0, n - 1);

        int unplaced = 0;

        for (int fruit : fruits) {
            int idx = query(0, 0, n - 1, fruit);
            if (idx == -1) {
                unplaced++;
            } else {
                update(0, 0, n - 1, idx, 0); // mark used
            }
        }
        return unplaced;
    }

    void build(int[] arr, int node, int l, int r) {
        if (l == r) {
            seg[node] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        build(arr, 2 * node + 1, l, mid);
        build(arr, 2 * node + 2, mid + 1, r);
        seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
    }

    int query(int node, int l, int r, int fruit) {
        if (seg[node] < fruit) return -1;
        if (l == r) return l;

        int mid = (l + r) / 2;
        int left = query(2 * node + 1, l, mid, fruit);
        if (left != -1) return left;
        return query(2 * node + 2, mid + 1, r, fruit);
    }

    void update(int node, int l, int r, int idx, int val) {
        if (l == r) {
            seg[node] = val;
            return;
        }
        int mid = (l + r) / 2;
        if (idx <= mid)
            update(2 * node + 1, l, mid, idx, val);
        else
            update(2 * node + 2, mid + 1, r, idx, val);

        seg[node] = Math.max(seg[2 * node + 1], seg[2 * node + 2]);
    }
}
