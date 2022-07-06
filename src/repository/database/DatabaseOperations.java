package repository.database;

import entity.Task;
import service.imp.TaskService;
import service.verification.ValueCheck;
import java.sql.*;

public class DatabaseOperations {

    public void connectionTest() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = Connector.getConnection()) {
                connection.isClosed();
            }
        } catch (Exception e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void addTask(Task task) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = Connector.getConnection()) {
                String query = "INSERT INTO tasks (name, description, status) VALUES (?, ?, ?)";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, task.getName());
                preparedStatement.setString(2, task.getDescription());
                preparedStatement.setString(3, task.getStatus());
                preparedStatement.execute();
            }
        } catch (Exception e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void updateTask(String inputName, int pick) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = Connector.getConnection()) {
                ValueCheck valueCheck = new ValueCheck();
                String query;
                String name;
                String description;
                String status;

                if (pick == 1) {
                    query = "UPDATE tasks SET name = ? WHERE name = ?";
                    System.out.println("Enter new name");
                    name = valueCheck.checkString();

                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, inputName);
                    preparedStatement.execute();
                } else if (pick == 2) {
                    query = "UPDATE tasks SET description = ? WHERE name = ?";
                    System.out.println("Enter new description");
                    description = valueCheck.checkString();

                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, description);
                    preparedStatement.setString(2, inputName);
                    preparedStatement.execute();

                } else if (pick == 3) {
                    query = "UPDATE tasks SET status = ? WHERE name = ?";
                    status = TaskService.chooseStatus();

                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, status);
                    preparedStatement.setString(2, inputName);
                    preparedStatement.execute();

                } else if (pick == 4) {
                    query = "UPDATE tasks SET name = ?, description = ?, status = ? WHERE name = ?";
                    System.out.println("Enter new name");
                    name = valueCheck.checkString();
                    System.out.println("Enter new description");
                    description = valueCheck.checkString();
                    status = TaskService.chooseStatus();

                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    preparedStatement.setString(1, name);
                    preparedStatement.setString(2, description);
                    preparedStatement.setString(3, status);
                    preparedStatement.setString(4, inputName);
                    preparedStatement.execute();
                } else {
                    System.out.println("Invalid input");
                }
            }
        } catch (Exception e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void removeTask(String inputName) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = Connector.getConnection()) {
                String query = "DELETE FROM tasks WHERE name = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, inputName);
                int rows = preparedStatement.executeUpdate();
                System.out.println("Rows removed: " + rows);
            }
        } catch (Exception e){
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void removeAllTasks(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection connection = Connector.getConnection()) {
                String query = "DELETE FROM tasks";

                Statement statement = connection.createStatement();
                int taskNumber = statement.executeUpdate(query);
                System.out.println("Number of tasks removed: " + taskNumber);
            }
        } catch (Exception e) {
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void showTask(String inputName){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = Connector.getConnection()){
                String query = "SELECT * FROM tasks WHERE name = ?";

                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, inputName);
                ResultSet resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    System.out.println(new Task(id, name, description, status));
                }
            }
        } catch (Exception e){
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

    public void showAllTasks(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection connection = Connector.getConnection()){
                String query = "SELECT * FROM tasks";

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);

                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name = resultSet.getString(2);
                    String description = resultSet.getString(3);
                    String status = resultSet.getString(4);
                    System.out.println(new Task(id, name, description, status));
                }
            }
        } catch (Exception e){
            System.out.println("Connection failed...");
            e.printStackTrace();
        }
    }

}
