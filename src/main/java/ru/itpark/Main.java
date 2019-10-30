package ru.itpark;

import ru.itpark.domain.Manager;
import ru.itpark.util.JDBCTemplate;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite")){
//            try (Statement statement = connection.createStatement()) {
//                try (ResultSet resultSet = statement.executeQuery("SELECT id, name, salary FROM managers")) {
//                    List<Manager> managers = new ArrayList<>();
//                    while (resultSet.next()) {
//                        int id = resultSet.getInt("id");
//                        String name = resultSet.getString("name");
//                        int salary = resultSet.getInt("salary");
//                        managers.add(new Manager(id, name, salary));
//                    }
//                    for (Manager manager : managers) {
//                        System.out.println(manager);
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
        final List<Manager> managers = JDBCTemplate.executeQuery(
                "jdbc:sqlite:db.sqlite",
                "SELECT id, name, salary FROM managers",
                rs -> new Manager(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("salary")
                )
        );
        for (Manager manager : managers) {
            System.out.println(manager);
        }
    }
}
