# LinkedListPolinomAritmetik
Polinomlar üzerinde toplama ve çıkarma programı

Bu program iki adet tek değişkenli polinomu kullanıcı isteğine göre toplar ya da çıkarır.

LinkedList.java, Node.java sınıflarından ve hesaplama.java JFrameForm’undan oluşur.

Kullanıcı arayüzü olan hesaplama.java :

    • Dosya okuma ve matematiksel hesaplama yapma için iki adet düğme
    
    • Polinomların görüntülenmesi için bir adet yazı alanı(TextArea)
    
    • İşlem sonrası denklem ve sayısal değer gösterimi için iki adet textfield
    
    • Başlıklar için birkaç adet label’dan
oluşur.

Node sınıfı, içerisinde iki adet generic tipli veriden ve bir sıralı liste için gerekli olan, sonraki düğümü gösterecek next adında bir Node nesnesinden oluşur.

LinkedList sınıfı ise listenin ilk elemanını tutan bir adet head Node nesnesi ve liste boyutu için size değişkeni tutmakta, liste üzerinde gerekli işlemler için methodlardan oluşmaktadır.

Kullanıcının hesaplama işlemlerini gerçekleştirebilmesi için tüm bu gerekli yapılar hesaplama.java içersinde kullanılmaktadır.

Ayrıca polinomlar ve değişkenin alacağı değer, kullanıcının belirlediği bir txt içersinde olmalıdır.

Txt dosyası içersinde, iki adet denklemin, ayrı satırlarda alt alta gelecek şekilde olması gerekmektedir. Çıkartma işleminde ikinci satırdaki polinom birinci satırdakinden çıkartılır. Ayrıca değişkenin alacağı değer de en alt yani üçüncü satıra denk gelmelidir. Bu, polinomun sayısal bir değer alabilmesi içindir. Denklemlerde değişken x ile,  kuvveti varsa x ile kuvvet arasına ‘^’ koyularak ifade edilir. Eğer, x’in katsayısı yoksa, mutlaka 1x olarak yazılmalıdır.

Örnek 1

18x^75-4x^56+18x^37+18x^19-18x^9-12

17x^56+18x^44-11x^37-21x^19+94

2


Kullanıcı arayüzünde “dosya oku” düğmesi ile bir dosya seçici (JfileChooser) aracılığıyla uygun formatlı bir txt dosyası seçilmelidir. Bu işlemin ardından dosya içersindeki iki polinom, textArea içersine yazdırılır. Seçim sonrası döngü ile bir String objesine(karakter dizisi) teker teker satırlar atanır. Atanan ilk iki satırda, önceden oluşturulmuş “tek bağlantılı sıralı liste” (singly linked list) objesinin yapısında bulunan, her biri iki adet veri tutan düğümlerin(node), birinci verisine x’in katsayısı, ikincisine ise kuvveti kopyalanır. Kopyalama işleminde, txt dosyasından gelen satır, bir String methodu olan split ile ilk olarak terimlere ayrılır ardından ikinci bir split işlemiyle terim içindeki x ve ^ karakterleri temizlendikten sonra, düğümlere aktarılır. Split işlemi sırasında regex’e yer verilmiştir. 

Düğümler sadece bir terimden oluşur. Bir singly linked listte polinomdaki terim sayısı kadar düğüm bulunur. Sabit sayılar düğümlerin katsayılarının tutulduğu birinci veri alanına kaydedilir ve kuvvet verisine 1 atanır. Kuvveti olmayan xli terimde ise kuvvet verisine 1 değeri atanır.

Örnek 2

18x^75 -> [(18)(75)] , 44x -> [(44)(1)] ve 19 -> [(19)(0)] şeklinde. 


Oluşturulan iki adet singly linked list, list1.txt ile list2.txt dosyasına yazdırılır.

İki polinom için iki ayrı “tek bağlı sıralı liste” kullanılmıştır. Hesapla düğmesi yanında bulunan işlem seçeneklerinden toplama ya da çıkarma için ‘+’ veya ‘-’ seçilir. Hesapla düğmesine basıldığında, iki adet denklem içersindeki tüm terimler, yeni bir LinkedList’e aktarılır. 

LinkedList sınıfı içersinde bulunan simplification methodu kullanılarak, aynı kuvvete sahip olan terimlerin katsayıları kendi aralarında toplanır. Toplanan bu ifade farklı bir LinkedListe eklenir ancak toplam işleminde kullanılan düğümler fazlalık oluşturduğundan eski LinkedList içersinden silinir. En son eski LinkListler içerisinde kalan sadeleşmemiş terimler de yeni oluşturduğumuz LinkedList’e eklenir. Sabit sayılar da kendi aralarında toplanır. Bu sayede daha sade bir görünüm kazanan polinom kullanıcıya sunulur.

Denklemin sayısal sonucu, primitive değişkenlerle tutulabilecek en büyük sayı değerini aştığından BigInteger sınıfı kullanılmıştır. Math kütüphanesi de kullanılmıştır. Denklemin sayısal sonucu da kullanıcıya sunulmaktadır. Çıkarma işlemi içinse ikinci polinomun tüm katsayıları -1 ile çarpılmıştır.
