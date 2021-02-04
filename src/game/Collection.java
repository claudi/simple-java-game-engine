package game;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public abstract class Collection<E> implements List<E> {
	List<E> elements = new ArrayList<E>();

	abstract void render(Graphics graphics);

	public int size() {
		return elements.size();
	}

	public boolean isEmpty() {
		return elements.isEmpty();
	}

	public boolean contains(Object o) {
		return elements.contains(o);
	}

	public Iterator<E> iterator() {
		return elements.iterator();
	}

	public Object[] toArray() {
		return elements.toArray();
	}

	public <T> T[] toArray(T[] a) {
		return elements.toArray(a);
	}

	public boolean add(E e) {
		return elements.add(e);
	}

	public boolean remove(Object o) {
		return elements.remove(o);
	}

	public boolean containsAll(java.util.Collection<?> c) {
		return elements.containsAll(c);
	}

	public boolean addAll(java.util.Collection<? extends E> c) {
		return elements.addAll(c);
	}

	public boolean addAll(int index, java.util.Collection<? extends E> c) {
		return elements.addAll(c);
	}

	public boolean removeAll(java.util.Collection<?> c) {
		return elements.removeAll(c);
	}

	public boolean retainAll(java.util.Collection<?> c) {
		return elements.retainAll(c);
	}

	public void clear() {
		elements.clear();
	}

	public E get(int index) {
		return elements.get(index);
	}

	public E set(int index, E element) {
		return elements.set(index, element);
	}

	public void add(int index, E element) {
		elements.add(index, element);
	}

	public E remove(int index) {
		return elements.remove(index);
	}

	public int indexOf(Object o) {
		return elements.indexOf(o);
	}

	public int lastIndexOf(Object o) {
		return elements.lastIndexOf(o);
	}

	public ListIterator<E> listIterator() {
		return elements.listIterator();
	}

	public ListIterator<E> listIterator(int index) {
		return elements.listIterator(index);
	}

	public List<E> subList(int fromIndex, int toIndex) {
		return elements.subList(fromIndex, toIndex);
	}
}
