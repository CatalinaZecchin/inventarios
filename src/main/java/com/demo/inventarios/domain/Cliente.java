package com.demo.inventarios.domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Cliente {
    @Id
    @SequenceGenerator(
        name = "cliente_sequence",
        sequenceName = "cliente_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "cliente_sequence"
    )
    private Long id;
    private String name;

    public Cliente() {
    }

    public Cliente(Long id, String name, String photoURL) {
        this.id = id;
        this.name = name;
        this.photoURL = photoURL;
    }

    public Cliente(String name, String photoURL) {
        this.name = name;
        this.photoURL = photoURL;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhotoURL() {
        return this.photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Cliente id(Long id) {
        setId(id);
        return this;
    }

    public Cliente name(String name) {
        setName(name);
        return this;
    }

    public Cliente photoURL(String photoURL) {
        setPhotoURL(photoURL);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Cliente)) {
            return false;
        }
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(name, cliente.name) && Objects.equals(photoURL, cliente.photoURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, photoURL);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", photoURL='" + getPhotoURL() + "'" +
            "}";
    }
    private String photoURL;
}
