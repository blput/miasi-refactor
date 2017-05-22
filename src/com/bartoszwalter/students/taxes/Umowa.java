package com.bartoszwalter.students.taxes;

import java.text.DecimalFormat;

/**
 * Created by student on 12.05.2017.
 */
public abstract class Umowa {
    protected DecimalFormat df00 = new DecimalFormat("#.00");
    protected DecimalFormat df = new DecimalFormat("#");
    protected String Name;
    protected double s_emerytalna = 0; // 9,76% podstawyy
    protected double s_rentowa = 0; // 1,5% podstawy
    protected double u_chorobowe = 0; // 2,45% podstawy
    protected double Podstawa;


    public double kosztyUzyskania = 111.25;
    public double s_zdrow1 = 0; // od podstawy wymiaru 9%
    public double s_zdrow2 = 0; // od podstawy wymiaru 7,75 %
    public double zaliczkaNaPod = 0; // zaliczka na podatek dochodowy 18%
    public double kwotaZmiejsz = 46.33; // kwota zmienjszająca podatek 46,33 PLN
    public double zaliczkaUS = 0;

    public Umowa(String name, double podstawa) {
        Name = name;
        Podstawa = podstawa;
    }

    public abstract void oblicz();

    public double obliczonaPodstawa(double podstawa) {
        s_emerytalna = (podstawa * 9.76) / 100;
        s_rentowa = (podstawa * 1.5) / 100;
        u_chorobowe = (podstawa * 2.45) / 100;
        wyswietlSkladkiUbezpieczenia();
        double oPodstawa = (podstawa - s_emerytalna - s_rentowa - u_chorobowe);
        System.out.println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                        + oPodstawa);
        return oPodstawa;
    }

    public void wyswietlSkladkiUbezpieczenia() {
        System.out.println("Składka na ubezpieczenie emerytalne "
                + df00.format(s_emerytalna));
        System.out.println("Składka na ubezpieczenie rentowe    "
                + df00.format(s_rentowa));
        System.out.println("Składka na ubezpieczenie chorobowe  "
                + df00.format(u_chorobowe));
    }

    public abstract double obliczWynagrodzenie();

    public void obliczZaliczke() {
        zaliczkaUS = zaliczkaNaPod - s_zdrow2 - kwotaZmiejsz;
    }

    public void obliczPodatek(double podstawa) {
        zaliczkaNaPod = (podstawa * 18) / 100;
        System.out.println("Zaliczka na podatek dochodowy 18 % = " + zaliczkaNaPod);
    }

    public void obliczUbezpieczenia(double podstawa) {
        s_zdrow1 = (podstawa * 9) / 100;
        s_zdrow2 = (podstawa * 7.75) / 100;
    }

    public double obliczPodatekPotracony()
    {
        double podatekPotracony = zaliczkaNaPod - kwotaZmiejsz;
        System.out.println("Podatek potrącony = "
                + df00.format(podatekPotracony));
        return podatekPotracony;
    }

    public void wyswietlInformacje()
    {

    }
}
