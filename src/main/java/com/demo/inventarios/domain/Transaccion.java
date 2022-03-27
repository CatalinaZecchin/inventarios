package com.demo.inventarios.domain;

import java.util.Objects;

public class Transaccion {
    private Long id;
    private Long clientId;
    private String productCode;
    private Long quantity;
    private String time;
    private String tiendaCode;

    public Transaccion() {
    }

    public Transaccion(Long id, Long clientId, String productCode, Long quantity, String time, String tiendaCode) {
        this.id = id;
        this.clientId = clientId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.time = time;
        this.tiendaCode = tiendaCode;
    }

    public Transaccion(Long id, Long clientId, String productCode, Long quantity, String time) {
        this.id = id;
        this.clientId = clientId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.time = time;
    }

    public Transaccion(Long clientId, String productCode, Long quantity, String time) {
        this.clientId = clientId;
        this.productCode = productCode;
        this.quantity = quantity;
        this.time = time;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return this.clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getProductCode() {
        return this.productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTiendaCode() {
        return this.tiendaCode;
    }

    public void setTiendaCode(String tiendaCode) {
        this.tiendaCode = tiendaCode;
    }

    public Transaccion id(Long id) {
        setId(id);
        return this;
    }

    public Transaccion clientId(Long clientId) {
        setClientId(clientId);
        return this;
    }

    public Transaccion productCode(String productCode) {
        setProductCode(productCode);
        return this;
    }

    public Transaccion quantity(Long quantity) {
        setQuantity(quantity);
        return this;
    }

    public Transaccion time(String time) {
        setTime(time);
        return this;
    }

    public Transaccion tiendaCode(String tiendaCode) {
        setTiendaCode(tiendaCode);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Transaccion)) {
            return false;
        }
        Transaccion transaccion = (Transaccion) o;
        return Objects.equals(id, transaccion.id) && Objects.equals(clientId, transaccion.clientId) && Objects.equals(productCode, transaccion.productCode) && Objects.equals(quantity, transaccion.quantity) && Objects.equals(time, transaccion.time) && Objects.equals(tiendaCode, transaccion.tiendaCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientId, productCode, quantity, time, tiendaCode);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", clientId='" + getClientId() + "'" +
            ", productCode='" + getProductCode() + "'" +
            ", quantity='" + getQuantity() + "'" +
            ", time='" + getTime() + "'" +
            ", tiendaCode='" + getTiendaCode() + "'" +
            "}";
    }


}
