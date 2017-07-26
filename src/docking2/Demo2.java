package docking2;

import javafx.application.Application;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/** Docking demo
 *
 *  @author Kay Kasemir
 */
public class Demo2 extends Application
{
	public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(final Stage stage)
    {
    	// Add dock items to the original stage
        final DockItem tab1 = new DockItem("Tab 1");
        final BorderPane layout = new BorderPane();
        layout.setTop(new Label("Top"));
        layout.setCenter(new Label("Center"));
        layout.setBottom(new Label("Bottom"));
        tab1.setContent(layout);

        final DockItem tab2 = new DockItem("Tab 2");
        tab2.setContent(new Rectangle(500, 500, Color.RED));

        final DockItem tab3 = new DockItem("Tab 3");
        tab3.setContent(new Rectangle(500, 500, Color.GRAY));

        DockPane.configureStage(stage, tab1, tab2, tab3);
        stage.setX(100);

        // Create another stage with more dock items
        final DockItem tab4 = new DockItem("Tab 4");
        tab4.setContent(new Rectangle(500, 500, Color.YELLOW));

        final DockItem tab5 = new DockItem("Tab 5");
        tab5.setContent(new Rectangle(500, 500, Color.BISQUE));

        final Stage other = new Stage();
        DockPane.configureStage(other, tab4, tab5);
        other.setX(600);
    }
}