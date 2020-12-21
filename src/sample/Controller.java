package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Line;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;


public class Controller implements Initializable {

    @FXML
    ImageView cerebellum;
    @FXML
    ImageView bridge;
    @FXML
    ImageView frontal;
    @FXML
    ImageView parietal;
    @FXML
    ImageView occipital;
    @FXML
    ImageView medulla;
    @FXML
    ImageView diencephalon;
    @FXML
    ImageView midbrain;
    @FXML
    ImageView thalamus;
    @FXML
    ImageView hypothalamus;
    @FXML
    AnchorPane pane;
    @FXML
    TableView table;
    @FXML
    TableColumn number;
    @FXML
    TableColumn titles;
    @FXML
    Label text;
    @FXML
    Button button;
    @FXML
    Button button2;
    @FXML
    ImageView one;
    @FXML
    ImageView two;
    @FXML
    ImageView three;
    @FXML
    ImageView four;
    @FXML
    ImageView five;
    @FXML
    ImageView six;
    @FXML
    ImageView seven;
    @FXML
    ImageView eight;
    @FXML
    ImageView nine;
    @FXML
    ImageView ten;
    @FXML
    Line line1;
    @FXML
    Line line2;
    @FXML
    Line line3;
    @FXML RadioButton ru_button;
    @FXML RadioButton en_button;

    //private final double cerebellum_height = 232.0;
    // private final double cerebellum_width = 193.0;

    private double lastXPosition, lastYPosition;
    private double orgTranslateX, orgTranslateY;
    private ArrayList<OnePuzzle> puzzles = new ArrayList();
    private ArrayList<ImageView> numbers = new ArrayList<>();
    Stage stage;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        //cerebellum.setOnMousePressed(circleOnMousePressedEventHandler);
        // cerebellum.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        // cerebellum.setOnMouseReleased(circleOnMouseReleasedEventHandler);
        table.setVisible(false);
        text.setVisible(false);
        button.setVisible(false);
        line1.setVisible(false);
        line2.setVisible(false);
        line3.setVisible(false);
        numbers.add(one);
        numbers.add(two);
        numbers.add(three);
        numbers.add(four);
        numbers.add(five);
        numbers.add(six);
        numbers.add(seven);
        numbers.add(eight);
        numbers.add(nine);
        numbers.add(ten);

        ToggleGroup group = new ToggleGroup();
        // установка группы
        ru_button.setToggleGroup(group);
        en_button.setToggleGroup(group);
        ru_button.setSelected(true);

        for (ImageView imageView : numbers) {
            imageView.setVisible(false);
        }
        ru_button.setTranslateY(ru_button.getTranslateY()+150); en_button.setTranslateY(en_button.getTranslateY()+150);


        ObservableList<String> langs = FXCollections.observableArrayList(
                "Таламус",
                "Мост",
                "Теменная доля",
                "Средний мозг",
                "Промежуточный мозг",
                "Продолговатый мозг",
                "Мозжечок",
                "Гипоталамус",
                "Затылочная доля",
                "Лобная доля");

        ObservableList<String> langs2 = FXCollections.observableArrayList(
                "Thalamus",
                "Bridge",
                "Parietal lobe",
                "Midbrain",
                "Diencephalon",
                "Medulla",
                "Cerebellum",
                "Hypothalamus",
                "Occipital lobe",
                "Frontal lobe");

        ObservableList<String> rightAnswers = FXCollections.observableArrayList(
                "Лобная доля",
                "Теменная доля",
                "Затылочная доля",
                "Мозжечок",
                "Продолговатый мозг",
                "Мост",
                "Средний мозг",
                "Гипоталамус",
                "Таламус",
                "Промежуточный мозг");

        ObservableList<String> rightAnswers2 = FXCollections.observableArrayList(
                "Frontal lobe",
                "Parietal lobe",
                "Occipital lobe",
                "Cerebellum",
                "Medulla",
                "Bridge",
                "Midbrain",
                "Hypothalamus",
                "Thalamus",
                "Diencephalon");

        // ComboBox<String> langsComboBox = new ComboBox<String>(langs);
        // langsComboBox.setValue("Java");

        ObservableList<Data> data = FXCollections.observableArrayList();
        for (int i = 0; i < langs.size(); i++) {
            data.add(new Data(i + 1, new ComboBox<String>(langs)));
            data.get(data.size() - 1).getVariants().setPrefWidth(titles.getPrefWidth());
        }
        // определяем фабрику для столбца с привязкой к свойству
        number.setCellValueFactory(new PropertyValueFactory<Data, String>("num"));
        titles.setCellValueFactory(new PropertyValueFactory<Data, Integer>("variants"));
        table.setItems(data);

