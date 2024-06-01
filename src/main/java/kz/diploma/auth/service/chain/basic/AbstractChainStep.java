package kz.diploma.auth.service.chain.basic;

public interface AbstractChainStep<IN, OUT> {
    OUT execute(IN in);
}
