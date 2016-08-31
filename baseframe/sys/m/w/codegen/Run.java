package m.w.codegen;

import m.w.message.domain.PushBatch;


public class Run {
    public static void main(String[] args) {
        CodeGen.gen(PushBatch.class, null);
    }
}
