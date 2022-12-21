package com.example.opsos_control_panel;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ImageView imageView;
    private int pickH = 850;
    private int pickW = 1100;
    @FXML private Canvas canvas ;
    @FXML
    private TextField xCoordinates;

    @FXML
    private TextField yCoordinates;
    private GraphicsContext gc ;
    private ToggleGroup group = new ToggleGroup();
    @FXML
    void initialize() {
        type1.setToggleGroup(group);
        type2.setToggleGroup(group);
        type3.setToggleGroup(group);

        canvas.setOnMouseClicked(event -> {
            clickHandler(event.getX(), event.getY());
        });

        doCanvasWork();
    }
    @FXML
    private RadioButton type1;

    @FXML
    private RadioButton type2;

    @FXML
    private RadioButton type3;

    @FXML
    private TextArea description;
    private List<station> stationList = new ArrayList<>();
    @FXML
    void addItemToMap(MouseEvent event) {
        try{
            station st = new station();
            st.setDescription(description.getText());
            st.setX(Double.parseDouble(xCoordinates.getText()));
            st.setY(Double.parseDouble(yCoordinates.getText()));
            RadioButton selection = (RadioButton) group.getSelectedToggle();
            switch (selection.getText()){
                case "Макросота":
                    st.setType(1);
                    break;
                case "Микросота":
                    st.setType(2);
                    break;
                case "Пикосота":
                    st.setType(3);
                    break;
            }
            stationList.add(st);
            doCanvasWork();
        }
        catch (Exception ex){
            System.out.println(ex);
        }
    }


    private void clickHandler(double x, double y) {
        if(x<pickW && y< pickH){
            doCanvasWork();
            String imagePath = "dot.png";
            Image image = new Image(imagePath);
            gc.drawImage(image, x+15, y-15, x-(15+x), y+(15-y));
            xCoordinates.setText(String.valueOf(x));
            yCoordinates.setText(String.valueOf(y));
        }
    }

    private void doCanvasWork() {
        gc = canvas.getGraphicsContext2D();
        String imagePath = "map.png";
        Image image = new Image(imagePath);
        gc.drawImage(image, 0, 0, pickW, pickH);
        for(station st : stationList){
            clickHandler(st.getX(), st.getY(), true);
        }
    }

    private void clickHandler(double x, double y, boolean b) {
        if(x<pickW && y< pickH){
            String imagePath = "dot.png";
            Image image = new Image(imagePath);
            gc.drawImage(image, x+15, y-15, x-(15+x), y+(15-y));
            xCoordinates.setText(String.valueOf(x));
            yCoordinates.setText(String.valueOf(y));
        }
    }
}