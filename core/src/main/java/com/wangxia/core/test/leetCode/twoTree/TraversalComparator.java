package com.wangxia.core.test.leetCode.twoTree;

import java.util.Comparator;

public class TraversalComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if(o1.toString().equals("preorderList")){
            return -1;
        }else if(o1.toString().equals("inorderList")&&o2.toString().equals("preorderList")){
            return 1;
        }else if(o1.toString().equals("inorderList")&&o2.toString().equals("postorderList")){
            return -1;
        }else if(o1.toString().equals("postorderList")){
            return 1;
        }
        return 0;
    }
}
