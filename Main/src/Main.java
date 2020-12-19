
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
/*
Burada Amacımız yaptığımız işlemleri bir dosyaya yazmak 
Her Hareketi yaptıktan sonra dosyaya yazmak amacımız ...
 
*/


public class Main {
    public static void main(String[] args) {
        // Idman Oluşturma Programı
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Idman Programına Hoşgeldiniz...");
        
        String idmanlar = "Geçerli Hareketler...\n"
                          + "Burpee\n"
                          +"Pushup(Şınav)\n"
                          +"Situp(Mekik)\n"
                          +"Squat";
        System.out.println(idmanlar);
        
        System.out.println("Bir idman oluşturun...");
        
        System.out.print("Burpee Sayısı : ") ;
        int burpee = scanner.nextInt();
        System.out.print("Pushup Sayısı : ") ;
        int pushup = scanner.nextInt();
        System.out.print("Situp Sayısı : ") ;
        int situp = scanner.nextInt();
        System.out.print("Squat Sayısı : ") ;
        int squat = scanner.nextInt();
        
        scanner.nextLine();
        
    
        Idman idman = new Idman(burpee, pushup, situp, squat);
        
        System.out.println("İdmanınız Başlıyor.....");
        
        int i = 1;//extra first
        
        try(FileWriter filewriter = new FileWriter("log.txt",true)){//üzerine yazmak isteiyorum
            
            
            filewriter.write("Idman Programınız\n");
            
            filewriter.write("Burpee Sayınız : " + idman.getBurpee_sayisi()+"\n");
            filewriter.write("Pushup Sayınız : " + idman.getPushup_sayisi()+"\n");
            filewriter.write("Situp Sayınız : " + idman.getSitup_sayisi()+"\n");
            filewriter.write("Squat Sayınız : " + idman.getSquat_sayisi()+"\n");
            
            
        
        while (idman.idmanBittiMi() == false){
            
            System.out.print("Hareket Türü(Burpee,Pushup,Situp,Squat) : ");
            String tur = scanner.nextLine();
            System.out.print("Bu hareketten kaç tane yapacaksınız ? : ");
            int sayi = scanner.nextInt();
            scanner.nextLine();
            idman.hareketYap(tur, sayi);
            
            filewriter.write(i+" . islem -------------->>> Hareket : " +tur +" Sayı : "+sayi+"\n");
            i++;
            filewriter.write("/////////////////////////////////////////\n"
                                + "****************************************\n"
                                + "----------------------------------------\n");
            
        }
          System.out.println("Idmanını başarıyla bitirdin....");
        }catch(IOException e ){
            System.out.println("İşlem sırasında bir IOException Meydana geldi");
        }finally{
              System.out.println("/////////////////////////////////////////\n"
                                + "****************************************\n"
                                + "----------------------------------------\n");
        }
      
    
      
    }
}
