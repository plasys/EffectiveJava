package Chapter02.Item03;

import java.util.function.Supplier;

public class TrueDamage {

    private static final TrueDamage TEAM = new TrueDamage();

    // 기본 생성자
    private TrueDamage() {}

    public static TrueDamage getInstance() {
        return TEAM;
    }

    public static void main(String[] args) {
        // 정적 팩토리 방식은 Supplier를 사용할 수 있음
        Supplier<TrueDamage> trueDamageSupplier = TrueDamage::new;

        TrueDamage t = trueDamageSupplier.get();
    }
}
