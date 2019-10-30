package sample.Teacher;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.Student.TestsStudent;
import sample.Student.ResultTestWindow;
import sample.Teacher.TeacherProfile.TeacherProfile;


public class TestEditor extends Application {
    private static Button button23, button20;
    private static Label label1,label2;

    private final Label sysMenuLabel = new Label("Using System Menu");

    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }



    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Testor 0.0.0 TEST EDITOR");

        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(20);
        vbox.setPrefSize(900, 500);
        final MenuBar menuBar = new MenuBar();






        label1 = new Label();
        label2 = new Label();

        Button button1 = new Button("Вернуться назад");
        button1.setOnAction(e ->{
            label1.getScene().getWindow().hide();
            TeacherProfile.display();
        });





        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20,20,20,20));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(button1, 50,28);
        grid.getChildren().addAll(button1,label1,label2);

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
        menu2.getItems().addAll(menu2Button);
        menu2Button.setOnAction(e ->{
            label1.getScene().getWindow().hide();
            //FirstPage.display();
        });

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
        primaryStage.show();
    }
}
