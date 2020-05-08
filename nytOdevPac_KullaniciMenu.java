package nytOdevPac;
import java.util.*;


public class KullaniciMenu {

    public static void main(String[] args) {

        boolean giris = false;

        while ( giris == false ) {
            Scanner veriGirisi = new Scanner(System.in);
            Database data = new Database();
            String kullaniciAd = null, sifre = null;
            System.out.println("Kullanici Adi : ");
            kullaniciAd = veriGirisi.nextLine();
            System.out.println("Sifre : ");
            sifre = veriGirisi.nextLine();

            giris = data.kullaniciDogrula(kullaniciAd, sifre);

        }

        SicaklikSensoru.getInstance();

        SensorGosterge gosterge =  new SensorGosterge(SicaklikSensoru.getInstance());


        int secim;
        do {
            Scanner secimgiris = new Scanner(System.in);

            System.out.println("\n\nSecim yapiniz\n1)Sıcaklık Göstergesi\n2)Soğutucu Aç\n3)Soğutucu Kapat\n9)Çıkış");
            secim=secimgiris.nextInt();

            switch (secim) {
                case 1 :
                    System.out.println("\nSıcaklık Göstergesi : ");
                    SicaklikSensoru.getInstance().setMeasurements();
                    break;

                case 2 :
                    System.out.println("\nSoğutucu Aç : ");
                    SicaklikSensoru.getInstance().setDurum(true);
                    break;

                case 3 :
                    System.out.println("\nSoğutucu Kapat : ");
                    SicaklikSensoru.getInstance().setDurum(false);

                    break;

                case 9 :
                    System.out.println("\n---Çıkış yapıldı---\n");
                    break;

                default :
                    System.out.println("Hatali secim! 1, 2 , 3 ya da 9'a basiniz.");
                    break;
            }

        }while (secim!=9);

    }

}