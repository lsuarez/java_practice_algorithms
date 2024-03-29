package com.tree;
/*
T1 and T2 are the two very large binary trees, with T1 much bigger than T2. Create an algorithm
to determine if T2 is a subtree of T1.
A tree T2 is a subtree of T1 if there exist a node n in T1 such that the subtree of n is identical to T2. That is, if you cut off
the tree at node n, the two trees would be identical.
 */

public class CheckSubtree {

    public static boolean isSubTree(BinaryNode t1, BinaryNode t2){
        boolean isSameTree=false;
        if(t1.getData() == t2.getData()){
            isSameTree = isSame(t1,t2);
        }
        if(!isSameTree) {
            if(t1.getLeft()!=null) {
                isSameTree = isSubTree(t1.getLeft(), t2);
            }
            if(!isSameTree && t1.getRight()!=null) {
                isSameTree = isSubTree(t1.getRight(), t2);
            }
        }
        return isSameTree;

    }


    private static boolean isSame(BinaryNode t1, BinaryNode t2){
        if(t1==null && t2== null){
            return true;
        }
        if(t1.getData()!= t2.getData()){
            return false;
        }
        return isSame(t1.getLeft(), t2.getLeft()) ? isSame(t1.getRight(), t2.getRight()) : false ;
    }

/*
    BigO -> N
 */
    public static void main(String[] args) {
        BinaryNode t1 =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 9), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);
        BinaryNode t2 = new BinaryNode(null,new BinaryNode(4),2);
        System.out.println(isSubTree(t1,t2)); //false

        BinaryNode t1_1 =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 9), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);
        BinaryNode t2_2 =  new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7);
                new BinaryNode(null,new BinaryNode(1),2);
        System.out.println(isSubTree(t1_1,t2_2)); //true

        BinaryNode t1_2 =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 9), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);
        BinaryNode t2_3 = new BinaryNode(null,new BinaryNode(1),2);

        System.out.println(isSubTree(t1_2,t2_3)); //true

        BinaryNode t1_4 =
                new BinaryNode(new BinaryNode(null, new BinaryNode(3), 2), new BinaryNode(new BinaryNode(8), new BinaryNode(null, new BinaryNode(1), 2), 7), 5);
        BinaryNode t2_4 = new BinaryNode(null,new BinaryNode(1),2);
        System.out.println(isSubTree(t1_4,t2_4));
    }
  /*    t1
        5
    9   |  7
   | 3  |  8  | 2
                  | 1

        t2
        2
            1
   */
}
