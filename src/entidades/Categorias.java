package entidades;

import java.util.Objects;

public class Categorias {
    private int idCategoria;
    private String nombreCategoria;
    private String imagenCategoria;
    private String descripcionCategoria;
    private String observaciones;
    private boolean activo;

    public Categorias(int idCategoria, String nombreCategoria) {
        this.idCategoria = idCategoria;
        this.nombreCategoria = nombreCategoria;
    }
    
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
        return nombreCategoria;
    }
    
    //Método equals y hasCode()
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idCategoria;
        hash = 47 * hash + Objects.hashCode(this.nombreCategoria);
        hash = 47 * hash + Objects.hashCode(this.imagenCategoria);
        hash = 47 * hash + Objects.hashCode(this.descripcionCategoria);
        hash = 47 * hash + Objects.hashCode(this.observaciones);
        hash = 47 * hash + (this.activo ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Categorias other = (Categorias) obj;
        if (this.idCategoria != other.idCategoria) {
            return false;
        }
        if (!Objects.equals(this.nombreCategoria, other.nombreCategoria)) {
            return false;
        }
        if (!Objects.equals(this.imagenCategoria, other.imagenCategoria)) {
            return false;
        }
        if (!Objects.equals(this.descripcionCategoria, other.descripcionCategoria)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        if (this.activo != other.activo) {
            return false;
        }
        return true;
    }
    
}
