package sample.Teacher.TeacherProfile;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Authorization.Login.Login;
import sample.Student.StudentRecommendations;
import sample.Student.TestsStudent;
import sample.Teacher.AcademicAttendance;
import sample.Teacher.AcademicPerfomance;
import sample.Teacher.TeacherRecommend;
import sample.Teacher.TestEditor;

import java.util.Optional;

public class TeacherProfile extends Application {
    private static Label label0,label1,label2,label3,label4,label5;
    private static void showConfirmationOnExit() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выйти из профиля");
        alert.setHeaderText("Вы уверены,что хотите выйти из профиля?");
        alert.setContentText("");

        Optional<ButtonType> option = alert.showAndWait();

        if(option.get() == null) {
            label0.setText("Не выбрано!");
        } else if (option.get() == ButtonType.OK) {
            label2.getScene().getWindow().hide();
            Login.display();
        } else if (option.get() == ButtonType.CANCEL) {
        }

    }


    private final Label sysMenuLabel = new Label("Using System Menu");

    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }



    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Testor 0.0.0 Teacher Profile");

        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(20);
        vbox.setPrefSize(900, 500);
        final MenuBar menuBar = new MenuBar();






        label1 = new Label();
        label2 = new Label();
        label3 = new Label();
        label4 = new Label();
        label5 = new Label();

        Button button1 = new Button("Редактор теста");
        button1.setOnAction(e ->{
            label1.getScene().getWindow().hide();
            TestEditor.display();
        });

        Button button2 = new Button("Тесты");
        button2.setOnAction(e ->{
            label2.getScene().getWindow().hide();
           // TestsStudent.display();
        });

        Button button3 = new Button("Создать рекомендацию");
        button3.setOnAction(e ->{
            label3.getScene().getWindow().hide();
            TeacherRecommend.display();
        });

        Button button4 = new Button("Расчет успеваемости студентов");
        button4.setOnAction(e ->{
            label4.getScene().getWindow().hide();
            AcademicPerfomance.display();
        });

        Button button5 = new Button("Расчет посещения студентов");
        button5.setOnAction(e ->{
            label5.getScene().getWindow().hide();
            AcademicAttendance.display();
        });




        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(label1, 29,6);
        GridPane.setConstraints(button1, 50,28);
        GridPane.setConstraints(button2, 50,30);
        GridPane.setConstraints(button3, 51,30);
        GridPane.setConstraints(button4, 52,30);
        GridPane.setConstraints(button5, 53,30);
        grid.getChildren().addAll(button1,button2,button3,button4,button5,label1,label2,label3,label4,label5);

        // Sub menus for Options->Submenu 1
        MenuItem menu111 = new MenuItem("blah");
        final MenuItem menu112 = new MenuItem("foo");
        final CheckMenuItem menu113 = new CheckMenuItem("Show \"foo\" item");
        menu113.setSelected(true);
        menu113.selectedProperty().addListener((Observable valueModel) -> {
            menu112.setVisible(menu113.isSelected());
        });
        // Options->Submenu 1 submenu
        /*final String INFO = "C:/Users/HP/IdeaProjects/kursovoiproject/src/Безымянный.png";
        final Image INFO_MENU_IMAGE =
                new Image(getClass().getResourceAsStream(INFO));*/
        Menu menu11 = new Menu("Submenu 1");
        menu11.getItems().addAll(menu111, menu112, menu113);
        // Options->Submenu 2 submenu
        MenuItem menu121 = new MenuItem("Item 1");
        MenuItem menu122 = new MenuItem("Item 2");
        Menu menu12 = new Menu("Submenu 2");
        menu12.getItems().addAll(menu121, menu122);

        // Options->Change Text
        final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu13 = new MenuItem(change[0]);
        menu13.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu13.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu13.getText().equals(change[0]) ? change[1] : change[0];
            menu13.setText(menuText);
        });

        // Options menu

        Menu menu2 = new Menu("Back");
        MenuItem menu2Button = new MenuItem("Home");
        menu2Button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                showConfirmationOnExit();
            }
        });
        menu2.getItems().addAll(menu2Button);

        menuBar.getMenus().addAll(menu2);
        Menu menu1 = new Menu("Options");
        menu1.getItems().addAll(menu11, menu12, menu13);
        menuBar.getMenus().addAll(menu1);

        Menu menu3 = new Menu("Help");
        MenuItem menu3Button = new MenuItem("About");
        menu3.getItems().addAll(menu3Button);
        menu3Button.setOnAction(e ->{
            //  About.display();
        });
        menuBar.getMenus().addAll(menu3);


        if (os != null && os.startsWith("Mac")) {
            Menu systemMenuBarMenu = new Menu("MenuBar Options");

            final String check = "Use System Menu Bar (Only works on Mac)";
            final CheckMenuItem useSystemMenuBarCB = new CheckMenuItem(check);
            useSystemMenuBarCB.setSelected(true);
            BooleanProperty selectedCB = useSystemMenuBarCB.selectedProperty();
            menuBar.useSystemMenuBarProperty().bindBidirectional(selectedCB);
            systemMenuBarMenu.getItems().add(useSystemMenuBarCB);

            menuBar.getMenus().add(systemMenuBarMenu);

            HBox hbox = new HBox();
            hbox.setAlignment(Pos.CENTER);
            sysMenuLabel.setStyle("-fx-font-size: 24");
            hbox.getChildren().addAll(sysMenuLabel);
            vbox.getChildren().add(hbox);
            sysMenuLabel.setVisible((menuBar.getHeight() == 0));
            ChangeListener<? super Number> heightListener =
                    (ObservableValue<? extends Number> ov,
                     Number old, Number now) -> {
                        sysMenuLabel.setVisible((menuBar.getHeight() == 0));
                    };
            menuBar.heightProperty().addListener(heightListener);
        }

        vbox.getChildren().addAll(menuBar,grid);


        primaryStage.setScene(new Scene(vbox));
        primaryStage.setMaximized(true);
        primaryStage.show();

    }
}
