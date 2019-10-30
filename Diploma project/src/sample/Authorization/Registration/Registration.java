package sample.Authorization.Registration;

import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import sample.Authorization.DatabaseHandler;
import sample.Authorization.User;
import sample.Other.About;
import sample.SecondPage;
import sample.Authorization.Login.Login;


public class Registration extends Application {


    private static Label label0,label1,label2,label3,label4,label5,label6,label7;



    private final Label sysMenuLabel = new Label("Using System Menu");



    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }
    private static void showAlertWithoutHeaderText() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Warning alert");
        alert.setHeaderText(null);
        alert.setContentText("The Battery is low!");

        alert.showAndWait();
    }
    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("/Icons/icons-exit.png"));
        primaryStage.setTitle("Testor 0.0.0 Register");

        // GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        //  int width = gd.getDisplayMode().getWidth();
        // int height = gd.getDisplayMode().getHeight();

        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(5);
        vbox.setPrefSize(400,400);
        final MenuBar menuBar = new MenuBar();

        DatabaseHandler dbHandler = new DatabaseHandler();

        TextField ageInput1 = new TextField();
        TextField ageInput2 = new TextField();
        TextField ageInput3 = new TextField();
        TextField ageInput4 = new TextField();
        TextField ageInput5 = new TextField();
        TextField ageInput6 = new TextField();
        TextField ageInput7 = new TextField();

        label0 = new Label("Регистрация");
        label1 = new Label("Фамилия:");
        label2 = new Label("Имя:");
        label3 = new Label("Отчество:");
        label4 = new Label("Номер группы:");
        label5 = new Label("Логин:");
        label6 = new Label("Пароль:");
        label7 = new Label("Повторите пароль:");


        Button button1 = new Button("Зарегистрироваться");
        button1.setOnAction(event ->{
            User newUser;
            if(!(ageInput1.getText().equals("")&&
                ageInput2.getText().equals("")&&
                ageInput3.getText().equals("")&&
                ageInput4.getText().equals("")&&
                ageInput5.getText().equals(""))) {

            newUser = new User(ageInput1.getText(),
                    ageInput2.getText(),
                    ageInput3.getText(),
                    ageInput4.getText(),
                    ageInput5.getText());

        }else {
            newUser = null;
        }
            dbHandler.signUpUser(newUser);
            SecondPage.display();
        });

        Button button2 = new Button("Вернуться назад");
        button2.setOnAction(e ->{
            label0.getScene().getWindow().hide();
            Login.display();
        });


        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(3,0,0,1));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(label0, 3,1);

        GridPane.setConstraints(label1, 2,2);
        GridPane.setConstraints(label2, 2,3);
        GridPane.setConstraints(label3, 2,4);
        GridPane.setConstraints(label4, 2,5);
        GridPane.setConstraints(label5, 2,6);
        GridPane.setConstraints(label6, 2,7);
        GridPane.setConstraints(label7, 2,8);

        GridPane.setConstraints(ageInput1, 3,2);
        GridPane.setConstraints(ageInput2, 3,3);
        GridPane.setConstraints(ageInput3, 3,4);
        GridPane.setConstraints(ageInput4, 3,5);
        GridPane.setConstraints(ageInput5, 3,6);
        GridPane.setConstraints(ageInput6, 3,7);
        GridPane.setConstraints(ageInput7, 3,8);

        GridPane.setConstraints(button1, 3,9);
        GridPane.setConstraints(button2, 3,10);


        grid.getChildren().addAll(ageInput1,ageInput2,ageInput3,ageInput4,ageInput5,ageInput6,ageInput7,
                                  button1,button2,
                                  label0,label1,label2,label3,label4,label5,label6,label7);

        Menu menu2 = new Menu("Help");
        MenuItem menu1Button = new MenuItem("Справка");
        MenuItem menu2Button = new MenuItem("О программе");
        menu2.getItems().addAll(menu1Button,menu2Button);
        menu1Button.setOnAction(e ->{
           //  About.display();
        });
        menu2Button.setOnAction(e ->{
            About.display();
        });
        menuBar.getMenus().addAll(menu2);

        vbox.getChildren().addAll(menuBar,grid);


        primaryStage.setScene(new Scene(vbox));
        primaryStage.setMaximized(true);
        primaryStage.fullScreenProperty();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
