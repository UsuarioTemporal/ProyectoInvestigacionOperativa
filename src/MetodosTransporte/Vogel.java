package MetodosTransporte;

import java.util.ArrayList;
import javax.swing.JTable;
import static App.App.celda;
import static App.App.existeRedundancia;

public class Vogel {

    // La logica fue planteada por otro autor --  
    // esta es mi fuente : https://www.youtube.com/watch?v=8eK72DSs5e0 gracias a este autor pude perssonalizar y solucionar los errores que tenia
    // y esta fuente tambien : https://github.com/0w3w/metodo-del-transporte/blob/master/src/metodoTransporte.java
    private ArrayList<String> inCongruentes;
    private int fila = celda.length;
    private int columna = celda[0].length;
    private int filaMenor1, filaMenor2;
    private int columnMenor1, columnMenor2;
    private double temporal;
    private double mayor;
    private double menor;
    private boolean busquedaPorColumna;
    private int filaMayor;
    private int columnaMayor;
    private int filaMenor;
    private int columnaMenor;

    public void setFilaMayor(int filaMayor) {
        this.filaMayor = filaMayor;
    }

    public void setColumnaMayor(int columnaMayor) {
        this.columnaMayor = columnaMayor;
    }

    public void setBuscarPorColumna(boolean buscarPorColumna) {
        this.busquedaPorColumna = buscarPorColumna;
    }

    public int getFilaMayor() {
        return filaMayor;
    }

    public int getColumnaMayor() {
        return columnaMayor;
    }

    public boolean obtenerVogel(JTable tableSolucion) {
        calcularmenoresColumnas(tableSolucion);
        calcularSumaMenoresFilas(tableSolucion);
        buscarMayorFilaColumna(tableSolucion);
        if (filaMayor >= 0 && columnaMayor >= 0) {
            buscarCostoMenor();
            if (!decicionRepetidos(tableSolucion)) {
                agregar(tableSolucion);
            } else if (ultimo()) {
                agregar(tableSolucion);
            }
            return false;
        }
        return true;
    }

    public void buscarCostoMenor() {
        menor = Double.MAX_VALUE;
        double aux;
        if (busquedaPorColumna) {
            for (int i = 0; i < fila; i++) {
                if (!celda[i][columnaMayor - 1].getPrecio().equals("-")) {
                    aux = Double.parseDouble(celda[i][columnaMayor - 1].getPrecio());
                    if (aux < menor && !celda[i][columnaMayor - 1].getAlmacenado()) {
                        menor = aux;
                        columnaMenor = columnaMayor - 1;
                        filaMenor = i;
                    }
                }
            }
        } else if (!busquedaPorColumna) {
            for (int i = 0; i < columna; i++) {
                if (!celda[filaMayor - 1][i].getPrecio().equals("-")) {
                    aux = Double.parseDouble(celda[filaMayor - 1][i].getPrecio());
                    if (aux < menor && !celda[filaMayor - 1][i].getAlmacenado()) {
                        menor = aux;
                        columnaMenor = i;
                        filaMenor = filaMayor - 1;
                    }
                }
            }
        }
    }

    public void agregar(JTable tableSolucion) {
        double demanda = Double.parseDouble("" + tableSolucion.getValueAt(tableSolucion.getRowCount() - 2, columnaMenor + 1));
        double oferta = Double.parseDouble("" + tableSolucion.getValueAt(filaMenor + 1, tableSolucion.getColumnCount() - 2));
        if (demanda == oferta) {
            tableSolucion.setValueAt(0, tableSolucion.getRowCount() - 2, columnaMenor + 1);
            tableSolucion.setValueAt(0, filaMenor + 1, tableSolucion.getColumnCount() - 2);
            celda[filaMenor][columnaMenor].setSubCoeficiente(demanda);
            establecerOferta2();
            establecerDemanda1();
        } else if (demanda > oferta) {
            demanda = demanda - oferta;
            tableSolucion.setValueAt(0, filaMenor + 1, tableSolucion.getColumnCount() - 2);
            tableSolucion.setValueAt(demanda, tableSolucion.getRowCount() - 2, columnaMenor + 1);
            celda[filaMenor][columnaMenor].setSubCoeficiente(oferta);
            establecerOferta2();
        } else if (oferta > demanda) {
            oferta = oferta - demanda;
            tableSolucion.setValueAt(0, tableSolucion.getRowCount() - 2, columnaMenor + 1);
            tableSolucion.setValueAt(oferta, filaMenor + 1, tableSolucion.getColumnCount() - 2);
            celda[filaMenor][columnaMenor].setSubCoeficiente(demanda);
            establecerDemanda1();
        }

    }

