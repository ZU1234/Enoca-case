### Service Paketi
Tüm veri tabanı işlemleri bu pakette yapılır.

### Model Paketi
Company ve Employee sınıflarını barındırır. 

@Entity — Sınıfın bir varlık olduğunu ve bir veritabanı tablosuna eşlendiğini belirtir.
@Table — Varlığın eşlendiği tablo adını belirtir

@Id — Özelliğin tablodaki Id olduğunu belirtir
@Column — Özelliğin tabloda belirtilen ada sahip bir sütun olduğunu belirtir.

Anatasyonları kullanılır.

### Controller Paketi
hangi yöntemin ne zaman ve nasıl çağrılacağına karar veren sınıfları içerir.

@Controller — Sınıfın, uygulamanın denetleyici kısmı olduğunu gösterir.

@Autowired — Kontrolün Ters Çevirilmesi içindir. 'CompanyService' projesi nesnesi için bağımlılık kontrolü uygulamaya enjekte edilir veya tersine çevrilir. Buna bağımlılık enjeksiyonu denir

@RequestMapping — Belirli bir URL modeliyle karşılaşıldığında yöntemin çağrılması gerektiğini belirtir.
#### Advice Paketi
Hata sınıflarını yakalar. Bir sorgu atıldığında bir hata meydana geliyorsa ve bu exception paketi içerisindeki 
sınıflarda belirtilmiş ise sorgu atılan method işlemi hatanın olduğu kısma kadar çalışır ve hata kısmında işlem 
durur. Belirtilen hata sınıfı fırlatılır. Advice paketi içerisindeki sınıf bu hatayı yakalar. İstek olarak verir.



### Exception Paketi
Programın çalışma zamanında hata mesajı olarak fırlatacağı sınıfları içerir.

### Converter Paketi
Sınıfların birbirine dönüştüğü methosları içeren sınıflar bulunur.

### Response Paketi
Gelen isteğe göre verilecek çıktıların bulunduğu sınıfları içerir.

### Request Paketi
İsteklerin sınıflarını içerir.



