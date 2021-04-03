# BİLGİLER

application.properties' den couchbase için ( username, password ) gerekli bilgilerini düzenle.

Couchbase' e giriş yap.

user ve task bucketları oluştur.

#### user ve task için aşağıdaki iki query yaz

- user için CREATE PRIMARY INDEX `user-primary-index` ON `user` USING GSI;

- task için CREATE PRIMARY INDEX `task-primary-index` ON `task` USING GSI;

### test

- Junit5 testi yazıldı.
  
- Testi çalıştırmak için java 11 ve maven 3.5.2 ( veya üstü ) kullanılmalı.