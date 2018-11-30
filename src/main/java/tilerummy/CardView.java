package tilerummy;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;

import javafx.scene.control.Button;

@SuppressWarnings("restriction")
public class CardView extends Button{
    public CardView(Tile t)
    {

        String colour = t.getColor();
        int number = t.getNumber();
        String numberInString = String.valueOf(number);
        this.setText(numberInString);
        if(colour == "R")
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(214,21,21); -fx-text-fill: rgb(255,255,255);");

        }
        else if(colour == "B")
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(0,0,0); -fx-text-fill: rgb(255,255,255);");
        }
        else if(colour == "G")
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(57,209,43); -fx-text-fill: rgb(255,255,255);");
        }
        else if(colour == "O")
        {
            this.setStyle("-fx-font: 22 arial; -fx-base: rgb(244,111,9); -fx-text-fill: rgb(255,255,255);");
        }
        this.setPrefSize(50, 40);


    }

}