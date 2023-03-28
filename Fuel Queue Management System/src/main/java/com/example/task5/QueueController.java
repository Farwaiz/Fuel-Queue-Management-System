package com.example.task5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class QueueController extends Pump {
    @FXML
    private Label welcomeText;


    @FXML
    protected void onHelloButtonClick() throws IOException {
        String details="";
        details+="Queue 1\n";
        for (int c = 0; c < 6; c++) {
            details+=show(1,c)+"\n";
        }
        details+="Queue 2\n";
        for (int c = 0; c < 6; c++) {
            details+=show(2,c)+"\n";
        }
        details+="Queue 3\n";
        for (int c = 0; c < 6; c++) {
            details+=show(3,c)+"\n";
        }
        details+="Queue 4\n";
        for (int c = 0; c < 6; c++) {
            details+=show(4,c)+"\n";
        }
        details+="Queue 5\n";
        for (int c = 0; c < 6; c++) {
            details+=show(5,c)+"\n";
        }
        welcomeText.setText(details);
    }
}