package rrhh.controlador;

public class clscargo {
    private int carid;
    private String carnombre;
    private String carestatus;

    public clscargo() {
    }

    public clscargo(int carid) {
        this.carid = carid;
    }
    
    public clscargo(String snombre, String sestado) {
        this.carnombre = snombre;
        this.carestatus = sestado;
    }
    
    public clscargo(int carid, String snombre, String sestado) {
        this.carid = carid;
        this.carnombre = snombre;
        this.carestatus = sestado;
    }
    

    public int getcarid() {
        return carid;
    }

    public void setcarid(int carid) {
        this.carid = carid;
    }

    public String getcarnombre() {
        return carnombre;
    }

    public void setcarnombre(String snombre) {
        this.carnombre = snombre;
    }

    public String getcarestatus() {
        return carestatus;
    }

    public void setcarestatus(String sestado) {
        this.carestatus = sestado;
    }
    @Override
    public String toString() {
        return "tbl_cargo{" + "carid=" + carid + ", carnombre="  +  carnombre +", estatus=" + carestatus +  "}";
    }
    
    
}
