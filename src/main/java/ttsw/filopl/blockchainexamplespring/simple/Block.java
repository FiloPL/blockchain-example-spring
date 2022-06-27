package ttsw.filopl.blockchainexamplespring.simple;

import java.util.List;
import java.util.Objects;

/**
 * Created by T. Filo Zegarlicki on 27.06.2022
 **/
public class Block {

    private int previousHash;
    private List<TransactionPayload> transationList;

    public Block(int previousHash, List<TransactionPayload> transationList) {
        this.previousHash = previousHash;
        this.transationList = transationList;
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public void setPreviousHash(int previousHash) {
        this.previousHash = previousHash;
    }

    public List<TransactionPayload> getTransationList() {
        return transationList;
    }

    public void setTransationList(List<TransactionPayload> transationList) {
        this.transationList = transationList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Block block = (Block) o;
        return previousHash == block.previousHash && Objects.equals(transationList, block.transationList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(previousHash, transationList);
    }
}
