package kz.gala.testing.matcher;


import org.junit.Assert;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ModelMatcher<T> {

    private Equality<T> equality;                   //  для каждого класса свой equality (аналог компоратора)
    private Class<T> entityClass;                  // класс, объекты которого будем сравнивать

    public interface Equality<T> {               //  аналог компоратора
        boolean areEqual(T expected, T actual);
    }

    private ModelMatcher(Class<T> entityClass, Equality<T> equality) { // приватный! конструктор принимает equality (аналог компоратора)
        this.entityClass = entityClass;
        this.equality = equality;
    }

    // создает экземпляр ModelMatcher, с equality по умолчанию (сравнение строкового представления)
    // в классе entityClass, требуется корректное переопределение метода toString()
    public static <T> ModelMatcher<T> of(Class<T> entityClass) {
        return of(entityClass, (T expected, T actual) -> expected == actual || String.valueOf(expected).equals(String.valueOf(actual)));
    }

    // создает экземпляр ModelMatcher на основе переданного  equality
    public static <T> ModelMatcher<T> of(Class<T> entityClass, Equality<T> equality) {
        return new ModelMatcher<>(entityClass, equality);
    }

    private class Wrapper {  // обертывает объект, переопределяя метод equals()
        private T entity;

        private Wrapper(T entity) {
            this.entity = entity;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Wrapper that = (Wrapper) o;
            return entity != null ? equality.areEqual(entity, that.entity) : that.entity == null;
        }

        @Override
        public String toString() {
            return String.valueOf(entity);
        }
    }


    public void assertEquals(T expected, T actual) {
        Assert.assertEquals(wrap(expected), wrap(actual));
    }

    public void assertCollectionEquals(Collection<T> expected, Collection<T> actual) {
        Assert.assertEquals(wrap(expected), wrap(actual));
    }

    private Wrapper wrap(T entity) {
        return new Wrapper(entity);
    }

    private List<Wrapper> wrap(Collection<T> collection) {
        return collection.stream().map(this::wrap).collect(Collectors.toList());
    }

}
