/*
 * Author: Sebastian Börebäck
 * Copyright (c) 2016.
 */

package DA353A_programmering2_datastrukturer.labbar.lab12.assets;


import DA353A_programmering2_datastrukturer.labbar.lab8.LinkedQueue;

import java.util.*;
//import collections.ArrayList;
//import collections.List;

public class BinarySearchTree<K,V> implements SearchTree<K,V>, Iterable{
    private Comparator<K> comparator;
    private BSTNode<K,V> tree;
    private int size;
    
    public BinarySearchTree() {
        comparator = new Comp();
    }
    
    public BinarySearchTree( Comparator<K> comp ) {
        comparator = comp;
    }
    
    public BSTNode<K,V> root() {
        return tree;
    }
    
    public V get(K key) {
        BSTNode<K,V> node = find( key );
        if(node!=null)
            return node.value;
        return null;
    }
    
    
    public void put(K key, V value) {
        tree = put(tree,key,value);
	    size++;
    } 
    
    public V remove(K key) {
        V value = get( key );
        if(value!=null) {
            tree = remove(tree,key);
	        size--;
        }
        return value;
    }
    
    public boolean contains( K key ) {
        return find( key ) != null;
    }
    
    public int height() {
        return height( tree );
    }
    
    public Iterator<V> iterator() {
        return new Iter();
    }
    
    private BSTNode<K,V> find(K key) {
        int res;
        BSTNode<K,V> node=tree;
        while( ( node != null ) && ( ( res = comparator.compare( key, node.key ) ) != 0 ) ) {
            if( res < 0 )
                node = node.left;
            else
                node = node.right;
        }

        return node;
    }
    
    private BSTNode<K,V> put(BSTNode<K,V> node, K key, V value) {

        if( node == null ) {
            node = new BSTNode<K,V>( key, value, null, null );
        } else {
            if(comparator.compare(key,node.key)<0) {
                node.left = put(node.left,key,value);
            } else if(comparator.compare(key,node.key)>0) {
                node.right = put(node.right,key,value);
            }
        }

        return node;
    }
    
    private BSTNode<K,V> remove(BSTNode<K,V> node, K key) {
        int compare = comparator.compare(key,node.key);
        if(compare==0) {
            if(node.left==null && node.right==null)
                node = null;
            else if(node.left!=null && node.right==null)
                node = node.left;
            else if(node.left==null && node.right!=null)
                node = node.right;
            else {
                BSTNode<K,V> min = getMin(node.right);
                min.right = remove(node.right,min.key);
                min.left = node.left;
                node = min;
            }
        } else if(compare<0) {
            node.left = remove(node.left,key);
        } else {
            node.right = remove(node.right,key);
        }

        return node;
    }
    
    private BSTNode<K,V> getMin(BSTNode<K,V> node) {
        while(node.left!=null)
            node = node.left;
        return node;
    }
        
    private int height( BSTNode<K,V> node ) {
        if( node == null )
            return -1;
        return 1 + Math.max( height( node.left ), height( node.right ));
    }


	/**
	 * Upg 8a. testa BTN-NODE size
	 * @return
	 */
	public int size1() {
		if (tree == null) {
			return 0;
		}
		//else
		return tree.size();
	}

    // Laboration 13
    public int size() {
        return size;
    }

	/**
	 * Upg 18
	 * @return
	 */
	public List<K> keys(){
    	ArrayList<K> list = new ArrayList<K>();
    	keys(tree, list);
        return list;
    }

	/**
	 * Upg 18
	 * @return
	 */
    private void keys(BSTNode<K,V> node, ArrayList<K> list){
	    if (node != null) {
		    keys(node.left,list);
		    list.add(list.size(),node.key);
		    keys(node.right,list);
	    }
    }


	/**
	 * Upg 19
	 * @return
	 */
    public List<V> values(){
	    LinkedList<V> list = new LinkedList<V>();
	    values(tree, list);
	    return (List<V>) list;
    }


	/**
	 * Upg 19
	 * @return
	 */
	private void values(BSTNode<K, V> node, LinkedList<V> list) {
		if (node != null) {
			values(node.left,list);

			list.addLast(node.value);
			values(node.right,list);
		}
	}

	public V first(){
	    BSTNode<K, V> node = this.tree;
	    if (node == null) {
		    return null;
	    }
	    while (node.left != null) {
		    node = node.left;
	    }
	    return node.value;

    }
    public V last(){
	    BSTNode<K, V> node = this.tree;
	    if (node == null) {
		    return null;
	    }
	    while (node.right != null) {
		    node = node.right;
	    }
	    return node.value;
    }
    
    public void print() {
    	printInOrder(tree);
    }

	/**
	 * upg 14 InOrder
	 * @param node
	 */
    private void printInOrder(BSTNode<K,V> node) {
	    //InOrder

	    if (node != null) {

//		    if (height(node) ) {
//			    System.out.println();
//		    }

		    //do left side
		    printInOrder(node.left);
		    //back on the top
		    if (height(node) >= 3) {
			    System.out.println();
			    System.out.print("[] "+node.key+ " []");
			    System.out.println();
		    }
		    else
		    System.out.print(node.key+ " -> ");
		    //do right side
		    printInOrder(node.right);

	    }

    }

	/**
	 * Upg 15
	 * preorder printInOrder
	 */
	private void printPreOrder() {
		printPreOrder(tree);


	}

