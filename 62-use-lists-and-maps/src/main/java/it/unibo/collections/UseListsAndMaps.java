package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    final static int MIN_RANGE = 1000;
    final static int MAX_RANGE = 2000;
    final static int ELEMS = 100_000;

    private ArrayList<Integer> list;
    private LinkedList<Integer> linkList;
    private HashMap<String, Long> populationMap;

    private UseListsAndMaps() {
        this.list = new ArrayList<Integer>();
        this.linkList = new LinkedList<>();
        this.populationMap = new HashMap<>();
    }

    ///ArrayList

    public ArrayList<Integer> getList() {
        return list;
    }

    public void setList(ArrayList<Integer> list) {
        this.list = list;
    }

    private void populateArrayList(){
        int i;
        for(i = MIN_RANGE; i < MAX_RANGE; i++){
            this.list.add(i);
        }
    }

    ///// LinkedList
    
    public LinkedList<Integer> getLinkList() {
        return linkList;
    }

    public void setLinkList(LinkedList<Integer> linkList) {
        this.linkList = linkList;
    }

    private void populateLinkedList(){
        this.linkList.addAll(this.list);
    }

    //// HashMap

    private void populateHashMap(){
        this.populationMap.put("Africa", 1110635000L);
        this.populationMap.put("Americas", 972005000L);
        this.populationMap.put("Antarctica", 0L);
        this.populationMap.put("Asia",  4298723000L);
        this.populationMap.put("Europe", 742452000L);
        this.populationMap.put("Oceania", 38304000L);
    }

    //// Method

    private void swapArrayList(){
        int temp;
        temp = this.list.get(0);
        this.list.set(this.list.size()-1, temp);
    } 

    private void printArrayList(){
        for (int elem : this.list) {
            System.out.print(elem + " | ");
        }
        System.out.print("\n");
    }

    private void measureArrayList(){
        long time = System.nanoTime();
        for (int i = 1; i <= UseListsAndMaps.ELEMS; i++) {
            this.list.add(0, i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + this.list.size()
                + "insert 100_000 elements in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    private void measureListedList(){
        long time = System.nanoTime();
        for (int i = 1; i <= UseListsAndMaps.ELEMS; i++) {
            this.linkList.add(0, i);
        }
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + this.linkList.size()
                + "insert 100_000 elements in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    private void readMiddlePositionArrayList(){
        long time = System.nanoTime();
        this.list.get(this.list.size() / 2);
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading element in middle position of ArrayList "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    private void readMiddlePositionLinkedList(){
        long time = System.nanoTime();
        this.list.get(this.linkList.size() / 2);
        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading element in middle position of LikedList "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
    }

    private void getWorldPopulation(){
        long total = 0;
        total += this.populationMap.get("Africa");
        total += this.populationMap.get("Americas");
        total += this.populationMap.get("Antarctica");
        total += this.populationMap.get("Europe");
        total += this.populationMap.get("Asia");
        total += this.populationMap.get("Oceania");
        System.out.println("World total population: " + total);;
    }



    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        UseListsAndMaps listsAndMaps = new UseListsAndMaps();
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        listsAndMaps.populateArrayList();
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        listsAndMaps.populateLinkedList();
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        listsAndMaps.swapArrayList();
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        listsAndMaps.printArrayList();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        listsAndMaps.measureArrayList();
        listsAndMaps.measureListedList();
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        listsAndMaps.readMiddlePositionArrayList();
        listsAndMaps.readMiddlePositionLinkedList();
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        listsAndMaps.populateHashMap();
        /*
         * 8) Compute the population of the world
         */
        listsAndMaps.getWorldPopulation();

    }
}