    public void buscarMayorFilaColumna(JTable t) {
        filaMayor = -1;
        columnaMayor = -1;
        mayor = Double.MIN_VALUE * -1;
        inCongruentes = new ArrayList<>();
        int fi = t.getRowCount();
        int co = t.getColumnCount();
        for (int i = 1; i < fi - 2; i++) {
            if (!String.valueOf(t.getValueAt(i, co - 1)).equals("-")) {
                double auxMenor = Double.parseDouble("" + t.getValueAt(i, co - 1));
                if (auxMenor > mayor) {
                    mayor = auxMenor;
                    filaMayor = i;
                    columnaMayor = co - 1;
                    busquedaPorColumna = false;
                }
            }
        }
        for (int i = 1; i < co - 2; i++) {
            if (!String.valueOf(t.getValueAt(fi - 1, i)).equals("-")) {
                double auxMayor = Double.parseDouble("" + t.getValueAt(fi - 1, i));
                if (auxMayor > mayor) {
                    mayor = auxMayor;
                    filaMayor = fi - 1;
                    columnaMayor = i;
                    busquedaPorColumna = true;
                }
            }
        }
    }

    public boolean decicionRepetidos(JTable t) {
        inCongruentes = new ArrayList<>();
        int fi = t.getRowCount();
        int co = t.getColumnCount();
        for (int i = 1; i < fi - 2; i++) {
            if (!String.valueOf(t.getValueAt(i, co - 1)).equals("-")) {
                String auxMenor = "" + t.getValueAt(i, co - 1);
                if (auxMenor.equalsIgnoreCase("" + t.getValueAt(filaMayor, columnaMayor))) {
                    inCongruentes.add(auxMenor);
                }
            }
        }
        for (int i = 1; i < co - 2; i++) {
            if (!String.valueOf(t.getValueAt(fi - 1, i)).equals("-")) {
                String auxMenor = "" + t.getValueAt(fi - 1, i);
                if (auxMenor.equalsIgnoreCase("" + t.getValueAt(filaMayor, columnaMayor))) {
                    inCongruentes.add(auxMenor);
                }
            }
        }
        if (inCongruentes.size() > 1) {
            existeRedundancia = inCongruentes.get(0);
            return true;
        } else {
            existeRedundancia = null;
            return false;
        }

    }

    public void calcularSumaMenoresFilas(JTable t) {
        for (int fil = 0; fil < fila; fil++) {
            columnMenor1 = calcularPrimerMenorFila(fil);
            if (columnMenor1 < 0) {
                t.setValueAt("-", fil + 1, t.getColumnCount() - 1);
            } else {
                columnMenor2 = calcularSegundoMenorDelaFila(fil);
                if (columnMenor2 >= 0) {
                    t.setValueAt(Math.abs(Double.parseDouble(celda[fil][columnMenor1].getPrecio()) - Double.parseDouble(celda[fil][columnMenor2].getPrecio())), fil + 1, t.getColumnCount() - 1);
                } else {
                    t.setValueAt(celda[fil][columnMenor1].getPrecio(), fil + 1, t.getColumnCount() - 1);
                }
            }
        }
    }

    public void calcularmenoresColumnas(JTable t) {
        for (int column = 0; column < columna; column++) {
            filaMenor1 = calcularPrimerMenorColumn(column);
            if (filaMenor1 < 0) {
                t.setValueAt("-", t.getRowCount() - 1, column + 1);
            } else {
                filaMenor2 = calularSegundoMenorColumn(column);
                if (filaMenor2 >= 0) {
                    t.setValueAt(Math.abs(Double.parseDouble(celda[filaMenor1][column].getPrecio()) - Double.parseDouble(celda[filaMenor2][column].getPrecio())), t.getRowCount() - 1, column + 1);
                } else {
                    t.setValueAt(celda[filaMenor1][column].getPrecio(), t.getRowCount() - 1, column + 1);
                }
            }
        }
    }

