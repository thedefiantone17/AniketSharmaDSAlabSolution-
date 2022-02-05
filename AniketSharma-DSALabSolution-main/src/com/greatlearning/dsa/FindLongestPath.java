package com.greatlearning.dsa;

import java.util.ArrayList;

public class FindLongestPath {
static class Node{
		
		int nodeData;
		Node rightNode;
		Node leftNode;
		
	};
	
	static Node newNode(int data) {
		Node temp = new Node();
		temp.nodeData = data;
		temp.leftNode = null;
		temp.rightNode = null;
		return temp;
		
	};
	
	public static ArrayList<Integer> findLongestPath(Node root){
		
		// if root is null which means there is no binary tree
		// then return empty list
		if (root == null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
					
		}
		
		// recursive call on root.rightNode
		ArrayList<Integer> rightNodeList = findLongestPath(root.rightNode);
		// recursive call on root.leftNode
		ArrayList<Integer> lefttNodeList = findLongestPath(root.leftNode);
		
		// comparing the size of arraylist and accordingly inserting the current node
		if(rightNodeList.size() < lefttNodeList.size()) {
			lefttNodeList.add(root.nodeData);
		}else {
			rightNodeList.add(root.nodeData);
		}
		
		return lefttNodeList.size() > rightNodeList.size() ? lefttNodeList : rightNodeList;
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = newNode(100);
		root.leftNode = newNode(20);
		root.rightNode = newNode(130);
		root.leftNode.leftNode = newNode(10);
		root.leftNode.rightNode = newNode(50);
		root.rightNode.leftNode = newNode(110);
		root.rightNode.rightNode = newNode(140);
		root.leftNode.leftNode.leftNode = newNode(5);
		
		ArrayList<Integer> longestPath = findLongestPath(root);
		
		System.out.println(longestPath);

	}

}
