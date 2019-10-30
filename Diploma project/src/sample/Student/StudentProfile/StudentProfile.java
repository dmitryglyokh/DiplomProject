package sample.Student.StudentProfile;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import sample.Other.About;
import java.util.Optional;



public class StudentProfile extends Application {
    private static Label label0,label1,label2;
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
        primaryStage.setTitle("Testor 0.0.0 Student Profile");

        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(20);
        vbox.setPrefSize(900, 500);
        final MenuBar menuBar = new MenuBar();

        label1 = new Label();
        label2 = new Label();

        Button button1 = new Button("Рекомендации");
        button1.setOnAction(e ->{
            label1.getScene().getWindow().hide();
            StudentRecommendations.display();
        });

        Button button2 = new Button("Тесты");
        button2.setOnAction(e ->{
            label2.getScene().getWindow().hide();
            TestsStudent.display();
        });


        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(label1, 29,6);
        GridPane.setConstraints(button1, 50,28);
        GridPane.setConstraints(button2, 50,30);
        grid.getChildren().addAll(button1,button2,label1,label2);

        // Sub menus for Options->Submenu 1
        MenuItem menu111 = new MenuItem("blah");
        final MenuItem menu112 = new MenuItem("foo");
        final CheckMenuItem menu113 = new CheckMenuItem("Show \"foo\" item");
        menu113.setSelected(true);
        menu113.selectedProperty().addListener((Observable valueModel) -> {
            menu112.setVisible(menu113.isSelected());
        });

        Menu menu11 = new Menu("Submenu 1");
        menu11.getItems().addAll(menu111, menu112, menu113);
        // Options->Submenu 2 submenu
        MenuItem menu121 = new MenuItem("Item 1");
        MenuItem menu122 = new MenuItem("Item 2");
        Menu menu12 = new Menu("Submenu 2");
        menu12.getItems().addAll(menu121, menu122);

        // Options->Мои тесты
        MenuItem menu13 = new MenuItem("Мои тесты");
        menu13.setAccelerator(KeyCombination.keyCombination("Shortcut+T"));
        menu13.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TestsStudent.display();
            }

        });

        // Options menu
        Menu menu2 = new Menu("Back");
        MenuItem menu2Button = new MenuItem("Выйти из профиля");
        menu13.setAccelerator(KeyCombination.keyCombination("Shortcut+E"));
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
              About.display();
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
