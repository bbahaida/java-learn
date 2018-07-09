package com.bahaida.io;

import java.io.Serializable;
import java.util.Date;

public class Operation implements Serializable{
    private int numero;
    private Date date;
    private double montant;

    public Operation(int numero, Date date, double montant) {
        this.numero = numero;
        this.date = date;
        this.montant = montant;
    }

    public Operation() {
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "numero=" + numero +
                ", date=" + date +
                ", montant=" + montant +
                '}';
    }
}
