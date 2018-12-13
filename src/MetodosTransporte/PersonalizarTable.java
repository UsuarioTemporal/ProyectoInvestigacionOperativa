package MetodosTransporte;

import static App.App.celda;
import static App.App.columnaAdicional;
import static App.App.filaAdicional;

import static App.App.existeRedundancia;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class PersonalizarTable extends DefaultTableCellRenderer implements TableCellRenderer {
    //Componentes creados gracias a netbeans y sobreescribiendo los metodos abstractos que pertenecen a TableCellRenderer
    private JLabel lblCelda;
    //Lógica para rellenar la tabla fue implementada desde otro proyecto ya existente -- lo primordial en esta clase
    //es que sirve para la personalizacion de las tablas de solucion >> los codigo de los coleres son generados gracias a netbeans
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        lblCelda = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        lblCelda.setIcon(null);

        if (existeRedundancia != null && String.valueOf(table.getValueAt(row, column)).equalsIgnoreCase(existeRedundancia)) {
            lblCelda.setBackground(new Color(252, 147, 147));
            return lblCelda;
        }
        if ((row == 0 && column < table.getColumnCount() - 1 - columnaAdicional)
                || column == 0 && row < table.getRowCount() - 1 - filaAdicional) {
            lblCelda.setBackground(new Color(0, 102, 153)); 
            lblCelda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            lblCelda.setFont(new java.awt.Font("Tahoma", 1, 18));
            return lblCelda;

        } else if (row == table.getRowCount() - 1 - filaAdicional && column < table.getColumnCount() - 1 - columnaAdicional) {
            lblCelda.setBackground(Color.WHITE);
            lblCelda.setHorizontalAlignment(javax.swing.JTextField.CENTER);

            return lblCelda;
        } else if (column == table.getColumnCount() - 1 - columnaAdicional && row < table.getRowCount() - 1) {
            lblCelda.setBackground(Color.WHITE);
            lblCelda.setHorizontalAlignment(javax.swing.JTextField.CENTER);
            return lblCelda;
        } else if (column == table.getColumnCount() - 1 - columnaAdicional && row == table.getRowCount() - 1 - columnaAdicional) {
            return lblCelda;
        }
        if (columnaAdicional > 0 && (column == table.getColumnCount() - 1 || row == table.getRowCount() - 1)) {
            lblCelda.setBackground(Color.WHITE);
            return lblCelda;
        }
        if (filaAdicional > 0 && (column == table.getColumnCount() - 1 || row == table.getRowCount() - 1)) {
            return lblCelda;
        }

        JPanel panel = returnPanel(row, column, table);
        if (isSelected) {
            panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 204)));
        }
        return panel;

    }

    private JPanel returnPanel(int row, int column, JTable table) {

        JPanel panelCont = new JPanel();
        JLabel lblSubCoeficiente = new JLabel("");
        JLabel labelPrecio = new JLabel("");

        if (column > 0 && row > 0 && row < (table.getRowCount() - 1 - filaAdicional) && column < (table.getColumnCount() - 1 - columnaAdicional)) {

            labelPrecio.setText("" + celda[row - 1][column - 1].getPrecio());

            panelCont.setLayout(null);
            panelCont.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));

            panelCont.add(lblSubCoeficiente);
            panelCont.add(labelPrecio);
            panelCont.setBackground(Color.WHITE);

            labelPrecio.setBounds(3, 3, 64, 22);
            lblSubCoeficiente.setBounds(3, 25, 64, 22);
            lblSubCoeficiente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            labelPrecio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
            labelPrecio.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
            if (celda[row - 1][column - 1].getSubCoeficiente() > 0) {
                lblSubCoeficiente.setText("" + celda[row - 1][column - 1].getSubCoeficiente());
                panelCont.setBackground(new Color(253, 137, 160));
            }
            if (celda[row - 1][column - 1].getAlmacenado() && celda[row - 1][column - 1].getSubCoeficiente() <= 0 || celda[row - 1][column - 1].getPrecio().equals("-")) {
                panelCont.setBackground(Color.white);
            }

        }

        return panelCont;
    }
}
