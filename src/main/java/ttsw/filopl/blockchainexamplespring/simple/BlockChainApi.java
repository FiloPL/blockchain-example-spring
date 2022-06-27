package ttsw.filopl.blockchainexamplespring.simple;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by T. Filo Zegarlicki on 27.06.2022
 **/

@RestController
public class BlockChainApi {

    BlockChainService blockChainService;

    public BlockChainApi() {
    }

    public BlockChainApi(BlockChainService blockChainService) {
        this.blockChainService = blockChainService;
    }

    @PostMapping
    public TransactionPayload getBlock(@RequestBody TransactionPayload transactionPayload) throws IOException {
        return blockChainService.proceed(transactionPayload);
    }
}
