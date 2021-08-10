package spreadsheet;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  {@code SpreadsheetFrame} is the class that
 *  contains the {@code JFrame}
 *  of the spreadsheet.
 *  @version 2021033000
 *  @author Trevor Watts
 */
class SpreadsheetFrame extends JFrame {

	/**
	 *  Constructs the frame of the spreadsheet
	 */
    public SpreadsheetFrame() {
        add(new SpreadsheetComponent());
        pack();

        /*
         *  Center the frame in the screen.
         */
        setLocationRelativeTo(null);
    }
}