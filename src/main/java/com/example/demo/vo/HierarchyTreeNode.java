package com.example.demo.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
    자료구조 :
        선형 자료구조 : 리스트,스택,큐
        비선형 자료구조 : 트리, 그래프
            트리 : 이진트리 : 모든 노드가 2개의 서브트리를 가지고 있는 트리
                   일반트리 : 각 노드들은 서로 다른 개수의 자식노드를 가진다
*/

@Getter
@AllArgsConstructor
public class HierarchyTreeNode<T> {
    private T data;
    private HierarchyTreeNode<T> child; // 자식
    private HierarchyTreeNode<T> sibling; // 형제
    
    public HierarchyTreeNode(T data){
        this.data = data;
        this.child = null;
        this.sibling = null;
    }

    /**
     * 현재노드에 자식노드 추가
     * @param data
     * @return
     */
    public HierarchyTreeNode<T> appendToChild(T data) {
        if (child == null) {
            child = new HierarchyTreeNode<T>(data);
            return child;
        }
        return child.appendToSibling(data);
    }

    /**
     * 현재노드에 형제노드 추가
     * @param data
     * @return
     */
    private HierarchyTreeNode<T> appendToSibling(T data) {
        if (sibling == null) {
            sibling = new HierarchyTreeNode<T>(data);
            return sibling;
        }
        return sibling.appendToSibling(data);
    }

    /**
     * 자식들 리스트를 가져온다
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<HierarchyTreeNode<T>> getChildren() {
        List<HierarchyTreeNode<T>> children = new ArrayList <>();
        if (child == null) return  Collections.EMPTY_LIST;
        HierarchyTreeNode<T> tempChild = child;
        while (tempChild != null) {
            children.add(tempChild);
            tempChild = tempChild.getSibling();
        }
        return children;
    }

    /**
     * 자식 노드를 찾는다
     * @param data
     * @return
     */
    public HierarchyTreeNode<T> findChild(T data) {
        Optional<HierarchyTreeNode<T>> first = 
        getChildren().stream()
                     .filter(n -> data == n.getData())
                     .findFirst();
        if (!first.isPresent()) return null;
        return first.get();
    }

}