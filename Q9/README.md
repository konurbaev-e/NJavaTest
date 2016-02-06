# Q8
Какой результат будет получен после компиляции и выполнения данного кода?

```java
public class Main {
    public static void main(String[] str) {
        outer:
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("Hello");
                continue outer;
            }
            System.out.println("outer");
        }
        System.out.println("Good-Bye");
    }
}
```

    1) Программа будет бесконечно выводить "Hello"
    2) Hello
       Hello
       outer
       Hello
       Hello
       outer
       Good-Bye
    3) Hello
       outer
       Hello
       outer
       Good-Bye
    4) Ошибка компиляции 
    5) Hello
       Hello
       Good-Bye
    6) Hello
       Good-Bye

## Правильный ответ
5) Hello

   Hello
   
   Good-Bye


