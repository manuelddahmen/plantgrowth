/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * This file is part of Plants-Growth-2
 *     Plants-Growth-2 is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     Plants-Growth-2 is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with Plants-Growth-2.  If not, see <http://www.gnu.org/licenses/>.
 */

package be.manudahmen.growth;

import be.manudahmen.growth.audio.SoundProductionSystem;
import javafx.application.Application;
import javafx.event.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import javax.sound.sampled.LineUnavailableException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class App extends Application {
    private Slider slider;
    private SoundProductionSystem soundProductionSystem;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        soundProductionSystem = new SoundProductionSystem();
        Parent root = null;
        try {
            URL location = new File("C:\\Users\\Line\\IdeaProjects\\Plants-2.0\\src\\java\\main\\be\\manudahmen\\growth\\AppSound.fxml").toURL();
            assert location != null;
            FXMLLoader fxmlLoader = new FXMLLoader(location);
            root = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(root, 300, 275);

        Button[] buttons = new Button[16];

        HBox[] pane = new HBox[2];
        pane[0] = new HBox();
        pane[1] = new HBox();

        BorderPane bl = new BorderPane();

        bl.setTop(pane[0]);
        bl.setCenter(pane[1]);

        String[] notes = new String[]{
                "do", "re", "mi", "fa", "sol", "la", "si", "do",
                "do#", "re#", "--", "fa#", "sol#", "la#", "--", "do#"};


        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new Button(notes[i]);
            buttons[i].setLayoutX(100 + i * 30);
            buttons[i].setLayoutY(150 + (i >= 8 ? 30 : 0));
            buttons[i].setId("Button" + i);
            buttons[i].setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    playNote(event.getSource());
                }
            });
            pane[i < 8 ? 0 : 1].getChildren().add(buttons[i]);
        }


        VBox vBox = new VBox();

        RadioButton radioButton = new RadioButton();
        radioButton.setText("Sine");
        vBox.getChildren().add(radioButton);
        radioButton = new RadioButton();
        radioButton.setText("Square");
        vBox.getChildren().add(radioButton);
        radioButton = new RadioButton();
        radioButton.setText("Triangle");
        vBox.getChildren().add(radioButton);
        radioButton = new RadioButton();
        radioButton.setText("Sawtooth");
        vBox.getChildren().add(radioButton);


        bl.setLeft(vBox);


        slider = new Slider();
        slider.setMin(1);
        slider.setMin(10);
        slider.setValue(4);
        slider.setMinorTickCount(1);
        slider.setAccessibleText("Octaves");

        bl.setRight(slider);

        Scene scene1 = new Scene(bl);

        primaryStage.setTitle("FXML Welcome");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private void playNote(Object source) {
        String note;
        note = "";
        switch (((Button) source).getId()) {
            case "do"://DO
                note = "C";
                break;
            case "re"://RE
                note = "D";
                break;
            case "mi"://MI
                note = "E";
                break;
            case "fa"://FA
                note = "F";
                break;
            case "sol"://SOL
                note = "G";
                break;
            case "la"://LA
                note = "A";
                break;
            case "si"://SI
                note = "B";
                break;
        }
        try {
            soundProductionSystem.playNote(soundProductionSystem.equiv(
                    "" + note + "" + (int) slider.getValue()), 1000.0f,
                    SoundProductionSystem.Waveform.SIN);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

    }

}

