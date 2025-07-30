package enums;

public enum AgencyLocality {
    SP("São Paulo - Centro"),
    RJ("Rio de Janeiro - Copacabana"),
    BH("Belo Horizonte - Savassi"),
    PoA("Porto Alegre - Moinhos"),
    SSA("Salvador - Barra"),
    CWB("Curitiba - Centro");

    private final String locality;

    AgencyLocality(String locality){
        this.locality = locality;
    }

    public String getLocality() {
        return locality;
    }

    @Override
    public String toString() {
        return  locality;
    }
}