        ru_button.setOnAction(event -> {
            text.setText("Отделы мозга");
            number.setText("№ отдела");
            titles.setText("Название");
            button.setText("Проверить ответы");
            data.clear();
            for (int i = 0; i < langs.size(); i++) {
                data.add(new Data(i + 1, new ComboBox<String>(langs)));
                data.get(data.size() - 1).getVariants().setPrefWidth(titles.getPrefWidth());
            }

        });

        en_button.setOnAction(event -> {
            text.setText("Parts of the brain");
            number.setText("Brain part number");
            titles.setText("Name");
            button.setText("Check answers");
            data.clear();
            for (int i = 0; i < langs.size(); i++) {
                data.add(new Data(i + 1, new ComboBox<String>(langs2)));
                data.get(data.size() - 1).getVariants().setPrefWidth(titles.getPrefWidth());
            }
        });

        OnePuzzle pariet = new OnePuzzle(parietal, 391, 440);
        setConditions(pariet, 710, 888, -322, -227, 782, -303);
        puzzles.add(pariet);

        OnePuzzle cerebel = new OnePuzzle(cerebellum, 327, 297);
        setConditions(cerebel, 1226, 1392, 385, 524, 1308, 457);
        puzzles.add(cerebel);

        OnePuzzle occipit = new OnePuzzle(occipital, 243, 363);
        setConditions(occipit, 889, 961, 144, 266, 913, 209);
        puzzles.add(occipit);

        OnePuzzle front = new OnePuzzle(frontal, 447, 512);
        setConditions(front, 800, 925, -301, -224, 848, -298);
        puzzles.add(front);

        OnePuzzle brid = new OnePuzzle(bridge, 131, 167);
        setConditions(brid, 813, 878, 393, 459, 837, 425);
        puzzles.add(brid);

        OnePuzzle med = new OnePuzzle(medulla, 218, 333);
        setConditions(med, 859, 944, -73, 12, 890, 5);
        puzzles.add(med);

        OnePuzzle dience = new OnePuzzle(diencephalon, 515, 333);
        setConditions(dience, 858, 1018, 41, 170, 937, 102);
        puzzles.add(dience);

        OnePuzzle mid = new OnePuzzle(midbrain, 202, 192);
        setConditions(mid, 334, 422, -261, -185, 381, -233);
        puzzles.add(mid);

        OnePuzzle th = new OnePuzzle(thalamus, 144, 151);
        setConditions(th, 412, 437, 210, 231, 425, 221);
        puzzles.add(th);

