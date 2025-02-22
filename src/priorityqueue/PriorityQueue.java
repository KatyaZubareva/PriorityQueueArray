package priorityqueue;

/**
 * Класс представляет очередь с приоритетами, реализованную через структуру кучи.
 * Используется для хранения элементов с приоритетами и выполнения операций вставки и удаления.
 */
public class PriorityQueue {
    Priority[] queue;  // Массив, в котором хранится очередь
    int add;  // Позиция, в которой добавим новое значение

    /**
     * Конструктор для создания очереди с заданным размером.
     *
     * @param size Размер очереди.
     */
    public PriorityQueue(int size) {
        queue = new Priority[size];
        add = 0;
    }

    /**
     * Вставка элемента в очередь с приоритетами.
     * Элемент добавляется в конец очереди, а затем очередь восстанавливает свой порядок.
     *
     * @param p Элемент с приоритетом для вставки.
     */
    public void insert(Priority p) {
        if (add >= queue.length) return;  // Проверка на переполнение очереди
        queue[add] = p;  // Добавляем новый элемент в позицию add
        shiftUp(add++);  // Обеспечиваем правильный порядок, поднимая элемент вверх
    }

    /**
     * Удаление элемента с минимальным приоритетом.
     * Удаляется элемент с наименьшим приоритетом (корень кучи),
     * и восстанавливается структура кучи.
     *
     * @return Приоритет удалённого элемента.
     * @throws IllegalStateException Если очередь пуста.
     */
    public int deleteMin() {
        if (add == 0) throw new IllegalStateException("Очередь пустая");  // Проверка на пустую очередь
        int result = queue[0].priority;  // Сохраняем минимальный приоритет
        swap(0, --add);  // Перемещаем последний элемент на место удаляемого и уменьшаем размер очереди
        shiftDown(0);  // Обеспечиваем правильный порядок, опуская элемент вниз
        return result;
    }

    /**
     * Вывод всех элементов очереди.
     * Отображает текущие элементы очереди и их приоритеты.
     */
    public void print() {
        if (add == 0) {
            System.out.println("Empty Queue");  // Если очередь пуста
            return;
        }
        System.out.println("Priority Queue:");
        int elements = 1;
        // Выводим элементы уровнями (для наглядности структуры кучи)
        for (int i = 0; i < add; ) {
            for (int j = 0; j < elements && i < add; j++, i++) {
                System.out.print(queue[i].priority + " ");  // Печатаем приоритет текущего элемента
            }
            System.out.println();
            elements *= 2;  // Количество элементов на следующем уровне удваивается
        }
        System.out.println("----------------------------------------");
    }

    /**
     * Очистка очереди.
     * Сбрасывает все элементы и устанавливает индекс для добавления в начало очереди.
     */
    public void makeNull() {
        add = 0;  // Сброс состояния очереди
    }

    /**
     * Приватный метод для обмена двух элементов в очереди.
     *
     * @param index1 Индекс первого элемента.
     * @param index2 Индекс второго элемента.
     */
    private void swap(int index1, int index2) {
        Priority temp = queue[index1];
        queue[index1] = queue[index2];
        queue[index2] = temp;
    }

    /**
     * Метод для перемещения элемента вверх по дереву, чтобы сохранить структуру кучи.
     *
     * @param index Индекс элемента, который нужно переместить.
     */
    private void shiftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;  // Индекс родительского элемента
            if (queue[parent].priority > queue[index].priority) {  // Если родительский элемент больше текущего
                swap(parent, index);  // Меняем местами родителя и текущий элемент
                index = parent;  // Обновляем индекс для продолжения вверх
            } else break;  // Если порядок правильный, выходим из цикла
        }
    }

    /**
     * Метод для перемещения элемента вниз по дереву, чтобы сохранить структуру кучи.
     *
     * @param index Индекс элемента, который нужно переместить.
     */
    private void shiftDown(int index) {
        while (2 * index + 1 < add) {  // Пока существует хотя бы один дочерний элемент
            int left = 2 * index + 1;  // Левый дочерний элемент
            int right = 2 * index + 2;  // Правый дочерний элемент
            int j = left;  // Изначально выбираем левый элемент как минимальный
            if (right < add && queue[right].priority < queue[left].priority) {  // Если правый элемент меньше левого
                j = right;  // Выбираем правый элемент
            }
            if (queue[index].priority <= queue[j].priority) break;  // Если порядок правильный, выходим из цикла
            swap(index, j);  // Меняем местами текущий элемент с минимальным дочерним
            index = j;  // Обновляем индекс для продолжения вниз
        }
    }
}
