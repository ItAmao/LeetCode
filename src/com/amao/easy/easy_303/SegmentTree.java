package com.amao.easy.easy_303;

public class SegmentTree<E> {

    private E[] tree;
    private E[] data;
    private Merger<E> merger;//用来给用户输入2个区间是怎么融合的

    //先存入整个区间的元素
    public SegmentTree(E[] arr, Merger<E> merger) {
        this.merger = merger;
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];//用来存储,4倍足够

        buildSegmentTree(0, 0, data.length - 1);
    }

    //构建线段树:需要传入3个参数,第一个参数是,当前创建线段树的根节点:treeIndex对应的索引
    //第二个参数,对于当前节点所表示那个区间的左端点
    //第三个参数,对于当前节点所表示那个区间的右端点
    //在treeIndex的位置创建表示区间[l...r]的线段树
    private void buildSegmentTree(int treeIndex, int l, int r) {

        if (l == r) {//此时考虑的区间只有一个元素,说明递归完了
            tree[treeIndex] = data[l];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);//找到左区间对应的索引
        int rightTreeIndex = rightChild(treeIndex);//找到右区间对应的索引
        int mid = l + (r - l) / 2;//二分算法
        //递归算法
        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);//进行融合
    }

    //获取区间的长度
    public int getSize() {
        return data.length;
    }

    //返回索引为index位置的元素
    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return data[index];
    }

    //返回完全二叉树的数组表示中,一个索引所表示的元素的左孩子节点的索引
    public int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回完全二叉树的数组中,一个索引所表示的元素的右孩子节点的索引
    public int rightChild(int index) {
        return 2 * index + 2;
    }

    //返回区间[queryL,queryR]的值
    public E query(int queryL, int queryR) {

        //边界检查
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length || queryL > queryR) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        return query(0, 0, data.length - 1, queryL, queryR);
    }

    //在treeID为根的线段树中[l..r]的范围里,搜索区间[queryL,queryR]的值
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {//递归到底
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        if (queryL >= mid + 1) {//如果用户的queryL比中间还要大,就要去右子树查找
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {//去左子树查找
            return query(leftTreeIndex, l, mid, queryL, queryR);
        }
        //一部分在左孩子,一部分在右孩子
        E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
        E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
        //找完以后 就开始融合
        return merger.merge(leftResult, rightResult);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append('[');
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null)
                res.append(tree[i]);
            else
                res.append("null");

            if (i != tree.length - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
