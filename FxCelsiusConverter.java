import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FxCelsiusConverter extends Application
{
	// Create the Message Label
	Label messageLbl = new Label("Press Enter or Convert button.");
    Label usageLbl = new Label("Valid Inputs: \n" +
                "Integer: 10, -10, +10, 10d\n" +
                "Double: 20.5, -20.5, +20.5, 20.5d\n" +
                "Float: 30.0f, -30.0f, +30.0f\n" +
                "Exponent: 2e3, -2e3, +2e3");

	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{
		// Create the TextField celsius
		TextField celsiusFld = new TextField();

        // Create the Label celsius
        Label celsiuLbl = new Label();

        // Create a normal button with C as its mnemonic
		Button convertBtn = new Button("_Convert");

        // Create the fahrenheit message label
		Label fahrenheitLbl = new Label("Fahrenheit: ");

        // Create the fahrenheit value label
		Label fahrenheitValueLbl = new Label();

        // Set textfield to be wide enough to display 10 chars
		celsiusFld.setPrefColumnCount(10);

		// Set ActionEvent handler for celsius field
		celsiusFld.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
                try {
                    double celsius = Double.parseDouble(celsiusFld.getText());
                    double fahrenheit = calculateFahrenheit(celsius);
                    fahrenheitValueLbl.setText(Double.toString(fahrenheit));
                } catch (NumberFormatException ex) {
                    fahrenheitValueLbl.setText("Invalid input");
                }

            }
        });


		// Add EventHandler to the Button
		convertBtn.setOnAction(new EventHandler<ActionEvent>()
		{
            @Override public void handle(ActionEvent e)
            {
                try {
                    double celsius = Double.parseDouble(celsiusFld.getText());
                    double fahrenheit = calculateFahrenheit(celsius);
                    fahrenheitValueLbl.setText(Double.toString(fahrenheit));
                } catch (NumberFormatException ex) {
                    fahrenheitValueLbl.setText("Invalid input");
                }
            }
        });


		GridPane root = new GridPane();
		// Set the horizontal spacing to 10px
		root.setHgap(10);
		// Set the vertical spacing to 10px
		root.setVgap(10);

		// Add Labels and Fields to the GridPane
		root.addRow(0, messageLbl);
		root.addRow(1, celsiusFld, convertBtn);
		root.addRow(2, fahrenheitLbl, fahrenheitValueLbl);
        root.addRow(3, usageLbl);

		// Set the Size of the GridPane
		root.setMinSize(350, 250);

		/*
		 * Set the padding of the GridPane
		 * Set the border-style of the GridPane
		 * Set the border-width of the GridPane
		 * Set the border-insets of the GridPane
		 * Set the border-radius of the GridPane
		 * Set the border-color of the GridPane
		*/
		root.setStyle("-fx-padding: 10;" +
				"-fx-border-style: solid inside;" +
				"-fx-border-width: 2;" +
				"-fx-border-insets: 5;" +
				"-fx-border-radius: 5;" +
				"-fx-border-color: blue;");

		// Create the Scene
		Scene scene = new Scene(root);
		// Add the scene to the Stage
		stage.setScene(scene);
		// Set the title of the Stage
		stage.setTitle("A Celsius Converter Example");
		// Display the Stage
		stage.show();
	}

	// Helper Method to calculate fahrenheit
	public double calculateFahrenheit(double value)
	{
        //Math.round(number*100.0)/100.0;
        return Math.round(((value * 9 / 5) + 32) * 100.0) / 100.0;
	}

}
