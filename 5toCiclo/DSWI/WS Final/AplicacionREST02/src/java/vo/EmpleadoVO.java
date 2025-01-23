package vo;


public class EmpleadoVO {
    private Integer idempleado;
    private String nomemp;
    private String apeemp;
    private String dniemp;
    private String telemp;
    private String coremp;

    public EmpleadoVO() {
    }

    public EmpleadoVO(Integer idempleado, String nomemp, String apeemp, String dniemp, String telemp, String coremp) {
        this.idempleado = idempleado;
        this.nomemp = nomemp;
        this.apeemp = apeemp;
        this.dniemp = dniemp;
        this.telemp = telemp;
        this.coremp = coremp;
    }

    public Integer getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Integer idempleado) {
        this.idempleado = idempleado;
    }

    public String getNomemp() {
        return nomemp;
    }

    public void setNomemp(String nomemp) {
        this.nomemp = nomemp;
    }

    public String getApeemp() {
        return apeemp;
    }

    public void setApeemp(String apeemp) {
        this.apeemp = apeemp;
    }

    public String getDniemp() {
        return dniemp;
    }

    public void setDniemp(String dniemp) {
        this.dniemp = dniemp;
    }

    public String getTelemp() {
        return telemp;
    }

    public void setTelemp(String telemp) {
        this.telemp = telemp;
    }

    public String getCoremp() {
        return coremp;
    }

    public void setCoremp(String coremp) {
        this.coremp = coremp;
    }
    
    
}
