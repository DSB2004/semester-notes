/*
 * -----------------------------------------------
 * Java Applet Example with Theory and Explanation
 * -----------------------------------------------
 *
 * What is a Java Applet?
 * -----------------------
 * - An Applet is a Java program that runs in a web browser or applet viewer.
 * - It is used to create interactive graphical applications.
 * - Applets extend the `java.applet.Applet` class.
 * - They override the `paint(Graphics g)` method to perform custom rendering.
 * 
 * Applet Life Cycle Methods:
 * ---------------------------
 * 1. init()     → Called once when the applet is loaded.
 * 2. start()    → Called after init() and when the applet is restarted.
 * 3. paint()    → Called whenever the applet needs to repaint itself.
 * 4. stop()     → Called when the user navigates away from the page.
 * 5. destroy()  → Called when the applet is destroyed completely.
 * 
 * To run an applet:
 * -----------------
 * - Older method: Use a browser or applet viewer like: `appletviewer`
 * - Modern Java versions have dropped support for applets in browsers.
 * - Recommended to use GUI frameworks like JavaFX or Swing for new applications.
 */

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Color;

public class AppletExample extends Applet {

    // Called when the applet is initialized
    public void init() {
        setBackground(Color.lightGray); // Set background color
    }

    // Called whenever the applet needs to repaint itself
    public void paint(Graphics g) {
        // Set color and draw a string
        g.setColor(Color.BLUE);
        g.drawString("Hello, this is a Java Applet!", 20, 30);

        // Draw a rectangle
        g.setColor(Color.RED);
        g.drawRect(20, 50, 150, 100);
    }
}

/*
 * How to run:
 * -----------
 * 1. Save this file as AppletExample.java
 * 2. Compile: javac AppletExample.java
 * 3. Create an HTML file (AppletExample.html):
 * 
 *    <html>
 *    <body>
 *      <applet code="AppletExample.class" width="300" height="200">
 *      </applet>
 *    </body>
 *    </html>
 * 
 * 4. Run using appletviewer (if installed):
 *    appletviewer AppletExample.html
 * 
 * NOTE: Applets are now obsolete and not supported in modern browsers or JDKs.
 */
