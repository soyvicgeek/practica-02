package entidades;

public class DetalleVenta {
    private int idDetalleVentas;
    private int idVenta;
    private int idProducto;
    private String nombreProducto;
    private int productoStock;
    private int cantidad;
    private double precio;
    private double descuento;
    private double subTotal;
    
    public DetalleVenta() {
    }

    public DetalleVenta(int idDetalleVentas, int idVenta, int idProducto, String nombreProducto, int productoStock, int cantidad, double precio, double descuento, double subTotal) {
        this.idDetalleVentas = idDetalleVentas;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.productoStock = productoStock;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }

    public DetalleVenta(int idProducto, int cantidad, double precio, double descuento) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.descuento = descuento;
    }

    public DetalleVenta(int idProducto, String nombreProducto, int cantidad) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.cantidad = cantidad;
    }

    public int getIdDetalleVentas() {
        return idDetalleVentas;
    }

    public void setIdDetalleVentas(int idDetalleVentas) {
        this.idDetalleVentas = idDetalleVentas;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getProductoStock() {
        return productoStock;
    }

    public void setProductoStock(int productoStock) {
        this.productoStock = productoStock;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "idDetalleVentas=" + idDetalleVentas + ", idVenta=" + idVenta + ", idProducto=" + idProducto + ", nombreProducto=" + nombreProducto + ", productoStock=" + productoStock + ", cantidad=" + cantidad + ", precio=" + precio + ", descuento=" + descuento + ", subTotal=" + subTotal + '}';
    }
}
