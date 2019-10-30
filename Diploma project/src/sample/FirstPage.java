package sample;

import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import sample.SecondPage;
import javafx.scene.control.ContentDisplay;
import java.lang.String;
import javafx.geometry.Insets;
import javafx.geometry.Pos;





public class FirstPage extends Application {

    private static Button button23, button20,button2;
    private static Label label0,label1,label2,label3,label4,label5,label6,label7,label8;


    private final Label sysMenuLabel = new Label("Using System Menu");



    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
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





       // ChoiceBox<Folder> choiceBox1 = new ChoiceBox<String>();


        Button button1 = new Button("Зарегистрироваться");
        button1.setOnAction(e ->{
            label1.getScene().getWindow().hide();
          //  NewUser.display();
        });

        Button button2 = new Button("Переход на 2 окно");
        button2.setOnAction(e ->{
            label7.getScene().getWindow().hide();

         //   if ((ageInput6.getText().equals("admin"))&&(ageInput7.getText().equals("1")))
            //    FirstWinAdmin.display();
         //   else{
                label1.getScene().getWindow().hide();
                SecondPage.display();
           // }

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


        grid.getChildren().addAll(ageInput1,ageInput2,ageInput3,ageInput4,ageInput5,ageInput6,ageInput7,button1,label0,label1,label2,label3,label4,label5,label6,label7);

        // Sub menus for Options->Submenu 1
        MenuItem menu111 = new MenuItem("blah");
        final MenuItem menu112 = new MenuItem("foo");
        final CheckMenuItem menu113 = new CheckMenuItem("Show \"foo\" item");
        menu113.setSelected(true);
        menu113.selectedProperty().addListener((Observable valueModel) -> {
            menu112.setVisible(menu113.isSelected());
        });
        // Options->Submenu 1 submenu
        Menu menu01 = new Menu("Submenu 1");
        menu01.getItems().addAll(menu111, menu112, menu113);

        // Options->Submenu 2 submenu
        MenuItem menu121 = new MenuItem("Item 1");
        MenuItem menu122 = new MenuItem("Item 2");
        Menu menu02 = new Menu("Submenu 2");
        menu02.getItems().addAll(menu121, menu122);

        // Options->Change Text
        final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu03 = new MenuItem(change[0]);
        menu03.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu03.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu03.getText().equals(change[0]) ? change[1] : change[0];
            menu03.setText(menuText);
        });

        // Options menu
        Menu menu1 = new Menu("Options");
        menu1.getItems().addAll(menu01, menu02, menu03);
        menuBar.getMenus().addAll(menu1);


        Menu menu2 = new Menu("Help");
        MenuItem menu3Button = new MenuItem("?");
        MenuItem menu2Button = new MenuItem("About");
        menu2.getItems().addAll(menu2Button,menu3Button);
        menu2Button.setOnAction(e ->{
           // About.display();
        });
        menu3Button.setOnAction(e ->{
            //      PuzzlePiecesApp.();
        });
        menuBar.getMenus().addAll(menu2);

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
            hbox.getChildren().addAll(sysMenuLabel, button23);
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
        primaryStage.setMaximized(false);
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
       // primaryStage.initStyle(StageStyle.U);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}