package com.example.demo.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
    자료구조 :
        선형 자료구조 : 리스트,스택,큐
        비선형 자료구조 : 트리, 그래프
            트리 : 이진트리 : 모든 노드가 2개의 서브트리를 가지고 있는 트리
                   일반트리 : 각 노드들은 서로 다른 개수의 자식노드를 가진다
*/
public class HierarchyNode {
    private final int data;
    private HierarchyNode child;
    private HierarchyNode sibling;
    
    public HierarchyNode(int data) {
        this(data, null, null);
    }
    private HierarchyNode(int data, HierarchyNode child, HierarchyNode sibling) {
        this.data = data;
        this.child = child;
        this.sibling = sibling;
    }
    public HierarchyNode appendToChild(int data) {
        if (child == null) {
            child = new HierarchyNode(data);
            return child;
        }
        return child.appendToSibling(data);
    }
    private HierarchyNode appendToSibling(int data) {
        if (sibling == null) {
            sibling = new HierarchyNode(data);
            return sibling;
        }
        return sibling.appendToSibling(data);
    }
    public int getData() {
        return data;
    }
    public HierarchyNode getChild() {
        return child;
    }
    public HierarchyNode getSibling() {
        return sibling;
    }
    public List<HierarchyNode> getChildren() {
        List<HierarchyNode> children = new ArrayList <>();
        if (child == null) return Collections.EMPTY_LIST;
        HierarchyNode tempChild = child;
        while (tempChild != null) {
            children.add(tempChild);
            tempChild = tempChild.getSibling();
        }
        return children;
    }
    public HierarchyNode findChild(int data) {
        Optional<HierarchyNode> first = getChildren().stream().filter(n -> data == n.getData()).findFirst();
        if (!first.isPresent()) return null;
        return first.get();
    }
}