package kz.diploma.auth.service.chain.basic;

public abstract class BaseChainStep<IN, OUT> implements AbstractChainStep<IN, OUT> {
    private final AbstractChainStep<IN, OUT> next;

    protected BaseChainStep(AbstractChainStep<IN, OUT> next) {
        this.next = next;
    }

    @Override
    public OUT execute(IN in) {
        return next.execute(in);
    }
}
