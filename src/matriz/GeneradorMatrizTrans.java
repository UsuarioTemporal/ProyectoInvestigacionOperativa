package matriz;

import static App.App.celda;
import MetodosTransporte.Cacillero;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static App.App.tablaModeloRestr;

public class GeneradorMatrizTrans {

    public void generadorMatrizTrans(int destino, int fuente, JTable matrizRestricciones, int desequilibrio) {
        String[] headerTable = new String[destino + 2 + desequilibrio];
        headerTable[0] = (" ");
        headerTable[destino + 1 + desequilibrio] = ("Oferta");
        for (int i = 1; i <= destino + desequilibrio; i++) {
            headerTable[i] = ("Destino " + i);
        }
        
        //clase anonima
        tablaModeloRestr = new DefaultTableModel(headerTable, 0) {
            public boolean isCellEditable(int row, int column) {
                if (column == 0 || (row == matrizRestricciones.getRowCount() - 1 && column == matrizRestricciones.getColumnCount() - 1)) {
                    return false;
                }
                return true;
            }
        };
        matrizRestricciones.setModel(tablaModeloRestr);
        String fila[] = new String[destino + 2 + desequilibrio];
        for (int i = 0; i < fuente; i++) {
            fila[0] = new String("Fuente " + (i + 1));
            tablaModeloRestr.addRow(fila);
        }
        fila[0] = new String("Demanda");
        tablaModeloRestr.addRow(fila);
    }
    private void extraerDatos(JTable jtRestriciones) {
        int row = jtRestriciones.getRowCount();
        int column = jtRestriciones.getColumnCount();
        celda = new Cacillero[row - 1][column - 2];
        for (int i = 0; i < row - 1; i++) {
            for (int j = 0; j < column - 2; j++) {
                celda[i][j] = new Cacillero(0, "" + jtRestriciones.getValueAt(i, j + 1), false);
            }
        }
    }
    public void crearMatrizSolucion(JTable matrRestriciones, JTable matrSoluc, int extraRow, int extaColumn) {
        int row = matrRestriciones.getRowCount();
        int column = matrRestriciones.getColumnCount();
        extraerDatos(matrRestriciones);
        String cabeza[] = new String[column + extaColumn];
        for (int i = 0; i < (column + extaColumn); i++) {
            cabeza[i] = ("");
        }
        DefaultTableModel modelosSolucion = new DefaultTableModel(cabeza, 0) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        matrSoluc.setModel(modelosSolucion);
        String origen[];
        for (int fila = 0; fila < row + 1 + extraRow; fila++) {
            origen = new String[column + extaColumn];
            if (fila > 0 && fila < row) {
                origen[0] = "" + fila;
            }
            modelosSolucion.addRow(origen);
        }
        for (int i = 0; i < modelosSolucion.getColumnCount(); i++) {
            matrSoluc.getColumnModel().getColumn(i).setPreferredWidth(70);
        }
        String tem;
        for (int fil = 0; fil < row - 1; fil++) {
            tem = "" + tablaModeloRestr.getValueAt(fil, column - 1);
            modelosSolucion.setValueAt(tem, fil + 1, column - 1);
        }
        for (int col = 1; col < column - 1; col++) {
            tem = "" + tablaModeloRestr.getValueAt(row - 1, col);
            modelosSolucion.setValueAt(tem, modelosSolucion.getRowCount() - 1 - extaColumn, col);
            modelosSolucion.setValueAt(col, 0, col);
        }
        modelosSolucion.setValueAt("Demanda", row, 0);
        modelosSolucion.setValueAt("Oferta", 0, column - 1);
        
    }

    

}
