package com.example.backdemo.leetcode.binary_tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @description:
 * @author: superman
 * @create: 2021-05-21 12:04
 **/
public class Bintree {

    public Bintree left;
    public Bintree right;
    public Bintree root;
    //    数据域
    private Object data;
    //    存节点
    public List<Bintree> datas;

    public Bintree(Bintree left, Bintree right, Object data){
        this.left=left;
        this.right=right;
        this.data=data;
    }
    //    将初始的左右孩子值为空
    public Bintree(Object data){
        this(null,null,data);
    }

    public Bintree() {}

    public void creat(Object[] objs){
        datas = new ArrayList<>();
        for (Object o : objs) {
            datas.add(new Bintree(o));
        }
        root = datas.get(0);
        for (int i = 0; i < datas.size() / 2; i++) {
            datas.get(i).left = datas.get(i*2 + 1);
            if (i * 2 + 2 < datas.size()) {
                datas.get(i).right = datas.get(i*2 + 2);
            }
        }
    }

    public void preOrder(Bintree root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void preOrder2(Bintree bintree) {
        if (root == null) {
            return;
        }
        Stack<Bintree> stack = new Stack();
        stack.push(bintree);
        while (!stack.isEmpty()) {
            Bintree tmp = stack.pop();
            System.out.println(tmp.data);

            if(tmp.right != null) stack.push(tmp.right);
            if(tmp.left != null) stack.push(tmp.left);
        }
    }

    public void midOrder(Bintree root){
        if (root == null){
            return;
        }
        midOrder(root.left);
        System.out.println(root.data);
        midOrder(root.right);
    }

    public void midOrder2(Bintree root) {
        Stack<Bintree> stack = new Stack();

        while (root != null || !stack.isEmpty()){
            while (root != null) { //这个循环是为了一直将左子节点压栈，直到root.left=null,root=root.left=null 退出这个循环
                stack.push(root);
                root = root.left;
            }
            Bintree cur = stack.pop();
            System.out.println(cur.data);
            root = cur.right;
        }

    }

    public void postOrder(Bintree root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root.data);
    }

    public void postOrder2(Bintree bintree) {
        if (root == null) {
            return;
        }
        List<Bintree> list = new ArrayList();
        Stack<Bintree> stack = new Stack();
        stack.push(bintree);
        while (!stack.isEmpty()) {
            Bintree tmp = stack.pop();
            list.add(tmp);

            if(tmp.left != null) stack.push(tmp.left);
            if(tmp.right != null) stack.push(tmp.right);
        }
        Collections.reverse(list);
        list.forEach(a-> System.out.println(a.data));
    }

    public static void main(String[] args) {
        Object []a={2,4,5,7,1,6,12,32,51,22};
        Bintree bintree = new Bintree();
        bintree.creat(a);
        bintree.midOrder(bintree.root);
        System.out.println("==================================");
        bintree.midOrder2(bintree.root);
    }
}
