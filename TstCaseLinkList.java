class node {
    int val;
    node next;
    node(int val) {
        this.val = val;
        this.next = null;
    }
}

class insertFront {
    static node insertAtFront(node head, int val) {
        node nfront = new node(val);
        nfront.next = head;
        return nfront;
    }
}

class insertBack {
    static node insertAtEnd(node head, int val) {
        node nBack = new node(val);
        if (head == null) {
            return nBack;
        }
        node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = nBack;
        return head;
    }
}

class delFront {
    static node delAtFront(node head) {
        if (head == null) {
            return null;
        }
        node temp = head;
        head = head.next;
        temp = null;
        return head;
    }
}

class delBack {
    static node delAtBack(node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        node secondLast = head;
        while (secondLast.next.next != null) {
            secondLast = secondLast.next;
        }
        secondLast.next = null;
        return head;
    }
}

class linkListPrint {
    static node printlinkList(node head) {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        return head;
    }
}

class findNode {
    static node searchNode(node head, int valTwo) {
        node temp = head;
        while (temp != null) {
            if (temp.val == valTwo) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

class linkListSize {
    static int sizeLinkList(node head) {
        int count = 0;
        node temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

class LinkListCheck {
    static boolean isEmpty(node head) {
        return head == null;
    }
}

public class TstCaseLinkList {

    public static void runTestCase(int inputVal) {
        System.out.println("==========================================");
        System.out.println("RUNNING TEST CASE FOR INPUT VALUE: " + inputVal);
        System.out.println("==========================================");

        node head = new node(3);
        head.next = new node(6);
        head.next.next = new node(9);
        head.next.next.next = new node(12);

        System.out.print("Initial List: ");
        linkListPrint.printlinkList(head);
        System.out.println();

        head = insertFront.insertAtFront(head, inputVal);
        System.out.print("After Insert Front (" + inputVal + "): ");
        linkListPrint.printlinkList(head);
        System.out.println();

        head = insertBack.insertAtEnd(head, inputVal + 15);
        System.out.print("After Insert Back (" + (inputVal + 15) + "): ");
        linkListPrint.printlinkList(head);
        System.out.println();

        head = delFront.delAtFront(head);
        System.out.print("After Delete Front: ");
        linkListPrint.printlinkList(head);
        System.out.println();

        head = delBack.delAtBack(head);
        System.out.print("After Delete Back: ");
        linkListPrint.printlinkList(head);
        System.out.println();

        node targetNode = findNode.searchNode(head, inputVal);
        if (targetNode != null) {
            System.out.println("Node found! Value = " + targetNode.val);
        } else {
            System.out.println("Node (" + inputVal + ") isn't found in the list");
        }

        if (LinkListCheck.isEmpty(head)) {
            System.out.println("The list is empty!");
        } else {
            System.out.println("The list has data.");
        }

        int length = linkListSize.sizeLinkList(head);
        System.out.println("Size of Linked List: " + length);

        System.out.print("Final Print via printlinkList: ");
        linkListPrint.printlinkList(head);
        System.out.println();

        System.out.print("Final Print via manual loop: ");
        node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        runTestCase(0);
    }
}