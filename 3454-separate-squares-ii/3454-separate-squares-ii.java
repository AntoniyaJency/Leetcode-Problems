class Solution {

    static class Event {
        long y, x1, x2;
        int type;
        Event(long y, long x1, long x2, int type) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.type = type;
        }
    }

    static class SegmentTree {
        int n;
        long[] xs;
        int[] count;
        long[] len;

        SegmentTree(long[] xs) {
            this.xs = xs;
            this.n = xs.length - 1;
            count = new int[n * 4];
            len = new long[n * 4];
        }

        void update(int idx, int l, int r, int ql, int qr, int v) {
            if (ql >= r || qr <= l) return;
            if (ql <= l && r <= qr) {
                count[idx] += v;
            } else {
                int mid = (l + r) / 2;
                update(idx * 2, l, mid, ql, qr, v);
                update(idx * 2 + 1, mid, r, ql, qr, v);
            }

            if (count[idx] > 0) {
                len[idx] = xs[r] - xs[l];
            } else {
                len[idx] = (l + 1 == r) ? 0 : len[idx * 2] + len[idx * 2 + 1];
            }
        }

        long query() {
            return len[1];
        }
    }

    public double separateSquares(int[][] squares) {

        int n = squares.length;
        List<Event> events = new ArrayList<>();
        List<Long> xList = new ArrayList<>();

        for (int[] s : squares) {
            long x1 = s[0];
            long x2 = s[0] + s[2];
            long y1 = s[1];
            long y2 = s[1] + s[2];

            events.add(new Event(y1, x1, x2, 1));
            events.add(new Event(y2, x1, x2, -1));

            xList.add(x1);
            xList.add(x2);
        }

        Collections.sort(xList);
        List<Long> uniq = new ArrayList<>();
        for (long x : xList)
            if (uniq.isEmpty() || uniq.get(uniq.size() - 1) != x)
                uniq.add(x);

        long[] xs = new long[uniq.size()];
        for (int i = 0; i < uniq.size(); i++) xs[i] = uniq.get(i);

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < xs.length; i++) map.put(xs[i], i);

        events.sort(Comparator.comparingLong(e -> e.y));

        SegmentTree st = new SegmentTree(xs);

        long prevY = events.get(0).y;
        long area = 0;
        long half;

        for (int[] s : squares)
            area += (long) s[2] * s[2];

        half = area / 2;

        long acc = 0;

        for (Event e : events) {
            long dy = e.y - prevY;
            long coveredX = st.query();

            if (dy > 0 && coveredX > 0) {
                long block = coveredX * dy;
                if (acc + block >= half) {
                    return prevY + (double) (half - acc) / coveredX;
                }
                acc += block;
            }

            int l = map.get(e.x1);
            int r = map.get(e.x2);
            st.update(1, 0, st.n, l, r, e.type);
            prevY = e.y;
        }

        return prevY;
    }
}
