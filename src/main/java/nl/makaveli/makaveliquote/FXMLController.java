package nl.makaveli.makaveliquote;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import nl.makaveli.makaveliquote.quote.Quote;

public class FXMLController implements Initializable {

    @FXML
    private Text quoteLabel;
    @FXML
    private Label auteurLabel;

    private Connection connection;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        connection = new Connection();
        for (Quote quote : connection.getQuotes()) {
            quoteLabel.setText(quote.getmQuote());
            auteurLabel.setText(quote.getmAuthor());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        connection = new Connection();
        for (Quote quote : connection.getQuotes()) {
            quoteLabel.setText(quote.getmQuote());
            auteurLabel.setText(quote.getmAuthor());
        }
    }
}
