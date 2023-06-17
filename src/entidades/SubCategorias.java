package entidades;

import java.util.Objects;

public class SubCategorias {
    private int idSubCategoria;
    private String nombreSubCategoria;
    private String imagenSubCategoria;
    private String observaciones;

    public SubCategorias(int idSubCategoria, String nombreSubCategoria) {
        this.idSubCategoria = idSubCategoria;
        this.nombreSubCategoria = nombreSubCategoria;
    }
    
    public SubCategorias(int idSubCategoria, String nombreSubCategoria, String imagenSubCategoria, String observaciones) {
        this.idSubCategoria = idSubCategoria;
        this.nombreSubCategoria = nombreSubCategoria;
        this.imagenSubCategoria = imagenSubCategoria;
        this.observaciones = observaciones;
    }
    
    public SubCategorias() {
    
    }

    public int getIdSubCategoria() {
        return idSubCategoria;
    }

    public void setIdSubCategoria(int idSubCategoria) {
        this.idSubCategoria = idSubCategoria;
    }

    public String getNombreSubCategoria() {
        return nombreSubCategoria;
    }

    public void setNombreSubCategoria(String nombreSubCategoria) {
        this.nombreSubCategoria = nombreSubCategoria;
    }

    public String getImagenSubCategoria() {
        return imagenSubCategoria;
    }

    public void setImagenSubCategoria(String imagenSubCategoria) {
        this.imagenSubCategoria = imagenSubCategoria;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return nombreSubCategoria;
    }
    
    //Método equals y hasCode()

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.idSubCategoria;
        hash = 41 * hash + Objects.hashCode(this.nombreSubCategoria);
        hash = 41 * hash + Objects.hashCode(this.imagenSubCategoria);
        hash = 41 * hash + Objects.hashCode(this.observaciones);
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
        final SubCategorias other = (SubCategorias) obj;
        if (this.idSubCategoria != other.idSubCategoria) {
            return false;
        }
        if (!Objects.equals(this.nombreSubCategoria, other.nombreSubCategoria)) {
            return false;
        }
        if (!Objects.equals(this.imagenSubCategoria, other.imagenSubCategoria)) {
            return false;
        }
        if (!Objects.equals(this.observaciones, other.observaciones)) {
            return false;
        }
        return true;
    }
    
}
