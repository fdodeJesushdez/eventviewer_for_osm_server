/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package solutec_interface;

/**
 *
 * @author Fernando
 */
import javax.swing.table.AbstractTableModel;

public class StringTableModel extends AbstractTableModel {

  private String [][] lookup;

  private final int rows;

  private final int columns;

  private final String headers[];

  public StringTableModel(int rows, String columnHeaders[]) {
    if ((rows < 0) || (columnHeaders == null)) {
      throw new IllegalArgumentException(
          "Invalid row count/columnHeaders");
    }
    this.rows = rows;
    this.columns = columnHeaders.length;
    headers = columnHeaders;
    lookup = new String[rows][columns];
    for(int i=0;i<rows;i++){
        for(int j=0;j<columns;j++){
            lookup[i][j] = " ";
        }
    }
    
  }

  public int getColumnCount() {
    return columns;
  }

  public int getRowCount() {
    return rows;
  }

  public String getColumnName(int column) {
    return headers[column];
  }

  public Object getValueAt(int row, int column) {
    return lookup[row][column];
  }

  public void setValueAt(Object value, int row, int column) {
    if ((rows < 0) || (columns < 0)) {
      throw new IllegalArgumentException("Invalid row/column setting");
    }
    if ((row < rows) && (column < columns)) {
      lookup[row][column] = (String)value;
    }
  }
}
