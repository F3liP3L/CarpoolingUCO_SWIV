package co.edu.uco.application.specification;

public class NotSpecification<T> extends CompositeSpecification<T> {
    private ISpecification<T> other;

    public NotSpecification(ISpecification<T> other) {
        this.other = other;
    }

    @Override
    public boolean isSatisfyBy(T candidate) {
        return !other.isSatisfyBy(candidate);
    }
}
