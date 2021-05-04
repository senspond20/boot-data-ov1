package com.example.demo.vo;

import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String...arg) {
        HierarchyNode node = new HierarchyNode(1);
        HierarchyNode node2Of1 = node.appendToChild(2);

        
        node.appendToChild(3);
        node.appendToChild(4);
        node2Of1.appendToChild(5);
        node2Of1.appendToChild(6);
        HierarchyNode node7Of2 = node2Of1.appendToChild(7);
        node7Of2.appendToChild(10);
        node7Of2.appendToChild(11);
        node7Of2.appendToChild(12);
        HierarchyNode newNode = node;
        while (newNode != null) {
            printChildren(newNode);
            Scanner sc = new Scanner(System.in);
            System.out.println("다음 노드 선택 해주세요.(종료:q) : ");
            String input = sc.nextLine();
            if ("q".equals(input)) {
                newNode = null;
            } else {
                newNode = newNode.findChild(Integer.parseInt(input));
            }
            if (newNode == null) {
                System.out.println("종료되었습니다.");
            }
        }
        
    }
    private static void printChildren(HierarchyNode node) {
        List < HierarchyNode > children = node.getChildren();
        System.out.println(node.getData());
        children.stream().map(n -> n.getData()).forEach(n -> System.out.println(String.format("ㄴ %d", n)));
    }

}