package com.example.demo.vo;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HierarchyNodeTest {
    private HierarchyNode node;
    private HierarchyNode node2;
    @BeforeEach
    public void setUp() throws Exception {
        node = new HierarchyNode(1);
        node.appendToChild(2);
        node.appendToChild(3);
        node.appendToChild(4);

        node2 = node.findChild(2);
        node2.appendToChild(5);
        node2.appendToChild(6);
        node2.appendToChild(7);
    }

    @Test
    void test_print(){
        printChildren(node);
        System.out.println("==");
        printChildren(node2);
    }

    @Test 
    public void test_children() throws Exception {
        printChildren(node);
        int expectedData = 2;
        for (HierarchyNode each: node.getChildren()) {
            // System.out.println(each);
            // assertThat(each.getData(), is(expectedData++));
        }
    }


    @Test
    public void test3(){
        List <HierarchyNode> children = node.getChildren();
        
        List<HierarchyNode> childern2 = children.get(0).getChildren();
        System.out.println(childern2.get(0).getData());
    }

    private void printChildren(HierarchyNode node) {
        List <HierarchyNode> children = node.getChildren();
        System.out.println(node.getData());
        children.stream().map(n -> n.getData()).forEach(n -> System.out.println(String.format("ㄴ %d", n)));
    }

    private void printChildernAll(HierarchyNode node){
        List <HierarchyNode> children = node.getChildren();
        System.out.println(node.getData());
    }

    @Test 
    public void test_appendToChild() throws Exception {
        node.appendToChild(5);
        int expectedData = 2;
        HierarchyNode siblingOfChild = node.getChild();
        while (siblingOfChild != null) {
            // assertThat(siblingOfChild.getData(), is(expectedData++));
            siblingOfChild = siblingOfChild.getSibling();
        }
    }
}