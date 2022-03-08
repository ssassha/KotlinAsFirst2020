@file:Suppress("UNUSED_PARAMETER", "ConvertCallChainIntoSequence")

package lesson7.task1

import java.io.File

// Урок 7: работа с файлами
// Урок интегральный, поэтому его задачи имеют сильно увеличенную стоимость
// Максимальное количество баллов = 55
// Рекомендуемое количество баллов = 20
// Вместе с предыдущими уроками (пять лучших, 3-7) = 55/103

/**
 * Пример
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Вывести его в выходной файл с именем outputName, выровняв по левому краю,
 * чтобы длина каждой строки не превосходила lineLength.
 * Слова в слишком длинных строках следует переносить на следующую строку.
 * Слишком короткие строки следует дополнять словами из следующей строки.
 * Пустые строки во входном файле обозначают конец абзаца,
 * их следует сохранить и в выходном файле
 */
fun alignFile(inputName: String, lineLength: Int, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    var currentLineLength = 0
    fun append(word: String) {
        if (currentLineLength > 0) {
            if (word.length + currentLineLength >= lineLength) {
                writer.newLine()
                currentLineLength = 0
            } else {
                writer.write(" ")
                currentLineLength++
            }
        }
        writer.write(word)
        currentLineLength += word.length
    }
    for (line in File(inputName).readLines()) {
        if (line.isEmpty()) {
            writer.newLine()
            if (currentLineLength > 0) {
                writer.newLine()
                currentLineLength = 0
            }
            continue
        }
        for (word in line.split(Regex("\\s+"))) {
            append(word)
        }
    }
    writer.close()
}

/**
 * Простая (8 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * Некоторые его строки помечены на удаление первым символом _ (подчёркивание).
 * Перенести в выходной файл с именем outputName все строки входного файла, убрав при этом помеченные на удаление.
 * Все остальные строки должны быть перенесены без изменений, включая пустые строки.
 * Подчёркивание в середине и/или в конце строк значения не имеет.
 */
fun deleteMarked(inputName: String, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    for (line in File(inputName).readLines()) {
        if (!line.startsWith('_')) {
            writer.write(line)
            writer.newLine()
        }
    }
    writer.close()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст.
 * На вход подаётся список строк substrings.
 * Вернуть ассоциативный массив с числом вхождений каждой из строк в текст.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 */
fun countSubstrings(inputName: String, substrings: List<String>): Map<String, Int> {
    val res = mutableMapOf<String, Int>()
<<<<<<< .merge_file_a38604
    val subs = substrings.toSet().toList()
    File(inputName).forEachLine {
        for (key in subs) {
            var count = 0
            var line = it.toLowerCase()
            while (line.contains(key.toLowerCase())) {
                count++
                line = line.removeRange(0..line.indexOf(key.toLowerCase(), 0))
            }
            res[key] = res.getOrDefault(key, 0) + count
        }
    }
    return res.toMap()
=======
    val text = File(inputName).readLines().toString()

    for (substr in substrings) {
        var textCopy = text
        var count = 0
        while (textCopy.contains(substr, ignoreCase = true)) {
            count++
            textCopy = textCopy.removeRange(0..textCopy.indexOf(substr, 0, true))
        }

        res[substr] = count
    }
    return res
>>>>>>> .merge_file_a56284
}


/**
 * Средняя (12 баллов)
 *
 * В русском языке, как правило, после букв Ж, Ч, Ш, Щ пишется И, А, У, а не Ы, Я, Ю.
 * Во входном файле с именем inputName содержится некоторый текст на русском языке.
 * Проверить текст во входном файле на соблюдение данного правила и вывести в выходной
 * файл outputName текст с исправленными ошибками.
 *
 * Регистр заменённых букв следует сохранять.
 *
 * Исключения (жюри, брошюра, парашют) в рамках данного задания обрабатывать не нужно
 *
 */
fun sibilants(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (15 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по центру
 * относительно самой длинной строки.
 *
 * Выравнивание следует производить путём добавления пробелов в начало строки.
 *
 *
 * Следующие правила должны быть выполнены:
 * 1) Пробелы в начале и в конце всех строк не следует сохранять.
 * 2) В случае невозможности выравнивания строго по центру, строка должна быть сдвинута в ЛЕВУЮ сторону
 * 3) Пустые строки не являются особым случаем, их тоже следует выравнивать
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых)
 *
 */
fun centerFile(inputName: String, outputName: String) {
    TODO()
}

