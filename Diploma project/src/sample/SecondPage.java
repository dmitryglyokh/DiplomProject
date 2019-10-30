package sample;

import JavaFxUtils.MyImageUtils;
import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Orientation;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.FlowPane;
import sample.Admin.AdminProfile.AdminProfile;
import java.lang.Boolean;


public class SecondPage extends Application {
    private static Button button23, button20;
    private static Label label1,label2;
    private static Spinner spinner1, spinner2;

    private final Label sysMenuLabel = new Label("Using System Menu");

    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }

    private static void showAlertWithoutHeaderText() {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Warning alert");
        alert.setHeaderText(null);
        alert.setContentText("The Battery is low!");

        alert.showAndWait();
    }


    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Testor 0.0.0 2 okno");

        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(20);
        final MenuBar menuBar = new MenuBar();

        TextField textField01 = new TextField();
        ObservableList<String> langs = FXCollections.observableArrayList();
        ListView<String> langsListView = new ListView<String>(langs);
        langsListView.setPrefSize(250, 150);

        Button addBtn = new Button("Add");
        Button deleteBtn = new Button("Delete");
        FlowPane buttonPane = new FlowPane(10, 10, textField01, addBtn, deleteBtn);

        addBtn.setOnAction(event -> langs.add(textField01.getText()));
        deleteBtn.setOnAction(event -> langs.remove(textField01.getText()));

        FlowPane root = new FlowPane(Orientation.VERTICAL, 10, 10, buttonPane, langsListView);


        label1 = new Label();

        Button button1 = new Button("Переход на 3 окно");
        button1.setOnAction(e ->{
            label1.getScene().getWindow().hide();
            AdminProfile.display();
        });




        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(buttonPane, 1,1);
        GridPane.setConstraints(label1, 29,6);
        GridPane.setConstraints(button1, 50,28);
        grid.getChildren().addAll(button1,label1,buttonPane,langsListView);

        // Sub menus for Options->Submenu 1
        MenuItem menu011 = new MenuItem("blah");
        final MenuItem menu012 = new MenuItem("foo");
        final CheckMenuItem menu113 = new CheckMenuItem("Show \"foo\" item");
        menu113.setSelected(true);
        menu113.selectedProperty().addListener((Observable valueModel) -> {
            menu012.setVisible(menu113.isSelected());
        });
        // Options->Submenu 1 submenu
        /*final String INFO = "C:/Users/HP/IdeaProjects/kursovoiproject/src/Безымянный.png";
        final Image INFO_MENU_IMAGE =
                new Image(getClass().getResourceAsStream(INFO));*/
        Menu menu01 = new Menu("Submenu 1");
        menu01.getItems().addAll(menu011, menu012, menu113);
        // Options->Submenu 2 submenu
        MenuItem menu021 = new MenuItem("Item 1");
        MenuItem menu022 = new MenuItem("Item 2");
        Menu menu02 = new Menu("Submenu 2");
        menu02.getItems().addAll(menu021, menu022);

        // Options->Change Text
        final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu03 = new MenuItem(change[0]);
        menu03.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu03.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu03.getText().equals(change[0]) ? change[1] : change[0];
            menu03.setText(menuText);
        });



      //  final String change[] = { "Change Text", "Change Back" };
        final SeparatorMenuItem separator = new SeparatorMenuItem();
        MenuItem menu04 = new MenuItem("menu04");
        menu04.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu04.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
         //       showAlertWithoutHeaderText();
            }
        });

        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu05 = new MenuItem("menu05");
        Image newImage = MyImageUtils.getImage("/Icons/icons-exit.png");
        menu05.setGraphic(new ImageView(newImage));
        menu05.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu05.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu05.getText().equals(change[0]) ? change[1] : change[0];
            menu05.setText(menuText);
        });


        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu06 = new MenuItem("menu06");
        menu06.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu06.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu06.getText().equals(change[0]) ? change[1] : change[0];
            menu06.setText(menuText);
        });


        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu07 = new MenuItem("menu07");
        menu07.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu07.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu07.getText().equals(change[0]) ? change[1] : change[0];
            menu07.setText(menuText);
        });

        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu08 = new MenuItem("menu08");
        menu08.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu08.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu08.getText().equals(change[0]) ? change[1] : change[0];
            menu08.setText(menuText);
        });

        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu09 = new MenuItem("menu09");
        menu09.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu09.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu09.getText().equals(change[0]) ? change[1] : change[0];
            menu04.setText(menuText);
        });

        //  final String change[] = { "Change Text", "Change Back" };
        final MenuItem menu10 = new MenuItem("menu10");
        menu10.setAccelerator(KeyCombination.keyCombination("Shortcut+C"));
        menu10.setOnAction((ActionEvent t) -> {
            final String menuText =
                    menu10.getText().equals(change[0]) ? change[1] : change[0];
            menu10.setText(menuText);
        });
        // Options menu

     //   Menu menu2 = new Menu("Back");
      //  MenuItem menu2Button = new MenuItem("Home");
      //  menu2.getItems().addAll(menu2Button);
      //  menu2Button.setOnAction(e ->{
      //      label1.getScene().getWindow().hide();
      //      FirstPage.display();
     //   });

      //  menuBar.getMenus().addAll(menu2);
        Menu menu1 = new Menu("Options");
        menu1.getItems().addAll(menu01, menu02, menu03,separator,menu04,menu05,menu06,menu07,menu08,menu09,menu10);
        menuBar.getMenus().addAll(menu1);

        Menu menu3 = new Menu("Help");
        MenuItem menu3Button = new MenuItem("About");
        MenuItem menu3Button2 = new MenuItem("Alert!");
        menu3.getItems().addAll(menu3Button,menu3Button2);
        menu3Button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        menu3Button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                showAlertWithoutHeaderText();
            }
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
        primaryStage.setMaximized(true);
        primaryStage.fullScreenProperty();
        primaryStage.show();
    }


}
