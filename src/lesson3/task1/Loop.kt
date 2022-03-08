@file:Suppress("UNUSED_PARAMETER")

package lesson3.task1

import kotlin.math.*

// Урок 3: циклы
// Максимальное количество баллов = 9
// Рекомендуемое количество баллов = 7
// Вместе с предыдущими уроками = 16/21

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    if (n == 2) return true
    if (n % 2 == 0) return false
    for (m in 3..sqrt(n.toDouble()).toInt() step 2) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n / 2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
    when {
        n == m -> 1
        n < 10 -> 0
        else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
    }

/**
 * Простая (2 балла)
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
<<<<<<< .merge_file_a62488
fun digitNumber(n: Int): Int =
    when {
        n / 10 == 0 -> 1
        else -> digitNumber(n / 10) + 1
    }
=======
fun digitNumber(n: Int): Int {
    var k = 0
    do (k++) while (n % 10.0.pow(k) != n.toDouble())
    return k
}
>>>>>>> .merge_file_a65148

/**
 * Простая (2 балла)
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int {
<<<<<<< .merge_file_a62488
    var a = 1
    var b = 1
    var res = 2
    while (res < n) {
        res += 1
        val c = b
        b += a
        a = c
    }
    return b
}
=======
    var a = 0
    var b = 1
    var p: Int
    for (j in 2..n) {
        p = b
        b += a
        a = p
    }
    return b
}

>>>>>>> .merge_file_a65148

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    for (i in 2..sqrt(n.toDouble()).toInt()) if (n % i == 0) return i
    return n
}

/**
 * Простая (2 балла)
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int =
    n / minDivisor(n)

/**
 * Простая (2 балла)
 *
 * Гипотеза Коллатца. Рекуррентная последовательность чисел задана следующим образом:
 *
 *   ЕСЛИ (X четное)
 *     Xслед = X /2
 *   ИНАЧЕ
 *     Xслед = 3 * X + 1
 *
 * например
 *   15 46 23 70 35 106 53 160 80 40 20 10 5 16 8 4 2 1 4 2 1 4 2 1 ...
 * Данная последовательность рано или поздно встречает X == 1.
 * Написать функцию, которая находит, сколько шагов требуется для
 * этого для какого-либо начального X > 0.
 */
fun collatzSteps(x: Int): Int {
    var number = x
    var count = 0
    while (number != 1) {
        if (number % 2 == 0) number /= 2
        else number = 3 * number + 1
        count++
    }
    return count
}

/**
 * Средняя (3 балла)
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
<<<<<<< .merge_file_a62488
fun gcd(m: Int, n: Int): Int { //Алгоритм Евклида на нахождение НОД
    var a = maxOf(m, n)
    var b = minOf(m, n)
    var c = a - b
    while (a != b) {
        a = maxOf(c, b)
        b = minOf(c, b)
        c = a - b
    }
    return a
}

fun lcm(m: Int, n: Int): Int = m * n / gcd(m, n)

=======
fun lcm(m: Int, n: Int): Int {
    var r1 = max(m, n)
    var r2 = min(m, n)
    while (r2 != 0) {
        r1 %= r2
        if (r1 == 0) {
            return n * m / r2
        }
        r2 %= r1
    }
    return n * m / r1
}
>>>>>>> .merge_file_a65148
/**
 * Средняя (3 балла)
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
<<<<<<< .merge_file_a62488
fun isCoPrime(m: Int, n: Int): Boolean =
    gcd(m, n) == 1
=======
fun isCoPrime(m: Int, n: Int): Boolean = TODO()
>>>>>>> .merge_file_a65148

/**
 * Средняя (3 балла)
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun revert(n: Int): Int {
    var res = 0
    var number = n
    while (number != 0) {
        res = res * 10 + number % 10
        number /= 10
    }
    return res
}

/**
 * Средняя (3 балла)
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun isPalindrome(n: Int): Boolean =
    revert(n) == n

/**
 * Средняя (3 балла)
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var number = n
    val digit = number % 10
    while (number > 0) {
        if (digit != number % 10) return true
        number /= 10
    }
    return false
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю.
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.sin и другие стандартные реализации функции синуса в этой задаче запрещается.
 */
fun sin(x: Double, eps: Double): Double {
    val a = x % (2 * PI)
    var fact = 1.0
    var power = 1.0
    var walkingMinus = 1
    var finRes = a
    var notFinRes = 1.0
    while (abs(notFinRes) >= eps) {
        walkingMinus *= -1
        fact *= (power + 1) * (power + 2)
        power += 2
        notFinRes = a.pow(power) / fact * walkingMinus
        finRes += notFinRes
    }
    return finRes
}

/**
 * Средняя (4 балла)
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 * Подумайте, как добиться более быстрой сходимости ряда при больших значениях x.
 * Использовать kotlin.math.cos и другие стандартные реализации функции косинуса в этой задаче запрещается.
 */
fun cos(x: Double, eps: Double): Double {
    val a = x % (2 * PI)
    var fact = 1.0
    var power = 0.0
    var walkingMinus = 1
    var finRes = 1.0
    var notFinRes = 1.0
    while (abs(notFinRes) >= eps) {
        power += 2
        walkingMinus *= -1
        fact *= (power - 1) * power
        notFinRes = a.pow(power) / fact * walkingMinus
        finRes += notFinRes
    }
    return finRes
}

/**
 * Сложная (4 балла)
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun squareSequenceDigit(n: Int): Int {
<<<<<<< .merge_file_a62488
    var number = 1
    var line = 1
    while (line < n) {
        number++
        line += digitNumber(number.toDouble().pow(2).toInt())
    }
    return (number.toDouble().pow(2).toInt()) / 10.0.pow(line - n).toInt() % 10
=======
    var digInOrder = 0
    var i = 1.0
    var sqr = 0
    while (digInOrder < n) {
        sqr = i.pow(2).toInt()
        digInOrder += digitNumber(sqr)
        i += 1
    }
    val digit = if (digInOrder == n) {
        sqr % 10
    } else {
        (sqr / 10.0.pow(digInOrder - n).toInt()) % 10
    }
    return digit
>>>>>>> .merge_file_a65148
}

/**
 * Сложная (5 баллов)
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 *
 * Использовать операции со строками в этой задаче запрещается.
 */
fun fibSequenceDigit(n: Int): Int {
<<<<<<< .merge_file_a62488
    var number = 1
    var line = 1
    while (line < n) {
        number++
        line += digitNumber(fib(number))
    }
    return fib(number) / 10.0.pow(line - n).toInt() % 10
=======
    var digInOrder = 0
    var i = 1
    var numbFib = 0
    while (digInOrder < n) {
        numbFib = fib(i)
        digInOrder += digitNumber(numbFib)
        i += 1
    }
    val digit: Int = if (digInOrder == n) {
        numbFib % 10
    } else {
        (numbFib / 10.0.pow(digInOrder - n).toInt()) % 10
    }
    return digit
>>>>>>> .merge_file_a65148
}
