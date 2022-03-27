package com.demo.inventarios.domain;

import java.util.Objects;

public class Producto {
    private String code;
    private String name;
    private Long stock;

    public Producto() {
    }

    public Producto(String code, String name, Long stock) {
        this.code = code;
        this.name = name;
        this.stock = stock;
    }

    public Producto(String name, Long stock) {
        this.name = name;
        this.stock = stock;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return this.stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public Producto code(String code) {
        setCode(code);
        return this;
    }

    public Producto name(String name) {
        setName(name);
        return this;
    }

    public Producto stock(Long stock) {
        setStock(stock);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Producto)) {
            return false;
        }
        Producto producto = (Producto) o;
        return Objects.equals(code, producto.code) && Objects.equals(name, producto.name)
                && Objects.equals(stock, producto.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name, stock);
    }

    @Override
    public String toString() {
        return "{" +
                " code='" + getCode() + "'" +
                ", name='" + getName() + "'" +
                ", stock='" + getStock() + "'" +
                "}";
    }

}
