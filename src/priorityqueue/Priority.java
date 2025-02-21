package priorityqueue;

/**
 * Класс, представляющий элемент очереди с приоритетами.
 * Каждый элемент имеет приоритет, который определяет его место в очереди.
 */
public class Priority {
    public int priority;  // Приоритет элемента

    /**
     * Конструктор для создания объекта с заданным приоритетом.
     *
     * @param priority Значение приоритета для элемента.
     */
    public Priority(int priority){
        this.priority = priority;  // Устанавливаем приоритет
    }
}