/**
 * Сложная (20 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 * Вывести его в выходной файл с именем outputName, выровняв по левому и правому краю относительно
 * самой длинной строки.
 * Выравнивание производить, вставляя дополнительные пробелы между словами: равномерно по всей строке
 *
 * Слова внутри строки отделяются друг от друга одним или более пробелом.
 *
 * Следующие правила должны быть выполнены:
 * 1) Каждая строка входного и выходного файла не должна начинаться или заканчиваться пробелом.
 * 2) Пустые строки или строки из пробелов трансформируются в пустые строки без пробелов.
 * 3) Строки из одного слова выводятся без пробелов.
 * 4) Число строк в выходном файле должно быть равно числу строк во входном (в т. ч. пустых).
 *
 * Равномерность определяется следующими формальными правилами:
 * 5) Число пробелов между каждыми двумя парами соседних слов не должно отличаться более, чем на 1.
 * 6) Число пробелов между более левой парой соседних слов должно быть больше или равно числу пробелов
 *    между более правой парой соседних слов.
 *
 * Следует учесть, что входной файл может содержать последовательности из нескольких пробелов  между слвоами. Такие
 * последовательности следует учитывать при выравнивании и при необходимости избавляться от лишних пробелов.
 * Из этого следуют следующие правила:
 * 7) В самой длинной строке каждая пара соседних слов должна быть отделена В ТОЧНОСТИ одним пробелом
 * 8) Если входной файл удовлетворяет требованиям 1-7, то он должен быть в точности идентичен выходному файлу
 */
