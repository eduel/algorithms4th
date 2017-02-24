package com.juzi.chapter1_3.demo;

import java.util.Iterator;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class List {

	static class Node<Item> {
		Item item;
		Node<Item> next;
	}
	public static void main(String[] args) {
		Node<String> n1 = new Node<>();
		Node<String> n2 = new Node<>();
		Node<String> n3 = new Node<>();
		n1.item = "n1";
		n1.next = n2;
		n2.item = "n2";
		n2.next = n3;
		n3.item = "n3";
		for(Node<String> n = n1;n!=null;n = n.next){
			String item = n.item;
			StdOut.println(item);
		}
		Stack<String> stack = new Stack<>();
		stack.push("n1");
		stack.push("n2");
		stack.push("n3");
		Iterator<String> iterator = stack.iterator();
		while(iterator.hasNext()){
			String item = iterator.next();
			StdOut.println(item);//n3,n2,n2,LIFO;
		}
	}
}
