package MetodosTransporte;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static App.App.celda;

public class NorOeste {

    private double demandaTotal, ofertaTotal;
    private int fila = celda.length;
    private int columna = celda[0].length;
    private int filaPenalizable = 0;
    private int columnaPenalizable = 0;

    public void establecerDemanda(JTable tableSolucion) {
        for (int i = 1; i <= fila; i++) {
            celda[i-1][columnaPenalizable].setAlamcenado(true);
        }
    }

    public void establecerOferta(JTable tableSolucion) {
        for (int i = 1; i <= columna; i++) {
            celda[filaPenalizable][i-1].setAlamcenado(true);
        }
    }

    public boolean metodNorOeste(JTable matrSolicion, DefaultTableModel matrModelSolucion) {
        equilibrioDemandaOfertaTotal(matrSolicion, 0, 0);
        if (demandaTotal == ofertaTotal) {
            if (columnaPenalizable < columna || filaPenalizable < fila) {
                double demanda = Double.parseDouble("" + matrSolicion.getValueAt(matrSolicion.getRowCount() - 1, columnaPenalizable + 1));
                double oferta = Double.parseDouble("" + matrSolicion.getValueAt(filaPenalizable + 1, matrSolicion.getColumnCount() - 1));
                if (demanda == oferta) {
                    matrSolicion.setValueAt(0, matrSolicion.getRowCount() - 1, columnaPenalizable + 1);
                    matrSolicion.setValueAt(0, filaPenalizable + 1, matrSolicion.getColumnCount() - 1);
                    celda[filaPenalizable][columnaPenalizable].setSubCoeficiente(demanda);
                    establecerDemanda(matrSolicion);
                    establecerOferta(matrSolicion);
                    columnaPenalizable++;
                    filaPenalizable++;
                } else if (demanda > oferta) {
                    demanda = demanda - oferta;
                    matrSolicion.setValueAt(0, filaPenalizable + 1, matrSolicion.getColumnCount() - 1);
                    matrSolicion.setValueAt(demanda, matrSolicion.getRowCount() - 1, columnaPenalizable + 1);
                    celda[filaPenalizable][columnaPenalizable].setSubCoeficiente(oferta);
                    establecerOferta(matrSolicion);
                    filaPenalizable++;
                } else if (oferta > demanda) {
                    oferta = oferta - demanda;
                    matrSolicion.setValueAt(0, matrSolicion.getRowCount() - 1, columnaPenalizable + 1);
                    matrSolicion.setValueAt(oferta, filaPenalizable + 1, matrSolicion.getColumnCount() - 1);
                    celda[filaPenalizable][columnaPenalizable].setSubCoeficiente(demanda);
                    establecerDemanda(matrSolicion);
                    columnaPenalizable++;
                }
                return false;
            }
            return true;

        }
        return false;

    }

    public void equilibrioDemandaOfertaTotal(JTable matrSol, int obtenerFila, int obtenerColumna) {
        demandaTotal = 0;
        ofertaTotal = 0;
        try {
            for (int i = 1; i < matrSol.getColumnCount() - 1 - obtenerColumna; i++) {
                demandaTotal = demandaTotal + Double.parseDouble("" + matrSol.getValueAt(matrSol.getRowCount() - 1 - obtenerFila, i));
            }
            for (int i = 1; i < matrSol.getRowCount() - 1 - obtenerFila; i++) {
                ofertaTotal = ofertaTotal + Double.parseDouble("" + matrSol.getValueAt(i, matrSol.getColumnCount() - 1 - obtenerColumna));
            }
            matrSol.setValueAt("" + demandaTotal + " | " + ofertaTotal, matrSol.getRowCount() - 1 - obtenerFila, matrSol.getColumnCount() - 1 - obtenerColumna);
        } catch (Exception r) {
        }
    }

}
