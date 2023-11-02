package com.example.mult3;

import javafx.animation.AnimationTimer;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

public class HelloController {

    @FXML
    private Button startDec;

    @FXML
    private TextField textVal;
    @FXML
    TextArea area1;

    LinkedBlockingQueue<String> buffer = new LinkedBlockingQueue<>();

    SimpleIntegerProperty value= new SimpleIntegerProperty(0);

    public void initialize(){
      //  textVal.textProperty().bindBidirectional(value, new DecimalFormat());

        value.addListener((observableValue, number, t1) -> {
            System.out.println("было "+number+" стало "+t1);
           // area1.appendText("\n"+"было "+number+" стало "+t1);
            buffer.add("было "+number+" стало "+t1);
        });

        AnimationTimer at = new AnimationTimer() {
            @Override
            public void handle(long l) {
                textVal.setText(String.valueOf(value.get()));
                List<String> lines = new ArrayList<>();
                buffer.drainTo(lines);
                for (String s: lines) {
                    area1.appendText("\n"+s);
                }
            }
        } ;
        at.start();
    }

    @FXML
    void onStartDec(ActionEvent event) {
        Summator sum = new Summator(value, -1, 15, 200);
        sum.start();
    }

    @FXML
    void onStartInc(ActionEvent event) {
        Summator sum = new Summator(value, 1, 10, 270);
        sum.start();
    }

}
