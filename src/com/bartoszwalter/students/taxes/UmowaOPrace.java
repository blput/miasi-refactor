package com.bartoszwalter.students.taxes;

/**
 * Created by student on 12.05.2017.
 */
public class UmowaOPrace extends Umowa{

    public UmowaOPrace(String name, double podstawa)
    {
        super(name, podstawa);
    }

    public void oblicz()
    {
        System.out.println(Name);
        System.out.println("Podstawa wymiaru składek " + Podstawa);

        double oPodstawa = obliczonaPodstawa(Podstawa);
//
        obliczUbezpieczenia(oPodstawa);
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                + df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
        System.out.println("Koszty uzyskania przychodu w stałej wysokości "
                + kosztyUzyskania);
        double podstawaOpodat = oPodstawa - kosztyUzyskania;
        double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
        System.out.println("Podstawa opodatkowania " + podstawaOpodat
                + " zaokrąglona " + df.format(podstawaOpodat0));
        obliczPodatek(podstawaOpodat0);

        System.out.println("Kwota wolna od podatku = " + kwotaZmiejsz);
        obliczPodatekPotracony();
        obliczZaliczke();
        double zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
        System.out.println("Zaliczka do urzędu skarbowego = "
                + df00.format(zaliczkaUS) + " po zaokrągleniu = "
                + df.format(zaliczkaUS0));
        double wynagrodzenie = obliczWynagrodzenie();
        System.out.println();
        System.out
                .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                        + df00.format(wynagrodzenie));
    }

    public double obliczWynagrodzenie()
    {
        return Podstawa - ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS);
    }
}
