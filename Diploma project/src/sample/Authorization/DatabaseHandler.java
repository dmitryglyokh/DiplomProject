package sample.Authorization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseHandler extends ConfigurationDB {
    Connection dbConnection;

    public Connection getDbConnection()
            throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":"
                +dbPort + "/" +dbName+dbTimeZone;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConnection = DriverManager.getConnection(connectionString,
                dbUser, dbPass);

        return dbConnection;
    }

    public void signUpUser(User user) {
       if(user != null){
           String insert = "INSERT INTO " + Const.STUDENTS_TABLE + "(" +
                   Const.STUDENT_NAME + "," + Const.STUDENT_SURNAME + "," +
                   Const.STUDENT_PATRONYMIC + "," + Const.STUDENT_LOGIN + "," +
                   Const.STUDENT_PASSWORD + ")" +
                   "VALUES(?,?,?,?,?)";

           try {
               PreparedStatement prSt = getDbConnection().prepareStatement(insert);
               prSt.setString(1, user.getName());
               prSt.setString(2, user.getSurname());
               prSt.setString(3, user.getPatronymic());
               prSt.setString(4, user.getLogin());
               prSt.setString(5, user.getPassword());

               prSt.executeUpdate();
           } catch (SQLException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }
       }
       else {
           System.out.println("пустой юзер");
       }

    }
}
