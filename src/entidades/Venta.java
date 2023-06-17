package entidades;

import java.sql.Date;
import java.util.List;

public class Venta {
    private int idVenta;
    private int idCliente;
    private String nombreCliente;
    private Date fecha;
    private double total;
    private double iva;
    private String estado;
    private List<DetalleVenta>detalles;
    
    public Venta(){}

    public Venta(int idVenta, int idCliente, String nombreCliente, Date fecha, double total, double iva, String estado, List<DetalleVenta> detalles) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
        this.estado = estado;
        this.detalles = detalles;
    }
    
    public Venta(int idVenta, int idCliente, String nombreCliente, Date fecha, double total, double iva, String estado) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.fecha = fecha;
        this.total = total;
        this.iva = iva;
        this.estado = estado;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<DetalleVenta> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetalleVenta> detalles) {
        this.detalles = detalles;
    }

    @Override
    public String toString() {
        return "Venta{" + "idVenta=" + idVenta + ", idCliente=" + idCliente + ", nombreCliente=" + nombreCliente + ", fecha=" + fecha + ", total=" + total + ", iva=" + iva + ", estado=" + estado + ", detalles=" + detalles + '}';
    }
}
