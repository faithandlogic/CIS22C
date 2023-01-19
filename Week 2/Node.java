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
