# Q6
Какой результат компиляции и выполнении данного кода?

```java
public class Clazz {
    private void process(String... s) {
        System.out.print("*");
    }
    private void process(String s) {
        System.out.print("1");
    }
    private void process(String s, String a) {
        System.out.print("2");
    }
    public static void main(String[] args) {
        Clazz c = new Clazz();
        c.process("asd");
        c.process("asd","asd");
        c.process("asd","asd","asd");
    }
}
```

    1) *** 
    2) 12* 
    3) 1** 
    4) Ошибка выполнения 
    5) Ошибка компиляции

## Пояснение

При вызове перегружаемого метода для определения нужного его варианта в Java используется тип и/или количество аргументов метода.

## Правильный ответ
2) 12*


