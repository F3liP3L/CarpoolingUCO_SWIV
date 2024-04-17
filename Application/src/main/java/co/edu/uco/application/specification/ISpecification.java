package co.edu.uco.application.specification;

public interface ISpecification<T> {
    public boolean isSatisfyBy(T object);
    public ISpecification<T> and(ISpecification<T> other);
    public ISpecification<T> or(ISpecification<T> other);
    public ISpecification<T> not(ISpecification<T> other);
    public ISpecification<T> andNot(ISpecification<T> other);
    public ISpecification<T> orNot(ISpecification<T> other);

}
