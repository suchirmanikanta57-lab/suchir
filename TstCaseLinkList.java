import java.util.Scanner;

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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        node head = null;
        int choice;

        do {
            System.out.println("\n------------------------------------------");
            System.out.println("          LINKED LIST MENU               ");
            System.out.println("------------------------------------------");
            System.out.println("1. Insert at Front");
            System.out.println("2. Insert at End");
            System.out.println("3. Delete from Front");
            System.out.println("4. Delete from Back");
            System.out.println("5. Search Node");
            System.out.println("6. Check if Empty");
            System.out.println("7. Get List Size");
            System.out.println("8. Print List");
            System.out.println("9. Exit");
            System.out.print("Enter your choice (1-9): ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert at front: ");
                    int valFront = scanner.nextInt();
                    head = insertFront.insertAtFront(head, valFront);
                    System.out.println("Inserted successfully!");
                    break;

                case 2:
                    System.out.print("Enter value to insert at back: ");
                    int valBack = scanner.nextInt();
                    head = insertBack.insertAtEnd(head, valBack);
                    System.out.println("Inserted successfully!");
                    break;

                case 3:
                    if (LinkListCheck.isEmpty(head)) {
                        System.out.println("List is empty! Nothing to delete.");
                    } else {
                        head = delFront.delAtFront(head);
                        System.out.println("Deleted front node successfully!");
                    }
                    break;

                case 4:
                    if (LinkListCheck.isEmpty(head)) {
                        System.out.println("List is empty! Nothing to delete.");
                    } else {
                        head = delBack.delAtBack(head);
                        System.out.println("Deleted back node successfully!");
                    }
                    break;

                case 5:
                    System.out.print("Enter value to search: ");
                    int searchVal = scanner.nextInt();
                    node targetNode = findNode.searchNode(head, searchVal);
                    if (targetNode != null) {
                        System.out.println("Node found! Value = " + targetNode.val);
                    } else {
                        System.out.println("Node (" + searchVal + ") isn't found in the list.");
                    }
                    break;

                case 6:
                    if (LinkListCheck.isEmpty(head)) {
                        System.out.println("The list is empty!");
                    } else {
                        System.out.println("The list has data.");
                    }
                    break;

                case 7:
                    int length = linkListSize.sizeLinkList(head);
                    System.out.println("Size of Linked List: " + length);
                    break;

                case 8:
                    if (LinkListCheck.isEmpty(head)) {
                        System.out.println("The list is currently empty.");
                    } else {
                        System.out.print("Current List: ");
                        linkListPrint.printlinkList(head);
                        System.out.println();
                    }
                    break;

                case 9:
                    System.out.println("Exiting menu... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select an option from 1 to 9.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
