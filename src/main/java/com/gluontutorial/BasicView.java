package com.gluontutorial;

import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class BasicView extends View {
    
    static ObservableList<String> chList = FXCollections.observableArrayList();

    public BasicView(String name) {
        super(name);
        
        Label label = new Label("Hello JavaFX World!");

        Button button = new Button("Change the World!");
        button.setGraphic(new Icon(MaterialDesignIcon.LANGUAGE));
        button.setOnAction(e -> label.setText("Hello JavaFX Universe!"));
        
        for (int i = 1; i <= 44; i++) {
            String str = Integer.toString(i);
            chList.add(str);
        }
        
        ComboBox chapter = new ComboBox(chList);
        chapter.setPrefWidth(110);
        //chapter.getStyleClass().add(qNumber);
        chapter.setPromptText("Chapter");
        
        VBox controls = new VBox(15.0, label, button , chapter);
        controls.setAlignment(Pos.CENTER);
        
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> System.out.println("Menu")));
        appBar.setTitleText("Basic View");
        appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }
    
}
