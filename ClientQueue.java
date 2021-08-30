// Name: Eugene
// ID: 1351553

// Creates a queue of client objects, where each client object
// can be added or removed from the queue, the first client that 
// is in the queue will be the first one out
public class ClientQueue {
    // A Client class that holds the properties for a client object
    // where each client has stores the location of the next client
    public class Client {
        public int arrTime;
        public int useTime;
        public Client next;

        // The Constructor
        public Client(int arrTime, int useTime) {
            this.arrTime = arrTime;
            this.useTime = useTime;
        }
    }

    Client head;    // A variable to store the head of the queue
    Client last;    // A variable to store the end of the queue

    int count = 0;  // The length of the queue

// A method that creates a client and adds it to the end of the queue.
    public void enqueue(int arrTime, int useTime) {
//        Checks if there is anyone in the queue
        if (head == null) {
            head = new Client(arrTime, useTime);
            last = head;
            count++;
        }
        else {
            Client newClient = new Client(arrTime, useTime);

//          Adds a new client to the end of the list and
//          shifts te last index onto the end of the queue
            last.next = newClient;
            last = last.next;
            count++;
        }
    }

    // A method that removes a client at the head of the queue
    public void dequeue() {
        // Check if the queue is not empty
        if (head != null) {
            head = head.next;
            if(head == null) last = null;   // Set the last item in the queue to the same as the head
            count--;
        }
    }

    // A method that returns the arrival time of the client at the head of the queue
    public int peekArrive() {

        return head != null ? head.arrTime : -1;
    }

    // A method that returns the usage time of the client at the head of the queue
    public int peekUsage() {

        return head != null ? head.useTime : -1;
    }

    // A method that returns true if the list is empty
    public boolean isEmpty() {
        return count == 0;
    }

    // A method that returns the length of the queue
    public int length() {
        return count;
    }

    // A method that prints the arrival time and usage time of each client
    public void dump() {
        Client index;
        index = head;
        // While there is still client in the que, print their values
        while(index != null) {
            System.out.println("Arrival Time: " + index.arrTime + "Usage Time: " + index.useTime);
            index = index.next;
        }

    }
}
