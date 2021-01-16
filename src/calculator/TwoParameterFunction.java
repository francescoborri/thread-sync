package calculator;

@FunctionalInterface
public interface TwoParameterFunction<T, V, U> {
    U apply (T t, V v);
}
