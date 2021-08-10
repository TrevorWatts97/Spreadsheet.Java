package spreadsheet;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  {@code spreadsheet} is class that implements a spreadsheet
 *  graphically.
 *  @version 2021033000
 *  @author Trevor Watts
 */

public class spreadsheet {
	/**
	 *  Creates the spreadsheet
	 *  @param arg arguments to the spreadsheet
	 */
    public static void main(String arg[])
    {
        EventQueue.invokeLater(() -> {
                SpreadsheetFrame      frame;

                frame = new SpreadsheetFrame();

                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("Rudimentary Spreadsheet");
                frame.setVisible(true);
            });
    }
}
