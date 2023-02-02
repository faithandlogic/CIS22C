public class LinkedBag<T> implements BagInterface<T>

{

        private Node firstNode; // Reference to first node of chain
        private int numberOfEntries;

        // default constructor
        public LinkedBag() {
                firstNode = null;
                numberOfEntries = 0;
        } // end default constructor

        // Implement the unimplemented methods

        /**
         * Gets the current number of entries in this bag.
         * 
         * @return The integer number of entries currently in the bag.
         */
        public int getCurrentSize() {
                return numberOfEntries;
        }

        /**
         * Sees whether this bag is empty.
         * 
         * @return True if the bag is empty, or false if not.
         */
        public boolean isEmpty() {
                return numberOfEntries == 0;
        }

        /**
         * Adds a new entry to this bag.
         * 
         * @param newEntry The object to be added as a new entry.
         * @return True if the addition is successful, or false if not.
         */
        public boolean add(T newEntry) {
                Node newNode = new Node(newEntry);
                newNode.next = firstNode;
                firstNode = newNode;
                numberOfEntries++;
                return true;
        }

        /**
         * Removes one unspecified entry from this bag, if possible.
         * 
         * @return Either the removed entry, if the removal.
         *         was successful, or null.
         */
        public T remove() {
                T result = null;
                if (firstNode != null) {
                        result = firstNode.data;
                        firstNode = firstNode.next;
                        numberOfEntries--;
                }
                return result;
        }

        /**
         * Removes one occurrence of a given entry from this bag.
         * 
         * @param anEntry The entry to be removed.
         * @return True if the removal was successful, or false if not.
         */
        public boolean remove(T anEntry) {
                boolean result = false;
                Node nodeN = getReferenceTo(anEntry);
                if (nodeN != null) {
                        nodeN.data = firstNode.data;
                        firstNode = firstNode.next;
                        numberOfEntries--;
                        result = true;
                }
                return result;
        }

        /** Removes all entries from this bag. */
        public void clear() {
                while (!isEmpty())
                        remove();
        }

        /**
         * Counts the number of times a given entry appears in this bag.
         * 
         * @param anEntry The entry to be counted.
         * @return The number of times anEntry appears in the bag.
         */
        public int getFrequencyOf(T anEntry) {
                int frequency = 0;
                int counter = 0;
                Node currentNode = firstNode;
                while ((counter < numberOfEntries) && (currentNode != null)) {
                        if (anEntry.equals(currentNode.data)) {
                                frequency++;
                        }
                        counter++;
                        currentNode = currentNode.next;
                }
                return frequency;
        }

        /**
         * Tests whether this bag contains a given entry.
         * 
         * @param anEntry The entry to locate.
         * @return True if the bag contains anEntry, or false if not.
         */
        public boolean contains(T anEntry) {
                boolean found = false;
                Node currentNode = firstNode;
                while (!found && (currentNode != null)) {
                        if (anEntry.equals(currentNode.data))
                                found = true;
                        else
                                currentNode = currentNode.next;
                }
                return found;
        }

        /**
         * Retrieves all entries that are in this bag.
         * 
         * @return A newly allocated array of all the entries in the bag.
         *         Note: If the bag is empty, the returned array is empty.
         */
        public T[] toArray() {
                @SuppressWarnings("unchecked")
                T[] result = (T[]) new Object[numberOfEntries];
                int index = 0;
                Node currentNode = firstNode;
                while ((index < numberOfEntries) && (currentNode != null)) {
                        result[index] = currentNode.data;
                        index++;
                        currentNode = currentNode.next;
                }
                return result;
        }

        // Locates a given entry within this bag.
        // Returns a reference to the node containing the entry, if located,
        // or null otherwise.
        private Node getReferenceTo(T anEntry) {
                boolean found = false;
                Node currentNode = firstNode;

                while (!found && (currentNode != null)) {
                        if (anEntry.equals(currentNode.data))
                                found = true;
                        else
                                currentNode = currentNode.next;
                } // end while

                return currentNode;
        } // end getReferenceTo

        private class Node {
                private T data; // data stored in this node, T stands for generic type
                private Node next; // reference to next node in list

                private Node(T dataPortion) {
                        this(dataPortion, null);
                } // end constructor

                private Node(T dataPortion, Node nextNode) {
                        data = dataPortion;
                        next = nextNode;
                } // end constructor

                private Node getNextNode() {
                        return next;
                } // end getNextNode

        } // end Node

}// end LinkedBag