package Practice14;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;

interface CalcIndicator {
    String CalcIndicatorLambda(ArrayList<SmallBusiness> array);
}

public class JavaFXButton extends Application {
    static ArrayList<SmallBusiness> shop = new ArrayList<>();
    static ArrayList<SmallBusiness> barber = new ArrayList<>();
    Label response;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage myStage){
        myStage.setTitle("Practice ¹14");
        FlowPane rootNode = new FlowPane(10,10);
        rootNode.setAlignment(Pos.CENTER);
        Scene myScene = new Scene(rootNode, 300, 100);
        myStage.setScene(myScene);
        response = new Label("Select an action!");

        Button buttonCreate = new Button("Create Objects");
        Button buttonPrint = new Button("Print Objects");
        Button buttonMax = new Button("Max Object");

        RadioButton listShopButton = new RadioButton("List Shop");
        RadioButton listBarberButton = new RadioButton("List BarberShop");

        // Create toggle group for radio buttons
        ToggleGroup group = new ToggleGroup();
        listShopButton.setToggleGroup(group);
        listBarberButton.setToggleGroup(group);
        listShopButton.setSelected(true);


        buttonCreate.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                if (listShopButton.isSelected()) {
                    for (int i = 0; i < 5; i++)
                        shop.add(new Shop());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Objects Created");
                    alert.setHeaderText(null);
                    alert.setContentText("Shop objects created in ArrayList");
                    alert.showAndWait();
                } else if (listBarberButton.isSelected()) {
                    for (int i = 0; i < 5; i++)
                        barber.add(new BarberShop());

                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Object Created");
                    alert.setHeaderText(null);
                    alert.setContentText("BarberShop objects created in ArrayList");
                    alert.showAndWait();
                }
            }
        }) ;

        buttonPrint.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String message = "";
                if (listShopButton.isSelected()) {
                    for (SmallBusiness obj : shop) {
                        message += obj.show() + "\n";
                    }
                } else {
                    for (SmallBusiness obj : barber) {
                        message += obj.show() + "\n";
                    }
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Objects");
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.showAndWait();
            }
        }) ;

        buttonMax.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String message = " ";
                if (barber.isEmpty() || shop.isEmpty()){
                    message = "ERROR! One of the lists is empty!";
                }   else {
                    // calculation of the calculated indicator using a lambda expression
                    CalcIndicator func = (ArrayList<SmallBusiness> arr) -> {
                        String fname = arr.get(0).getName();
                        int maxSfaff = arr.get(0).getCountStaff();
                        for (SmallBusiness obj : arr) {
                            if (obj.getCountStaff() >= maxSfaff) {
                                fname = obj.getName();
                                maxSfaff = obj.getCountStaff();
                            }
                        }
                        return fname;
                    };

                    // #1
                    message = "\nIndicator via block lambda (search among Shop): ";
                    message += func.CalcIndicatorLambda(shop);


                    //#2
                    MyCalcCountStaffLink obj = new MyCalcCountStaffLink();
                    message += "\n\nIndicator via a link to the method (search among BarberShop): ";
                    message += stringLambdaFunLink(obj::finName, barber);
                }

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("NameShop MaxStuff");
                alert.setHeaderText(null);
                alert.setContentText(message);
                alert.showAndWait();

            }
        });

        rootNode.getChildren().addAll(buttonCreate, buttonPrint, buttonMax, listShopButton, listBarberButton, response);
        myStage.show();
    }

    static String stringLambdaFunLink(CalcIndicator cl, ArrayList<SmallBusiness> array){
        return cl.CalcIndicatorLambda(array);
    }
}


class MyCalcCountStaffLink{
    String finName(ArrayList<SmallBusiness> arr){
        String fname = arr.get(0).getName();
        int maxSfaff = arr.get(0).getCountStaff();
        for (SmallBusiness obj: arr) {
            if (obj.getCountStaff() >= maxSfaff) {
                fname = obj.getName();
                maxSfaff = obj.getCountStaff();
            }
        }
        return fname;
    }
}