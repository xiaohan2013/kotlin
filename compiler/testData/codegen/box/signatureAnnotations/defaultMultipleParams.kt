// IGNORE_BACKEND: JS, NATIVE

// FILE: A.java

import kotlin.internal.*;

class A {
    public int first(@DefaultValue(value = "1") int a, @DefaultValue(value = "2") int b) {
        return 100 * a + b;
    }

    public int second(int a, @DefaultValue(value = "42") int b) {
        return 100 * a + b;
    }
}

// FILE: main.kt
fun box(): String {
    val a = A()

    if (a.first() != 102) {
        return "FAIL 1"
    }

    if (a.first(2) != 202) {
        return "FAIL 2"
    }

    if (a.first(3, 4) != 304)  {
        return "FAIL 3"
    }

    if (a.second(7, 8) != 708) {
        return "FAIL 4"
    }

    if (a.second(1) != 142) {
        return "FAIL 5"
    }

    return "OK"
}