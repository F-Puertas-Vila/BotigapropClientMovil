package fernandopuertas.ioc.botigapropclientmovil;

public class Usuari {

    private String nom, email, rol, contrasenya;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Usuari(String CLIENT, String nom, String email, String contrasenya) {
        this.rol = CLIENT;
        this.nom = nom;
        this.email = email;
        this.contrasenya = contrasenya;
    }
    public Usuari(String nomUsuari, String contrasenya){
        this.email = nomUsuari;
        this.contrasenya = contrasenya;
    }


}