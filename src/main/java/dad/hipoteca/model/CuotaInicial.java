package dad.hipoteca.model;

import dad.hipoteca.api.Cuota;
import javafx.beans.property.*;

public class CuotaInicial {
    IntegerProperty numero = new SimpleIntegerProperty();
    IntegerProperty anyo = new SimpleIntegerProperty();
    IntegerProperty mes = new SimpleIntegerProperty();
    DoubleProperty capitalInicial = new SimpleDoubleProperty();
    DoubleProperty intereses = new SimpleDoubleProperty();
    DoubleProperty capitalAmortizado = new SimpleDoubleProperty();
    DoubleProperty cuotas = new SimpleDoubleProperty();
    DoubleProperty capitalPendiente = new SimpleDoubleProperty();

    public CuotaInicial() {
    }

    public CuotaInicial(Cuota cuota) {
        numero.set(cuota.getNumero());
        anyo.set(cuota.getAnyo());
        mes.set(cuota.getMes());
        capitalInicial.set(cuota.getCapitalInicial());
        intereses.set(cuota.getIntereses());
        capitalAmortizado.set(cuota.getCapitalAmortizado());
        cuotas.set(cuota.getCuota());
        capitalPendiente.set(cuota.getCapitalPendiente());
    }

    public double getCapitalPendiente() {
        return capitalPendiente.get();
    }

    public DoubleProperty capitalPendienteProperty() {
        return capitalPendiente;
    }

    public void setCapitalPendiente(double capitalPendiente) {
        this.capitalPendiente.set(capitalPendiente);
    }

    public double getCuota() {
        return cuotas.get();
    }

    public DoubleProperty cuotaProperty() {
        return cuotas;
    }

    public void setCuota(double cuota) {
        this.cuotas.set(cuota);
    }

    public double getCapitalAmortizado() {
        return capitalAmortizado.get();
    }

    public DoubleProperty capitalAmortizadoProperty() {
        return capitalAmortizado;
    }

    public void setCapitalAmortizado(double capitalAmortizado) {
        this.capitalAmortizado.set(capitalAmortizado);
    }

    public double getIntereses() {
        return intereses.get();
    }

    public DoubleProperty interesesProperty() {
        return intereses;
    }

    public void setIntereses(double intereses) {
        this.intereses.set(intereses);
    }

    public double getCapitalInicial() {
        return capitalInicial.get();
    }

    public DoubleProperty capitalInicialProperty() {
        return capitalInicial;
    }

    public void setCapitalInicial(double capitalInicial) {
        this.capitalInicial.set(capitalInicial);
    }

    public int getMes() {
        return mes.get();
    }

    public IntegerProperty mesProperty() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes.set(mes);
    }

    public int getAnyo() {
        return anyo.get();
    }

    public IntegerProperty anyoProperty() {
        return anyo;
    }

    public void setAnyo(int anyo) {
        this.anyo.set(anyo);
    }

    public int getNumero() {
        return numero.get();
    }

    public IntegerProperty numeroProperty() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero.set(numero);
    }
}
