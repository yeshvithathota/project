import java.util.*;

// ---------------- CO2 ----------------
// Linked List Node for storing courses
class CourseNode {
    String course;
    CourseNode next;

    CourseNode(String course) {
        this.course = course;
        this.next = null;
    }
}

public class CareerGuidanceDSA {

    // ---------------- CO4 ----------------
    // HashMap for fast lookup of course categories
    static HashMap<String, String> courseCategory = new HashMap<>();

    // ---------------- CO3 ----------------
    // Stack for resume undo operations
    static Stack<String> resumeStack = new Stack<>();

    // ---------------- CO2 ----------------
    // Linked list head
    static CourseNode head = null;

    // INSERT COURSE (Linked List)
    public static void addCourse(String course) {

        CourseNode newNode = new CourseNode(course);

        if (head == null) {
            head = newNode;
            return;
        }

        CourseNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
    }

    // DISPLAY COURSES
    public static void displayCourses() {

        CourseNode temp = head;

        System.out.println("\nAvailable Courses:");

        while (temp != null) {
            System.out.println(temp.course);
            temp = temp.next;
        }
    }

    // ---------------- CO1 ----------------
    // Linear Search
    public static boolean linearSearch(String key) {

        CourseNode temp = head;

        while (temp != null) {

            if (temp.course.equalsIgnoreCase(key))
                return true;

            temp = temp.next;
        }

        return false;
    }

    // ---------------- CO1 ----------------
    // Bubble Sort
    public static void bubbleSort(ArrayList<String> list) {

        int n = list.size();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (list.get(j).compareTo(list.get(j + 1)) > 0) {

                    String temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
    }

    // DISPLAY SORTED COURSES
    public static void displaySortedCourses() {

        ArrayList<String> list = new ArrayList<>();

        CourseNode temp = head;

        while (temp != null) {
            list.add(temp.course);
            temp = temp.next;
        }

        bubbleSort(list);

        System.out.println("\nSorted Courses:");

        for (String c : list) {
            System.out.println(c);
        }
    }

    // ---------------- CO5 ----------------
    // Course Recommendation
    public static void recommendCourse(String interest) {

        if (courseCategory.containsKey(interest)) {

            System.out.println("Recommended Course: "
                    + courseCategory.get(interest));

        } else {

            System.out.println("No course found for this interest.");
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Course categories
        courseCategory.put("PROGRAMMING", "Java Development");
        courseCategory.put("DATA", "Data Science");
        courseCategory.put("DESIGN", "UI/UX Design");
        courseCategory.put("BUSINESS", "MBA");

        // Initial courses
        addCourse("Java Development");
        addCourse("Data Science");
        addCourse("Cyber Security");
        addCourse("UI UX Design");

        while (true) {

            System.out.println("\n---- Career Guidance System ----");
            System.out.println("1. Show Courses");
            System.out.println("2. Search Course");
            System.out.println("3. Sorted Courses");
            System.out.println("4. Recommend Course");
            System.out.println("5. Add Course");
            System.out.println("6. Add Resume");
            System.out.println("7. Undo Resume");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    displayCourses();
                    break;

                case 2:

                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();

                    if (linearSearch(course))
                        System.out.println("Course Found");
                    else
                        System.out.println("Course Not Found");

                    break;

                case 3:
                    displaySortedCourses();
                    break;

                case 4:

                    System.out.print("Enter interest: ");
                    String interest = sc.nextLine().toUpperCase();

                    recommendCourse(interest);
                    break;

                case 5:

                    System.out.print("Enter new course name: ");
                    String newCourse = sc.nextLine();

                    addCourse(newCourse);
                    System.out.println("Course added successfully!");

                    break;

                case 6:

                    System.out.print("Enter resume name: ");
                    String resume = sc.nextLine();

                    resumeStack.push(resume);
                    System.out.println("Resume added.");

                    break;

                case 7:

                    if (!resumeStack.isEmpty()) {

                        String removed = resumeStack.pop();
                        System.out.println("Removed resume: " + removed);

                    } else {

                        System.out.println("No resumes to undo.");
                    }

                    break;

                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);
            }
        }
    }
}