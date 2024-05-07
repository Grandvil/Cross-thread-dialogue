# Межпоточный диалог

## Задача №1

В качестве первой задачи создано 4 потока, которые каждые 2.5 секунды отправляют в консоль некоторое сообщение, обязательно содержащее имя потока, которое было задано при создании. Поток выполняет бесконечный цикл вывода сообщения и сна (задержки). Главный поток программы (метод main) даёт поработать остальным потокам 15 секунд, а потом одним методом завершает все созданные ранее потоки.

### Пример
```
Создаю потоки...
Я поток 1. Всем привет!
Я поток 2. Всем привет!
Я поток 4. Всем привет!
Я поток 3. Всем привет!
Я поток 2. Всем привет!
Я поток 1. Всем привет!
Я поток 3. Всем привет!
Я поток 4. Всем привет!
Я поток 4. Всем привет!
Я поток 3. Всем привет!
Я поток 2. Всем привет!
Я поток 1. Всем привет!
Завершаю все потоки.
```

## Задача №2. Межпоточный диалог со счетчиком

Модифицировать код для потоков из предыдущей задачи таким образом, чтобы это была Callable-задача, возвращающая кол-во выведенных в консоль сообщений, а цикл выполнения был конечен. Запустить некоторое кол-во этих задач в пул потоков фиксированного количества и получить результаты выполнения задач. Провести аналогичную операцию, но с получением результата от одной из задач (`pool.invokeAny()`).