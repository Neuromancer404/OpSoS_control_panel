package com.example.opsos_control_panel;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private ImageView imageView;

    @FXML private Canvas canvas ;

    private GraphicsContext gc ;
    @FXML
    void initialize() {
        canvas.setOnMouseClicked(event -> {
            clickHandler(event.getX(), event.getY());
        });

        doCanvasWork();
    }

    private void clickHandler(double x, double y) {
        String imagePath = "dot.png";
        Image image = new Image(imagePath);
        gc.drawImage(image, x+15, y-15, x-(15+x), y+(15-y));
    }

    private void doCanvasWork() {
        gc = canvas.getGraphicsContext2D();

        String imagePath = "map.png";
        Image image = new Image(imagePath);
        gc.drawImage(image, 0, 0, 1100, 850);
    }
}