package spreadsheet;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *  {@code SpreadsheetComponent} is the class that
 *  contains the {@code JComponent} of the spread sheet.
 *  @version 2021033000
 *  @author Trevor Watts
 */
public class SpreadsheetComponent extends JComponent {
	/**
	 *	Text Field Grid
	 */
	private JTextField      textField[][];
	/**
	 *	Text Field Grid
	 */
	private int             size;
	/**
	 *	Saved font
	 */
	private Font            monospaceFont;
	/**
	 *	Saved text for each field
	 */
	private String			storedText[][];
	/**
	 *	Saved last row
	 */
	private int				lastRow;
	/**
	 *	Saved last column
	 */
	private int				lastColumn;
	/**
	 *	set flag for remembering index
	 */
    private boolean 		selected;

	/**
	 *	This is the class that manages the keys
	 */
	private class GridKeyHandler extends KeyAdapter
	{
		private int     row;
        private int     column;

		public GridKeyHandler(int row, int column)
		{
			/*
			 *  Remember what text field we're associated with.
			 */
			this.row = row;
			this.column = column;
        }
		/**
		 *	Handles what happens when a key is pressed
		 */
		public void keyPressed(KeyEvent event)
		{
			int enter = 10;
			int escape = 27;

			if(event.getKeyCode() == enter){
				/*
				 *	enter key was pressed
				 */
				storedText[row][column] =
								textField[row][column].getText();
				textField[row][column].setEditable(false);
			}
			else if(event.getKeyCode() == escape){
				/*
				 *	escape key was pressed
				 */
				textField[row][column].
								setText(storedText[row][column]);
				textField[row][column].setEditable(false);
			}
        }

	}

	/**
	 *	This is the class that manages mouse clicks
	 */
    private class MouseHandler extends MouseAdapter
    {
		private int     row;
        private int     column;

		/*
		 *	Stores the row and column for the
		 *  field being clicked
		 */
		public MouseHandler(int row, int column)
		{
			/*
			 *  Remember what text field we're associated with.
			 */
			this.row = row;
			this.column = column;
        }

		/*
		 *	Handles what happens when mouse is clicked
		 */
		public void mouseClicked(MouseEvent event)
		{
			if (event.getButton() == MouseEvent.BUTTON1) {
				/*
				 *	Only takes left clicks
				 */
				if(textField[row][column].isEditable() == true){
					/*
					 *	current text field is being edited
					 *	do nothing
					 */
					return;
				}
				else{
					/*
					 *	Uses the last edited text field
					 *  saves the current text
					 *  disables edit mode
					 *  enables edit mode for new text field
					 *  saves new index as old index
					 */
					if(selected == true){
						textField[lastRow][lastColumn].
												    setEditable(false);
						storedText[lastRow][lastColumn] =
							  textField[lastRow][lastColumn].getText();
					}
				}
				textField[row][column].setEditable(true);
				selected = true;
				lastRow = row;
				lastColumn = column;
			}
		}
	}

    /**
     *  Construct the Component that contains and manages
     *  the canvas.
     */
    public SpreadsheetComponent()
    {
		int 	row;
		int     column;

		monospaceFont = new Font("Monospaced", Font.BOLD, 18);
		size = 8;
		setLayout(new GridLayout(size,size));
		storedText = new String[size][size];
		textField = new JTextField[size][size];
		for (row = 0; (row < size); ++row) {
			for (column = 0; (column < size); ++column) {
				/*
				 *  Instantiate and configure this text field.
				 */
				textField[row][column] = new JTextField(10);
				textField[row][column].
					   addMouseListener(new MouseHandler(row, column));
				textField[row][column].
					   addKeyListener(new GridKeyHandler(row, column));
				textField[row][column].setFont(monospaceFont);
				textField[row][column].setEditable(false);
				add(textField[row][column]);
			}
        }
    }
}