# Q5
Возникнут ли ошибки компиляции и если да, то в каких строках? (возможно несколько вариантов ответа)

```java
public class Foo {
    private Foo() {
        return this; // 1
    }
    public static Foo get() {
        return new Foo(); // 2
    }
    public static void main(String[] args) {
        Foo foo1 = get(); // 3
        Foo foo2 = new Foo(); // 4
    }
}
```

    1) Код скомпилируется без ошибок
    2) Ошибка компиляции в строке 1
    3) Ошибка компиляции в строке 2
    4) Ошибка компиляции в строке 3
    5) Ошибка компиляции в строке 4

## Пояснение

Ошибка будет в строке 1:

Error:(3, 16) java: incompatible types: unexpected return value

## Правильный ответ
2) Ошибка компиляции в строке 1


