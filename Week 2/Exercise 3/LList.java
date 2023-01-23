public class LList<T> implements ListInterface<T> 

{

private Node firstNode; // Reference to first node of chain
private int numberOfEntries;

public LList()
{
initializeDataFields();
} // end default constructor

public void clear() {
    initializeDataFields(); // clear the list by reinitializing the data fields to their default values
} // end clear

/** Adds a new entry to the end of this list.
Entries currently in the list are unaffected.
The list's size is increased by 1.
* @param newEntry The object to be added as a new entry.
*/
public void add(T newEntry){
    Node newNode = new Node(newEntry);
    if (isEmpty())
        firstNode = newNode;
    else { // add to end of nonempty list
        Node lastNode = getNodeAt(numberOfEntries);
        lastNode.next = newNode; // make last node reference new node
    } // end if
    numberOfEntries++;
} // end add

/** Adds a new entry at a specified position within this list.
* Entries originally at and above the specified position
* are at the next higher position within the list.
* The list's size is increased by 1.
* @param newPosition An integer that specifies the desired
* position of the new entry.
* @param newEntry The object to be added as a new entry.
* @throws IndexOutOfBoundsException if either
*    newPosition less than 1, or
*    newPosition greater than getLength()+1. 
*/
public void add(int newPosition, T newEntry){
    if ((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
        Node newNode = new Node(newEntry);
        if (isEmpty() || (newPosition == 1)) { // case 1: add to beginning of list
            newNode.next = firstNode;
            firstNode = newNode;
        }
        else { // case 2: list is not empty and newPosition > 1
            Node nodeBefore = getNodeAt(newPosition - 1);
            Node nodeAfter = nodeBefore.next;
            newNode.next = nodeAfter;
            nodeBefore.next = newNode;
        } // end if
        numberOfEntries++;
    }
    else
        throw new IndexOutOfBoundsException("Illegal position given to add operation.");
} // end add

/** Removes the entry at a given position from this list.
* Entries originally at positions higher than the given
* position are at the next lower position within the list,
* and the list's size is decreased by 1.
* @param givenPosition An integer that indicates the position of
* the entry to be removed.
* @return A reference to the removed entry.
* @throws IndexOutOfBoundsException if either
*    givenPosition less than 1, or
*    givenPosition greater than getLength()+1. 
*/
public T remove(int givenPosition) {
    T result = null; // return value
    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
        assert !isEmpty();
        if (givenPosition == 1) { // case 1: remove first entry
            result = firstNode.data; // save entry to be removed
            firstNode = firstNode.next;
        }
        else { // case 2: givenPosition > 1
            Node nodeBefore = getNodeAt(givenPosition - 1);
            Node nodeToRemove = nodeBefore.next;
            Node nodeAfter = nodeToRemove.next;
            nodeBefore.next = nodeAfter;
            result = nodeToRemove.data; // save entry to be removed
        } // end if
        numberOfEntries--; // decrease length by 1
        return result; // return removed entry
    }
    else
        throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
} // end remove

/** Replaces the entry at a given position in this list.
* @param givenPosition An integer that indicates the position of the
* entry to be replaced.
* @param newEntry The object that will replace the entry at the
* position givenPosition.
* @return The original entry that was replaced.
* @throws IndexOutOfBoundsException if either
*    givenPosition less than 1, or
*    givenPosition greater than getLength()+1. 
*/
public T replace(int givenPosition, T newEntry) {
    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
        assert !isEmpty();
        Node desiredNode = getNodeAt(givenPosition);
        T originalEntry = desiredNode.data;
        desiredNode.data = newEntry;
        return originalEntry;
    }
    else
        throw new IndexOutOfBoundsException("Illegal position given to replace operation.");
} // end replace

/** Retrieves the entry at a given position in this list.
* @param givenPosition An integer that indicates the position of
* the desired entry.
* @return A reference to the indicated entry.
* @throws IndexOutOfBoundsException if either
*    givenPosition less than 1, or
*    givenPosition greater than getLength()+1. 
*/
public T getEntry(int givenPosition) {
    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
        assert !isEmpty();
        return getNodeAt(givenPosition).data;
    }
    else
        throw new IndexOutOfBoundsException("Illegal position given to getEntry operation.");
} // end getEntry

/** Sees whether this list contains a given entry.
* @param anEntry The object that is the desired entry.
* @return True if the list contains anEntry, or false if not. 
*/
public boolean contains(T anEntry) {
    boolean found = false;
    Node currentNode = firstNode;
    while (!found && (currentNode != null)) {
        if (anEntry.equals(currentNode.data))
            found = true;
        else
            currentNode = currentNode.next;
    } // end while
    return found;
} // end contains

/** Gets the length of this list.
* @return The integer number of entries currently in the list. 
*/
public int getLength() {
    return numberOfEntries;
} // end getLength

/** Sees whether this list is empty.
* @return True if the list is empty, or false if not.
*/
public boolean isEmpty() {
    boolean result;
    if (numberOfEntries == 0) { // or getLength() == 0
        assert firstNode == null;
        result = true;
    }
    else {
        assert firstNode != null;
        result = false;
    } // end if
    return result;
} // end isEmpty

/** Retrieves all entries that are in this list in the order in which
they occur in the list. 
@return A newly allocated array of all the entries in the list.
*/
public T[] toArray() {
    // the cast is safe because the new array contains null entries
    @SuppressWarnings("unchecked")
    T[] result = (T[])new Object[numberOfEntries]; // unchecked cast

    int index = 0;
    Node currentNode = firstNode;
    while ((index < numberOfEntries) && (currentNode != null)) {
        result[index] = currentNode.data;
        currentNode = currentNode.next;
        index++;
    } // end while
    return result;
} // end toArray

// professor provided code below

// Initializes the class's data fields to indicate an empty list.
private void initializeDataFields()
{
firstNode = null;
numberOfEntries = 0;
} // end initializeDataFields

 

// Returns a reference to the node at a given position.
// Precondition: The chain is not empty;
// 1 <= givenPosition <= numberOfEntries.
private Node getNodeAt(int givenPosition)
{
assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
Node currentNode = firstNode;

// Traverse the chain to locate the desired node
// (skipped if givenPosition is 1)
for (int counter = 1; counter < givenPosition; counter++)
currentNode = currentNode.getNextNode();

assert currentNode != null;

return currentNode;
} // end getNodeAt

 

private class Node {
    private T    data; // data stored in this node, T stands for generic type
    private Node next; // reference to next node in list

    private Node(T dataPortion) {
        this(dataPortion, null);
    } // end constructor

    private Node(T dataPortion, Node nextNode) {
        data = dataPortion;
        next = nextNode;
    } // end constructor

    private T getData() {
        return data;
    } // end getData

    private void setData(T newData) {
        data = newData;
    } // end setData

    private Node getNextNode() {
        return next;
    } // end getNextNode

} // end Node


 

} // end LList