fun alignFileByWidth(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (14 баллов)
 *
 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * Вернуть ассоциативный массив, содержащий 20 наиболее часто встречающихся слов с их количеством.
 * Если в тексте менее 20 различных слов, вернуть все слова.
 * Вернуть ассоциативный массив с числом слов больше 20, если 20-е, 21-е, ..., последнее слова
 * имеют одинаковое количество вхождений (см. также тест файла input/onegin.txt).
 *
 * Словом считается непрерывная последовательность из букв (кириллических,
 * либо латинских, без знаков препинания и цифр).
 * Цифры, пробелы, знаки препинания считаются разделителями слов:
 * Привет, привет42, привет!!! -привет?!
 * ^ В этой строчке слово привет встречается 4 раза.
 *
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 * Ключи в ассоциативном массиве должны быть в нижнем регистре.
 *
 */
fun top20Words(inputName: String): Map<String, Int> = TODO()

/**
 * Средняя (14 баллов)
 *
 * Реализовать транслитерацию текста из входного файла в выходной файл посредством динамически задаваемых правил.

 * Во входном файле с именем inputName содержится некоторый текст (в том числе, и на русском языке).
 *
 * В ассоциативном массиве dictionary содержится словарь, в котором некоторым символам
 * ставится в соответствие строчка из символов, например
 * mapOf('з' to "zz", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "yy", '!' to "!!!")
 *
 * Необходимо вывести в итоговый файл с именем outputName
 * содержимое текста с заменой всех символов из словаря на соответствующие им строки.
 *
 * При этом регистр символов в словаре должен игнорироваться,
 * но при выводе символ в верхнем регистре отображается в строку, начинающуюся с символа в верхнем регистре.
 *
 * Пример.
 * Входной текст: Здравствуй, мир!
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Пример 2.
 *
 * Входной текст: Здравствуй, мир!
 * Словарь: mapOf('з' to "zZ", 'р' to "r", 'д' to "d", 'й' to "y", 'М' to "m", 'и' to "YY", '!' to "!!!")
 *
 * заменяется на
 *
 * Выходной текст: Zzdrавствуy, mир!!!
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun transliterate(inputName: String, dictionary: Map<Char, String>, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Во входном файле с именем inputName имеется словарь с одним словом в каждой строчке.
 * Выбрать из данного словаря наиболее длинное слово,
 * в котором все буквы разные, например: Неряшливость, Четырёхдюймовка.
 * Вывести его в выходной файл с именем outputName.
 * Если во входном файле имеется несколько слов с одинаковой длиной, в которых все буквы разные,
 * в выходной файл следует вывести их все через запятую.
 * Регистр букв игнорировать, то есть буквы е и Е считать одинаковыми.
 *
 * Пример входного файла:
 * Карминовый
 * Боязливый
 * Некрасивый
 * Остроумный
 * БелогЛазый
 * ФиолетОвый

 * Соответствующий выходной файл:
 * Карминовый, Некрасивый
 *
 * Обратите внимание: данная функция не имеет возвращаемого значения
 */
fun chooseLongestChaoticWord(inputName: String, outputName: String) {
    val writer = File(outputName).bufferedWriter()
    val res = mutableListOf<String>()
    var maxSize = 0
    for (line in File(inputName).readLines()) {
        if (line.toLowerCase().toSet().size == line.toLowerCase().length) {
            if (line.length > maxSize) {
                res.clear()
                res.add(line)
                maxSize = line.length
            } else if (line.length == maxSize) res.add(line)
        }
    }
    for (i in res) {
        if (i != res.last()) writer.append(i, ", ")
        else writer.write(i)
    }
    writer.close()
}

/**
 * Сложная (22 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе элементы текстовой разметки следующих типов:
 * - *текст в курсивном начертании* -- курсив
 * - **текст в полужирном начертании** -- полужирный
 * - ~~зачёркнутый текст~~ -- зачёркивание
 *
 * Следует вывести в выходной файл этот же текст в формате HTML:
 * - <i>текст в курсивном начертании</i>
 * - <b>текст в полужирном начертании</b>
 * - <s>зачёркнутый текст</s>
 *
 * Кроме того, все абзацы исходного текста, отделённые друг от друга пустыми строками, следует обернуть в теги <p>...</p>,
 * а весь текст целиком в теги <html><body>...</body></html>.
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 * Отдельно следует заметить, что открывающая последовательность из трёх звёздочек (***) должна трактоваться как "<b><i>"
 * и никак иначе.
 *
 * При решении этой и двух следующих задач полезно прочитать статью Википедии "Стек".
 *
 * Пример входного файла:
Lorem ipsum *dolor sit amet*, consectetur **adipiscing** elit.
Vestibulum lobortis, ~~Est vehicula rutrum *suscipit*~~, ipsum ~~lib~~ero *placerat **tortor***,

Suspendisse ~~et elit in enim tempus iaculis~~.
 *
 * Соответствующий выходной файл:
<html>
<body>
<p>
Lorem ipsum <i>dolor sit amet</i>, consectetur <b>adipiscing</b> elit.
Vestibulum lobortis. <s>Est vehicula rutrum <i>suscipit</i></s>, ipsum <s>lib</s>ero <i>placerat <b>tortor</b></i>.
</p>
<p>
Suspendisse <s>et elit in enim tempus iaculis</s>.
</p>
</body>
</html>
 *
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlSimple(inputName: String, outputName: String) {

    var input = File(inputName).readLines()
    val output = File(outputName).bufferedWriter()
    var opened = mutableListOf<String>()
    var lastLineIsNotEmpty = false    // была ли прошлая строка не пустой

    while (input.size > 1 &&
        (input[input.lastIndex].isEmpty() || input[input.lastIndex] == "\t" || input[input.lastIndex].matches(
            Regex(""" +""")
        )
                )
    ) input = input.dropLast(1)

    output.write("<html><body><p>")

    for (i in input.indices) {
        var workingLine = input[i]
        if (workingLine.isEmpty() || workingLine == "\t" || workingLine.matches(Regex(""" +"""))) {
            if (lastLineIsNotEmpty && i != input.size - 1) {
                output.write("</p><p>")
                lastLineIsNotEmpty = false
            }
            continue
        } else lastLineIsNotEmpty = true
        while (workingLine.contains("~~")) {
            if (opened.contains("s")) {
                workingLine = workingLine.replaceFirst("~~", "</s>")
                opened = opened.filter { it != "s" }.toMutableList()
            } else {
                workingLine = workingLine.replaceFirst("~~", "<s>")
                opened.add("s")
            }
        }
        while (workingLine.contains(Regex("""\*{1,3}"""))) {
            val substrToChange = workingLine.split(Regex("""[^*]+"""))
            for (substr in substrToChange) {
                when (substr) {
                    "*" -> if (opened.contains("i")) {
                        workingLine = workingLine.replaceFirst("*", "</i>")
                        opened = opened.filter { it != "i" }.toMutableList()
                    } else {
                        workingLine = workingLine.replaceFirst("*", "<i>")
                        opened.add("i")
                    }
                    "**" -> if (opened.contains("b")) {
                        workingLine = workingLine.replaceFirst("**", "</b>")
                        opened = opened.filter { it != "b" }.toMutableList()
                    } else {
                        workingLine = workingLine.replaceFirst("**", "<b>")
                        opened.add("b")
                    }
                    "***" ->
                        if (opened.containsAll(listOf("i", "b"))) {
                            workingLine = if (opened.indexOf("i") > opened.indexOf("b"))
                                workingLine.replaceFirst("***", "</i></b>") // b, i
                            else workingLine.replaceFirst("***", "</b></i>")
                            opened = opened.filter { it != "i" && it != "b" }.toMutableList()
                        } else {
                            workingLine = workingLine.replaceFirst("***", "<b><i>")
                            opened.addAll(listOf("b", "i"))
                        }
                }
            }
        }
        output.write(workingLine)
    }
    output.write("</p></body></html>")
    output.close()
}

/**
 * Сложная (23 балла)
 *
 * Реализовать транслитерацию текста в заданном формате разметки в формат разметки HTML.
 *
 * Во входном файле с именем inputName содержится текст, содержащий в себе набор вложенных друг в друга списков.
 * Списки бывают двух типов: нумерованные и ненумерованные.
 *
 * Каждый элемент ненумерованного списка начинается с новой строки и символа '*', каждый элемент нумерованного списка --
 * с новой строки, числа и точки. Каждый элемент вложенного списка начинается с отступа из пробелов, на 4 пробела большего,
 * чем список-родитель. Максимально глубина вложенности списков может достигать 6. "Верхние" списки файла начинются
 * прямо с начала строки.
 *
 * Следует вывести этот же текст в выходной файл в формате HTML:
 * Нумерованный список:
 * <ol>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ol>
 *
 * Ненумерованный список:
 * <ul>
 *     <li>Раз</li>
 *     <li>Два</li>
 *     <li>Три</li>
 * </ul>
 *
 * Кроме того, весь текст целиком следует обернуть в теги <html><body><p>...</p></body></html>
 *
 * Все остальные части исходного текста должны остаться неизменными с точностью до наборов пробелов и переносов строк.
 *
 * Пример входного файла:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
 * Утка по-пекински
 * Утка
 * Соус
 * Салат Оливье
1. Мясо
 * Или колбаса
2. Майонез
3. Картофель
4. Что-то там ещё
 * Помидоры
 * Фрукты
1. Бананы
23. Яблоки
1. Красные
2. Зелёные
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 *
 *
 * Соответствующий выходной файл:
///////////////////////////////начало файла/////////////////////////////////////////////////////////////////////////////
<html>
<body>
<p>
<ul>
<li>
Утка по-пекински
<ul>
<li>Утка</li>
<li>Соус</li>
</ul>
</li>
<li>
Салат Оливье
<ol>
<li>Мясо
<ul>
<li>Или колбаса</li>
</ul>
</li>
<li>Майонез</li>
<li>Картофель</li>
<li>Что-то там ещё</li>
</ol>
</li>
<li>Помидоры</li>
<li>Фрукты
<ol>
<li>Бананы</li>
<li>Яблоки
<ol>
<li>Красные</li>
<li>Зелёные</li>
</ol>
</li>
</ol>
</li>
</ul>
</p>
</body>
</html>
///////////////////////////////конец файла//////////////////////////////////////////////////////////////////////////////
 * (Отступы и переносы строк в примере добавлены для наглядности, при решении задачи их реализовывать не обязательно)
 */
fun markdownToHtmlLists(inputName: String, outputName: String) {
    TODO()
}

/**
 * Очень сложная (30 баллов)
 *
 * Реализовать преобразования из двух предыдущих задач одновременно над одним и тем же файлом.
 * Следует помнить, что:
 * - Списки, отделённые друг от друга пустой строкой, являются разными и должны оказаться в разных параграфах выходного файла.
 *
 */
fun markdownToHtml(inputName: String, outputName: String) {
    TODO()
}

/**
 * Средняя (12 баллов)
 *
 * Вывести в выходной файл процесс умножения столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 111):
19935
 *    111
--------
19935
+ 19935
+19935
--------
2212785
 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 * Нули в множителе обрабатывать так же, как и остальные цифры:
235
 *  10
-----
0
+235
-----
2350
 *
 */
fun printMultiplicationProcess(lhv: Int, rhv: Int, outputName: String) {
    TODO()
}


/**
 * Сложная (25 баллов)
 *
 * Вывести в выходной файл процесс деления столбиком числа lhv (> 0) на число rhv (> 0).
 *
 * Пример (для lhv == 19935, rhv == 22):
19935 | 22
-198     906
----
13
-0
--
135
-132
----
3

 * Используемые пробелы, отступы и дефисы должны в точности соответствовать примеру.
 *
 */
fun printDivisionProcess(lhv: Int, rhv: Int, outputName: String) {
    val outputWriter = File(outputName).bufferedWriter()
    val res = lhv / rhv
    val strLhv = if (lhv in 10 until rhv || ((lhv / rhv) * rhv).toString().length + 1 == lhv.toString().length) {
        outputWriter.write("$lhv | $rhv\n")
        lhv.toString()
    } else {
        outputWriter.write(" $lhv | $rhv\n")
        " $lhv"
    }
    var denominator = ""
    var currentDigitIndex = 0
    if (lhv < rhv) denominator = "0"
    else
        do {
            denominator += lhv.toString()[currentDigitIndex] // делимое
            currentDigitIndex += 1
        } while (denominator.toInt() < rhv)
    var subtrahend = (denominator.toInt() / rhv) * rhv // вычитаемое
    var currentLine = "-$subtrahend"
    if (lhv < rhv) {
        while (currentLine.length < strLhv.length) currentLine = " $currentLine"
        while (currentLine.length != ("$strLhv | ").length) currentLine += " "
    } else while (currentLine.length != ("$strLhv | ").length) currentLine += " "
    outputWriter.write(currentLine + "$res\n")
    if (lhv < rhv) {
        for (i in strLhv) outputWriter.write("-")
    } else for (i in "-$subtrahend") outputWriter.write("-")
    outputWriter.write("\n")
    if (lhv > rhv) {
        while (currentDigitIndex != lhv.toString().length) {
            denominator = (denominator.toInt() % rhv).toString() + lhv.toString()[currentDigitIndex]
            currentLine = denominator
            while (currentLine.length != currentDigitIndex + 2) currentLine = " $currentLine"
            currentLine += "\n"
            outputWriter.write(currentLine)
            subtrahend = (denominator.toInt() / rhv) * rhv
            currentLine = "-$subtrahend"
            while (currentLine.length != currentDigitIndex + 2) currentLine = " $currentLine"
            outputWriter.write(currentLine + "\n")
            currentLine = ""
            val longestNumber = if (denominator.length > "-$subtrahend".length) denominator else "-$subtrahend"
            for (i in longestNumber) currentLine += "-"
            while (currentLine.length != currentDigitIndex + 2) currentLine = " $currentLine"
            outputWriter.write(currentLine + "\n")
            currentDigitIndex++
        }
    }
    currentLine = (lhv % rhv).toString()
    while (currentLine.length != strLhv.length) currentLine = " $currentLine"
    outputWriter.write(currentLine)
    outputWriter.close()
}

/**
 * Дан текстовый файл, в котором схематично изображена схема
 * прямоугольного мини-лабиринта:
 * - во всех строках одинаковое количество символов
 * - символ # обозначает препятствие
 * - символ . свободное место
 * - символ * начальное местоположение "Робота"
 * Функция, которую нужно написать, принимает как параметры
 * имя этого файла и строку с командами для робота вида
 * "rllluddurld", где r обозначает движение вправо, l влево, u вверх
 * и d вниз, другие команды запрещены. Функция должна вернуть
 * координаты той клетки лабиринта, на которой робот окажется
 * после выполнения команд. Если очередная команда требует от
 * робота наступить на препятствие или выйти за границы
 * лабиринта, робот просто остаётся на месте и переходит к следующей команде.
 */

fun maze(inputName: String, commands: String): Pair<Int, Int> {
    var start = -1 to -1
    val lab = mutableListOf<MutableList<Char>>()
    for (line in File(inputName).readLines()) {
        lab.add(line.toMutableList())
        lab[lab.size - 1].add(0, '#')
        lab[lab.size - 1].add('#')
        if ('*' in line) start = lab.size to line.toList().indexOf('*') + 1
    }
    lab.add(0, lab[0].toMutableList())
    lab.first().replaceAll { '#' }
    lab.add(lab[0])
    for (command in commands) {
        val check = when (command) {
            'r' -> start.first to start.second + 1
            'l' -> start.first to start.second - 1
            'u' -> start.first - 1 to start.second
            'd' -> start.first + 1 to start.second
            else -> throw IllegalArgumentException()
        }
        if (lab[check.first][check.second] != '#') start = check.first to check.second
    }
    return start.first to start.second
}

