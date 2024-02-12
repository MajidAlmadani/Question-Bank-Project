package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.*;
import javafx.scene.control.ScrollPane;
import static java.lang.Integer.parseInt;

public class Main extends Application {
    public VBox getPaneForCreate(VBox pane,String[] newStrings) throws IOException {
        pane.getChildren().clear();
        pane.setPadding(new Insets(20));
        Label label = new Label("Enter the question:");
        TextField tf = new TextField();
        label.setStyle("-fx-font-weight: bold;");
        Label label1 = new Label("Enter first choice:");
        TextField tf1 = new TextField();
        label1.setStyle("-fx-font-weight: bold;");
        Label label2 = new Label("Enter second choice:");
        TextField tf2 = new TextField();
        label2.setStyle("-fx-font-weight: bold;");
        Label label3 = new Label("Enter third choice:");
        TextField tf3 = new TextField();
        label3.setStyle("-fx-font-weight: bold;");
        Label label4 = new Label("Enter fourth choice:");
        TextField tf4 = new TextField();
        label4.setStyle("-fx-font-weight: bold;");
        Label label5 = new Label("Enter the number of the right answer:");
        label5.setStyle("-fx-font-weight: bold;");
        RadioButton firstChoiceRB = new RadioButton("1");
        RadioButton secondChoiceRB = new RadioButton("2");
        RadioButton thirdChoiceRB = new RadioButton("3");
        RadioButton fourthChoiceRB = new RadioButton("4");
        ToggleGroup group = new ToggleGroup();
        firstChoiceRB.setToggleGroup(group);
        secondChoiceRB.setToggleGroup(group);
        thirdChoiceRB.setToggleGroup(group);
        fourthChoiceRB.setToggleGroup(group);
        Button bt = new Button("Done");
        VBox vBox = new VBox(label,tf,label1,tf1,label2,tf2,label3,tf3,label4,tf4,label5,firstChoiceRB,secondChoiceRB,thirdChoiceRB,fourthChoiceRB,new Label(""),bt);
        pane.getChildren().addAll(vBox);
        final String[] correctAnswer = {"0"};
        firstChoiceRB.setOnAction(e -> {
            if (firstChoiceRB.isSelected()) {
                correctAnswer[0] = "1";
            }
        });
        secondChoiceRB.setOnAction(e -> {
            if (secondChoiceRB.isSelected()) {
                correctAnswer[0] = "2";
            }
        });
        thirdChoiceRB.setOnAction(e -> {
            if (thirdChoiceRB.isSelected()) {
                correctAnswer[0] = "3";
            }
        });
        fourthChoiceRB.setOnAction(e -> {
            if (fourthChoiceRB.isSelected()) {
                correctAnswer[0] = "4";
            }
        });
        bt.setOnAction(e-> {
            try {
                String[] string = {tf.getText(),tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(), correctAnswer[0]};
                String[] strings = new String[newStrings.length+6];
                for(int i=0;i<newStrings.length;i++){
                    strings[i] = newStrings[i];
                }
                for(int i= newStrings.length,j=0;i<strings.length;i++,j++){
                    strings[i] = string[j];
                }
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"))){
                    output.writeObject(strings);
                }
                getPane(pane);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });

        return pane;
    }
    public VBox getPaneForDelete(VBox pane,String[] strings){
        pane.getChildren().clear();
        pane.setPadding(new Insets(20));
        int numberOfQuestion = strings.length/6;
        Label label1 = new Label("Type the Number of the question that you want to delete there is "+numberOfQuestion+" Questions");
        label1.setStyle("-fx-font-weight: bold;");
        TextField tf = new TextField();
        Button bt = new Button("Done");
        VBox vBox = new VBox(label1,tf,new Label(""),bt);
        pane.getChildren().addAll(vBox);
        bt.setOnAction(e->{
            try {
                int deleteQuestion = parseInt(tf.getText())*6;
                String[] anotherStrings = new String[strings.length-6];
                deleteQuestion -= 6;
                for(int i=0,k=0;i< strings.length;i++){
                    if(i==deleteQuestion){
                        i+=6;
                    }
                    if(i == strings.length){
                        break;
                    }
                    anotherStrings[k++] = strings[i];
                }
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"))){
                    output.writeObject(anotherStrings);
                }
                getPane(pane);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });
        return pane;
    }
    public VBox getPaneForEditTheQuestion(VBox pane,String[] newStrings,int numberOfQuestionForEdit){
        pane.getChildren().clear();
        pane.setPadding(new Insets(20));
        Label label = new Label("Enter the question:");
        label.setStyle("-fx-font-weight: bold;");
        TextField tf = new TextField();
        Label label1 = new Label("Enter first choice:");
        label1.setStyle("-fx-font-weight: bold;");
        TextField tf1 = new TextField();
        Label label2 = new Label("Enter second choice:");
        label2.setStyle("-fx-font-weight: bold;");
        TextField tf2 = new TextField();
        Label label3 = new Label("Enter third choice:");
        label3.setStyle("-fx-font-weight: bold;");
        TextField tf3 = new TextField();
        Label label4 = new Label("Enter fourth choice:");
        label4.setStyle("-fx-font-weight: bold;");
        TextField tf4 = new TextField();
        Label label5 = new Label("Enter the number of the right answer:");
        label5.setStyle("-fx-font-weight: bold;");
        RadioButton firstChoiceRB = new RadioButton("1");
        RadioButton secondChoiceRB = new RadioButton("2");
        RadioButton thirdChoiceRB = new RadioButton("3");
        RadioButton fourthChoiceRB = new RadioButton("4");
        ToggleGroup group = new ToggleGroup();
        firstChoiceRB.setToggleGroup(group);
        secondChoiceRB.setToggleGroup(group);
        thirdChoiceRB.setToggleGroup(group);
        fourthChoiceRB.setToggleGroup(group);
        Button bt = new Button("Done");
        VBox vBox = new VBox(label,tf,label1,tf1,label2,tf2,label3,tf3,label4,tf4,label5,firstChoiceRB,secondChoiceRB,thirdChoiceRB,fourthChoiceRB,new Label(""),bt);
        pane.getChildren().addAll(vBox);
        final String[] correctAnswer = {"0"};
        firstChoiceRB.setOnAction(e -> {
            if (firstChoiceRB.isSelected()) {
                correctAnswer[0] = "1";
            }
        });
        secondChoiceRB.setOnAction(e -> {
            if (secondChoiceRB.isSelected()) {
                correctAnswer[0] = "2";
            }
        });
        thirdChoiceRB.setOnAction(e -> {
            if (thirdChoiceRB.isSelected()) {
                correctAnswer[0] = "3";
            }
        });
        fourthChoiceRB.setOnAction(e -> {
            if (fourthChoiceRB.isSelected()) {
                correctAnswer[0] = "4";
            }
        });
        bt.setOnAction(e->{
            try {
                String[] string = {tf.getText(),tf1.getText(),tf2.getText(),tf3.getText(),tf4.getText(),correctAnswer[0]};
                String[] strings = new String[newStrings.length];
                int questionEdit = (numberOfQuestionForEdit*6) - 6;
                for(int i=0;i<newStrings.length;i++){
                    strings[i] = newStrings[i];
                }
                for(int i=questionEdit,j=0;j<6;i++,j++){
                    strings[i] = string[j];
                }
                try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"))){
                    output.writeObject(strings);
                }
                getPane(pane);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });
        return pane;
    }
    public VBox getPaneForEdit(VBox pane,String[] strings){
        pane.getChildren().clear();
        pane.setPadding(new Insets(20));
        Label label1 = new Label("Type the Number of the question that you want to edit there is "+strings.length/6+" Questions: ");
        label1.setStyle("-fx-font-weight: bold;");
        TextField tf = new TextField();
        Button bt = new Button("Done");
        VBox vBox = new VBox(label1,tf,new Label(""),bt);
        pane.getChildren().addAll(vBox);
        bt.setOnAction(e->{
            int numberOfQuestionForEdit = parseInt(tf.getText());
            if(numberOfQuestionForEdit > 0 && numberOfQuestionForEdit <= strings.length/6){
                getPaneForEditTheQuestion(pane,strings,numberOfQuestionForEdit);
            }

        });
        return pane;
    }
    public VBox getPaneForView(VBox pane) throws IOException, ClassNotFoundException{
        pane.getChildren().clear();
        VBox vboxOfChoices = new VBox();
        ToggleGroup group = new ToggleGroup();
        String[] newStrings;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("QuestionBank.dat"))) {
            newStrings = (String[]) (input.readObject());
            String correctAnswer;
            for (int i = 0,j=0; i < newStrings.length; i += 6,j++) {
                Text text = new Text(newStrings[i]);
                RadioButton firstChoiceRB = new RadioButton(newStrings[i + 1]);
                RadioButton secondChoiceRB = new RadioButton(newStrings[i + 2]);
                RadioButton thirdChoiceRB = new RadioButton(newStrings[i + 3]);
                RadioButton fourthChoiceRB = new RadioButton(newStrings[i + 4]);
                HBox firstChoice = new HBox(firstChoiceRB);
                HBox secondChoice = new HBox(secondChoiceRB);
                HBox thirdChoice = new HBox(thirdChoiceRB);
                HBox fourthChoice = new HBox(fourthChoiceRB);
                correctAnswer = newStrings[i+5];
                text.setFont(Font.font("Comic Sans MS", FontWeight.BOLD, 16));
                Label label = new Label(" Correct Answer");
                label.setFont(new Font("Arial",14));
                label.setTextFill(Color.web("#ff0000", 0.8));
                if(parseInt(correctAnswer) == 1){
                    firstChoice.getChildren().add(label);
                }
                if(parseInt(correctAnswer) == 2){
                    secondChoice.getChildren().add(label);
                }
                if(parseInt(correctAnswer) == 3){
                    thirdChoice.getChildren().add(label);
                }
                if(parseInt(correctAnswer) == 4){
                    fourthChoice.getChildren().add(label);
                }
                firstChoiceRB.setToggleGroup(group);
                secondChoiceRB.setToggleGroup(group);
                thirdChoiceRB.setToggleGroup(group);
                fourthChoiceRB.setToggleGroup(group);
                vboxOfChoices.getChildren().addAll(text, firstChoice, secondChoice, thirdChoice, fourthChoice);
            }
        }
        catch(IOException e){
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"));
            String[] strings = {};
            output.writeObject(strings);
        }
        ScrollPane s = new ScrollPane();
        Button exitBtn = new Button("Exit");
        HBox hboxOfbottomButtons = new HBox(exitBtn);

        pane.setPadding(new Insets(20));
        pane.getChildren().addAll(hboxOfbottomButtons,vboxOfChoices);
        hboxOfbottomButtons.setAlignment(Pos.BOTTOM_RIGHT);
        vboxOfChoices.setAlignment(Pos.CENTER_LEFT);
        s.setContent(pane);
        exitBtn.setOnAction(e->{
            try {
                getPane(pane);
            } catch (ClassNotFoundException | IOException classNotFoundException) {
                classNotFoundException.printStackTrace();
            }
        });
        VBox vBox = new VBox();
        vBox.setPrefHeight(600);
        vBox.setPrefWidth(600.0);
        vBox.getChildren().add(s);
        return vBox;
    }
    public VBox getPane(VBox pane) throws ClassNotFoundException, IOException {
        pane.getChildren().clear();
        pane.setPrefWidth(600);
        pane.setPrefHeight(600);
        String[] newStrings;
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("QuestionBank.dat"))) {
            newStrings = (String[]) (input.readObject());
        }
        Button createBtn = new Button("Create a Question");
        Button deleteBtn = new Button("Delete a Question");
        Button editBtn = new Button("  Edit a Question  ");
        Button viewBtn = new Button("  View Questions  ");
        createBtn.setStyle("-fx-border-color: green");
        deleteBtn.setStyle("-fx-border-color: green");
        editBtn.setStyle("-fx-border-color: green");
        viewBtn.setStyle("-fx-border-color: green");
        HBox hboxOfbottomButtons = new HBox(createBtn, deleteBtn);
        HBox hboxOfbottomButtons1 = new HBox(editBtn,viewBtn);
        hboxOfbottomButtons.setSpacing(10);
        hboxOfbottomButtons1.setSpacing(12);
        VBox vBox = new VBox(hboxOfbottomButtons,hboxOfbottomButtons1);
        vBox.setSpacing(5);
        pane.getChildren().addAll(vBox);
        vBox.setPadding(new Insets(260,0,0,160));
        String[] finalNewStrings1 = newStrings;
        createBtn.setOnAction(e -> {
            try {
                getPaneForCreate(pane, finalNewStrings1);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        deleteBtn.setOnAction(e-> getPaneForDelete(pane,finalNewStrings1));
        editBtn.setOnAction(e-> getPaneForEdit(pane,finalNewStrings1));
        viewBtn.setOnAction(e->{
            try {
                getPaneForView(pane);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });
        return pane;
    }
    public VBox getPane() throws IOException, ClassNotFoundException {
        String[] newStrings = {};
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("QuestionBank.dat"))) {
            newStrings = (String[]) (input.readObject());
        }
        catch(IOException e){
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("QuestionBank.dat"));
        }
        Button createBtn = new Button("Create a Question");
        Button deleteBtn = new Button("Delete a Question");
        Button editBtn = new Button("  Edit a Question  ");
        Button viewBtn = new Button("  View Questions  ");
        createBtn.setStyle("-fx-border-color: green");
        deleteBtn.setStyle("-fx-border-color: green");
        editBtn.setStyle("-fx-border-color: green");
        viewBtn.setStyle("-fx-border-color: green");
        HBox hboxOfbottomButtons = new HBox(createBtn, deleteBtn);
        HBox hboxOfbottomButtons1 = new HBox(editBtn,viewBtn);
        hboxOfbottomButtons.setSpacing(10);
        hboxOfbottomButtons1.setSpacing(12);
        VBox vBox = new VBox(hboxOfbottomButtons,hboxOfbottomButtons1);
        vBox.setSpacing(5);
        vBox.setPadding(new Insets(300,0,0,180));
        String[] finalNewStrings1 = newStrings;
        createBtn.setOnAction(e -> {
            try {
                getPaneForCreate(vBox, finalNewStrings1);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        deleteBtn.setOnAction(e-> getPaneForDelete(vBox,finalNewStrings1));
        editBtn.setOnAction(e-> getPaneForEdit(vBox,finalNewStrings1));
        viewBtn.setOnAction(e->{
            try {
                getPaneForView(vBox);
            } catch (IOException | ClassNotFoundException ioException) {
                ioException.printStackTrace();
            }
        });
        return vBox;
    }
    public void start(Stage primaryStage) throws IOException, ClassNotFoundException {
        Scene scene = new Scene(getPane(),600,600);
        primaryStage.setTitle("Project");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}