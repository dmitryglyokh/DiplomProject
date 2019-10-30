package sample.Other;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import JavaFxUtils.MyImageUtils;
import javafx.scene.control.Label;
import javafx.scene.control.*;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import sample.Authorization.Registration.Registration;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.FlowPane;





public class About extends Application {


    private static Label label0,label1,label2,label3,label4;


    private final Label sysMenuLabel = new Label("Using System Menu");



    @Override
    public void start(Stage primaryStage) throws Exception {
        display();
    }
    public static void display (){
        Stage primaryStage = new Stage();
        primaryStage.getIcons().add(new Image("/Icons/icons помощь.png"));
        primaryStage.setTitle("О программе");


        final String os = System.getProperty("os.name");
        VBox vbox = new VBox(5);
        vbox.setPrefSize(300,150);
        final MenuBar menuBar = new MenuBar();


        label0 = new Label("Регистрация");
        label1 = new Label("Copyright by");
        label2 = new Label("Автор:");
        label3 = new Label("Dmitry Glyokh");
        label4 = new Label("HyperLink");

        Image newImage = MyImageUtils.getImage("/Icons/icons undefined.png");
        label0.setGraphic(new ImageView(newImage));

//        Hyperlink hyperlink = new Hyperlink("Go to Eclipse home page");
//
//        hyperlink.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent event) {
//                getHostServices().showDocument("https://eclipse.org");
//            }
//        });

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(0,0,0,2));
        grid.setVgap(5);
        grid.setHgap(2);


        GridPane.setConstraints(label0, 2,1);
        GridPane.setConstraints(label1, 2,2);
        GridPane.setConstraints(label2, 2,3);
        GridPane.setConstraints(label3, 2,4);
        GridPane.setConstraints(label4, 2,5);
//        GridPane.setConstraints(hyperlink, 2,6);

        grid.getChildren().addAll(label0,label1,label2,label3,label4);


        vbox.getChildren().addAll(grid);

        primaryStage.setScene(new Scene(vbox));
        primaryStage.resizableProperty().setValue(Boolean.FALSE);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
