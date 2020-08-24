/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.Random;
import java.util.StringTokenizer;

/**
 *
 * @author macbook
 */
public class BinarySearchTree  implements Serializable {
    
    public static final long serialVersionUID = 1L;

    
    TreeNode root;
    Bus[] treeArray = new Bus[5];
    int index = 0;

    public BinarySearchTree() {
        root = null;
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }
    
    
    
    boolean isEmpty(){
        return (root == null);
    }
    
    void clear(){
        root = null;
    }
    
    void fvisit(TreeNode p, RandomAccessFile f) throws Exception{
        if(p != null) {
            f.writeBytes(p.info + " ");
        }
    }
    
    void inOrder(TreeNode p, RandomAccessFile f) throws Exception {
        if (p == null) {
            return;
        }
        inOrder(p.left, f);
        fvisit(p, f);
        inOrder(p.right, f);
    }
    
    void visit(TreeNode p) {
        if (p == null) {
            return;
        }
        System.out.println(" ( " + p.info + " ) ");
    }
    
    void inOrder(TreeNode root){
        if(root == null){
            return;
        }
        inOrder(root.left);
        visit(root);
        inOrder(root.right);
    }
    
    void insert(Bus x) {
        TreeNode q = new TreeNode(x);
        if (isEmpty()) {
            root = q;
            return;
        }
        TreeNode f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info.bcode.equals(x.bcode)) {
                System.out.println("The key " + x.bcode + " already exists, no insertion");
                return;
            }
            f = p;
            if (x.bcode.compareTo(p.info.bcode) < 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (x.bcode.compareTo(f.info.bcode) < 0) {
            f.left = q;
        } else {
            f.right = q;
        }
    }
    
    int height(TreeNode p) {
        if (p == null) {
            return (0);
        }
        int k, h, r;
        k = height(p.left);
        h = height(p.right);
        r = k > h ? k : h;
        return (r + 1);
    }
    
    void addArray(Bus[] a) {
        for (int i = 0; i < a.length; i++) {
            insert(a[i]);
        }
    }

