package ttsw.filopl.blockchainexamplespring.simple;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthSendTransaction;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by T. Filo Zegarlicki on 27.06.2022
 **/

public class BlockChainService {

    private final Web3j web3j;

    public BlockChainService(Web3j web3j) {
        this.web3j = web3j;
    }

    public TransactionPayload proceed(TransactionPayload transactionPayload) throws IOException {
        List<String> accounts = web3j.ethAccounts().send().getAccounts();

        Transaction etherTransaction = Transaction.createEtherTransaction(
                accounts.get(Integer.parseInt(transactionPayload.getFrom())),

                        null,
                BigInteger.valueOf(1),
                BigInteger.valueOf(100000),
                accounts.get(Integer.parseInt(transactionPayload.getTo())),
                transactionPayload.getValue().toBigInteger()
                );

//        Transaction etherTransaction = Transaction.createEtherTransaction(
//                transactionPayload.getFrom(),
//
//                null,
//                null,
//                null,
//                transactionPayload.getTo(),
//                transactionPayload.getValue().toBigInteger()
//        );

        EthSendTransaction send = web3j.ethSendTransaction(etherTransaction).send();
        transactionPayload.setId(send.getTransactionHash());
        return transactionPayload;
    }
}
