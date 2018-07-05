package nl.makaveli.makaveliquote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import nl.makaveli.makaveliquote.quote.Quote;

public class FXMLController implements Initializable {
    
    @FXML
    private Label label;
    private Connection connection;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        connection = new Connection();
        for(Quote quote: connection.getQuotes()) {
        label.setText(quote.toString());

        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
