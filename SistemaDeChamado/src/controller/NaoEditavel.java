package controller;

import javax.swing.table.DefaultTableModel;

public class NaoEditavel extends DefaultTableModel{
	
	private static final long serialVersionUID = 1L;

	public NaoEditavel(Object[] colunmNames, int rowCount) {
		super(colunmNames,rowCount);
	}
	
	@Override
    public boolean isCellEditable(int row, int column) {
        return false; // Desativa a edição para todas as células
    }
}
