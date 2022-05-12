# Laboratuar Raporları Yönetim Sistemi

# Kurulum

CLI ile çalışan bir maven ve JDK 13'e sahip olmak yeterli.

Komut satırında projenin kök klasörüne ulaşıldığında kodu çalıştırmak yeterli.
```sh
mvn spring-boot:run
```

Komut satırı belirtilen portta(8081) Spring Boot uygulamasını başlatacak ve Default olarak belirlenen URL'den ulaşılabilir olacaktır.

# Gerekli Bilgiler

Default URL : http://localhost:8081/

Veritabanı Konsol URL : http://localhost:8081/h2-console

> Veritabanı Kullanıcı Adı: admin  
> Veritabanı Kullanıcı Şifresi : pwd 

# Kullanıcı Listesi

> Kullanıcı Adı : Admin     
> Şifre : pwd  
> Yetkinlik: Admin   

> Kullanıcı Adı : Furkan  
> Şifre : pwd  
> Yetkinlik: Admin  

> Kullanıcı Adı : Omer  
> Şifre : pwd  
> Yetkinlik: User  

Konsol üzerinden farklı veritabanı dosyalarının kontrolü için gerekli URL listesi  

Reports/Workers file location : jdbc:h2:./reports-file  
Users file location : jdbc:h2:./users
