package MetodosTransporte;

public class Cacillero {
    private boolean almacenado;
    private double subCoeficiente;
    private String precio;
    
    public Cacillero(double cantidad, String precio, boolean lleno) {
        this.subCoeficiente = cantidad;
        this.almacenado = lleno;
        this.precio = precio;
    }

    public double getSubCoeficiente() {
        return subCoeficiente;
    }

    public void setSubCoeficiente(double cantidad) {
        this.subCoeficiente = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    
    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public boolean getAlmacenado() {
        return almacenado;
    }

    public void setAlamcenado(boolean lleno) {
        this.almacenado = lleno;
    }

    
    
}
