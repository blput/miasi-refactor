package com.bartoszwalter.students.taxes;

/**
 * Created by student on 12.05.2017.
 */
public class UmowaZlecenie extends Umowa{
    public UmowaZlecenie(String name, double podstawa)
    {
        super(name, podstawa);
    }
    public void oblicz()
    {
        System.out.println("UMOWA-ZLECENIE");
        System.out.println("Podstawa wymiaru składek " + Podstawa);

        wyswietlSkladkiUbezpieczenia();

        double oPodstawa = obliczonaPodstawa(Podstawa);
        System.out
                .println("Podstawa wymiaru składki na ubezpieczenie zdrowotne: "
                        + oPodstawa);
        obliczUbezpieczenia(oPodstawa);
        System.out.println("Składka na ubezpieczenie zdrowotne: 9% = "
                + df00.format(s_zdrow1) + " 7,75% = " + df00.format(s_zdrow2));
        kwotaZmiejsz = 0;
        kosztyUzyskania = (oPodstawa * 20) / 100;
        System.out.println("Koszty uzyskania przychodu (stałe) "
                + kosztyUzyskania);
        double podstawaOpodat = oPodstawa - kosztyUzyskania;
        double podstawaOpodat0 = Double.parseDouble(df.format(podstawaOpodat));
        System.out.println("Podstawa opodatkowania " + podstawaOpodat
                + " zaokrąglona " + df.format(podstawaOpodat0));
        obliczPodatek(podstawaOpodat0);
        System.out.println("Zaliczka na podatek dochodowy 18 % = "
                + zaliczkaNaPod);
        double podatekPotracony = zaliczkaNaPod;
        System.out.println("Podatek potrącony = "
                + df00.format(podatekPotracony));
        obliczZaliczke();
        double zaliczkaUS0 = Double.parseDouble(df.format(zaliczkaUS));
        System.out.println("Zaliczka do urzędu skarbowego = "
                + df00.format(zaliczkaUS) + " po zaokrągleniu = "
                + df.format(zaliczkaUS0));
        double wynagrodzenie = Podstawa
                - ((s_emerytalna + s_rentowa + u_chorobowe) + s_zdrow1 + zaliczkaUS0);
        System.out.println();
        System.out
                .println("Pracownik otrzyma wynagrodzenie netto w wysokości = "
                        + df00.format(wynagrodzenie));
    }

    public double obliczWynagrodzenie()
    {
        return 0.0;
    }
}
