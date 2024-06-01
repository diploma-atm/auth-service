package kz.diploma.auth.service.chain.basic;

public abstract class ConditionalChainStep<IN, OUT> implements AbstractChainStep<IN, OUT> {

    private final AbstractChainStep<IN, OUT> chainA;
    private final AbstractChainStep<IN, OUT> chainB;

    protected ConditionalChainStep(AbstractChainStep<IN, OUT> chainA,
                                   AbstractChainStep<IN, OUT> chainB) {
        this.chainA = chainA;
        this.chainB = chainB;
    }

    /**
     * Overriding the method in subclasses is optional
     */
    @Override
    public OUT execute(IN in) {
        return branch(in) ? chainA.execute(in) : chainB.execute(in);
    }

    /**
     * Return true value for redirect to chainA else chainB
     */
    protected abstract boolean branch(IN in);

}
