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


# Kullanılan Teknik Seçimleri/Kabulleri

Spring ile 4 katmanlı bir yapı içerisinde uygulamayı gerçekleştirdim. Bu katmanlar sırasıyla ve birbirleri arasındaki bağlantıları gösterecek şekilde şöyledir: 
```sh
Presentation Layer(resources/static altında bulunan HTML dosyaları) <--> Controller Layer(MainController ve ReportController)
<--> Service Layer(ReportService, WorkerService ve onların implementasyonları) <--> Persistance Layer(ReportRepository ve WorkerRepository)
```

Bu şekilde birbirleriyle iletişim ve uyum içerisinde bir yapının en büyük faydası herhangi bir katmanda yapılacak değişikliklerin diğer katmanları etkilememesidir ve ayrıca böyle katmanlı yapılar Java EE için - ki özellikle Spring ile beraber gelen Dependancy Injection özelliği ile - çok daha basit ve kullabilir hale gelmektedir.

Veritabanı tarafında ise iki ayrı veritabanı kullanıldı. Birincisi yetkilendirilmiş kullanıcılar için bir diğeri ise raporların ve laborantlar için 
kullanıldı. Admin yetkisine sahip olmayan kullanıcılar için Thymeleaf'ın sağladığı özellik ile beraber silme, yeni rapor ve laborant ekleme butonları gizlendi. 
