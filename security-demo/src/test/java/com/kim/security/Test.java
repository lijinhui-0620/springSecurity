package com.kim.security;

import com.kim.security.test.AppConfig;
import com.kim.security.test.PasswordService;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther: kim
 * @create: 2019-10-25 10:03
 * @description:
 */
@EnableAspectJAutoProxy
public class Test {


    @org.junit.Test
    public void test() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        PasswordService bean = context.getBean(PasswordService.class);
        System.out.println(bean);

    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<Integer>();
        int length = input.length;
        if(k > length || k == 0){
            return result;
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, (o1,o2)->o2.compareTo(o1));
        for (int i = 0; i < length; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else if (maxHeap.peek() > input[i]) {
                Integer temp = maxHeap.poll();
                temp = null;
                maxHeap.offer(input[i]);
            }
        }
        for (Integer integer : maxHeap) {
            result.add(integer);
        }
        return result;
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length == 0 || in.length == 0) return null;

        if (pre.length != in.length) return null;
        int rootVal = pre[0];

        //我们先找到root所在的位置，确定好前序和中序中左子树和右子树序列的范围
        TreeNode root = new TreeNode(rootVal);
        if (pre.length == 1)//递归得终止操作
            return root;
        int rootIndex = 0;
        for (int i = 0; i < in.length; i++) {
            if (rootVal == in[i]) {
                rootIndex = i;
                break;
            }
        }
        //递归获取数得左右节点
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre, 1, rootIndex + 1), Arrays.copyOfRange(in, 0,
                rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre, rootIndex + 1, pre.length), Arrays.copyOfRange(in,
                rootIndex + 1, in.length));

        return root;
    }


    @org.junit.Test
    public void test4() {
//        System.out.println(Add(8, -2));
        int[] ins = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] ins2 = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = reConstructBinaryTree(ins, ins2);
        System.out.println(treeNode);
    }


    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int temp = num1 & num2;
            num1 = num1 ^ num2;
            num2 = temp << 1;

        }
        return num1;
    }

    public int GetUglyNumber_Solution(int index) {
        if (index < 0)
            return 0;
        if (index == 1)
            return 1;
        int twoPointer = 0;
        int threePointer = 0;
        int fivePointer = 0;
        List<Integer> uglies = new ArrayList<>(index);
        uglies.add(1);

        for (int i = 1; i < index; ++i) {
            int two = uglies.get(twoPointer) * 2;
            int three = uglies.get(threePointer) * 3;
            int five = uglies.get(fivePointer) * 5;
            int minNum = Math.min(Math.min(two, three), five);
            uglies.add(minNum);
            if (minNum == two)
                twoPointer++;
            if (minNum == three)
                threePointer++;
            if (minNum == five)
                fivePointer++;
        }
        return uglies.get(index - 1);
    }

    @org.junit.Test
    public void test2() {
        String str = "hello world";
        String str1 = new String("hello world");
        String str2 = "hello" + new String(" world");

        System.out.println(str == str1);
        System.out.println(str == str2);
        System.out.println(str1 == str2);
        ExecutorService executorService = Executors.newSingleThreadExecutor();
    }

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @org.junit.Test
    public void test3() {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(3);
        ListNode list2 = new ListNode(3);
        list2.next = new ListNode(4);
        ListNode merge = Merge(list1, list2);
        while (merge != null) {
            System.out.println(merge.val);
            merge = merge.next;
        }
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode newHead;
        ListNode pNode1 = list1;
        ListNode pNode2 = list2;
        if (list1.val < list2.val) {
            newHead = list1;
            pNode1 = list1.next;
        } else {
            newHead = list2;
            pNode2 = list2.next;
        }
        ListNode pNext = newHead;
        while (pNode1 != null && pNode2 != null) {
            if (pNode1.val < pNode2.val) {
                pNext.next = pNode1;
                pNext = pNext.next;
                pNode1 = pNode1.next;
            } else {
                pNext.next = pNode2;
                pNext = pNext.next;
                pNode2 = pNode2.next;
            }
        }
        if (pNode1 == null) {
            pNext.next = pNode2;
        } else if (pNode2 == null) {
            pNext.next = pNode1;
        }

        return newHead;
    }


}
