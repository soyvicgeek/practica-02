package entidades;

public class Productos {
    private int idProducto;
    private int idCategoria;
    private String nombreCategoria;
    private int idSubcategoria;
    private String nombreSubCategoria;
    private String nombreProducto;
    private float precioProducto;
    private int descuentoProducto;
    private int existenciaProducto;
    private String tipoProducto;
    private String imagenProducto;
    private String codigoQR;
    private boolean estado;

    public Productos(int idProducto, int idCategoria, String nombreCategoria, int idSubcategoria, String nombreSubCategoria, String nombreProducto, float precioProducto, int descuentoProducto, int existenciaProducto, String tipoProducto, String imagenProducto, String codigoQR, boolean estado) {
        this.idProducto = idProducto;
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.idSubcategoria = idSubcategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.descuentoProducto = descuentoProducto;
        this.existenciaProducto = existenciaProducto;
        this.tipoProducto = tipoProducto;
        this.imagenProducto = imagenProducto;
        this.codigoQR = codigoQR;
        this.estado = estado;
    }

    public Productos(int idProducto, String nombreProducto, float precioProducto, int existenciaProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.precioProducto = precioProducto;
        this.existenciaProducto = existenciaProducto;
    }
    
    public Productos() {
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getIdSubcategoria() {
        return idSubcategoria;
    }

    public void setIdSubcategoria(int idSubcategoria) {
        this.idSubcategoria = idSubcategoria;
    }

    public String getNombreSubCategoria() {
        return nombreSubCategoria;
    }

    public void setNombreSubCategoria(String nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public float getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(float precioProducto) {
        this.precioProducto = precioProducto;
    }

    public int getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(int descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public int getExistenciaProducto() {
        return existenciaProducto;
    }

    public void setExistenciaProducto(int existenciaProducto) {
        this.existenciaProducto = existenciaProducto;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public String getImagenProducto() {
        return imagenProducto;
    }

    public void setImagenProducto(String imagenProducto) {
        this.imagenProducto = imagenProducto;
    }

    public String getCodigoQR() {
        return codigoQR;
    }

    public void setCodigoQR(String codigoQR) {
        this.codigoQR = codigoQR;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Productos{" + "idProducto=" + idProducto + ", idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", idSubcategoria=" + idSubcategoria + ", nombreSubCategoria=" + nombreSubCategoria + ", nombreProducto=" + nombreProducto + ", precioProducto=" + precioProducto + ", descuentoProducto=" + descuentoProducto + ", existenciaProducto=" + existenciaProducto + ", tipoProducto=" + tipoProducto + ", imagenProducto=" + imagenProducto + ", codigoQR=" + codigoQR + ", estado=" + estado + '}';
    }
}
