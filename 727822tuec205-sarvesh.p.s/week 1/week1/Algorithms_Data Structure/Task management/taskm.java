class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    public Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.next = null;
    }
}

class TaskLinkedList {
    private Task head;

    public void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        if (head == null) {
            head = newTask;
        } else {
            Task current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newTask;
        }
    }

    public void deleteTask(int taskId) {
        if (head == null) return;

        if (head.taskId == taskId) {
            head = head.next;
            return;
        }

        Task current = head;
        while (current.next != null && current.next.taskId != taskId) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public Task searchTask(int taskId) {
        Task current = head;
        while (current != null) {
            if (current.taskId == taskId) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void traverseTasks() {
        Task current = head;
        while (current != null) {
            System.out.println("Task ID: " + current.taskId + ", Name: " + current.taskName + ", Status: " + current.status);
            current = current.next;
        }
    }
}

public class taskm {
    public static void main(String[] args) {
        TaskLinkedList taskList = new TaskLinkedList();

        taskList.addTask(1, "Design UI", "Pending");
        taskList.addTask(2, "Develop Backend", "In Progress");
        taskList.addTask(3, "Write Tests", "Pending");

        System.out.println("All Tasks:");
        taskList.traverseTasks();

        System.out.println("\nSearching for Task ID 2:");
        Task found = taskList.searchTask(2);
        if (found != null) {
            System.out.println("Found: " + found.taskName + " - " + found.status);
        } else {
            System.out.println("Task not found.");
        }

        System.out.println("\nDeleting Task ID 1...");
        taskList.deleteTask(1);

        System.out.println("\nAll Tasks After Deletion:");
        taskList.traverseTasks();
    }
}