    public void convertBSTtoArray(TreeNode q) { 
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        } else {
            if (q.left != null) {
                convertBSTtoArray(q.left);
            }            index++;
            if (q.right != null) {
                convertBSTtoArray(q.right);
            }
        }
    }
    
    public int countNode(TreeNode rootNode) {
        int count = 1;
        if (rootNode.left != null) {
            count += countNode(rootNode.left);
        }
        if (rootNode.right != null) {
            count += countNode(rootNode.right);
        }
        return count;
    }

    TreeNode search(TreeNode root, String infox) {
        TreeNode p = root;
        if (p == null || p.info.bcode.equalsIgnoreCase(infox)) {
            return root;
        }
        
        String st;
        while(p!=null)
        {
            st = p.info.bcode.trim();
            if (st.compareTo(infox) == 0){
                return p;
            } 
            if(st.compareTo(infox)>0){
                p = p.left;
            }else{
                p=p.right;
            }
            
        }
        return p;
    }
    
    void deleByCopy(String xbCode) {
        TreeNode f, p;

        f = null;
        p = root;
        while (p != null) {
            if (p.info.bcode.equals(xbCode)) {
                break;                
            }
            if(xbCode.compareTo(p.info.bcode)<0)
            {
                f = p;
                p = p.left;
            }else{
                f=p;
                p=p.right; 
            }
        }
        if (p == null) {
            System.out.println("The Bus has Code " + xbCode + " does not exit!");
            return;
        }
        if(p.left == null && p.right == null){
            System.out.println("Deleting Leaf Node");
            if(f==null){
                root = null;
            }else{
                if(f.left==p){
                    f.left=null;
                }else{
                    f.right=null;
                }
            }
            return;
        }
        if (p.left != null && p.right == null) {
            System.out.println("Deleting Node has only left");
            if (f == null) {
                root=p.left;
            }else{
                if(f.left==p){
                    f.left=p.left; 
                    if(f.right==p) 
                    f.right=p.left; 
                }
            }
            return;
        }
        
        
        if (p.left==null && p.right!=null) {
            System.out.println("Deleting Node has onlt right");  
            if(f==null){
                root = p.right;
            }else{
                if (f.left == p) {
                    f.left = p.right;
                } else{
                    if(f.right==p){
                    f.right=p.right;
                    }
                }
            
            }
            return;
        }
        if(p.left!=null &&p.right!=null){
            System.out.println("Deleting Node has two child");
            TreeNode rp;
            f=null;
            rp=p.right;
            while(rp.left!=null){
                f=rp;
                rp=rp.left;
            }
            p.info=rp.info;
            if(f==null){
                p.right=rp.right;
            }else{
                f.left=rp.left;
            }
        }
    }
    
    private void viewNode(TreeNode node) {
        System.out.println(node.info.toString());
    }
    
    public void breadthTraverse() {
        if (root == null) {
            return;
        }
        MyQueue queue = new MyQueue(100);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.dequeue();
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
            viewNode(node);
        }
    }
    
    public void delete(String tcode) {
        root = deleteNode(root, tcode);
    }
    
    private TreeNode deleteNode(TreeNode rootNode, String tcode) {
        if (rootNode == null) {
            return null;
        }
        if (tcode.compareToIgnoreCase(rootNode.info.getBcode()) > 0) {
            rootNode.right = deleteNode(rootNode.right, tcode);
        } else if (tcode.compareToIgnoreCase(rootNode.info.getBcode()) < 0) {
            rootNode.left = deleteNode(rootNode.left, tcode);
        } else {
            if (rootNode.right == null) {
                return rootNode.left;
            } else if (rootNode.left == null) {
                return rootNode.right;
            } else {
                rootNode.info = getMin(rootNode.right).info;
                rootNode.right = deleteNode(rootNode.right, rootNode.info.getBcode());
            }
        }
        return rootNode;
    }
    
    public TreeNode getMin(TreeNode rootNode) {
        if (rootNode == null) {
            return rootNode;
        }
        while (rootNode.left != null) {
            rootNode = rootNode.left;
        }
        return rootNode;
    }
    
    public Bus[] sort() {
        Bus[] bus = new Bus[countNode(root)];
        int i = 0;
        MyQueue queue = new MyQueue(100);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            TreeNode node = (TreeNode) queue.dequeue();
            if (node.left != null) {
                queue.enqueue(node.left);
            }
            if (node.right != null) {
                queue.enqueue(node.right);
            }
            bus[i++] = node.info;
        }
        for (int j = 0; j < bus.length; j++) {
            for (int k = bus.length - 1; k > j; k--) {
                if (bus[k - 1].getBcode().compareToIgnoreCase(bus[k].getBcode()) > 0) {
                    Bus temp = bus[k - 1];
                    bus[k - 1] = bus[k];
                    bus[k] = temp;
                }
            }
        }
        return bus;
    }
    
    public TreeNode simplyBalance(Bus[] bus, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode rootNode = new TreeNode(bus[mid]);
        addToTree(rootNode.info);
        rootNode.left = simplyBalance(bus, start, mid - 1);
        rootNode.right = simplyBalance(bus, mid + 1, end);
        return rootNode;
    }
    
    public void addToTree(Bus info) {
        if (root == null) {
            root = insertNode(root, info);
        } else {
            insertNode(root, info);
        }
    }
    
    private TreeNode insertNode(TreeNode rootNode, Bus info) {
        TreeNode newNode = new TreeNode(info);
        if (rootNode == null) {
            rootNode = newNode;
            return rootNode;
        }
        if (newNode.info.getBcode().compareTo(rootNode.info.getBcode()) < 0) {
            rootNode.left = insertNode(rootNode.left, info);
        } else {
            rootNode.right = insertNode(rootNode.right, info);
        }
        return rootNode;
    }
    
    
    
}
