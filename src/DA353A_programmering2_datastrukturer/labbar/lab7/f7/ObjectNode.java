/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab7.f7;

public class ObjectNode {
	private Object data;
	private ObjectNode next;

	public ObjectNode(Object data, ObjectNode next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public ObjectNode getNext() {
		return this.next;
	}

	public void setNext(ObjectNode next) {
		this.next = next;
	}

	public String toString() {
		StringBuilder str = new StringBuilder("[ ");
		str.append("{ "+data.toString()+" }");
		ObjectNode node = next;
		while (node != null) {
			str.append(" --> \t{ ");
			str.append(node.getData().toString());
			str.append(" }");
			node = node.getNext();
		}
		str.append(" ]");
		return str.toString();
	}
}