	private void printPreOrder(BSTNode<K, V> node) {
		//dont need to check left or right if its null.
		//because i do this in the beginning. Bellow if.
		if (node != null) {


			System.out.print(node.key +" -> ");

			printPreOrder(node.left);

			printPreOrder(node.right);
			System.out.println();
		}

		//		preorder(a -> list.add(a));
//		list.add(this.value);
//		//if left has something preOrder its childes
//		if (this.left != null) {
//			this.left.collectPreorder(list);
//		}
//		//Done with left side do right side preOrder
//		if (this.right != null) {
//			this.right.collectPreorder(list);
//		}

//		Action<V> a = new Action<V>() {
//			@Override
//			public void action(V value) {
//				list.add(V value);
//			}
//		};
	}

	/**
	 * Upg 16 PostOrder
	 */
	private void printPostOrder() {
		printPostOrder(tree);
	}

	private void printPostOrder(BSTNode<K, V> node) {
		if (node != null) {
			System.out.println();
			printPostOrder(node.left);

			printPostOrder(node.right);
			System.out.print(node.key +" -> ");
		}
//		if (left != null)
//			left.postorder(a);
//		if (right != null)
//			right.postorder(a);
//		a.action(value);
	}

	/**
	 * Upg 17 levelOrder
	 */
	private void printLevelOrder() {
		printLevelOrder(tree);
	}

	private void printLevelOrder(BSTNode<K, V> tree) {
		//		if (this.left != null) {
//			this.left.collect(list, filter);
//		}
//
//		if (filter.accept(this.value)) {
//			list.add(this.value);
//		}
//
//		if (this.right != null) {
//			this.right.collect(list,filter);
//		}

		LinkedQueue<BSTNode<K,V>> queue = new LinkedQueue<BSTNode<K,V>>();
		BSTNode<K,V> node;
		queue.enqueue(tree);
		int height = height(tree);

		while (!queue.isEmpty()) {
			node = queue.dequeue();

			if (height > height(node)) {
				height--;
				System.out.println();
			}
			//do the action to printInOrder
//			a.action(node.value);
			System.out.print(node.key +"\t\t");


			if (node.left != null) {
				queue.enqueue(node.left);
			}
			if (node.right != null) {
				queue.enqueue(node.right);
			}



		}
	}

	/**
	 * upg 8b
	 * @return
	 */
	public int size2() {
		return size2(this.tree);

	}

	/**
	 * Recursive walkthrough the nodes to count them
	 * @param node current node
	 * @return the tree size
	 */
	private int size2(BSTNode<K, V> node) {
		if (node == null) {
			return 0;
		}
		return 1 + size2(node.left) + size2(node.right);
	}

	/**
	 * UPG 21
	 *
	 */
	public void traverse(Action<V> action) {
		traverse(tree,action);
	}

	private void traverse(BSTNode<K,V> node, Action<V> action) {
		if (node != null) {
			//InOrder
			traverse(node.left, action);
			action.action(node.value);
			traverse(node.right,action);
		}
	}

	private class Comp implements Comparator<K> {
        public int compare( K key1, K key2 ) {
            Comparable<K> k1 = ( Comparable<K> )key1;
            return k1.compareTo( key2 );
        }
    }
    
    private class Iter implements Iterator<V> {
        ArrayList<V> list = new ArrayList<V>();
        int index = -1;
        
        public Iter() {
            inOrder(tree);
        }
        
        private void inOrder(BSTNode<K,V> node) {
            if(node!=null) {
                inOrder(node.left);
                list.add(node.value);
                inOrder(node.right);
            }
        }
        
        public boolean hasNext() {
            return index<list.size()-1;
        }
        
        public V next() {
            if(!hasNext())
                throw new NoSuchElementException();
            index++;
            return list.get(index);
        }
        
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }




	public static void main(String[] args) {
        BinarySearchTree<String,String> tree = new BinarySearchTree<String,String>();
        tree.put("karta","map");
        tree.put("vacker","beautiful");
        tree.put("svart","black");
        tree.put("lärare","teacher");
        tree.put("boll", "ball");
        tree.put("vit","white");
        tree.put("hus","house");
        tree.put("vänster","left");
        tree.put("höger","right");

        String res = (String)tree.get("lärare");
        System.out.println(res);
        System.out.println(tree.get("LÄRARE"));
        System.out.println("---------------------");
        Iterator<String> elements = tree.iterator();
        while(elements.hasNext()) {
            System.out.println(elements.next());
        }

        System.out.println("---------------------");
	    System.out.println("PRINT InOrder");
	    System.out.println("---------------------");
	    tree.print();

	    System.out.println("---------------------");
	    System.out.println("keys in order");
	    System.out.println("---------------------");
	    List<String> keys = tree.keys();
	    System.out.println(keys);

	    System.out.println("---------------------");
	    System.out.println("keys in order");
	    System.out.println("---------------------");
	    List<String> values = tree.values();
	    System.out.println(values);

//	    System.out.println("---------------------");
//	    System.out.println("PRINT PREOrderer");
//	    System.out.println("---------------------");
//	    tree.printPreOrder();

//	    System.out.println("---------------------");
//	    System.out.println("PRINT PostOrder");
//	    System.out.println("---------------------");
//	    tree.printPostOrder();
//
	    System.out.println("---------------------");
	    System.out.println("PRINT LevelOrder");
	    System.out.println("---------------------");
	    tree.printLevelOrder();

//	    tree.root().showTree();
    }




}
