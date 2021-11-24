package com.danielme.demo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EntityPK implements Serializable {

    private static final long serialVersionUID = 4451186209733902128L;

    private Long idRef1;

    private Long idRef2;

    public Long getIdRef1() {
        return idRef1;
    }

    public void setIdRef1(Long idRef1) {
        this.idRef1 = idRef1;
    }

    public Long getIdRef2() {
        return idRef2;
    }

    public void setIdRef2(Long idRef2) {
        this.idRef2 = idRef2;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idRef1 == null) ? 0 : idRef1.hashCode());
        result = prime * result + ((idRef2 == null) ? 0 : idRef2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EntityPK other = (EntityPK) obj;
        if (idRef1 == null) {
            if (other.idRef1 != null)
                return false;
        } else if (!idRef1.equals(other.idRef1))
            return false;
        if (idRef2 == null) {
            if (other.idRef2 != null)
                return false;
        } else if (!idRef2.equals(other.idRef2))
            return false;
        return true;
    }

}
