package ttsw.filopl.blockchainexamplespring.simple;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by T. Filo Zegarlicki on 27.06.2022
 **/
public class Main {

    public static void main(String[] args) {
        // blockchain
        // block -> hashcode do poprzedniego bloku

        TransactionPayload transactionPayload1 = new TransactionPayload("Anna", "jan", BigDecimal.valueOf(10000l));
        TransactionPayload transactionPayload2 = new TransactionPayload("Anna", "jan", BigDecimal.valueOf(10l));
        TransactionPayload transactionPayload3 = new TransactionPayload("Anna", "jan", BigDecimal.valueOf(14000l));
        TransactionPayload transactionPayload4 = new TransactionPayload("Anna", "jan", BigDecimal.valueOf(100l));

        Block block1 = new Block(0, Arrays.asList(transactionPayload1, transactionPayload2));
        System.out.println(block1.hashCode());

        Block block2 = new Block(block1.hashCode(), Arrays.asList(transactionPayload3));
        System.out.println(block2.hashCode());

        Block block3 = new Block(block2.hashCode(), Arrays.asList(transactionPayload4));
        System.out.println(block3.hashCode());


//        -50955254
//                -1067857666
//                -1316883674
    }
}
