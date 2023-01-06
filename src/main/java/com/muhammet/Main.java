package com.muhammet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {
        /**
         * dosyanın yolu -> c:\logdata\
         * dosyanın adı ->  [AD].[UZANTI] -> hata.log / ASarkı.mp3 / film.mp4 / gezi.jpg / notlar.docx
         * MAC: /Users/muhammetali/LogData/
         */
        String ifade = "selam bir söz vardır: \"erken kalakan yol alır\" ";
        String fileUrl = "c:\\LogData\\";
        File file = new File(fileUrl+"sistem.log");
        /**
         * Gerekli olduğunda dosyayı oluşturabilirsiniz.
         * Genellikle File, var olan dosyalarımız üzerinde işlem yapmak için kullanılır.
         */
        System.out.println("Dosya var mı............: "+ file.exists()); // true
        System.out.println("Dosya Tam yolu..........: "+ file.getAbsolutePath()); // c:\LogData\sistem.log
        System.out.println("Dosya adı...............: "+ file.getName()); // sistem.log
        System.out.println("Dosyanın konumu.........: "+ file.getParent()); // c:\LogData
        System.out.println("Bu bir dosya mıdır......: "+ file.isFile()); // true
        System.out.println("Boyut - byte............: "+ file.length()); // 4
        System.out.println("Son değiştirilme Zamanı.: "+ file.lastModified()); // 1672990688336

        Path path = Path.of("c:/LogData/sistem.log");
        /**
         * Dosya işlemlerini yönetmek için Files kullanılır. yaygındır.
         * Dosya Kopyalama
         * Dosya Silme
         * Dosyayı sorgulama işlemleri için kullanılır.
         */
        System.out.println("Files - Dosya var mı.....: "+ Files.exists(path));
        //path = Path.of("c:/LogData/resim.bmp");
        /**
         * Dosya işlemleri yapılırken, dosya adlarının yanlış yazılması
         * ya da var olmayan dosyaların üzerinde işlem yapılmaya çalışılması
         * sorunlara neden olacaktır. bu nedenle dosya işlemlerinde exception
         * kullanılır.
         */
        //Files.setAttribute(path,"dos:readonly",false);
        //Files.setAttribute(path,"dos:hidden",false);
        //Files.delete(path);  // dosya var ise siler yok ise hata fırlatır.
        //Files.deleteIfExists(path);  // dosya var ise siler. yok ise bişey yapmaz.
        //Files.copy(path,Path.of("c:/LogData/sistem_yedek.log")); // dosyayı başka bir hedefe kopyalar, eğer
        // daha önceden böyle bir dosya var ise hata fırlatır.
        /**
         * DİKKAT!!!!
         * dosyayı istediğiniz başkabir dosyaya yazar. ancak dikkat etmeniz gereken şey. dosya aynı isim ile
         * mevcut ise o dosyayı değiştirerek üzerinde yazar.
         * -> PC resimlerini kopyalıyoruz.
         * -> Modem, Laptop, Monitör
         * bir hata yaptık, döngüde tekrara düştük. 1.PC, 2.Modem, 3.Laptop
         * yanlışıkla -> 1.PC, 2.PC, 3.PC
         */
        Files.copy(path,Path.of("c:/LogData/sistem_yedek.log"), StandardCopyOption.REPLACE_EXISTING);
        Files.move(path,Path.of("c:/LogData/yedek/sistem"+new Date().getYear()+".log"),StandardCopyOption.REPLACE_EXISTING);
    }
}