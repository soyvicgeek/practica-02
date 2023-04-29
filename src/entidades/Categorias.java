package entidades;

public class Categorias {
    private int idCategoria;
    private String nombreCategoria;
    private String imagenCategoria;
    private String descripcionCategoria;
    private String observaciones;
    private boolean activo;
    
    //Constructores
    public Categorias(int idCategoria, String nombreCategoria, String imagenCategoria, String descripcionCategoria, String observaciones, boolean activo) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
        this.imagenCategoria = imagenCategoria;
        this.descripcionCategoria = descripcionCategoria;
        this.observaciones = observaciones;
        this.activo = activo;
    }
    
    public Categorias() {
    
    }
    
    //Setter y Getter
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

    public String getImagenCategoria() {
        return imagenCategoria;
    }

    public void setImagenCategoria(String imagenCategoria) {
        this.imagenCategoria = imagenCategoria;
    }

    public String getDescripcionCategoria() {
        return descripcionCategoria;
    }

    public void setDescripcionCategoria(String descripcionCategoria) {
        this.descripcionCategoria = descripcionCategoria;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    //String
    @Override
    public String toString() {
        return "Categorias{" + "idCategoria=" + idCategoria + ", nombreCategoria=" + nombreCategoria + ", imagenCategoria=" + imagenCategoria + ", descripcionCategoria=" + descripcionCategoria + ", observaciones=" + observaciones + ", activo=" + activo + '}';
    }
    
    
}
