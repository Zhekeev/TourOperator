package entity;

import java.util.Objects;

public class ServiceContract {
    private Integer idContract;
    private Integer idService;

    public ServiceContract(){

    }

    public Integer getIdContract() {
        return idContract;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ServiceContract that = (ServiceContract) o;
        return Objects.equals(idContract, that.idContract) &&
                Objects.equals(idService, that.idService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContract, idService);
    }

    @Override
    public String toString() {
        return "ServiceContract{" +
                "idContract=" + idContract +
                ", idService=" + idService +
                '}';
    }
}
