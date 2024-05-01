package co.edu.uco.application.specification;

public abstract class CompositeSpecification<T> implements ISpecification<T> {
    @Override
    public abstract boolean isSatisfyBy(T object);

    @Override
    public ISpecification<T> not(ISpecification<T> other) {
        return new NotSpecification<T>(this);
    }

    @Override
    public ISpecification<T> and(ISpecification<T> other) {
        return new AndSpecification<T>(this, other);
    }

    @Override
    public ISpecification<T> or(ISpecification<T> other) {
        return new OrSpecification<T>(this, other);
    }

    @Override
    public ISpecification<T> andNot(ISpecification<T> other) {
        return new AndNotSpecification<T>(this, other);
    }

    @Override
    public ISpecification<T> orNot(ISpecification<T> other) {
        return new OrNotSpecification<T>(this, other);
    }
}
