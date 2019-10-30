package sample.Authorization.Login;

import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.geometry.Insets;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.stage.StageStyle;
import sample.Authorization.Registration.Registration;
import sample.Other.About;





public class Login extends Application {


    private static Label label0;


    private final Label sysMenuLabel = new Label("Using System Menu");



    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }
    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("/Icons/icons undefined.png"));
      //  primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Testor 0.0.0 Login");





        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(5);
        vbox.setPrefSize(400,400);
        final MenuBar menuBar = new MenuBar();

//        Stage visibleStage = new Stage();
//        visibleStage.initOwner(primaryStage);
//        visibleStage.getIcons().add(new Image("/Icons/icons помощь.png"));
//        visibleStage.setScene (new Scene("/Authorization/Login/Login.java"));
//        visibleStage.setOnHidden(e -> Platform.runLater(primaryStage::hide));
//        visibleStage.show();

        TextField ageInput1 = new TextField();
        TextField ageInput2 = new TextField();

        label0 = new Label("Войти");

        CheckBox saveprofile = new CheckBox("Save Profile");
        saveprofile.setSelected(true);

        // ChoiceBox<Folder> choiceBox1 = new ChoiceBox<String>();

        Button button1 = new Button("Войти");
        button1.setOnAction(event ->{
            String loginText = ageInput1.getText().trim();
            String passwordText = ageInput2.getText().trim();

            if(!loginText.equals("") && !passwordText.equals(""))
                loginUser(loginText, passwordText);
            else
                    System.out.println("Логин и пароль пусты!");
        });

        Button button2 = new Button("Зарегистрироваться");
        button2.setOnAction(e ->{
            label0.getScene().getWindow().hide();
              Registration.display();
        });


        final Label sysMenuLabel = new Label("Using System Menu");


        GridPane grid = new GridPane();
        grid.setPadding(new Insets(3,0,0,1));
        grid.setVgap(8);
        grid.setHgap(10);

        GridPane.setConstraints(label0, 12,8);
        GridPane.setConstraints(ageInput1, 12,9);
        GridPane.setConstraints(ageInput2, 12,10);
        GridPane.setConstraints(saveprofile, 12,11);
        GridPane.setConstraints(button1, 12,12);
        GridPane.setConstraints(button2, 12,20);

        grid.getChildren().addAll(ageInput1,ageInput2,button1,button2,label0,saveprofile);

        // Options menu
        Menu menu1 = new Menu("Help");
        MenuItem menu1Button = new MenuItem("Справка");
        MenuItem menu2Button = new MenuItem("О программе");
        menu1.getItems().addAll(menu1Button,menu2Button);
        menu1Button.setOnAction(e ->{
            //      PuzzlePiecesApp.();
        });
        menu2Button.setOnAction(e ->{
             About.display();
        });

        menuBar.getMenus().addAll(menu1);

//        if (os != null && os.startsWith("Mac")) {
//            Menu systemMenuBarMenu = new Menu("MenuBar Options");
//
//            final String check = "Use System Menu Bar (Only works on Mac)";
//            final CheckMenuItem useSystemMenuBarCB = new CheckMenuItem(check);
//            useSystemMenuBarCB.setSelected(true);
//            BooleanProperty selectedCB = useSystemMenuBarCB.selectedProperty();
//            menuBar.useSystemMenuBarProperty().bindBidirectional(selectedCB);
//            systemMenuBarMenu.getItems().add(useSystemMenuBarCB);
//
//            menuBar.getMenus().add(systemMenuBarMenu);
//
//            HBox hbox = new HBox();
//            hbox.setAlignment(Pos.CENTER);
//            sysMenuLabel.setStyle("-fx-font-size: 24");
//            hbox.getChildren().addAll(sysMenuLabel);
//            vbox.getChildren().add(hbox);
//            sysMenuLabel.setVisible((menuBar.getHeight() == 0));
//            ChangeListener<? super Number> heightListener =
//                    (ObservableValue<? extends Number> ov,
//                     Number old, Number now) -> {
//                        sysMenuLabel.setVisible((menuBar.getHeight() == 0));
//                    };
//            menuBar.heightProperty().addListener(heightListener);
//        }

        vbox.getChildren().addAll(menuBar,grid);

        primaryStage.setScene(new Scene(vbox));
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
    }

    private static void loginUser(String loginText, String passwordText) {

    }

    public static void main(String[] args) {
        launch(args);
    }
}
