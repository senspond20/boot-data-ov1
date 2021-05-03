package com.example.demo.vo;

import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

public class HierarchyNodeTest {
    private HierarchyNode node;
    @Before 
    public void setUp() throws Exception {
        node = new HierarchyNode(1);
        node.appendToChild(2);
        node.appendToChild(3);
        node.appendToChild(4);
    }
    @Test 
    public void test_children() throws Exception {
        printChildren(node);
        int expectedData = 2;
        for (HierarchyNode each: node.getChildren()) {
            // assertThat(each.getData(), is(expectedData++));
        }
    }
    private void printChildren(HierarchyNode node) {
        List <HierarchyNode> children = node.getChildren();
        System.out.println(node.getData());
        children.stream().map(n -> n.getData()).forEach(n -> System.out.println(String.format("ㄴ %d", n)));
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