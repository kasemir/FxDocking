/*******************************************************************************
 * Copyright (c) 2017 Oak Ridge National Laboratory.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package docking2;

import java.lang.reflect.Method;
import java.util.Arrays;

import javax.swing.ImageIcon;

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
        for (String prop : Arrays.asList("java.specification.name",
                                         "java.specification.vendor",
                                         "java.specification.version",
                                         "java.home",
                                         "java.runtime.name",
                                         "java.runtime.version"))
            System.out.println(prop + " = " + System.getProperty(prop));

        launch(args);
    }

    @Override
    public void start(final Stage stage)
    {
        // Set Mac OS X application image.
        try
        {   // Use introspection to call this without direct dependency:
            //com.apple.eawt.Application.getApplication().setDockIconImage(..);
            final Class<?> clazz = Class.forName("com.apple.eawt.Application");
            Method method = clazz.getMethod("getApplication");
            final Object app = method.invoke(clazz);
            method = app.getClass().getMethod("setDockIconImage", java.awt.Image.class);
            method.invoke(app, new ImageIcon("icons/logo.png").getImage());
        }
        catch (Exception ex)
        {
            // Ignore, not on Mac
            // ex.printStackTrace();
        }


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
