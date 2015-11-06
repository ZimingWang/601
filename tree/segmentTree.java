package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by lipingxiong on 10/17/15.
 */
public class segmentTree{



/*
    class Solution2 {
        class Interval {
            int sta;
            int end;
            public Interval(int sta, int end) {
                this.sta = sta;
                this.end = end;
            }
        }

        class SegmentTreeNode {
            int sta;
            int end;
            int cnt;
            SegmentTreeNode left, right;
            public SegmentTreeNode(int sta, int end) {
                this.sta = sta;
                this.end = end;
                left = null;
                right = null;
            }
        }

        private SegmentTreeNode buildST(int sta, int end) {
            if (sta > end) {
                return null;
            }
            if (sta == end) {
                return new SegmentTreeNode(sta, end);
            }
            int mid = (sta+end)/2;
            SegmentTreeNode midNode = new SegmentTreeNode(sta, end);
            midNode.left = buildST(sta, mid);
            midNode.right = buildST(mid+1, end);
            return midNode;
        }

        SegmentTreeNode root = null;
        int maxNum = 0;

        private void updateST(SegmentTreeNode root, int sta, int end, HashMap<Integer, Integer> hash) {
            if (root.sta == sta && root.end == end && sta == end) {
                root.cnt++;
                if (root.cnt > maxNum) {
                    maxNum = root.cnt;
                }
                hash.put(root.sta, root.cnt);
                return;
            }
            int mid = (root.sta+root.end)/2;
            if (end <= mid) {
                updateST(root.left, sta, end, hash);
            }
            else if (sta > mid) {
                updateST(root.right, sta, end, hash);
            }
            else {
                updateST(root.left, sta, mid, hash);
                updateST(root.right, mid+1, end, hash);
            }
            //root.cnt = root.left.cnt+root.right.cnt;
        }

        public List<Integer> getmax(Interval[] num) {
            HashMap<Integer, Integer> hash = new HashMap<>();
            int min = num[0].sta, max = num[0].end;
            for (int i = 1; i < num.length; i++) {
                if (num.sta < min) {
                    min = num.sta;
                }
                if (num.end > max) {
                    max = num.end;
                }
            }
            root = buildST(min, max);
            for (int i = 0; i < num.length; i++) {
                updateST(root, num.sta, num.end, hash);
            }

            Set<Integer> key = hash.keySet();
            List<Integer> res = new LinkedList<>();
            for (int x: key) {
                if (hash.get(x) == maxNum) {
                    res.add(x);
                }
            }
            return res;
        }
    }
*/
}
