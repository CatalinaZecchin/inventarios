package com.demo.inventarios.domain;

import java.util.Objects;
import javax.persistence.*;


@Entity
@Table
public class Tienda {
    @Id
    @SequenceGenerator(
        name = "tienda_sequence",
        sequenceName = "tienda_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.AUTO,
        generator = "tienda_sequence"
    )
    private String code;
    private String name;


    public Tienda() {
    }

    public Tienda(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Tienda(String name) {
        this.name = name;
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

    public Tienda code(String code) {
        setCode(code);
        return this;
    }

    public Tienda name(String name) {
        setName(name);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Tienda)) {
            return false;
        }
        Tienda tienda = (Tienda) o;
        return Objects.equals(code, tienda.code) && Objects.equals(name, tienda.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    @Override
    public String toString() {
        return "{" +
            " code='" + getCode() + "'" +
            ", name='" + getName() + "'" +
            "}";
    }


}
