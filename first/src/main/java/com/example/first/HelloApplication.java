package com.example.first;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.io.IOException;

import static java.lang.Integer.parseInt;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Font font = new Font("arial", 27);
        Label lblFirstNo = new Label("First Number");
        Label lblSecondNo = new Label("Second Number");
        Label lblResult = new Label("Result");

        TextField tfFirstno = new TextField();
        TextField tfSecondno = new TextField();
        TextField tfResult = new TextField();

        Button btnadd = new Button("add");
        Button btnclear = new Button("clear");

        Text txt = new Text("Simple Calculator");
        txt.setFont(font);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setStyle("-fx-background-color:lightblue");
        grid.addRow(0, txt);
        grid.addRow(1, lblFirstNo, tfFirstno);
        grid.addRow(2, lblSecondNo, tfSecondno);
        grid.addRow(3, lblResult, tfResult);
        grid.addRow(4, btnadd, btnclear);

        Label entertxt = new Label("Enter Text");
        entertxt.setFont(font);
        TextField newText = new TextField("");
        newText.setPromptText("Bahir dar University Institute of Technology");
        Button addText = new Button("Add Text");
        GridPane grid1 = new GridPane();
        grid1.setHgap(10);
        grid1.setVgap(10);
        grid1.addColumn(0, entertxt,newText,addText);

        Label color = new Label("Color");
        color.setFont(font);
        RadioButton redbtn = new RadioButton("Red");
        redbtn.setTextFill(Color.RED);
        RadioButton greenbtn = new RadioButton("Green");
        greenbtn.setTextFill(Color.GREEN);
        RadioButton bluebtn = new RadioButton("Blue");
        bluebtn.setTextFill(Color.BLUE);
        RadioButton boldbtn = new RadioButton("Bold");
        RadioButton italicbtn = new RadioButton("Italic");


        VBox vbox = new VBox(color,redbtn,greenbtn,bluebtn,boldbtn,italicbtn);
        vbox.setStyle("-fx-background-color:lightblue");
        ToggleGroup group = new ToggleGroup();
        redbtn.setToggleGroup(group);
        greenbtn.setToggleGroup(group);
        bluebtn.setToggleGroup(group);
        boldbtn.setToggleGroup(group);
        italicbtn.setToggleGroup(group);

        TextArea txtarea = new TextArea();


        addText.setOnAction(new EventHandler<ActionEvent>() {
                                @Override
                                public void handle(ActionEvent actionEvent) {
                                    txtarea.setText(newText.getText());
                                }
                            }
        );
        group.selectedToggleProperty().addListener((ObservableValue<? extends Toggle> ov, Toggle t, Toggle t1) -> {
            if (redbtn.isSelected()){
                txtarea.setStyle("-fx-text-fill:red;");
            }
            else if(greenbtn.isSelected()){
                txtarea.setStyle("-fx-text-fill:green;");
            }
            else{
                txtarea.setStyle("-fx-text-fill:blue;");
            }
        });
         btnadd.setOnAction(e ->{
             int x = parseInt(tfFirstno.getText());
             int y = parseInt(tfSecondno.getText());
             int sum = x+y;
             tfResult.setText(Integer.toString(sum));
         });

        btnclear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent t){
                tfFirstno.clear();
                tfSecondno.setText("");
                tfResult.clear();
            }
        });
        HBox root = new HBox();

        Scene scene = new Scene(root,640,280);

        root.getChildren().addAll(grid,grid1,vbox,txtarea);
        stage.setScene(scene);
        stage.setTitle("First javafx lab");
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
}
