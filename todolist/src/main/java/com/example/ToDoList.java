package com.example;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class ToDoList extends Application {
    @Override
    public void start(Stage stage) {
        TextField taskField = new TextField();
        taskField.setPromptText("Enter your task");
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");
        ListView<String> taskList = new ListView<>();
        ObservableList<String> tasks = FXCollections.observableArrayList();
        taskList.setItems(tasks);
        addButton.setOnAction(e -> {
            String task = taskField.getText();
            if (!task.isEmpty()) {
                tasks.add(task);
                taskField.clear();
            }
        });
        deleteButton.setOnAction(e -> {
            int selectedIndex =
                    taskList.getSelectionModel().getSelectedIndex();
            if (selectedIndex != -1) {
                tasks.remove(selectedIndex);
            }
        });
        HBox buttons = new HBox(10);
        buttons.getChildren().addAll(addButton, deleteButton);
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));

        root.getChildren().addAll(
                new Label("JavaFX To-Do List"),
                taskField,
                buttons,
                taskList
        );
        Scene scene = new Scene(root, 400, 450);
        stage.setTitle("JavaFX To-Do List");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
