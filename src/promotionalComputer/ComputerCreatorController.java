/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promotionalComputer;

import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.RadioButton;
/**
 * FXML Controller class
 *
 * @author Mou Chen
 */
public class ComputerCreatorController implements Initializable {
    
    @FXML
    private TextField idTextField;

    @FXML
    private TextField stockTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private DatePicker productDatePicker;

    @FXML
    private ChoiceBox<String> brandChioceBox;

    @FXML
    private ColorPicker compColorPicker;

    @FXML
    private Label sumMsgLabel;

    @FXML
    private Label eroMsgLabel;
    
    @FXML
    private RadioButton trueRadioBtn;

    @FXML
    private RadioButton falseRadioBtn;

    @FXML
    private ImageView imageView;

    @FXML
    private Button getPriceBtn;
    private Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //configure the choicebox
        brandChioceBox.getItems().add("Dell");
        brandChioceBox.getItems().add("ACER");
        brandChioceBox.getItems().add("Lenovo");
        brandChioceBox.getItems().add("HP");
        brandChioceBox.getItems().add("ASUS");
        brandChioceBox.getItems().add("Apple");
        
        eroMsgLabel.setText("");
        sumMsgLabel.setText("");        
    }    
    
    @FXML
    public void brandChanger()
    {
        String brand = brandChioceBox.getValue();
        if (brand.equalsIgnoreCase("dell"))
            imageView.setImage(new Image("./images/dell.png"));
        else if (brand.equalsIgnoreCase("acer"))
            imageView.setImage(new Image("./images/acer.jpg"));
        else if (brand.equalsIgnoreCase("Lenovo"))
            imageView.setImage(new Image("./images/lenovo.jpg"));
        else if (brand.equalsIgnoreCase("hp"))
            imageView.setImage(new Image("./images/hp.jpg"));
        else if (brand.equalsIgnoreCase("ausu"))
            
            imageView.setImage(new Image("./images/asus.jpg"));
        else
            imageView.setImage(new Image("./images/apple.jpg"));
    }
    
    @FXML
    public void getPriceBtnPushed()
    {
        if (this.productDatePicker.getValue() != null)
        {
            try{
                PromotionalComputer newPromotionalComputer = new PromotionalComputer(1, 
                        this.idTextField.getText(),
                        this.priceTextField.getText(),
                        this.brandChioceBox.getValue(), 
                        this.brandChioceBox.getValue(),
                        this.compColorPicker.getValue());
                System.out.println(newPromotionalComputer);
            } catch (IllegalArgumentException e)
            {
                eroMsgLabel.setText(e.getMessage());
                
            }
        }
        else
        {
            eroMsgLabel.setText("You need to set the birthday");
            
        }
        
    }
    
    @FXML
    public void productDateChoose()
    {
        Period period = Period.between(productDatePicker.getValue(), LocalDate.now());
        
    }
    
}
            

