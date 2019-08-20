/*
Anmol Nagpal (Sheridan)
 */

package nbaplayersdatabase;

import content.Controller;
import content.Player;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {

    private Label title = new Label("NBA Player Search");
    private final Label mainTitle = new Label("THE LEAGUE");
    private BorderPane pane = new BorderPane();
    private TextField sf = new TextField();
    private Button btnContinue = new Button("CONTINUE");
    private Button btnSearch = new Button("SEARCH");
    private Button btnClear = new Button("CLEAR");
    private Button btnClose = new Button("CLOSE");
    private Label pName = new Label();
    private Label pPPG = new Label();
    private Label pAPG = new Label();
    private Label pRPG = new Label();
    private Label pBPG = new Label();
    private Label pSPG = new Label();
    private Label pSzn = new Label();
    private Label pFgP = new Label();
    private Label pTpP = new Label();
    private Label pFtP = new Label();
    private Label pTo = new Label();
    private Label pMpg = new Label();
    private Label author = new Label("ANMOL NAGPAL");
    private Label rights = new Label("2019 ALL RIGHTS RESERVED");
    private Label version = new Label("VOLUME 1.0");
    private ImageView imageView;
    private HBox hBox = new HBox();
    private HBox hBoxBottom = new HBox();
    private HBox hBoxCenter = new HBox();
    private VBox vBox = new VBox();
    private boolean isCompare = false;
    private final int STAGE_X = 710;
    private final int SCREENINCREASEAMOUNT = 260;
    private int screenY = 500;
    private int screenX = STAGE_X;
    Scene scene = new Scene(pane, screenX, screenY);
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double displayWidth;

    @Override  
    public void start(Stage primaryStage) {
        mainScreen();
        btnContinue.setOnAction(g -> {
            hBoxCenter.getChildren().clear(); //get rid of main screen
            hBox.getChildren().clear(); //get rid of main screen
            hBoxBottom.getChildren().remove(btnContinue);//get rid of main screen
            createPane();
        });
        btnSearch.setOnAction(new AddPlayer(primaryStage));
        btnClear.setOnAction(g -> {
            hBoxCenter.getChildren().clear();
            screenX = STAGE_X;
            primaryStage.setWidth(screenX);
            sf.requestFocus();
        });
        
        scene.getStylesheets().add("style/MainStyle.css");
        primaryStage.setTitle("The League");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }
    
    public void mainScreen(){
        VBox VBoxMain = new VBox();
        mainTitle.setId("main-title");
        btnContinue.setId("continue");
        imageView = new ImageView(new Image("images/img1.PNG"));
        imageView.setFitWidth(687.5);
        imageView.setFitHeight(104);
        VBoxMain.getChildren().add(imageView);
        imageView = new ImageView(new Image("images/img2.PNG"));
        imageView.setFitWidth(550);
        imageView.setFitHeight(83);
        VBoxMain.getChildren().add(imageView);
        imageView = new ImageView(new Image("images/img3.PNG"));
        imageView.setFitWidth(440);
        imageView.setFitHeight(66);
        VBoxMain.getChildren().add(imageView);
        imageView = new ImageView(new Image("images/img4.PNG"));
        imageView.setFitWidth(352);
        imageView.setFitHeight(53);
        VBoxMain.getChildren().add(imageView);
        imageView = new ImageView(new Image("images/img5.PNG"));
        imageView.setFitWidth(282);
        imageView.setFitHeight(42);
        VBoxMain.getChildren().add(imageView);
        imageView = new ImageView(new Image("images/img6.PNG"));
        imageView.setFitWidth(226);
        imageView.setFitHeight(34);
        VBoxMain.getChildren().add(imageView);
        hBox.getChildren().addAll(mainTitle);
        hBoxCenter.getChildren().addAll(VBoxMain);
        author.setId("author");
        rights.setId("rights");
        hBoxBottom.getChildren().addAll(author, rights, btnContinue);
        hBoxBottom.setSpacing(40);
        hBoxBottom.setId("footer");
        pane.setTop(hBox);
        pane.setCenter(hBoxCenter);
        pane.setBottom(hBoxBottom);
    }

    public void createPane() {
        hBoxBottom.getChildren().add(version);
        hBox.getChildren().addAll(title, sf, btnSearch, btnClear);
        hBox.setSpacing(10);
        hBox.setPadding(new Insets(15, 12, 15, 12));
        hBoxCenter.setSpacing(20);
        pane.setTop(hBox);
        title.setId("searchTitle");
        hBox.setId("header");
        btnSearch.setId("search");
        btnClear.setId("clear");
        title.setId("title");
        displayWidth = Math.sqrt((screenSize.getWidth()*screenSize.getWidth()) - 
                (screenSize.getHeight()*screenSize.getHeight()));

    }

    public class AddPlayer implements EventHandler<ActionEvent> {
 
        private Stage stage;
        public AddPlayer(Stage stage) {
            this.stage = stage;
        }

        @Override
        public void handle(ActionEvent e) {
            try {
                Player player = Controller.findPlayer(sf.getText());
                Controller.setPlayerStats(player);
                vBox = new VBox();
                vBox.setSpacing(10);
                btnClose = new Button("CLOSE");
                btnClose.setId("close");
                pPPG = new Label("PPG: " + player.getPpg());
                pAPG = new Label("APG: " + player.getApg());
                pRPG = new Label("RPG: " + player.getRpg());
                pBPG = new Label("BPG: " + player.getBpg());
                pSPG = new Label("SPG: " + player.getSpg());
                pFgP = new Label("FG%: " + player.getFgP() + "%");
                pTpP = new Label("3P%: " + player.getTpP() + "%");
                pFtP = new Label("FT%: " + player.getFtP() + "%");
                pTo = new Label("TO: " + player.getTo());
                pMpg = new Label("MPG: " + player.getMpg());
                pSzn = new Label(player.getTitle());
                imageView = new ImageView(new Image(player.getSource()));
                imageView.setFitHeight(159);
                imageView.setFitWidth(220);
                HBox hBoxA = new HBox(pPPG, pRPG, pAPG);
                HBox hBoxB = new HBox(pSPG, pBPG, pTo);
                HBox hBoxC = new HBox(pFgP, pTpP, pFtP);
                hBoxA.setSpacing(13);
                hBoxB.setSpacing(13);
                hBoxC.setSpacing(10);
                vBox.getChildren().addAll(pSzn, imageView, hBoxA, hBoxB, hBoxC,
                        pMpg, btnClose);
                hBoxCenter.getChildren().add(vBox);
                
                pane.setCenter(hBoxCenter);
                if (hBoxCenter.getChildren().size() > 3) {
                    if(displayWidth >= screenX + SCREENINCREASEAMOUNT * 2){
                        screenX += SCREENINCREASEAMOUNT;
                        this.stage.setWidth(screenX);
                    }else{
                        Alert dlgWarning = new Alert(Alert.AlertType.WARNING);
                        dlgWarning.setTitle("WARNING");
                        dlgWarning.setHeaderText("MAXIMUM NUMBER OF PLAYERS ADDED");
                        dlgWarning.setContentText("Please click the 'close' or "
                                + " 'clear' button if you wish to add another "
                                + " player.");
                        dlgWarning.show();
                        hBoxCenter.getChildren().remove(hBoxCenter.getChildren().size() - 1);
                    }
                }
                btnClose.setOnAction(g -> {
                    if (hBoxCenter.getChildren().size() > 3){
                        screenX -= SCREENINCREASEAMOUNT;
                        this.stage.setWidth(screenX);
                    }
                    Node source = (Node) g.getSource();
                    hBoxCenter.getChildren().remove(source.getParent());
                    sf.requestFocus();
                });
                sf.clear();
                sf.requestFocus();
                
            } catch (MalformedURLException | IllegalArgumentException | NoSuchElementException f) {
                Alert dlgError = new Alert(Alert.AlertType.ERROR);
                dlgError.setTitle("Error");
                dlgError.setHeaderText("NO PLAYER FOUND");
                dlgError.show();

                vBox = new VBox();
            } catch (IOException f) {
                Alert dlgError = new Alert(Alert.AlertType.ERROR);
                dlgError.setTitle("Error");
                dlgError.setHeaderText("NO PLAYER FOUND");
                dlgError.show();
                vBox = new VBox();
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
