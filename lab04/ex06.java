package lab04;

class Student {
    int id;
    String name;
    String gender;
    int age;
    String major;
    Student next;

    Student(String name) {
        this.name = name;
        this.next = null;
    }
}

class StudentList {
    Student head;
    int size;

    StudentList() {
        head = null;
        size = 0;
    }


    void add(String name) {
        Student newStudent = new Student(name);
        if (head == null) {
            head = newStudent;
        } else {
            Student current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newStudent;
        }
        size++;
    }

    
    void remove(int index) {
        if (index < 0 || index >= size) {
            System.out.println("Index is out of range");
            return;
        }
        if (index == 0) {
            head = head.next;
        } else {
            Student current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    
    void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Student current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    
    void clear() {
        head = null;
        size = 0;
    }

    
    void display() {
        if (head == null) {
            System.out.println("Array is emply");
            return;
        }
        Student current = head;
        while (current != null) {
            System.out.print(current.name);
            if (current.next != null) System.out.print(" ");
            current = current.next;
        }
        System.out.println();
    }
}

public class ex06 {
    public static void main(String[] args) {

        StudentList myArr = new StudentList();

        System.out.println("==> Add");
        myArr.add("Makara");
        myArr.add("Kompheak");
        myArr.display();

        System.out.println("==> Remove at last");
        myArr.removeLast();
        myArr.add("Minea");
        myArr.add("Mehsa");
        myArr.display();

        System.out.println("\n==> Remove at larger index");
        myArr.remove(10);

        System.out.println("==> Clear all element");
        myArr.clear();
        myArr.display();
    }
}