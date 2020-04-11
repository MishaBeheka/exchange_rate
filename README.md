# EXCHANGE RATE

## Task :
  * Потрібно розробити простий сайт використовуючи Spring Boot. В якості БД потрібно використовувати  H2 (file)
  * Сайт повинен в зручній формі відображати реальний актуальний курс таких валютних пар:  USD/UAH, EUR/USD, USD/RUB, BTC/USD, ETH/USD, BTC/ETH, BTC/UAH
    Курси потрібно брати з зовнішніх відкритих джерел.
  * Вхід на сайт (та перегляд курсів) дозволено лише зареєстрованим користувачам.  Це потрібно реалізувати за допомогою Spring Security. Зареєструвати нового користувача може будь хто з тих, хто вже зареєстрований. Користувач не може сам себе зареєструвати.
  * Будь хто з зареєстрованих користувачів може переглядати перелік всіх користувачів (їх персональні дані) які зареєстровані на сайті.
  
  <hr>
  
##  All data is obtained from the web-service
   * [min-api.cryptocompare.com](http://min-api.cryptocompare.com)
   
   <hr> 
   
## For users

#### When you start the program, you are taken to the login page.
#### After successful authorization, you will see the homepage,
#### where you can use the five tabs of the top menu:   
   * HOME - always returns you to your homepage;
   * REGISTER A NEW USER - will allow you to register a new user;
   * VIEW THE CURRENT EXCHANGE RATE - you will see exchange rate;
   * RETRIEVE ALL USERS - you will see all users;
   * LOGIN - will return you to the login page;
   
   <hr>
   
   ### Note : 
   For authorization enter EMAIL - "FirstEmail@gmail.com" and PASSWORD - "1".

