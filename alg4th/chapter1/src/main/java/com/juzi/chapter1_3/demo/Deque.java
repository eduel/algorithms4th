package com.juzi.chapter1_3.demo;

import java.util.Iterator;

public class Deque<T> implements Iterable<T>{
	private DoubleLinkedList<T> nestedList = new DoubleLinkedList<>();
	public boolean isEmpty(){
		return nestedList.isEmpty();
	}
	public int size(){
		return nestedList.size();
	}
	public void pushLeft(T t){
		DoubleLinkedList.insertBeforeFirst(nestedList, t);
	}
	public void pushRight(T t){
		DoubleLinkedList.insertAfterLast(nestedList, t);
	}
	public T popLeft(){
		return DoubleLinkedList.removeFromFirst(nestedList);
	}
	public T popRight(){
		return DoubleLinkedList.removeFromLast(nestedList);
	}
	@Override
	public Iterator<T> iterator() {
		return nestedList.iterator();
	}
	public void printElements(){
		DoubleLinkedList.printElements(nestedList);
	}

}
