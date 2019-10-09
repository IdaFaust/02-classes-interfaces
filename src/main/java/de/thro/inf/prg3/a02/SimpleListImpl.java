package de.thro.inf.prg3.a02;

/**
 * @author Peter Kurfer
 * Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList {

    private static class Element {

        private Object obj;
        private Element next;

        public Element (Object o){
            this.obj = o;
            this.next = null;
        }
    }

    private Element head;

    @Override
    public void add(Object o) {
        if (head == null){
            head = new Element(o);
        }
        else{
            Element it = head;

            while(it.next != null){
                it = it.next;
            }
            it.next = new Element(o);
        }
    }

    @Override
    public int size()  {
        int counter = 0;
        Element it = head;

        while(it.next != null){
            counter++;
            it = it.next;
        }
        return counter;
    }

    @Override
    public SimpleList filter(SimpleFilter filter){
        SimpleList liste = new SimpleListImpl();
        Element it = head;

        while(it.next != null) {
            if (filter.include(it.obj)){
                liste.add(it.obj);
            }
            it = it.next;
        }
        return liste;
    }

	// TODO: Implement the required methods.

}
