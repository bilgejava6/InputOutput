package com.muhammet.LogIslemleri;

public class Runner {
    public static void main(String[] args) {
        DosyaIslemleri ds = new DosyaIslemleri();
        try{
            int sayi = 9;
            int sayi2 = 0;
            int bolum = sayi / sayi2;
        }catch (Exception exception){
            System.out.println("hata......: "+ exception.getMessage());
            ds.createLog(new Log(
                    exception.getMessage(), 1000,
                    "Runner","main",
                    System.currentTimeMillis(),
                    "iki sayının bir birine bölünme işlemi"

            ));
        }

        System.out.println(ds.getLogFile("b1e845cc-2cb4-42cd-9566-a05af3f38ba0").get().toString());
    }
}