        OnePuzzle hypo = new OnePuzzle(hypothalamus, 131, 143);
        setConditions(hypo, 244, 263, -100, -76, 251, -91);
        puzzles.add(hypo);

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (isTestCompleted(data)) {
                    if (checkAnswers(data, rightAnswers) || checkAnswers(data, rightAnswers2)) {
                        //Close current
                         stage = (Stage) button.getScene().getWindow();
                        // do what you have to do
                        stage.close();
                        FXMLLoader fxmlLoader;
                        if (ru_button.isSelected())  fxmlLoader = new FXMLLoader(getClass().getResource("/sample/OK.fxml"));
                        else  fxmlLoader = new FXMLLoader(getClass().getResource("/sample/OK2.fxml"));
                        //Parent root1 = null;
                        try {
                            fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = fxmlLoader.getRoot();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root));
                        stage1.setTitle("Neuro Puzzle");
                       // primaryStage.setScene(new Scene(root, 1800, 875));
                        stage1.getIcons().add(new Image("resources/icon.png"));
                        stage1.setResizable(false);
                        stage1.setMaximized(true);
                        stage1.initModality(Modality.APPLICATION_MODAL);
                        stage1.showAndWait();
                    } else {
                         stage = (Stage) button.getScene().getWindow();
                        // do what you have to do
                        //stage.close();
                        FXMLLoader fxmlLoader;
                        if (ru_button.isSelected()) fxmlLoader = new FXMLLoader(getClass().getResource("/sample/Bad.fxml"));
                        else fxmlLoader = new FXMLLoader(getClass().getResource("/sample/Bad2.fxml"));
                        //Parent root1 = null;
                        try {
                            fxmlLoader.load();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Parent root = fxmlLoader.getRoot();
                        Stage stage1 = new Stage();
                        stage1.setScene(new Scene(root));
                        stage1.setTitle("Neuro Puzzle");
                        // primaryStage.setScene(new Scene(root, 1800, 875));
                        stage1.getIcons().add(new Image("resources/icon.png"));
                        stage1.setResizable(false);
                        stage1.setMaximized(true);
                        stage1.initModality(Modality.APPLICATION_MODAL);
                        stage1.showAndWait();

                    }

                }
            }
        });

    }

        private void setConditions(OnePuzzle onePuzzle,
                                   double left,
                                   double right,
                                   double top,
                                   double bottom,
                                   double neededX,
                                   double neededY) {
            AtomicInteger index = new AtomicInteger();
            ImageView image = onePuzzle.getImage();
            EventHandler<MouseEvent> circleOnMousePressedEventHandler =
                    t -> {
                        lastXPosition = t.getSceneX();
                        lastYPosition = t.getSceneY();
                        orgTranslateX = ((ImageView) (t.getSource())).getTranslateX();
                        orgTranslateY = ((ImageView) (t.getSource())).getTranslateY();
                        index.set(pane.getChildren().indexOf(image));
                        pane.getChildren().remove(image);
                        pane.getChildren().add(image);
                    };

            EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
                    t -> {
                        if (!onePuzzle.getCompleted()) {
                            double offsetX = t.getSceneX() - lastXPosition;
                            double offsetY = t.getSceneY() - lastYPosition;
                            double newTranslateX = orgTranslateX + offsetX;
                            double newTranslateY = orgTranslateY + offsetY;

                            ((ImageView) (t.getSource())).setTranslateX(newTranslateX);
                            ((ImageView) (t.getSource())).setTranslateY(newTranslateY);

                            if (image.getTranslateY() + image.getLayoutY() <= 0)
                                image.setTranslateY(-image.getLayoutY());
                            if (image.getTranslateY() + image.getLayoutY() >= pane.getHeight() - onePuzzle.getHeight())
                                image.setTranslateY(pane.getHeight() - onePuzzle.getHeight() - image.getLayoutY());
                            if (image.getTranslateX() + image.getLayoutX() >= pane.getWidth() - onePuzzle.getWidth())
                                image.setTranslateX(pane.getWidth() - onePuzzle.getWidth() - image.getLayoutX());
                            if (image.getTranslateX() + image.getLayoutX() <= 0)
                                image.setTranslateX(-image.getLayoutX());

                        } else {
                            image.setTranslateX(neededX);
                            image.setTranslateY(neededY);
                        }
                    };

            EventHandler<MouseEvent> circleOnMouseReleasedEventHandler =
                    t -> {
               // boolean first = onePuzzle.getImage().getTranslateY() >= top;
               // boolean second = onePuzzle.getImage().getTranslateY() <= bottom;
               // boolean third = onePuzzle.getImage().getTranslateX() >= left;
                //boolean fourth = cerebellum.getTranslateX() <= right;

                        if (image.getTranslateY() >= top &&
                                image.getTranslateY() <= bottom &&
                                image.getTranslateX() >= left &&
                                image.getTranslateX() <= right) {
                            image.setTranslateY(neededY);
                            image.setTranslateX(neededX);
                            onePuzzle.setCompleted();
                            if (gameDone()) {
                                table.setVisible(true); text.setVisible(true); button.setVisible(true);
                                line1.setVisible(true); line2.setVisible(true); line3.setVisible(true);
                                for (ImageView imageView: numbers) {
                                    imageView.setVisible(true);
                                }

                            }
                            //pane.getChildren().remove(image); pane.getChildren().add(index.intValue(),image);

                        }

                        //System.out.println(onePuzzle.getImage().getTranslateX() + " " + onePuzzle.getImage().getTranslateY());
                        pane.getChildren().remove(image);
                        pane.getChildren().add(index.intValue(),image);
                    };

            onePuzzle.getImage().setOnMousePressed(circleOnMousePressedEventHandler);
            onePuzzle.getImage().setOnMouseDragged(circleOnMouseDraggedEventHandler);
            onePuzzle.getImage().setOnMouseReleased(circleOnMouseReleasedEventHandler);
        }

        private boolean gameDone() {
            for (OnePuzzle onePuzzle : puzzles) {
                if (!onePuzzle.getCompleted()) return false;
            }
            return true;
        }

        private boolean isTestCompleted(ObservableList<Data> data) {
            for (Data d:data) {
                if (d.getVariants().getSelectionModel().isEmpty()) return false;
            }
            return true;
        }

        private boolean checkAnswers(ObservableList<Data> answers, ObservableList<String> right_answers) {

                for (int i=0;i<right_answers.size();i++) {
                    if (!answers.get(i).getVariants().getSelectionModel().getSelectedItem().equals(right_answers.get(i))) return false;
                }

            return true;
        }

    public void ttt(ActionEvent actionEvent) {
        Stage stage1 = (Stage)button2.getScene().getWindow();
        stage1.close();

       // stage.show();
    }
}