    public int calularSegundoMenorColumn(int col) {
        double tem = 0;
        int pos = -1;
        for (int i = 0; i < fila; i++) {
            if (i != filaMenor1) {
                if (!celda[i][col].getAlmacenado() && !celda[i][col].getPrecio().equals("-")) {
                    pos = i;
                    tem = Double.parseDouble(celda[i][col].getPrecio());
                }
            }
        }
        if (pos < 0) {
            return -1;
        }
        double tem2 = 0;
        for (int i = 0; i < fila; i++) {
            if (i != filaMenor1) {
                if (!celda[i][col].getAlmacenado() && !celda[i][col].getPrecio().equals("-") && i != pos) {
                    tem2 = Double.parseDouble(celda[i][col].getPrecio());
                    if (tem > tem2) {
                        pos = i;
                        tem = tem2;
                    }
                }
            }
        }
        return pos;
    }

    public int calcularPrimerMenorColumn(int col) {
        int pos = - 1;
        for (int i = 0; i < fila; i++) {
            if (!celda[i][col].getAlmacenado() && !celda[i][col].getPrecio().equals("-")) {
                pos = i;
                temporal = Double.parseDouble(celda[i][col].getPrecio());;
            }
        }
        if (pos < 0) {
            return -1;
        }
        double tem2 = 0;
        for (int i = 0; i < fila; i++) {
            if (!celda[i][col].getAlmacenado() && !celda[i][col].getPrecio().equals("-") && i != pos) {
                tem2 = Double.parseDouble(celda[i][col].getPrecio());
                if (temporal > tem2) {
                    pos = i;
                    temporal = tem2;
                }
            }
        }
        return pos;
    }

    public int calcularSegundoMenorDelaFila(int fil) {
        double tem = 0;
        int pos = -1;
        for (int i = 0; i < columna; i++) {
            if (i != columnMenor1) {
                if (!celda[fil][i].getAlmacenado() && !celda[fil][i].getPrecio().equals("-")) {
                    pos = i;
                    tem = Double.parseDouble(celda[fil][i].getPrecio());
                }
            }
        }
        if (pos < 0) {
            return -1;
        }
        double tem2 = 0;
        for (int i = 0; i < columna; i++) {
            if (i != columnMenor1) {
                if (!celda[fil][i].getAlmacenado() && !celda[fil][i].getPrecio().equals("-") && i != pos) {
                    tem2 = Double.parseDouble(celda[fil][i].getPrecio());
                    if (tem > tem2) {
                        pos = i;
                        tem = tem2;
                    }
                }
            }
        }
        return pos;
    }

    public int calcularPrimerMenorFila(int fil) {
        int pos = - 1;
        for (int i = 0; i < columna; i++) {
            if (!celda[fil][i].getAlmacenado() && !celda[fil][i].getPrecio().equals("-")) {
                pos = i;
                temporal = Double.parseDouble(celda[fil][i].getPrecio());;
            }
        }
        if (pos < 0) {
            return -1;
        }
        double tem2 = 0;
        for (int i = 0; i < columna; i++) {
            if (!celda[fil][i].getAlmacenado() && !celda[fil][i].getPrecio().equals("-") && i != pos) {
                tem2 = Double.parseDouble(celda[fil][i].getPrecio());
                if (temporal > tem2) {
                    pos = i;
                    temporal = tem2;
                }
            }
        }
        return pos;
    }

    public void establecerDemanda1() {

        for (int i = 1; i <= fila; i++) {
            celda[i - 1][columnaMenor].setAlamcenado(true);
        }
    }

    public void establecerOferta2() {

        for (int i = 1; i <= columna; i++) {
            celda[filaMenor][i-1].setAlamcenado(true);
        }
    }

    public boolean existe(int fila, int col, JTable t) {
        String g = "" + t.getValueAt(fila, col);
        for (int i = 0; i < inCongruentes.size(); i++) {
            if (inCongruentes.get(i).equalsIgnoreCase(g)) {
                return true;
            }
        }
        return false;
    }

    public boolean ultimo() {
        int canti = 0;
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                if (!celda[i][j].getAlmacenado()) {
                    if (canti++ > 1) {
                        return false;
                    }
                }
            }
        }
        existeRedundancia = null;
        return true;
    }
}
