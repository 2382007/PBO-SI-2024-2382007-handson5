import java.util.Scanner;

public class Main {
    public static String[] todos = new String[3];
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("BEFORE DELETEE");
        addTodoList("Mewarnai");
        addTodoList("Membaca");
        addTodoList("Bersepeda");
        addTodoList("Berkhotbah");
        showTodoList();
        editTodoList(3, "Bekerja");
        removeTodoList(3);
        System.out.println("AFTER DELETE");
        showTodoList();
    }


    public static void showTodoList() {
        System.out.println("TODO LIST");
        for (int i = 0; i < todos.length; i++) {
            String todo = todos[i];
            if (todo != null) {
                System.out.println((i + 1) + ". " + todo);
            }
        }
    }

    public static void addTodoList(String todo) {
        isArrayFull();
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                todos[i] = todo;
                break;
            }
        }
    }

    public static void resizeFull() {
        Boolean isFull = true;
        isFull = isArrayFull();
        if (isFull) {

        }
    }

    public static boolean isArrayFull() {
        for (int i = 0; i < todos.length; i++) {
            if (todos[i] == null) {
                return false;
            }
        }
        return true;
    }

    public static void resizeArrayToTwoTimeBigger() {
        String[] temp = todos;
        todos = new String[todos.length * 2];
        for (int i = 0; i < todos.length; i++) {
            todos[i] = temp[i];
        }
    }
    public static boolean removeTodoList(Integer number){
        if (isSelectedTodoNotValid(number)){
            return false;
        }
        for (int i = number - 1; i < todos.length; i++){
            if (i == (todos.length)){
                todos[i] = null;
            } else {
                todos[i] = todos [i + 1];
            }
        }
        return true;
    }
    public static boolean isSelectedTodoNotValid(Integer number){
        if (number <= 0){
            return true;
        }
        if (number -1 > todos.length - 1){
            return true;
        }
        if (todos[number - 1] == null){
            return true;
        }
        return false;
    }
    public static boolean editTodoList(Integer number, String newTodo){
        if (isSelectedTodoNotValid(number)){
            return false;
        }
        todos[number - 1] = newTodo;
        return true;
    }

}

