/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackv2;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author s1601378
 */
public class BlackJackV2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        KorttiPakka pakka = new KorttiPakka(1);
        System.out.println(pakka);

        PelaajanKasi pelaajanKasi = new PelaajanKasi();
        PelaajanKasi tietokoneAvustajanKasi = new PelaajanKasi();

        primaryStage.setTitle("BlackJack Peli!");

        //luodaan GridPane objekti, asetetaan muuttujaan nimeltä grid
        GridPane grid = new GridPane();
        //muutetaan oletussijainti (vasen yläkulma) -> keskelle ruutua
        grid.setAlignment(Pos.CENTER);

        //gap ominaisuudet määrittävät välin rivien ja sarakkeiden välillä
        grid.setHgap(10);
        grid.setVgap(10);

        //kontrolloi tyhjää tilaa GridPanen reunojen ympärillä
        //järjestyksessä ylä reuna, oikea reuna, ala reuna ja vasen reuna
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Luo Text objektin (jota ei voi editoida) asettaa muuttujaan scenetitle tekstin "Welcome"
        Text scenetitle = new Text("Tervetuloa pelaamaan");
        //Käytetään setFont() metodia, ja asetetaan  fontti perhe (font family), lihavointi/painotus (weight), ja fontin koon scenetitle muuttujalle
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));//Style sheet parempi kuin inline tyyli
        //Lisääs scenetitle muuttujan Gridiin
        /*
         Numerointi sarakkeille ja riveille alkaa nollasta (0) ja scenetitle lisätään sarakkeeseen 0 ja riville 0
        The last two arguments of the grid.add() method set the sarake väli (column span) kakkoseksi (2) ja rivivälin (row span) ykköseksi (1).
        
         */
        grid.add(scenetitle, 0, 0, 2, 1);

        /*
        Tehdään Label objekti tekstillä "User Name" sarakkeeseen nolla (0), riville yksi (1) Text Field objekti, jota voi editoida.
        text field lisätään grid paneen sarakkeeseen (1), riville yksi (1).
        A password field and label are created and added to the grid pane in a similar fashion.
         */
        Label pelaajanKortitLabel = new Label("Pelaajan kortit:");
        grid.add(pelaajanKortitLabel, 2, 1);

        TextArea pelaajanKortitTextArea = new TextArea();
        pelaajanKortitTextArea.setEditable(false);
        pelaajanKortitTextArea.setPrefHeight(300);
        pelaajanKortitTextArea.setPrefWidth(200);
        grid.add(pelaajanKortitTextArea, 2, 2);
        Label pelaajanKorttienSumma = new Label("Korttien summa: " + pelaajanKasi.selvitaSumma());
        grid.add(pelaajanKorttienSumma, 2, 3);

        Label tietokoneenKortitLabel = new Label("Tietokoneen kortit:");
        grid.add(tietokoneenKortitLabel, 0, 1);

        TextArea tietokoneAvustajanKortit = new TextArea();
        tietokoneAvustajanKortit.setEditable(false);
        tietokoneAvustajanKortit.setPrefHeight(300);
        tietokoneAvustajanKortit.setPrefWidth(200);
        grid.add(tietokoneAvustajanKortit, 0, 2);
        Label tietokoneAvustajanKorttienSumma = new Label("Korttien summa: " + tietokoneAvustajanKasi.selvitaSumma());
        grid.add(tietokoneAvustajanKorttienSumma, 0, 3);
        //Luo napin nimellä btn ja labelillä "Sign in"
        Button lisaaKorttiButton = new Button("Lisää kortti");
        Button lopetaButton = new Button("Lopeta");

        //Luo HBox layout pane nimeltään hbBtn with spacing of 10 pixels
        HBox hbBtn = new HBox(10);

        int kortteja = 0;
        while (kortteja < 2) {

            Kortti jaettuKortti = pakka.jaaKortti();
            pelaajanKasi.otaKortti(jaettuKortti);
            pelaajanKortitTextArea.appendText(jaettuKortti + "\n");

            if (pelaajanKasi.selvitaSumma() < 21) {
                lisaaKorttiButton.setVisible(true);
            } else {
                lisaaKorttiButton.setVisible(false);
                lisaaKorttiButton.setDisable(true);
                pelaajanKorttienSumma.setText("Loppusumma: " + pelaajanKasi.selvitaSumma());
            }
            kortteja++;
        }

        /*
            The HBox pane sets an alignment for the button that is different from the alignment applied to the other controls in the grid pane.
            The alignment property has a value of Pos.BOTTOM_RIGHT, which positions a node at the bottom of the space vertically and at the right edge of the space horizontally. 
         */
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        //The button is added as a child of the HBox pane, and the HBox pane is added to the grid in column 2, row 4
        hbBtn.getChildren().add(lopetaButton);
        hbBtn.getChildren().add(lisaaKorttiButton);
        grid.add(hbBtn, 2, 4);

        lisaaKorttiButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Kortti lisaKortti = pakka.jaaKortti();
                pelaajanKasi.otaKortti(lisaKortti);
                pelaajanKortitTextArea.appendText(lisaKortti + "\n");

                pelaajanKorttienSumma.setText("Korttien summa: " + pelaajanKasi.selvitaSumma());

                if (pelaajanKasi.selvitaSumma() < 21) {
                    lisaaKorttiButton.setVisible(true);
                } else {
                    lisaaKorttiButton.setVisible(false);
                    lisaaKorttiButton.setDisable(true);
                    pelaajanKorttienSumma.setText("Loppusumma: " + pelaajanKasi.selvitaSumma());

                    while (tietokoneAvustajanKasi.selvitaSumma() < 15) {
                        Kortti avustajalleJaettuKortti = pakka.jaaKortti();
                        tietokoneAvustajanKasi.otaKortti(avustajalleJaettuKortti);
                        tietokoneAvustajanKortit.appendText(avustajalleJaettuKortti + "\n");
                        tietokoneAvustajanKorttienSumma.setText("Korttien summa: " + tietokoneAvustajanKasi.selvitaSumma());
                    }
                    tietokoneAvustajanKorttienSumma.setText("Loppu summa: " + tietokoneAvustajanKasi.selvitaSumma());
                }
                System.out.println("Pelaajan summa: " + pelaajanKasi.selvitaSumma());
            }
        }
        );

        lopetaButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                lisaaKorttiButton.setDisable(true);
                lisaaKorttiButton.setVisible(false);

            }
        });

        pelaajanKorttienSumma.setText("Korttien summa: " + pelaajanKasi.selvitaSumma());

        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
